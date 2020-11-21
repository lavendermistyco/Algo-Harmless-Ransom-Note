package hbcu.stay.ready.algor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public Boolean harmlessRansomNote(String message , String magazineText){
        Map<String, Integer> messageMap = populateMap(message);
        Map<String, Integer> magazineMap = populateMap(magazineText);
        //iterate over entry set in magazineMap
        //entry: <key, value>
        //entry: <this, 1>
        for(Map.Entry<String, Integer> entry: messageMap.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            if(magazineMap.get(key) < value || !magazineMap.containsKey(key)){
                return false;
            }
        }
        return true;
}

    public Map<String, Integer> populateMap(String str){
        String[]  arr = str.split(" ");
        Map<String, Integer> map = new TreeMap<>();
        for(String word : arr){
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }
}
