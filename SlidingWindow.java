import java.util.HashSet;

public class SlidingWindow {
    /**
     * The function `maximumSubarraySum` finds the maximum sum of a subarray with exactly `k` distinct
     * elements in an array.
     * 
     * @param nums The `nums` parameter is an array of integers that represents the input array for
     * which we need to find the maximum subarray sum with exactly `k` distinct elements.
     * @param k The `k` parameter in the `maximumSubarraySum` method represents the number of unique
     * elements you want to find in a subarray. The method calculates the maximum sum of a subarray
     * that contains exactly `k` unique elements.
     * @return The `maximumSubarraySum` method returns the maximum sum of a subarray where the subarray
     * contains exactly `k` distinct elements from the input array `nums`.
     */
    public static int maximumSubarraySum(int nums[], int k)  {
        HashSet<Integer> seen = new HashSet<>();
        int maxSum = 0;
        int currSum = 0;
        int left = 0;

        for (int right=0; right<nums.length; right++) {
            while (seen.contains(nums[right]) || seen.size() == k) {
                seen.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
            seen.add(nums[right]);
            currSum += nums[right];

            if (seen.size() == k) {
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    /**
     * The `longestSubstring` function in Java finds the length of the longest substring without
     * repeating characters in a given string.
     * 
     * @param str The `longestSubstring` method you provided is used to find the length of the longest
     * substring without repeating characters in a given string. The method uses a sliding window
     * approach to keep track of the characters seen so far.
     * @return The `longestSubstring` method returns an integer value, which represents the length of
     * the longest substring without repeating characters in the input string `str`.
     */
    public static int longestSubstring(String str) {
        HashSet<Character> seen = new HashSet<>();
        int maxLen = 0;
        int left = 0;

        for (int right=0; right<str.length(); right++) {
            while (seen.contains(str.charAt(right))) {
                seen.remove(str.charAt(left));
                left++;
            }
            seen.add(str.charAt(right));
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }

   /**
    * The `minSubArrayLen` function in Java calculates the minimum length of a contiguous subarray
    * whose sum is greater than or equal to a given target value.
    * 
    * @param target The `target` parameter in the `minSubArrayLen` method represents the sum that we
    * want to find in the subarray. The method aims to find the minimum length of a contiguous subarray
    * of which the sum is greater than or equal to the target value.
    * @param num An array of integers representing the input numbers.
    * @return The `minSubArrayLen` method returns the minimum length of a contiguous subarray of the
    * input array `num` whose sum is greater than or equal to the target value.
    */
    public static int minSubArrayLen(int target, int num[]) {
        int left = 0;
        int currSum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right=0; right<num.length; right++) {
            currSum += num[right];
            while (currSum >= target) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                }
                currSum -= num[left];
                left++;
            }
        }
        return minLen;
    }
    public static void main(String[] args) {
        // int nums[] = {1, 5, 4, 2, 9, 9, 9};
        // int k = 3;
        // System.out.println(maximumSubarraySum(nums, k));

        // String str = "abcabcbb";
        // System.out.println(longestSubstring(str));

        int nums[] = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
