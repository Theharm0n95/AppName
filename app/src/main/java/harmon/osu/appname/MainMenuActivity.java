package harmon.osu.appname;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Justin on 2/19/2018.
 */

public class MainMenuActivity extends AppCompatActivity {

    String TAG = "MainMenu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

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

    public void toSettings(View v){
        Intent i = new Intent(this,SettingsMenuActivity.class);
        startActivity(i);
    }
}
