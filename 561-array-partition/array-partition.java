import java.util.*;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;

        // Take every alternate element (even index)
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}