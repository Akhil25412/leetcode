class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;

        // Move non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }

        // Fill remaining positions with zeros
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
