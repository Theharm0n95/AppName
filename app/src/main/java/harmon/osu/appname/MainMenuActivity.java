package harmon.osu.appname;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Justin on 2/19/2018.
 */

public class MainMenuActivity extends AppCompatActivity {

    private Button mSettingsButton = findViewById(R.id.settings_button);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.settings_menu);
            }
        });
        setContentView(R.layout.main_menu);
    }
}
