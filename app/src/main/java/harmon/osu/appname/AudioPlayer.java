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

        mAudio = MediaPlayer.create(audioContext, songList[genreId][songId]);
        mAudio.prepareAsync();
    }

    public void play(){
        if(mAudio == null){
            mAudio = MediaPlayer.create(audioContext, songList[genreId][songId]);
        }

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

    public void pause(){
        if(mAudio != null){
            mAudio.pause();
        }
    }

    public void resume(){
        if(mAudio != null){
            mAudio.start();
        }
    }

    public void next(){
        if(mAudio != null){
            stop();
            mAudio = null;
        }

        mAudio = MediaPlayer.create(audioContext, songList[genreId][(++songId % songList[genreId].length)]);
        mAudio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                play();
            }
        });

        mAudio.prepareAsync();

    }

    public void stop(){
        if(mAudio != null){
            mAudio.release();
            mAudio = null;
        }
    }

    public boolean hasAudioLoaded(){
        return (mAudio != null);
    }

    private int songList[][] = {
            {R.raw.electonica_house, R.raw.electronica_dubstep, R.raw.electronica_endless},
            {R.raw.rock_beginning, R.raw.rock_higher},
            {R.raw.acoustic_breeze, R.raw.acoustic_remember}
    };

    private String songName[][] = {
            {"House", "Dubstep", "Endless"},
            {"Beginning", "Higher"},
            {"Breeze", "Remember"}
    };
}
