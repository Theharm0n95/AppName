package harmon.osu.appname;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by Justin on 2/19/2018.
 */

public class AverageColorActivity extends AppCompatActivity {

    private Bitmap bMap;

    private String closestColor;
    private int mAvgColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.average_color);
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        bMap = (Bitmap) i.getParcelableExtra("bitmap");

        String averageColor = CalculateAverageColor.getAverageColor(bMap);
        View colorBox = (View) this.findViewById(R.id.color_square);

        mAvgColor = Color.parseColor(averageColor);
        colorBox.setBackgroundColor(mAvgColor);

        closestColor = FindClosestColor.getClosestColor(averageColor, this);

    }

    public void toNowPlaying(View v) {
        Intent i = new Intent(this,NowPlayingActivity.class);

        i.putExtra("closestColor", closestColor);
        i.putExtra("avgColor", mAvgColor);
        i.putExtra("play", true);
        startActivity(i);
    }

    public void toTakePicture(View v) {
        Intent i = new Intent(this,TakePictureActivity.class);
        startActivity(i);
    }

    public void toPhotos(View v) {
        Intent i = new Intent(this,PhotosActivity.class);
        startActivity(i);
    }
}
