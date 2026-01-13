import java.util.HashMap;

public class PrefixSum {

    /**
     * The `pivotIndex` function in Java finds the index in an array where the sum of elements to the
     * left is equal to the sum of elements to the right.
     * 
     * @param nums The `pivotIndex` method you provided is used to find the index in an array where the
     * sum of the elements to the left of the index is equal to the sum of the elements to the right of
     * the index.
     * @return The `pivotIndex` method returns the index of the pivot element in the `nums` array. If
     * there is no pivot element found, it returns -1.
     */
    public static int pivotIndex (int nums[]) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    /**
     * The `subArraySum` function in Java calculates the number of subarrays in an array whose sum
     * equals a given target value `k`.
     * 
     * @param nums An array of integers representing the input array.
     * @param k The parameter `k` in the `subArraySum` method represents the target sum that you want
     * to find subarrays that sum up to `k`. The method calculates the number of subarrays in the given
     * `nums` array that sum up to the target `k`.
     * @return The `subArraySum` method returns the count of subarrays in the given `nums` array whose
     * sum is equal to the specified `k`.
     */
    public static int subArraySum(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /**
     * The function `checkSubarraySum` in Java checks if there exists a subarray with a sum that is a
     * multiple of a given integer `k`.
     * 
     * @param nums The `nums` parameter is an array of integers that represents the input array for
     * which we need to check if there exists a subarray with a sum that is divisible by `k`.
     * @param k The variable `k` in the `checkSubarraySum` method represents the target sum that you
     * are checking for in subarrays of the given `nums` array. The method uses a HashMap to keep track
     * of the running sum modulo `k` and the corresponding index. It then checks if there
     * @return The `checkSubarraySum` method returns an integer value. If a subarray with a sum that is
     * a multiple of `k` and has a length of at least 2 is found in the input array `nums`, it returns
     * 1. Otherwise, it returns 0.
     */
    public static int checkSubarraySum(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (mod < 0) {
                mod += k;
            }
            if (map.containsKey(mod)) {
                if (i - map.get(mod) >= 2) {
                    return 1;
                }
            } else {
                map.put(mod, i);
            }
        }
        return 0;
    }
    public static void main(String[] args) {

        // int nums[] = {1, 7, 3, 6, 5, 6};
        // int pivot = pivotIndex(nums);
        // System.out.println("Pivot Index: " + pivot);

        // int nums[] = {1, 2, 3};
        // int k = 3;
        // int count = subArraySum(nums, k);
        // System.out.println("Count of subarrays with sum " + k + " : " + count);

        int nums[] = {23, 2, 4, 6, 7};
        int k = 6;
        int result = checkSubarraySum(nums, k);
        System.out.println("Result of checkSubarraySum: " + result);
    }
}
