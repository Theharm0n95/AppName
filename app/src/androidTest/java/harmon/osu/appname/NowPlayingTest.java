package harmon.osu.appname;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class NowPlayingTest {
    @Rule
    public ActivityTestRule<NowPlayingActivity> rule  = new ActivityTestRule<NowPlayingActivity>(NowPlayingActivity.class){
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation()
                    .getTargetContext();
            Intent result = new Intent(targetContext, NowPlayingActivity.class);
            result.putExtra("closestColor", "#000000");
            result.putExtra("avgColor", "#000000");
            result.putExtra("play", true);
            return result;
        }
    };

    @Test
    public void ensureNowPlayingTextIsPresent() throws Exception {
        NowPlayingActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.now_playing_text);
        assertThat(viewById,notNullValue());
        assertThat(viewById, instanceOf(TextView.class));
    }


    @Test
    public void ensureSongPhotoIsPresent() throws Exception {
        NowPlayingActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.SongPhoto);
        assertThat(viewById,notNullValue());
        assertThat(viewById, instanceOf(View.class));
    }

    @Test
    public void ensureSongInfoTextIsPresent() throws Exception {
        NowPlayingActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.song_info_text);
        assertThat(viewById,notNullValue());
        assertThat(viewById, instanceOf(TextView.class));
    }
}
