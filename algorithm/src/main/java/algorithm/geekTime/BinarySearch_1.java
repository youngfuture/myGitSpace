package algorithm.geekTime;

public class BinarySearch_1 {
    public static void main(String[] args) {
        int[] a = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
        System.out.println(a[new BinarySearch_1().bsearch(a, a.length, 33)]);
    }


    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
