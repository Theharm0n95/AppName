package harmon.osu.appname;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by Justin on 2/19/2018.
 */

public class AverageColorActivity extends AppCompatActivity {

    private String file;

    private String closestColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.average_color);
        Bundle extras = getIntent().getExtras();
        file = extras.getString("file");
        String averageColor = CalculateAverageColor.getAverageColor(file);
        View colorBox = (View) this.findViewById(R.id.color_square);
        colorBox.setBackgroundColor(Color.parseColor(averageColor));
        closestColor = FindClosestColor.getClosestColor(averageColor, this);

    }

    public void toNowPlaying(View v) {
        Intent i = new Intent(this,NowPlayingActivity.class);
        i.putExtra("file", file);
        i.putExtra("closestColor", closestColor);
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
