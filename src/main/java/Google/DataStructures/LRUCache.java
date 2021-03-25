package Google.DataStructures;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {


        LRUCacheImpl cache = new LRUCacheImpl(10);

        cache.put(1,1);
        cache.put(2,2);
        cache.put(1,2);
        cache.put(3,3);
        cache.put(4,3);
        cache.put(5,3);
        cache.put(6,3);
        cache.put(7,3);
        cache.put(8,3);
        cache.put(9,3);
        cache.put(11,3);
        cache.put(12,3);
        cache.put(13,3);
        cache.put(14,3);
        cache.put(15,3);

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
