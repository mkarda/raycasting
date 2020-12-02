package Google.DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Autocomplete {

    public static void main(String[] args) {

        String[] s = new String[] {"jedne", "dwa", "trzy"};
        int[] times = new int[] {1,2,3};
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(s, times);

    }

    static class Node {
        String sentence;
        int times;

        Node(String st, int t) {
            sentence = st;
            times = t;
        }
    }

    static class AutocompleteSystem {
        private HashMap<String, Integer>[] arr;
        private String cur_sent = "";

        public AutocompleteSystem(String[] sentences, int[] times) {
            arr = new HashMap[26];
            for (int i = 0; i < 26; i++) arr[i] = new HashMap<String, Integer>();
            for (int i = 0; i < sentences.length; i++)
                arr[sentences[i].charAt(0) - 'a'].put(sentences[i], times[i]);
        }

        public List<String> input(char c) {
            List<String> res = new ArrayList<>();
            if (c == '#') {
                arr[cur_sent.charAt(0) - 'a'].put(
                        cur_sent, arr[cur_sent.charAt(0) - 'a'].getOrDefault(cur_sent, 0) + 1);
                cur_sent = "";
            } else {
                List<Node> list = new ArrayList<>();
                cur_sent += c;
                for (String key : arr[cur_sent.charAt(0) - 'a'].keySet()) {
                    if (key.indexOf(cur_sent) == 0) {
                        list.add(new Node(key, arr[cur_sent.charAt(0) - 'a'].get(key)));
                    }
                }
                Collections.sort(
                        list,
                        (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
                for (int i = 0; i < Math.min(3, list.size()); i++) res.add(list.get(i).sentence);
            }
            return res;
        }
    }
}
