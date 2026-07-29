class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findPosition(nums, target, true);  // Find first occurrence
        result[1] = findPosition(nums, target, false); // Find last occurrence
        return result;
    }

    private int findPosition(int[] nums, int target, boolean findFirst) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents integer overflow

            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                index = mid; // Potential answer found
                if (findFirst) {
                    high = mid - 1; // Keep searching left for the first position
                } else {
                    low = mid + 1;  // Keep searching right for the last position
                }
            }
        }
        return index;
    }
}
