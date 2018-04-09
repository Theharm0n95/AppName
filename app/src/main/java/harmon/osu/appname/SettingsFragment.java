package harmon.osu.appname;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Jak on 4/8/18.
 */

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);
    }
}
