import java.util.List;

public class RecursionBasics {

    static String nos[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    //Print Decreasing Order
    public static void printDec(int n) {
        if(n == 1) {
            return;
        }
        System.out.print(n+ " ");
        printDec(n - 1);
        //Output: 10 9 8 7 6 5 4 3 2 1
    }

    //Print Increasing Order
    public static void printInc(int n) {
        if(n == 1) {
            System.out.print(1+ " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
        //Output: 1 2 3 4 5 6 7 8 9 10
    }

    //Print Factorial
    public static int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        int fn = n * factorial(n-1);
        return fn;
        //Output: 120
    }

    //Print sum of N natural nos.
    public static int sumOfNatural(int n) {
        if(n == 1) {
            return 1;
        }
        return n + sumOfNatural(n-1);
    }

    //calculate nth number of fibonacci
    public static int fibn(int n) {
        if(n==0 || n==1) {
            return n;
        }

        return fibn(n - 1) + fibn(n - 2);
    }

    //check array is sorted or not
    public static boolean isSorted(int arr[], int i) {
        if(i == arr.length-1) {
            return true;
        }

        if(arr[i] > arr[i+1]) {
            return false;
        }

        return isSorted(arr, i+1);
    }

    //find first occurence of no.
    public static int firstOccurence(int arr[], int key, int i) {
        if(i == arr.length - 1) {
            return -1;
        }

        if(arr[i] == key) {
            return i;
        }

        return firstOccurence(arr, key, i+1);
    }

    //find last occurence of no.
    public static int lastOccurence(int arr[], int key, int i) {
        if(i == arr.length - 1) {
            return -1;
        }

        int isFound = lastOccurence(arr, key, i+1);

        if(isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;
    }

    //print x to power of n
    public static int power(int x, int n) {
        if(n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    //Tiling Problem
    public static int tilingProblem(int n) {
        //base case
        if(n == 0 || n == 1) {
            return 1;
        }

        //kaam
        int fnm1 = tilingProblem(n-1);
        int fnm2 = tilingProblem(n-2);

        return fnm1 + fnm2;
    }

    //Remove duplicates from string 
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        //Base Case
        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        //kaam
        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true) {
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
    }

    //Friend's Pairing Problem
    public static int friendsPairing(int n) {
        //Base Case
        if(n == 1 || n == 2) {
            return n;
        }

        //Choices
        //Single
        int fnm1 = friendsPairing(n-1);

        //Pair
        int fnm2 = (n-1) * friendsPairing(n-2);

        //Total Ways
        int totalWays = fnm1 + fnm2;

        return totalWays;
    }

    //Binary Strings Problem
    public static void binaryStrings(int n, int lastPlace, String str) {
        //Base Case
        if(n == 0) {
            System.out.println(str);
            return;
        }

        binaryStrings(n-1, 0, str+"0");
        if(lastPlace == 0) {
            binaryStrings(n-1, 1, str+"1");
        }
    }

    //Find Occurences of key
    public static void findOccurences(int arr[], int key, int idx) {
        //Base Case
        if(idx == arr.length) {
            return;
        }

        //kaam
        if(arr[idx] == key) {
            System.out.print(idx + " ");
        }

        findOccurences(arr, key, idx+1);
    }

    //Print Digits
    public static void printNos(int n) {
        //base case
        if(n == 0) {
            return;
        }

        //kaam
        int lastDigit = n % 10;
        printNos(n/10);
        System.out.println(nos[lastDigit]);

    }

   // Calculate length of string
   public static int stringLen(String str, int idx, int count) {
    // Base Case
    if (idx == str.length()) {
        return count; // Return the count when the end of the string is reached
    }

    // Recursive call
    return stringLen(str, idx + 1, count + 1);
   }

    // Count substrings that start and end with the same character
    public static int countSubstrings(String s, int start, int end) {
        // Base case: if end exceeds string length
        if (start >= s.length()) {
            return 0;
        }
        if (end > s.length()) {
            // Move to next starting character
            return countSubstrings(s, start + 1, start + 2);
        }

        int count = 0;
        // Check if substring starts and ends with the same character
        if (s.charAt(start) == s.charAt(end - 1)) {
            count = 1;
        }

        // Continue recursion with next substring
        return count + countSubstrings(s, start, end + 1);
    }

    //print Subsequences of array
    public static void printSubsequences(int idx, int arr[], List<Integer> current) {
        //Base Case
        if(idx == arr.length) {
            System.out.println(current);
            return;
        }

        //Include
        current.add(arr[idx]);
        printSubsequences(idx + 1, arr, current);

        //Exclude
        current.remove(current.size() - 1);
        printSubsequences(idx + 1, arr, current);
    }

    //find out the sum of its digits using recursion;
    public static int integerSum(int num, int sum) {
        if(num == 0) {
            return sum;
        }
        int digit = num % 10;
        sum += digit;
        num = num / 10;
        return integerSum(num, sum);
    }

    //return the count of digits in a number
    public static int countDigits(int num) {
        if(num == 0) {
            return 0;
        }
        return 1 + countDigits(num / 10);
    }

    public static void printMultiples(int num, int k) {
        if(k == 0) {
            return;
        }
        printMultiples(num, k-1);
        System.out.println(num * k);
    }

    //Find the sum of natural nos. till n but with alternate signs
    public static int alternateSignsSum(int n) {
        if(n == 0) return 0;

        if(n % 2 == 0) {
            return alternateSignsSum(n-1) - n;
        } else {
            return alternateSignsSum(n-1) + n;
        }
    }

    //GCD (Greatest Common Divisor) 
    /**
     * The function calculates the greatest common divisor (GCD) of two integers using recursion.
     * 
     * @param x The parameter `x` represents the first integer input for which you want to find the
     * greatest common divisor (GCD) with another integer `y`.
     * @param y The parameter `y` represents the second integer input for which we are calculating the
     * Greatest Common Divisor (GCD) with the first integer `x`.
     * @return The Greatest Common Divisor (GCD) of the two input integers `x` and `y` is being
     * returned.
     */
    public static int GCD(int x, int y) {
        if(y == 0) {
            return x;
        }
        return GCD(y, x % y);
    }

    //print the max value of the array
    public static void maxValue(int arr[], int i, int maximum) {
        if(i == arr.length) {
            System.out.println(maximum);
            return;
        }
        maximum = Math.max(maximum, arr[i]);
        maxValue(arr, i + 1, maximum);
    }

    public static int arraySum(int arr[], int i) {
        if(i == arr.length) {
            return 0;
        }
        int val = arraySum(arr, i+1);
        return val + arr[i];
    }

    //Print where x exists in the array or not
    public static boolean searchInArray(int arr[], int i, int x) {
        // base case
        if(i >= arr.length)  return false;
        // self work
        if(arr[i] == x)  return true;
        //recursive work 
        return searchInArray(arr, i + 1, x);
    }

    public static void searchIdx(int arr[], int i, int x) {
        if(i >= arr.length) return;

        if(arr[i] == x) {
            System.out.print(i + " ");
        }

        searchIdx(arr, i + 1, x);
    }

    public static String removeOccurences(String str, int i) {
        if(i == str.length()) {
            return "";
        }
        char currChar = str.charAt(i);
        String restOfString = removeOccurences(str, i + 1);
        if(currChar == 'a') {
            return restOfString;
        }
        return currChar + restOfString;
    }

    public static String removeOccurences2(String str) {
        if(str.length() == 0) {
            return "";
        }
        char currChar = str.charAt(0);
        String restOfString = removeOccurences2(str.substring(1));
        if(currChar == 'a') {
            return restOfString;
        }
        return currChar + restOfString;
    }

    /**
     * The function `keypadCombinations` recursively generates all possible combinations of characters
     * corresponding to a given numeric string using a keypad mapping.
     * 
     * @param dig The `dig` parameter is a String representing the digits for which we need to find all
     * possible keypad combinations. Each digit in the `dig` String corresponds to a set of characters
     * on a standard phone keypad.
     * @param kp The `kp` parameter in the `keypadCombinations` method is an array of strings that
     * represents the possible characters corresponding to each digit on a phone keypad. Each index of
     * the array corresponds to a digit from 0 to 9, and the string at that index contains the
     * characters that can
     * @param res The `res` parameter in the `keypadCombinations` method is used to store the current
     * combination of characters being generated as we recursively explore the possible combinations of
     * characters corresponding to the input digits.
     */
    public static void keypadCombinations(String dig, String kp[], String res) {
        if(dig.length() == 0) {
            System.out.print(res + " ");
            return;
        }

        int currNum = dig.charAt(0) - '0';
        String currChoices = kp[currNum];

        for(int i=0; i<currChoices.length(); i++) {
            keypadCombinations(dig.substring(1), kp, res + currChoices.charAt(i));
        }
    }

    public static void main(String[] args) {

        // String dig = "253";

        // String kp[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        // keypadCombinations(dig, kp, "");

        // int arr[] = {2, 5, 3, 1, 2};
        // System.out.println(searchInArray(arr, 0, 0));
        // searchIdx(arr, 0, 2);

        // System.out.println(removeOccurences("abracadabra", 0));

        // System.out.println(GCD(24, 15));
        // printDec(10);
        // printInc(10);
        // System.out.println(factorial(5));
        // System.out.println(sumOfNatural(5));
        // System.out.println(fibn(10));
        // int arr[] = {8, 6, 2, 4, 2, 10, 1, 2};
        // System.out.println(isSorted(arr, 0));
        // System.out.println(lastOccurence(arr, 6, 0));
        // System.out.println(power(2, 10));
        // System.out.println(tilingProblem(2));
        // String str = "appnnacollege";
        // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
        // System.out.println(friendsPairing(3));
        // binaryStrings(3, 0, "");
        // findOccurences(arr, 2, 0);
        // printNos(1234);
        // System.out.println(stringLen(str, 0, 0));
        // System.out.println(countSubstrings("aba", 0, 1)); // Example usage
        // int[] arr = {1, 2, 3};
        // List<Integer> current = new ArrayList<>();
        // printSubsequences(0, arr, current);

        // int num = 1234;
        // int sum = 0;
        // System.out.println("Sum of digits: " + integerSum(num, sum));
        // System.out.println("Count of digits: " + countDigits(num));

        // printMultiples(5, 4);
        // System.out.println(alternateSignsSum(4));
    }
}
