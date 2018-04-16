package harmon.osu.appname;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainMenuTest {
    @Rule
    public ActivityTestRule<MainMenuActivity> rule  = new ActivityTestRule<>(MainMenuActivity.class);

    @Test
    public void ensureMainMenuTextIsPresent() throws Exception {
        MainMenuActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.main_menu_text);
        assertThat(viewById,notNullValue());
        assertThat(viewById, instanceOf(TextView.class));
    }

    @Test
    public void ensureNowPlayingButtonIsPresent() throws Exception {
        MainMenuActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.now_playing_menu_button);
        assertThat(viewById,notNullValue());
        assertThat(viewById, instanceOf(Button.class));
    }

    @Test
    public void ensureTakePictureButtonIsPresent() throws Exception {
        MainMenuActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.take_picture_menu_button);
        assertThat(viewById,notNullValue());
        assertThat(viewById, instanceOf(Button.class));
    }

    @Test
    public void ensurePhotosButtonIsPresent() throws Exception {
        MainMenuActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.photos_menu_button);
        assertThat(viewById,notNullValue());
        assertThat(viewById, instanceOf(Button.class));
    }

    @Test
    public void ensureSettingsButtonIsPresent() throws Exception {
        MainMenuActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.settings_menu_button);
        assertThat(viewById,notNullValue());
        assertThat(viewById, instanceOf(Button.class));
    }
}
