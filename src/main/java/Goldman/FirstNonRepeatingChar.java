package Goldman;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FirstNonRepeatingChar {

    static HashMap<Character, CCounter> hm = new HashMap<>(256);

    public static void main(String[] args) {


        boolean b = Integer.valueOf(128) == Integer.valueOf(128);
        System.out.println(b);


        Optional<Map.Entry<Character, CCounter>> index = nonRepeating("geeksfforrgeeks");

        if (index.isPresent()) {
            System.out.println(index.get().getKey());
        } else{
            System.out.println("ni ma");
        }
    }

    private static Optional<Map.Entry<Character, CCounter>> nonRepeating(String str) {

        for (char c : str.toCharArray()) {
            if (hm.containsKey(c)) {
                hm.get(c).addCount();
            } else {
                hm.put(c, new CCounter(c));
            }
        }

        return hm.entrySet().stream().filter(x -> x.getValue().count == 1).findFirst();
    }

    private static class CCounter {
        int count, index;

        public CCounter(int index) {
            this.count = 1;
            this.index = index;
        }

        public void addCount(){
            this.count++;
        }
    }
}
