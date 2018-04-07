package harmon.osu.appname;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Justin on 2/19/2018.
 */

public class MainMenuActivity extends AppCompatActivity {

    private Button mSettingsButton;
    private Button mTakePictureButton;
    private Button mPhotosButton;
    private Button mNowPlayingButton;
    private TextView mAppNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        mSettingsButton = (Button) findViewById(R.id.settings_menu_button);
        mTakePictureButton = (Button) findViewById(R.id.take_picture_menu_button);
        mPhotosButton = (Button) findViewById(R.id.photos_menu_button);
        mNowPlayingButton = (Button) findViewById(R.id.now_playing_menu_button);
        mAppNameText = (TextView) findViewById(R.id.main_menu_text);

        mSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSettings();
            }
        });

        mTakePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toTakePicture();
            }
        });

        mPhotosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPhotos();
            }
        });

        mNowPlayingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toNowPlaying(R.color.army, true);
            }
        });

        mAppNameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Developed by:\nJacob Harmon & Jeremy Heer\n2018",
                        Toast.LENGTH_LONG).show();
            }
        });
    }


    public void toSettings(){
        Intent i = new Intent(this,SettingsMenuActivity.class);
        startActivity(i);
    }

    public void toTakePicture() {
        Intent i = new Intent(this,TakePictureActivity.class);
        startActivity(i);
    }

    public void toPhotos() {
        Intent i = new Intent(this,PhotosActivity.class);
        startActivity(i);
    }

    public void toNowPlaying(int avg, boolean play) {
        Intent i = new Intent(this, NowPlayingActivity.class);
        i.putExtra("avgColor", avg);
        i.putExtra("play", play);
        startActivity(i);
    }

}
