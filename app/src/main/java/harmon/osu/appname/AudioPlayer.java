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
        genreId = genre % songList.length;
        songId = 0;
        audioContext = c;

        mAudio = MediaPlayer.create(audioContext, songList[genreId][songId]);
        mAudio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if((songId + 1) < songList[genreId].length){
                    next();
                }
            }
        });
    }

    public void play(){
        if(mAudio == null){
            mAudio = MediaPlayer.create(audioContext, songList[genreId][songId]);
            mAudio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    if((songId + 1) < songList[genreId].length){
                        next();
                    }
                }
            });
        }

        mAudio.start();
    }

    public void pause(){
        if(mAudio != null){
            mAudio.pause();
        }
    }

    public void next(){
        if(mAudio != null){
            stop();
        }

        if (++songId < songList[genreId].length){
            play();
        }
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

    public boolean isPlaying(){
       return (mAudio != null);
    }

}
