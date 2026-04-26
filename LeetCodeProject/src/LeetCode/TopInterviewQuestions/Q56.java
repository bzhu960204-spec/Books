package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q56 {
    /*
    Given an array of intervals where intervals[i] = [starti, endi],
    merge all overlapping intervals,
    and return an array of the non-overlapping intervals that cover all the intervals in the input.
    */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });
        List<List<Integer>> resultList = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i < intervals.length - 1 && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            i++;
            List<Integer> range = new ArrayList<>();
            range.add(start);
            range.add(end);
            resultList.add(range);
        }
        int[][] resultArray = new int[resultList.size()][2];
        for (int j = 0; j < resultList.size(); j++) {
            resultArray[j][0] = resultList.get(j).get(0);
            resultArray[j][1] = resultList.get(j).get(1);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        Q56 q56 = new Q56();
        int[][] intervals = new int[][]{
                new int[]{1, 4},
                new int[]{0, 5},
        };
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });
        for (int[] array : intervals) {
            System.out.println(Arrays.toString(array));
        }
    }
}
