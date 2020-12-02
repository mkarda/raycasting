package Goldman;

public class ReachTarget {

    static int reachTarget(int target)
    {

        target = Math.abs(target);

    // Keep moving while sum is smaller
    // or difference is odd.
    int sum = 0, step = 0;

        while (sum < target || (sum - target) % 2 != 0) {
        step++;
        sum += step;
    }
        return step;
}

    // Driver code
    public static void main(String args[])
    {
        int target = 5;
        System.out.println(reachTarget(target));
    }
}
