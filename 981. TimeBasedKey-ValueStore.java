import java.util.ArrayList;
import java.util.HashMap;

class TimeMap {

    HashMap<String, ArrayList<String[]>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<String[]> list = map.getOrDefault(key, new ArrayList<>());
        String[] str = {value, String.valueOf(timestamp)};
        list.add(str);
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";

        ArrayList<String[]> list = map.get(key);
        int low = 0;
        int high = list.size() - 1;
        String result = "";

        while(low <= high){
            int mid = low + (high - low)/2;
            int midTime = Integer.parseInt(list.get(mid)[1]);

            if(midTime <= timestamp){
                result = list.get(mid)[0];
                low = mid + 1; // search for a larger valid timestamp
            } else
                high = mid - 1;
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */