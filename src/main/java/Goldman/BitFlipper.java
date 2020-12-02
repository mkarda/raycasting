package Goldman;

import java.util.*;

public class BitFlipper {


    public static void main(String args[])
    {

        String str = "0001010111";
        System.out.println(minFlipToMakeStringAlternate(str));
    }
    private static int minFlipToMakeStringAlternate(String str)
    {
        return Math.min(getFlipWithStartingCharcter(str, '0'),
                getFlipWithStartingCharcter(str, '1'));
    }

    private static int getFlipWithStartingCharcter(String str, char expected)
    {
        int flipCount = 0;


        for (char c : str.toCharArray()) {

            if (c != expected) {
                flipCount++;
            }
            expected = flip(expected);
        }
        return flipCount;
    }

    private static char flip(char ch)
    {
        return (ch == '0') ? '1' : '0';
    }

}
