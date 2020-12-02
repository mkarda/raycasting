package Goldman;

public class KnapsackProblem {

    static int value[] = {60, 100, 1000};
    static int weight[] = {10,20,30};
    public static void main(String[] args) {


        int W = 50;

        int result = dynamic(W, weight, value);
        System.out.println(result);


    }

    private static int dynamic(int W, int[] weight, int[] value) {


        int[][] K = new int[value.length + 1][W + 1];

        for (int i = 0; i <= value.length; i++) {
            for (int w = 0; w <= W; w++) {

                if (i==0 || w==0) {
                    K[i][w] = 0;
                } else if(weight[i-1] <= w ) {
                    K[i][w] = Math.max(value[i-1] + K[i-1][w-weight[i-1]],  K[i-1][w]);
                } else {
                    K[i][w] = K[i-1][w];
                }
            }
        }

        print2D(K);
        return K[value.length][W];
    }

    public static void print2D(int mat[][]) {

        System.out.print("    ");
        for (int c : weight) {
            System.out.print(c + " ");

        }

        System.out.println();
        String str = " " + value;
        int c = 0;

        for (int[] row : mat) {
            // Loop through all columns of current row
            System.out.print(str.toCharArray()[c] + " ");
            c++;
            for (int x : row) {

                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
