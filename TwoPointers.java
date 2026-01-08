import java.util.Arrays;

public class TwoPointers {
    public static int[] twoPointer(int nums[], int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[] { i + 1, j + 1 };
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void removeDuplicates(int nums[]) {
        int i = 0; // Points to last unique element position
        for (int j = 1; j < nums.length; j++) { // j scans the array
            if (nums[j] != nums[i]) { // Found a new unique element
                i++; // Move to next position
                nums[i] = nums[j]; // Place unique element
            }
        }
        printArr(nums, i + 1); // Print only unique elements (count = i+1)
    }

    public static void printArr(int nums[], int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(); // New line at the end
    }

    public static boolean isValidPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(str.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(str.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    public static int containerWithMostWater(int height[]) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int currArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currArea);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    public static void main(String args[]) {
        // int nums[] = { 0, 0, 1, 1, 2, 3, 3 };
        // int target = 9;
        // System.out.println(Arrays.toString(twoPointer(nums, target)));
        // removeDuplicates(nums);
        // String str = "A man, a plan, a canal: Panama";
        // System.out.println(isValidPalindrome(str));
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(containerWithMostWater(height));
    }
}
