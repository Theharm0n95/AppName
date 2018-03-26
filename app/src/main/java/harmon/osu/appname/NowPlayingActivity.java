package harmon.osu.appname;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class NowPlayingActivity extends AppCompatActivity {

    private ImageView mSongPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent playIntent = this.getIntent();
        Bundle extras = playIntent.getExtras();
        mSongPhoto = (ImageView) findViewById(R.id.SongPhoto);
        // Get the file
        String file = extras.getString("file");
        Bitmap bMap = BitmapFactory.decodeFile(file);
        // Set the bitmap
        mSongPhoto.setImageBitmap(Bitmap.createScaledBitmap(bMap, 120, 120, false));

        
        String closestColor = extras.getString("closestColor");
    }
}
