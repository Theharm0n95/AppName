package harmon.osu.appname;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Jak on 4/5/18.
 */

public class AudioPlayer {
    private MediaPlayer mAudio;
    private int songId;
    private int genreId;
    private final Context audioContext;


    public AudioPlayer(Context c, int genre){
        genreId = genre;
        songId = 0;
        audioContext = c;
    }

    public void play(){
        stop();

        mAudio = MediaPlayer.create(audioContext, songList[genreId][songId]);

        mAudio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if((songId % songList[genreId].length != 0) && songId != 0){
                    next();
                }
            }
        });

        mAudio.start();
    }

    public void next(){
        if(mAudio != null){
            stop();
        }

        songId++;
        play();

    }

    public void stop(){
        if(mAudio != null){
            mAudio.release();
            mAudio = null;
        }
    }

    private int songList[][] = {
            {R.raw.electonica_house, R.raw.electronica_dubstep, R.raw.electronica_endless},
            {R.raw.rock_beginning, R.raw.rock_higher},
            {R.raw.acoustic_breeze, R.raw.acoustic_remember}
    };
}
