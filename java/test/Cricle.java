package test;

import java.util.*;

public class Cricle {

    public Map<String, Object> fastSort(Map<String, Object> map) {
        Map<String, Object> sortMap = new TreeMap<String, Object>(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
        sortMap.putAll(map);
        Set<String> set = map.keySet();
        for (String key : set) {
            Object o = map.get(key);
            if (o instanceof Map) {
                fastSort((Map<String, Object>) map.get(key));
            } else if (o instanceof List) {
                Collections.sort((List<String>) o);
            }
        }

        return sortMap;
    }

    public static void main(String[] args) {

    }


}
