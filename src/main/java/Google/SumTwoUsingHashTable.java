package Google;

import java.util.HashMap;
import java.util.Map;

public class SumTwoUsingHashTable {

    public static void main(String[] args) {


        int[] nums = new int[] {2,7,11,15};
        int target = 9;

        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {

                System.out.println("Answer");
                System.out.println(i);
                System.out.println(map.get(complement));
            }
            map.put(nums[i], i);


        }

        int x = 5;
    }


}
