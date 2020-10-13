package Google;

public class MergeSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = new int[10];
        nums1 = new int[]{1, 2, 3, 4, 6};
        int[] nums2 = new int[]{1, 1, 3, 5, 7};

        int[] merge = merge(nums1, nums1.length, nums2, nums2.length);
        System.out.println(merge);
        int x = 5;
    }

    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0;
        int p2 = 0;

        int p = 0;

        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        }

        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }

        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }

        return nums1;
    }
}
