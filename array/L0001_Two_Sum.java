package array;

import java.util.HashMap;
import java.util.Map;

public class L0001_Two_Sum {
    public static int[] twoSumBruteForce(int[] a, int target) {
        int[] result = new int[2];
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static int[] twoSumHashMap(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int complement = target - a[i]; // the key we want to find in map
            if (map.containsKey(complement)) {
                // if found, return the complement's index & current number's index
                return new int[] { map.get(complement), i };
            }
            // if no complement found, put the visisted number and index in map
            map.put(a[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[][] nums = { { 2, 7, 11, 15 }, { 3, 2, 4 }, { 3, 3 } };
        int[] targets = { 9, 6, 6 };
        int[][] answers = { { 0, 1 }, { 1, 2 }, { 0, 1 } };

        boolean passed = true;
        for (int i = 0; i < nums.length; i++) {
            int[] result = twoSumHashMap(nums[i], targets[i]);
            for (int j = 0; j < result.length; j++) {
                if (result[j] != answers[i][j]) {
                    passed = false;
                    break;
                }
            }
            if (!passed) {
                System.out.println("Test failed at index: " + i);
                break;
            }
        }
        if (passed) {
            System.out.println("All tests passed.");
        }

    }
}
