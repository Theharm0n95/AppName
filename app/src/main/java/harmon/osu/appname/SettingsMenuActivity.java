package harmon.osu.appname;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class SettingsMenuActivity extends AppCompatActivity {

    private Button mPlaybackButton = (Button) findViewById(R.id.playback_button);
    private Button mColorButton = (Button) findViewById(R.id.color_mood_button);
    private Button mGeneralButton = (Button) findViewById(R.id.gen_setting_button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_menu);

        mPlaybackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setContentView(R.layout.test_activity);
            }
        });

        mColorButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setContentView(R.layout.test_activity);
            }
        });

        mGeneralButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setContentView(R.layout.test_activity);
            }
        });

    }




}
