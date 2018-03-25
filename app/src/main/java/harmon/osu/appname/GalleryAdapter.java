package harmon.osu.appname;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


/**
 * Created by Jak on 3/16/18.
 */

public class GalleryAdapter extends BaseAdapter {
    private Context imgContext;
    private Gallery imgGallery;

    public GalleryAdapter(Context c){
        this.imgContext = c;
    }

    public View getView(int i, View v, ViewGroup g) {
        ImageView picture;
        Bitmap picBit = BitmapFactory.decodeFile(this.imgGallery.getPicture(i).getAbsolutePath());

        if(v == null){
            picture = new ImageView(imgContext);
            picture.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            picture = (ImageView) v;
        }

        return picture;
    }

    public Object getItem(int i){
        return this.imgGallery.getPicture(i);
    }

    public long getItemId(int i){
        return 0;
    }

    public int getCount(){
        return this.imgGallery.getSize();
    }
}
