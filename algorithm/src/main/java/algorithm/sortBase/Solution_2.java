package algorithm.sortBase;

public class Solution_2 {

    public static void main(String[] args) {
        int arrays[] = new int[]{11, 8, 3, 9, 7, 1, 2, 5};
    }

    public int partition(int[] arrays, int start, int end) {
        int pivot = arrays[end];
        int i = start;
        for (int j = start; j <= end - 1; j++) {
            if (arrays[j] < pivot) {
                swap(arrays, i, j);
                i++;
            }
        }
        swap(arrays, i, end);
        return i;
    }

    public void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[i] = temp;
    }
}
