package Google.DataStructures;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {


        LRUCacheImpl cache = new LRUCacheImpl(10);

        cache.put(1,1);
        cache.put(2,2);
        cache.put(1,2);

        int x = 5;

    }

    private static class LRUCacheImpl extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCacheImpl(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
