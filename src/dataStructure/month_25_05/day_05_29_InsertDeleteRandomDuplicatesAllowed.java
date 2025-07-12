    package dataStructure.month_25_05;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.HashSet;

    public class day_05_29_InsertDeleteRandomDuplicatesAllowed {
        class RandomizedCollection {
            public HashMap<Integer, HashSet<Integer>> map;

            public ArrayList<Integer> arr;

            public RandomizedCollection() {
                map = new HashMap<>();
                arr = new ArrayList<>();
            }
            
            public boolean insert(int val) {
                arr.add(val);
                HashSet<Integer> set = map.getOrDefault(val, new HashSet<Integer>());
                set.add(arr.size() - 1);
                map.put(val, set);
                return true;
            }
            
            public boolean remove(int val) {
                if (!map.containsKey(val)) {
                    return false;
                } 
                HashSet<Integer> valSet = map.get(val);
                int endVal = arr.get(arr.size() - 1);
                int valIndex = valSet.iterator().next();
                if (val == endVal) {
                    valSet.remove(arr.size() - 1);
                } else {
                    HashSet<Integer> endSet = map.get(endVal);
                    arr.set(valIndex, endVal);
                    valSet.remove(valIndex);
                    endSet.remove(arr.size() - 1);
                    endSet.add(valIndex);
                    arr.remove(arr.size() - 1);
                }

                if (valSet.isEmpty()) {
                    map.remove(val);
                }

                return true;
            }
            
            public int getRandom() {
                return arr.get((int)(Math.random() * arr.size()));
            }
        }    
    }
