package harmon.osu.appname;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {
    private GenreControler mControler = new GenreControler();
    private ImageView mSongPhoto;
    private TextView mInfoText;
    private Button mPlayButton;
    private Button mNextButton;
    private Uri mSongUri;
    private int songPos;
    private int genrePos;
    private ColorSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent playIntent = this.getIntent();
        Bundle extras = playIntent.getExtras();
        mSongPhoto = (ImageView) findViewById(R.id.SongPhoto);
        mPlayButton = (Button) findViewById(R.id.play_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mInfoText = (TextView) findViewById(R.id.song_info_text);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPlayClick();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNextClick();
            }
        });

        // Get the file
        String file = extras.getString("file");
        Bitmap bMap = BitmapFactory.decodeFile(file);
        // Set the bitmap
        mSongPhoto.setImageBitmap(Bitmap.createScaledBitmap(bMap, 120, 120, false));

        
        String closestColor = extras.getString("closestColor");

        genrePos = 0;
    }

    private void getUri(){
        songPos = (int) (Math.random() * songPath[genrePos].length);
        String info = songPath[genrePos][songPos];
        String text;

        mSongUri = Uri.parse(info);

        info = info.split("/")[1];
        info = info.split(".")[0];

        text = "Genre: " + info.split("-")[0];
        text += "\tSong: " + info.split("-")[1];

        mInfoText.setText(text);
    }

    private void getNextUri(){
        String info = songPath[genrePos][(++songPos) % (songPath[genrePos].length)];
        String text;

        mSongUri = Uri.parse(info);

        info = info.split("/")[1];
        info = info.split(".")[0];

        text = "Genre: " + info.split("_")[0];
        text += "\tSong: " + info.split("_")[1];

        mInfoText.setText(text);
    }

    private String[][] songPath = {
            {"raw/electronica_dance.mp3",
                    "raw/electronica_dubstep.mp3",
                    "raw/electronica_endlessmotion.mp3",
                    "raw/electronica_house.mp3",
                    "raw/electronica_popdance.mp3",
                    "raw/electronica_summer.mp3"},

            {"raw/acoustic_breeze.mp3",
                    "raw/acoustic_remember.mp3",
                    "raw/acoustic_sunny.mp3"},

            {"raw/rock_beginning.mp3",
                    "raw/rock_higher.mp3",
                    "raw/rock_octane.mp3"}
    };

    private void onPlayClick(){
        if(mSongUri == null){
            getUri();
        }

        mControler.play(this, mSongUri);

        mPlayButton.setText("Pause");
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPauseClick();
            }
        });
    }

    private void onNextClick(){
        getNextUri();
        mControler.next(this, mSongUri);
    }

    private void onPauseClick(){
        mControler.pause();

        mPlayButton.setText("Play");
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPlayClick();
            }
        });
    }


}
