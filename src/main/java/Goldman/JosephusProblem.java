package Goldman;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

    public static void main(String[] args) {


        int result = getWinnner(14, 2);
        System.out.println(result);
    }


    private static int getWinnner(int n, int k) {

        if (n == 1) {
            return 0;
        } else {
            return (getWinnner(n-1, k) + k) % n;
        }
    }
}
