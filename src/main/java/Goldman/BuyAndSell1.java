package Goldman;

public class BuyAndSell1 {

    public static void main(String[] args) {


//        int[] input = {7, 1, 5, 3, 6, 4};
        int[] input = {2, 5, 0, 2,3, 4};

        int result = getMaxProfit(input);
        System.out.println(result);
    }

    private static int getMaxProfit(int[] input) {
        int maxCur = 0;
        int maxSoFar = 0;


        for (int i = 1; i < input.length; i++) {

            maxCur = Math.max(0,maxCur += input[i] - input[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }

        return maxSoFar;

    }
}
