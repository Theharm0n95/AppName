package harmon.osu.appname;

import android.graphics.Bitmap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AverageColorUnitTest {
    @Test
    public void whiteBitmap_isCorrect() throws Exception {
        Bitmap bMap = Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888);
        bMap.eraseColor(android.graphics.Color.WHITE);
        String averageColor = CalculateAverageColor.getAverageColor(bMap);
        assertEquals("#ffffff", averageColor);
    }
}