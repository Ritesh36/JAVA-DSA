import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_Demo {

    //Swapping two elements in the ArrayList
    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    //Maximum water in container
    //Brute Force Approach - O(n^2)
    // public static int storeWater(ArrayList<Integer>height) {
    //     int maxWater = 0;
    //     for(int i=0; i<height.size(); i++) {
    //         for(int j=i+1; j<height.size(); j++) {
    //             int ht = Math.min(height.get(i), height.get(j));
    //             int width = j - i;
    //             int currWater = ht * width;
    //             maxWater = Math.max(maxWater, currWater);
    //         }
    //     }

    //     return maxWater;
    // }

    //2 Pointer Approach - O(n)
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0, rp = height.size() - 1;

        while(lp < rp) {
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);

            if(height.get(lp) < height.get(rp)) {
                lp ++;
            } else {
                rp --;
            }
        }
        return maxWater;
    }

    //Brute Force
    // public static void pairSum(ArrayList<Integer>arr, int target) {
    //     for(int i=0; i<arr.size(); i++) {
    //         for(int j=i+1; j<arr.size(); j++) {
    //             if(arr.get(i) + arr.get(j) == target) {
    //                 System.out.println("[" + arr.get(i)+","+ arr.get(j)+ "]");
    //             }
    //         }
    //     }
    // }
    
    //Time Complexity - O(n)
    public static boolean pairSum2(ArrayList<Integer>list, int target) {
        int bp = 0;

        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) > list.get(i+1)) {
                bp = i;
                break;
            }
        }
        int lp = bp + 1;
        int rp = bp;

        while(lp != rp) {
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }
            if(list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % list.size();
            } else {
                rp = (rp - 1 + list.size()) % list.size();
            }   
        }
        return false;
    }

    public static boolean isMonotone(ArrayList<Integer>arr) {
        boolean inc = true;
        boolean dec = true;
        for(int i=0; i<arr.size()-1; i++) {
            if(arr.get(i) < arr.get(i+1)) {
                dec = false;
            } else if(arr.get(i) > arr.get(i+1)) {
                inc = false;
            }
        }
        return inc || dec;
    }

    public static ArrayList<Integer> lonelyInt(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            boolean isLonely = true;
            int count = 0;

            // Count occurrences of the current element
            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(i).equals(arr.get(j))) {
                    count++;
                }
            }

            // If the element appears more than once, it's not lonely
            if (count > 1) {
                isLonely = false;
            }

            // Check the previous element
            if (i > 0 && Math.abs(arr.get(i) - arr.get(i - 1)) == 1) {
                isLonely = false;
            }

            // Check the next element
            if (i < arr.size() - 1 && Math.abs(arr.get(i) - arr.get(i + 1)) == 1) {
                isLonely = false;
            }

            // Add to result if it's lonely
            if (isLonely) {
                result.add(arr.get(i));
            }
        }
        return result;
    }

    public static void mergeTwoSortedList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        // Add remaining elements
        while (i < list1.size()) {
            mergedList.add(list1.get(i++));
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j++));
        }

        Collections.sort(mergedList); // Sort the merged list in ascending order

        System.out.println(mergedList);
    }


    public static void main(String args[]) {
        // ArrayList<Integer> list = new ArrayList<>();

        // Adding elements to the ArrayList
        // for(int i=1; i<=5; i++) {
        //     list.add(i);
        // }

        // list.add(2);
        // list.add(5);
        // list.add(9);
        // list.add(3);
        // list.add(1);

        // System.out.println("ArrayList: " + list);

        // Accessing elements
        // System.out.println("Element at index 2: " + list.get(2));

        // Removing elements
        // list.remove(2); // removes the element at index 2
        // System.out.println("ArrayList after removal: " + list);

        // Setting elements
        // list.set(2, 10); // sets the element at index 2 to 10
        // System.out.println("ArrayList after setting: " + list);

        // Contains method
        // System.out.println(list.contains(5));
        // System.out.println(list.contains(10)); // false

        // Size of the ArrayList
        // System.out.println("Size of ArrayList: " + list.size());

        //Reverse Print
        // for(int i=list.size() - 1; i>=0; i--) {
        //     System.out.print(list.get(i) + " ");
        // }

        //Find maximum in the ArrayList
        // int max = Integer.MIN_VALUE; 
        // for(int i=0; i<list.size(); i++) {
            // if(max < list.get(i)) {
            //     max = list.get(i);
            // }

        //     max = Math.max(max, list.get(i));
        // }
        // System.out.println("Maximum value in the ArrayList: " + max);
        
        // swap(list, 2, 4);
        // System.out.println(list);

        // Collections.sort(list);  //ascending order
        // System.out.println(list);

        // Collections.sort(list, Collections.reverseOrder());  //descending order
        // System.err.println(list);

        //2D Arraylist
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        
        // ArrayList<Integer> list1 = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();

        // for(int i=1; i<=5; i++) {
        //     list1.add(i*1);
        //     list2.add(i*2);
        //     list3.add(i*3);
        // }

        // list2.remove(2);
        // list2.remove(3);
        
        // mainList.add(list1);
        // mainList.add(list2);
        // mainList.add(list3);

        // System.out.println(mainList);

        // for(int i=0; i<mainList.size(); i++) {
        //     ArrayList<Integer> currList = mainList.get(i);
        //     for(int j=0; j<currList.size(); j++) {
        //         System.out.print(currList.get(j)+ " ");
        //     }
        //     System.out.println();
        // }

        // ArrayList<Integer> height = new ArrayList<>();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);

        // System.out.println(storeWater(height));

        // ArrayList<Integer> arr = new ArrayList<>();
        // arr.add(1);
        // arr.add(2);
        // arr.add(3);
        // arr.add(4);
        // arr.add(5);
        // arr.add(6);

        // pairSum(arr, 5);

        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(11);
        // list.add(15);
        // list.add(6);
        // list.add(8);
        // list.add(9);
        // list.add(10);

        // int target = 16;

        // System.out.println(pairSum2(list, target));

        ArrayList<Integer>arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(3);
        System.out.println(lonelyInt(arr));

        // ArrayList<Integer> list1 = new ArrayList<>();
        // list1.add(1);
        // list1.add(3);
        // list1.add(5);
        // list1.add(3);
        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(2);
        // list2.add(4);
        // list2.add(6);
        // mergeTwoSortedList(list1, list2);
    }
}
