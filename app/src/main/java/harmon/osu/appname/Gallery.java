package harmon.osu.appname;

/**
 * Created by Jak on 3/16/18.
 */

import android.media.Image;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;


public class Gallery {
    private static ArrayList<File> imgGallery;

    public Gallery(){
        this.imgGallery = new ArrayList<File>();
    }

    public int getSize(){
        return this.imgGallery.size();
    }

    public void addPicture(File i){
        this.imgGallery.add(i);
    }

    public File getPicture(int i){
        return this.imgGallery.get(i);
    }

}
