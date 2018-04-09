package harmon.osu.appname;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by Justin on 2/19/2018.
 */

public class TakePictureActivity extends AppCompatActivity {
    final int PHOTO_CODE = 5;
    private static String file = "";
    private Uri outputFileUri;

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
        outputFileUri = Uri.fromFile(newfile);

        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(TakePictureActivity.this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        1);
            }

        } else {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            startActivityForResult(cameraIntent, PHOTO_CODE);
        }

    }

    public void capture(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, PHOTO_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, PHOTO_CODE);

                } else {

                    // permission denied
                    File unusedFile = new File(file);
                    // Delete unused photo file
                    unusedFile.delete();
                    // Return to MainMenu
                    Intent i = new Intent(this,MainMenuActivity.class);
                    startActivity(i);
                    finish();
                }

                break;
            }
            default:
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent i;

        // Check if photo was successful
        if (requestCode == PHOTO_CODE && resultCode == RESULT_OK) {
            i = new Intent(this,AverageColorActivity.class);
            //Bitmap img = (Bitmap) data.getExtras().get("data");

            // Go to AverageColor

            i.putExtra("file", file);
            //i.putExtra("bitmap", img);
            startActivity(i);
            finish();

        } else {
            i = new Intent(this,MainMenuActivity.class);
            File unusedFile = new File(file);

            // Delete unused photo file
            unusedFile.delete();


            startActivity(i);
            finish();
        }
    }

}
