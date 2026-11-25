import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int insertPosition = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[insertPosition++] = num;
            }
        }

        while (insertPosition < nums.length) {
            nums[insertPosition++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Before: " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("After: " + Arrays.toString(nums));

        int[] nums2 = {0, 0, 1};
        System.out.println("Before: " + Arrays.toString(nums2));
        moveZeroes(nums2);
        System.out.println("After: " + Arrays.toString(nums2));
    }
}
