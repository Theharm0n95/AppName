package harmon.osu.appname;
import android.graphics.Color;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;


/**
 * Created by Justin on 3/3/2018.
 */

public class CalculateAverageColor {
    // The default color when the color can not be obtained.
    private final static String DEFAULT_COLOR = "#000000";
    // The amount of pixels to skip when obtaining color.
    private final static int SKIPRATE = 11;

    /**
     * Returns the HEX value of the average color from filePath.
     * @requires the jpg from filePath doe not contain transparency
     * @param bMap a Bitmap representation of an image
     * @return a HEX value of the average color
     */
    public static String getAverageColor(Bitmap bMap) {
        String averageColor = DEFAULT_COLOR;
        // Check if the image was null
        if(bMap != null) {
            long redBucket = 0;
            long greenBucket = 0;
            long blueBucket = 0;
            int pixelCount = bMap.getWidth() * bMap.getHeight();
            int[] pixels = new int[pixelCount];
            bMap.getPixels(pixels, 0, bMap.getWidth(), 0, 0, bMap.getWidth(), bMap.getHeight());
            // Loop through each pixel and add heir red, green, and blue to the buckets
            for (int y = 0, h = bMap.getHeight(); y < h; y++)
            {
                for (int x = 0, w = bMap.getWidth(); x < w; x++)
                {
                    int c = pixels[x + y * w];
                    redBucket += Color.red(c);
                    greenBucket += Color.green(c);
                    blueBucket += Color.blue(c);
                }
            }
            // Take averages
            redBucket = redBucket / pixelCount;
            greenBucket = greenBucket / pixelCount;
            blueBucket = blueBucket / pixelCount;
            // Get HEX value
            averageColor = String.format("#%02X%02X%02X", redBucket, greenBucket, blueBucket);
        }
        return averageColor;
    }
}
