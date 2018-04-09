package harmon.osu.appname;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PhotosActivity extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Start an activity to select an image
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

        startActivityForResult(chooserIntent, PICK_IMAGE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check if successful
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            // Return to main menu if NULL
            if (data == null) {
                Intent i = new Intent(this,MainMenuActivity.class);
                startActivity(i);
                finish();
                return;
            }
            // Attempt to open stream
            try {
                InputStream inputStream = this.getContentResolver().openInputStream(data.getData());
            }
            catch (FileNotFoundException e) {
                Intent i = new Intent(this,MainMenuActivity.class);
                startActivity(i);
                finish();
            }
            // Obtain the filepath of the selected image
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String file = cursor.getString(columnIndex);
            cursor.close();

            // Go to average color activity
            Intent i = new Intent(this,AverageColorActivity.class);

            i.putExtra("bitmap", BitmapFactory.decodeFile(file));
            startActivity(i);
            finish();
        }
        else {
            // Return to main menu on fail
            Intent i = new Intent(this,MainMenuActivity.class);
            startActivity(i);
            finish();
        }
    }


}
