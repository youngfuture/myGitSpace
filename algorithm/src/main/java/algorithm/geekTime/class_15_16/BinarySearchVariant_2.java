package algorithm.geekTime.class_15_16;

/**
 * 变体二：查找最后一个值等于给定值的元素
 */
public class BinarySearchVariant_2 {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        System.out.println("查找最后一个值等于给定值的元素位置：" + new BinarySearchVariant_2().bsearch(a, a.length, 8));
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
                if (mid == n - 1 || a[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
