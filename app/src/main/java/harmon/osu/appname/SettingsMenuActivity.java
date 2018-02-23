package harmon.osu.appname;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class SettingsMenuActivity extends AppCompatActivity {

    private String TAG = "SettingsMenu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_menu);

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
