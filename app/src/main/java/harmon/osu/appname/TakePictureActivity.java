package harmon.osu.appname;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by Justin on 2/19/2018.
 */

public class TakePictureActivity extends AppCompatActivity {
    final int PHOTO_CODE = 0;
    private static String file = "";
    //Button mSettingsButton = findViewById(R.id.settings_menu_button);
    String TAG = "MainMenu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create photo directory
        final String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/" + getString(R.string.app_name) + "/pictures/";
        File newdir = new File(dir);
        newdir.mkdirs();
        // Make new file
        String time = Calendar.getInstance().getTime().toString();
        file = dir + time +".jpg";
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
        startActivityForResult(cameraIntent, PHOTO_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PHOTO_CODE && resultCode == RESULT_OK) {
            Log.d("CameraDemo", "Pic saved");
        } else {
            File unusedFile = new File(file);
            // Delete unused photo file
            unusedFile.delete();
        }
    }

    /**
     * Returns a string to the last file created.
     *
     * @return last made photo as string
     */
    public String getFile(){
        return file;
    }
}
