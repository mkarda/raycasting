package Goldman;

        import java.util.Arrays;

public class ReverseWordsInArray {

    public static void main(String[] args) {

        char[] input = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};

        char[] result = invert(input);

        System.out.println(result);
    }

    private static char[] invert(char[] input) {

        reverse(input);
        System.out.println(input);


        int beginingIndex = 0;
        for (int i = 0; i < input.length; i++) {

            if (input[i] == ' ') {
                reverseSingleWord(input, beginingIndex, i-1);
                beginingIndex = i+1;
            }
        }
        reverseSingleWord(input, beginingIndex, input.length-1);

        return input;



    }

    private static void reverseSingleWord(char[] arr, int beginingIndex, int endIndex) {
        System.out.println(beginingIndex);
        System.out.println(endIndex);

        int flips = (endIndex-beginingIndex)/2;


        for (int i = 0; i < flips; i++) {
            char temp = arr[beginingIndex+i];
            arr[beginingIndex+i] = arr[endIndex-i];
            arr[endIndex-i] = temp;
            System.out.println(arr);
        }
        System.out.println("------");
    }

    static void reverse(char[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-1-i] = temp;
        }
    }
}
