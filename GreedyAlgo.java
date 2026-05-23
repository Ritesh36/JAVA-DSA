import java.util.*;

public class GreedyAlgo {

    /**
     * The `nonOverLapping` function takes an array of intervals, sorts them based on the end points,
     * and returns the minimum number of intervals that need to be removed to make sure none of them
     * overlap.
     * 
     * @param intervals The `intervals` parameter in the `nonOverLapping` method is a 2D array where
     * each subarray represents an interval. Each subarray has two elements: the start of the interval
     * at index 0 and the end of the interval at index 1.
     * @return The `nonOverLapping` method returns the number of intervals that need to be removed in
     * order to make the given set of intervals non-overlapping.
     */
    public static int nonOverLapping(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int removed = 0;
        int lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                removed++;
            } else {
                lastEnd = intervals[i][1];
            }
        }
        return removed;
    }

    /**
     * The function `findMinArrowShots` takes an array of points, sorts them based on the end points,
     * and calculates the minimum number of arrows needed to burst all the balloons.
     * 
     * @param points A 2D array where each subarray represents a balloon with its start and end
     * coordinates. The function `findMinArrowShots` calculates the minimum number of arrows needed to
     * burst all the balloons without missing any.
     * @return The method `findMinArrowShots` returns the minimum number of arrows that can burst all
     * the balloons represented by the input points array.
     */
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 0;
        int lastEnd = Integer.MIN_VALUE;
        for (int[] point : points) {
            if (point[0] > lastEnd) {
                arrows++;
                lastEnd = point[1];
            }
        }
        return arrows;
    }

    public static void maxActivity(int start[], int end[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int maxActivity = 1;
        int lastEnd = end[0];
        ans.add(0);

        for (int i=1; i<end.length; i++) {
            if (start[i] >= lastEnd) {
                maxActivity++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("Max Activity: " + maxActivity);
        for (int i=0; i<ans.size(); i++) {
            System.out.print("A"+ ans.get(i)+ " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        // int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        // System.out.println(nonOverLapping(intervals));

        // int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        // System.out.println(findMinArrowShots(points));

        int start[] = {10, 12, 20};
        int end[] = {20, 25, 30};
        maxActivity(start, end);
    }
}
