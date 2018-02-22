package harmon.osu.appname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoadingScreenActivity extends AppCompatActivity {

    private Button mMuffinButton = (Button) findViewById(R.id.muffin_button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMuffinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.main_menu);
            }
        });
        setContentView(R.layout.loading_screen);

    }

    @Override
    protected void onStart(){
        super.onStart();
    }
}
