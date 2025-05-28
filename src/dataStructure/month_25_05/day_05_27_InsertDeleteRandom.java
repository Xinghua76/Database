package dataStructure.month_25_05;

import java.util.ArrayList;
import java.util.HashMap;

public class day_05_27_InsertDeleteRandom {
    class RandomizedSet {
        public HashMap<Integer, Integer> map;
        public ArrayList<Integer> arr;

        public RandomizedSet() {
            map = new HashMap<>();
            arr = new ArrayList<>();
        }
        
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            } else {
                map.put(val, arr.size());
                arr.add(val);
                return true;
            }
        }
        
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            } 
            int valIndex = map.get(val);
			int endValue = arr.get(arr.size() - 1);
			map.put(endValue, valIndex);
			arr.set(valIndex, endValue);
			map.remove(val);
			arr.remove(arr.size() - 1);
			return true;
        }
        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }
    }   
}
