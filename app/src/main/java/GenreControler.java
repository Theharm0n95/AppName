import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * Created by Jak on 3/25/18.
 */

public class GenreControler {
    private MediaPlayer mGenrePlayer;

    public void stop(){
        if(mGenrePlayer != null){
            mGenrePlayer.release();
            mGenrePlayer = null;
        }
    }

    public void next(Context c, Uri mAudio){
        if(mGenrePlayer != null){
            mGenrePlayer.stop();
        }
        mGenrePlayer = MediaPlayer.create(c, mAudio);
        mGenrePlayer.start();
    }

    public void play(Context c, Uri mAudio){
        mGenrePlayer = MediaPlayer.create(c, mAudio);
        mGenrePlayer.start();
    }

    public void pause(){
       if(mGenrePlayer != null){
           mGenrePlayer.pause();
       }
    }


}
