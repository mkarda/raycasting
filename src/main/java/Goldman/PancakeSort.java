package Goldman;

import java.util.Arrays;

public class PancakeSort {

    public static void main(String[] args) {


        int[] ar = {3,4,2,1};
        int[] result = sortuj(ar);
        System.out.println(Arrays.toString(result));


    }

    private static int[] sortuj(int[] ar) {
        if (ar == null || ar.length < 2) {
             return ar;
        }

        for (int i = ar.length-1; i>=0; i--) {
            int maxElementIndex = i;

            for (int j = i; j >=0; j--) {
                if (ar[j] > ar[maxElementIndex]) {
                    maxElementIndex = j;
                }
            }
            flip(ar,maxElementIndex+1);
            flip(ar,i+1);
        }
        return ar;

    }

    private static void flip(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0 ; i < k/2; i++) {
            int temp = arr[i];
            arr[i] = arr[k-i-1];
            arr[k-i-1] = temp;
        }
        System.out.println(k + "   " + Arrays.toString(arr));
    }
}
