package harmon.osu.appname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {
    private String closestColor;
    private int genre = 0;
    private int avgColorVal;
    private AudioPlayer mGenrePlayer;
    private Button mPlayPauseButton;
    private Button mNextButton;
    private View mAvgColor;
    private TextView mSongInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        closestColor = getIntent().getExtras().getString("closestColor");
        avgColorVal = getIntent().getExtras().getInt("avgColor");

        mAvgColor = (View) findViewById(R.id.SongPhoto);
        mAvgColor.setBackgroundColor(avgColorVal);

        mPlayPauseButton = (Button) findViewById(R.id.play_button);
        mNextButton = (Button) findViewById(R.id.next_button);

        mPlayPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playClick();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextClick();
            }
        });
        

        mGenrePlayer = new AudioPlayer(this, genre++);

        if(getIntent().getExtras().getBoolean("play")){
            playClick();
        }

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mGenrePlayer.stop();
    }

    public void playClick(){

        mPlayPauseButton.setText("Pause");
        mPlayPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseClick();
            }
        });

        mGenrePlayer.play();
    }

    public void pauseClick(){
       mPlayPauseButton.setText("Play");
       mPlayPauseButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               playClick();
           }
       });

       mGenrePlayer.pause();
    }

    public void nextClick(){
        mGenrePlayer.next();
        if(!mGenrePlayer.isPlaying()){
            mPlayPauseButton.setText("Play");
            mPlayPauseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    playClick();
                }
            });

            mGenrePlayer = new AudioPlayer(this, genre);
        }
    }
}