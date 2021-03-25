package Goldman;

import java.util.*;

public class aaa {
    public static void main(String[] args) {


        TreeNode t = new TreeNode(2, new TreeNode(4, new TreeNode(6), new TreeNode(9)), new TreeNode(2));
        int x = max_gain(t);

    }

    static int max_sum = Integer.MIN_VALUE;
    private static int max_gain(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left_gain = Math.max(max_gain(root.left), 0);
        int right_gain = Math.max(max_gain(root.right), 0);

        int price = root.val + left_gain + right_gain;

        max_sum = Math.max(max_sum, price);


//        return root.val + Math.max(left_gain, right_gain);


        Map<String, Integer> mapa = new HashMap<>();

        Integer one = mapa.computeIfAbsent("one", String::length);
        mapa.computeIfAbsent("one", x -> x.length());


        Integer one1 = mapa.computeIfPresent("one", (x, y) -> y + 1);
        Integer two1 = mapa.computeIfPresent("two", (x, y) -> y + 1);

        char a = ' ';

        List<String> l = new ArrayList<>();
        Set<String> s = new HashSet<>();
        String str = "   ";
        char c = str.charAt(1);   str.length();



        return 1;
    }
}
