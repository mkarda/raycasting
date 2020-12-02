package Goldman;

public class Fibanaci {

    public static void main(String[] args) {


        int input = 9;
        int result = fib(9);
        System.out.println(result);

    }

    private static int fib(int input) {

        if (input <=1) {
            return input;
        }

        return fib(input - 1) + fib(input - 2);
    }
}
