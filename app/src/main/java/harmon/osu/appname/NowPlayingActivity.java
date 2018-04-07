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

        if(closestColor != null){
            switch(closestColor){
                case "electronica": {
                    break;
                }
                case "rock": {
                    genre = 1;
                    break;
                }
                case "acoustic": {
                    genre = 2;
                    break;
                }
                default:{
                    break;
                }

            }
        }

        mGenrePlayer = new AudioPlayer(this, genre);

        if(getIntent().getExtras().getBoolean("play")){
            genre = 1;
            mGenrePlayer = new AudioPlayer(this, genre);
            playClick();
        }

    }

    public void playClick(){
        mGenrePlayer.play();
    }

    public void nextClick(){
        mGenrePlayer.next();
    }
}
