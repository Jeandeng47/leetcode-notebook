package array;

public class L0027_Remove_Element {
    public static int removeElement(int[] a, int val) {
        int slow = 0; // slow: track position to be filled

        // fast: track next element that move forward
        for (int fast = 0; fast < a.length; fast++) {
            if (a[fast] != val) {
                a[slow] = a[fast];
                slow++;
            }
        }
        return slow;
    }

}
