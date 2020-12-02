package Goldman;

public class average2LArgeNumbers {

    static int compute_average(int a,
                               int b)
    {
        return (a / 2) + (b / 2) + ((a % 2 + b % 2) / 2);
    }

    // Driver code
    public static void main (String[] args)
    {

// Assigning maximum
// integer value
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

// Average of two equal
// numbers is the same number
        System.out.println("Actual average : " +
                Integer.MAX_VALUE);

// Function to get the
// average of 2 numbers
        System.out.print("Computed average : ");
        System.out.println(compute_average(a, b));
    }
}
