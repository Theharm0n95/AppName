package harmon.osu.appname;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;


/**
 * Created by Justin on 3/3/2018.
 */

public class FindClosestColor {

    /**
     * Returns the closest color found in ColorList of the given hex color.
     * @param hex the hex string value of the color
     * @param context the context of this
     * @requires hex.charAt(0) == '#'
     * @return the hex value of the closest color contained in ColorList
     * @ensures getClosestColor.charAt(0) == '#'
     */
    public static String getClosestColor(String hex, Context context) {
        // Get the RGB value of the given color
        int color = (int)Long.parseLong(hex.substring(1), 16);
        final int RED = (color >> 16) & 0xFF;
        final int GREEN = (color >> 8) & 0xFF;
        final int BLUE = (color >> 0) & 0xFF;


        /*
         * Get the first color in colorList, take it's distance from the given color.
         */
        String[] colors = context.getResources().getStringArray(R.array.choices_vals);

        int colorInList = (int)Long.parseLong(colors[0], 16);
        int redDist = Math.abs(RED - ((colorInList >> 16) & 0xFF) );
        int greenDist = Math.abs(GREEN - ((colorInList >> 8) & 0xFF) );
        int blueDist = Math.abs(BLUE - ((colorInList >> 0) & 0xFF) );
        int totalDist = redDist + greenDist + blueDist;
        // Set the distance and color as the closest
        int closestDist = totalDist;
        String closest = colors[0];
        int i = 1;
        /*
         * Loop through the remaining colors in the colorList to find the closest of them all.
         */
        while(i < colors.length) {
            colorInList = (int)Long.parseLong(colors[i], 16);
            redDist = Math.abs(RED - ((colorInList >> 16) & 0xFF) );
            greenDist = Math.abs(GREEN - ((colorInList >> 8) & 0xFF) );
            blueDist = Math.abs(BLUE - ((colorInList >> 0) & 0xFF) );
            totalDist = redDist + greenDist + blueDist;
            // Update if the new distance is closer
            if(totalDist < closestDist) {
                closestDist = totalDist;
                closest = colors[i];
            }
            i++;
        }

        return "#"+ closest;
    }
}
