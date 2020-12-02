package Goldman;

public class RemoveBitToMakeStringAlternate {



    static int countToMake0lternate(String s)
    {
        int result = 0;

        for (int i = 0; i < (s.length() - 1); i++)

            // if two alternating characters
            // of string are same
            if (s.charAt(i) == s.charAt(i + 1))
                result++; // then need to
        // delete a character

        return result;
    }

    // Driver code
    static public void main(String[] args)
    {
        System.out.println(countToMake0lternate("000111"));
        System.out.println(countToMake0lternate("11111"));
        System.out.println(countToMake0lternate("01010101"));
    }

}
