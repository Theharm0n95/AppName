package harmon.osu.appname;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import java.util.Calendar;

import java.io.File;
import java.io.IOException;

/**
 * Created by Justin on 2/19/2018.
 */

public class MainMenuActivity extends AppCompatActivity {

    //Button mSettingsButton = findViewById(R.id.settings_menu_button);
    String TAG = "MainMenu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

    }

    @Override
    protected void onStart(){
        Log.d(TAG, "onStart() Called");
        super.onStart();
    }

    @Override
    protected void onResume(){
        Log.d(TAG, "onResume() Called");
        super.onResume();
    }

    @Override
    protected void onPause(){
        Log.d(TAG, "onPause() Called");
        super.onPause();
    }

    @Override
    protected void onStop(){
        Log.d(TAG, "onStop() Called");
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        Log.d(TAG, "onDestroy() Called");
        super.onDestroy();
    }

    public void toSettings(View v){
        Intent i = new Intent(this,SettingsMenuActivity.class);
        startActivity(i);
    }

    public void takePicture(View v) {
        // Create photo directory
        final String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/" + getString(R.string.app_name) + "/pictures/";
        File newdir = new File(dir);
        newdir.mkdirs();
        // Make new file
        String file = dir + Calendar.getInstance().getTime().toString() +".jpg";
        File newfile = new File(file);
        try {
            newfile.createNewFile();
        }
        catch (IOException e)
        {
        }
        // Take photo
        Uri outputFileUri = Uri.fromFile(newfile);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

        startActivity(cameraIntent);
    }
}
