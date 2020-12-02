package Goldman;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] input = {3, 0, 0, 2, 0, 4};
        int result = solve(input);
        int result2 = solveQuicker(input);

        System.out.println(result);
        System.out.println(result2);
    }

    private static int solveQuicker(int[] input) {
        int result = 0;
        int left = 0;
        int right = input.length - 1;


        while (left < right) {
            result = Math.max(result, Math.min(input[left], input[right]) * (right - left));
            if (input[left] < input[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    private static int solve(int[] input) {

        int result = 0;

        int left_hight = 0;
        int right_hight = 0;

        int left = 0, right = input.length - 1;

        while (left < right) {
            if (input[left] < input[right]) {
                if (input[left] > left_hight) {
                    left_hight = input[left];
                } else {
                    result += left_hight - input[left];
                    left++;
                }

            } else {
                if (input[right] > right_hight) {
                    right_hight = input[right];
                } else {
                    result += right_hight - input[right];
                    right--;
                }
            }
        }
        return result;
    }
}
