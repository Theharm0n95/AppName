package harmon.osu.appname;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {
    private SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
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

        if(closestColor != null){
            String key = "genre_" + closestColor + "_setting";
            genre = pref.getInt(key, 0);
        }

        mGenrePlayer = new AudioPlayer(this, genre);

        if(getIntent().getExtras().getBoolean("play")){
            mGenrePlayer = new AudioPlayer(this, genre);
            playClick();
        }

    }

    public void playClick(){
        if(mGenrePlayer.hasAudioLoaded()) {
            mGenrePlayer.resume();
        } else {
            mGenrePlayer.play();
        }

        mPlayPauseButton.setText("Pause");
        mPlayPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseClick();
            }
        });
    }

    public void pauseClick(){
        mGenrePlayer.pause();

        mPlayPauseButton.setText("Play");
        mPlayPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    public void nextClick(){
        mGenrePlayer.next();
    }
}
