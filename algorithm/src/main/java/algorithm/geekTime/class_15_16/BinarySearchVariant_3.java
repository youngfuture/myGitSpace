package algorithm.geekTime.class_15_16;

/**
 * 变体三：查找第一个大于等于给定值的元素
 */
public class BinarySearchVariant_3 {
    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 10};
        System.out.println("查找第一个大于等于给定值的元素：" + new BinarySearchVariant_3().bsearch(a, a.length, 5));
    }


    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
