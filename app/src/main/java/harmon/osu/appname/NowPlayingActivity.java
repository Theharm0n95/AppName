package harmon.osu.appname;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class NowPlayingActivity extends AppCompatActivity {

    private ImageView mSongPhoto;
    private Button mPlayButton;
    private Button mNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent playIntent = this.getIntent();
        Bundle extras = playIntent.getExtras();





    }
}
