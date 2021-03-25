package Google.Trees;


public class BinaryTreeMAximumPathSum {
    private static int max_sum = Integer.MIN_VALUE;

    public static void main(String[] args) {


        TreeNode root = new TreeNode(-10, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null,null), new TreeNode(7, null, null)));
        int i = maxPathSum(root);
        System.out.println(i);

    }

    private static int maxPathSum(TreeNode root) {

        max_gain(root);
        return max_sum;

    }

    public static int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }


    /* Definition for a binary tree node. */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
