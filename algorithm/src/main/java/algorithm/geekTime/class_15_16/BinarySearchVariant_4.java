package algorithm.geekTime.class_15_16;

/**
 * 变体四：查找最后一个小于等于给定值的元素
 */
public class BinarySearchVariant_4 {
    public static void main(String[] args) {
        int[] a = {3, 5, 6, 8, 9, 10};
        System.out.println("查找最后一个小于等于给定值的元素：" + new BinarySearchVariant_4().bsearch(a, a.length, 7));
    }


    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {

                if (mid == n - 1 || a[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }

            } else if (a[mid] > value) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
