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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.average_color);
        String file = TakePictureActivity.getFile();
        String averageColor = CalculateAverageColor.getAverageColor(file);
        View colorBox = (View) this.findViewById(R.id.color_square);
        colorBox.setBackgroundColor(Color.parseColor(averageColor));

    }

    public void toTakePicture(View v) {
        Intent i = new Intent(this,TakePictureActivity.class);
        startActivity(i);
    }

}
