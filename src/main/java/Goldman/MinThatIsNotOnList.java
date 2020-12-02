package Goldman;

public class MinThatIsNotOnList {

    public static void main(String[] args) {


        int[] input = {1,4,6,4,8, 2, 100, 4,5,6,7,8, 43,654,434,4536,54,63,46,32456, 3};
        int result = getMin(input);
        System.out.println(result);

    }

    private static int getMin(int[] input) {


        int maxValue = Integer.MAX_VALUE;

        int[] vals = new int[500000];


        for (int x: input) {
            vals[x] = x;
        }


        for (int i = 1; i < maxValue; i++) {
            if (vals[i] == 0) {
                return i;
            }
        }

        return maxValue;
    }
}
