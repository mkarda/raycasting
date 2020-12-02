package Goldman;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BiggestNumber {

    private static void printLargest(List<String> arr) {

        // A comparison function which is used by
// sort() in printLargest()
        arr.sort((X, Y) -> {

            // first append Y at the end of X
            String XY = X + Y;

            // then append X at the end of Y
            String YX = Y + X;

            // Now see which of the two formed numbers
            // is greater
            return XY.compareTo(YX) > 0 ? -1 : 1;
        });

        Iterator it = arr.iterator();

        while (it.hasNext())
            System.out.print(it.next());
        System.out.println();

    }

    // driver program
    public static void main(String[] args) {

        List<String> arr = new ArrayList<>();

        //output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);

        System.out.println("6054854654");


    }


}
