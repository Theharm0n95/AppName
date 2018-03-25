package harmon.osu.appname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class PhotoGalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);

        GridView mPhotoGrid = findViewById(R.id.photo_gallery_grid);
        mPhotoGrid.setAdapter(new GalleryAdapter(this));

    }
}
