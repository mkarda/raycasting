package Goldman;

import java.util.*;

public class findAnagrams {

    public static void main(String[] args) {


        String arr[] = { "cat", "dog", "tac", "god", "act" };

        findAnagrams(arr);
    }

    private static void findAnagrams(String[] arr) {



        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : arr) {
            char[] letters = word.toCharArray();

            Arrays.sort(letters);

            String newWord =  new String(letters);

            if (map.containsKey(newWord)) {
                map.get(newWord).add(word);
            } else {
                List<String> words = new ArrayList<>();
                words.add(word);
                map.put(newWord, words);
            }
        }

        map.values().forEach(System.out::println);

    }
}
