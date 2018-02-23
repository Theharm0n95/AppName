package harmon.osu.appname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class LoadingScreenActivity extends AppCompatActivity {

    private Button mMuffinButton = (Button) findViewById(R.id.muffin_button);
    private String TAG = "AppName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen);
        Log.d(TAG, "onCreate() Called");

        mMuffinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.main_menu);
            }
        });
    }

    @Override
    protected void onStart(){
        Log.d(TAG, "onStart() Called");
        super.onStart();
    }

    @Override
    protected void onResume(){
        Log.d(TAG, "onResume() Called");
        super.onResume();
    }

    @Override
    protected void onPause(){
        Log.d(TAG, "onPause() Called");
        super.onPause();
    }

    @Override
    protected void onStop(){
        Log.d(TAG, "onStop() Called");
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        Log.d(TAG, "onDestroy() Called");
        super.onDestroy();
    }
}
