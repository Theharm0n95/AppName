package harmon.osu.appname;

import java.util.Map;
import java.util.Map.*;
import java.util.Set;


/**
 * Created by Jak on 3/26/18.
 */

public class ColorSettings {
    private static Map<String, Integer> relationshipMap;

    public ColorSettings(Map<String, Integer> m){
       relationshipMap.putAll(m);
    }

    public ColorSettings(){}


    public void changeColor(String genre, int color){
        if(relationshipMap.containsKey(genre)) {
            relationshipMap.remove(genre);
        }

        if(!relationshipMap.containsValue(color)) {
            relationshipMap.put(genre, color);
        }
    }

    public String getGenre(int color){
        for(Entry<String, Integer> e : relationshipMap.entrySet()){
            if(e.getValue() == color){
                return e.getKey();
            }
        }

        return "";
    }

    public String[] getColors(String[] s){
        int i = 0;
        int size = relationshipMap.size();
        String res[] = new String[size];

        for(String color : s){
            if(relationshipMap.containsValue(color)){
                res[i++] = color;
            }
        }

        return res;
    }
}
