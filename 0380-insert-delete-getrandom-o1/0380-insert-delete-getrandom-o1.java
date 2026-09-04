import java.util.ArrayList;
import java.util.HashSet;

class RandomizedSet {

    HashSet<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(!set.contains(val)){
            set.add(val);
            return true;
        } else
            return false;
    }
    
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        } else
            return false;
    }
    
    public int getRandom() {
        ArrayList<Integer> array = new ArrayList<>(set);
        return array.get( (int) (Math.random() * array.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */