package algorithm.leedcode.binaryTree;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 答案：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
 * <p>
 * 关键在左右指针走到相交，且low > high 的时候，循环停止，
 */
public class MySqrt_69 {

    public static void main(String[] args) {
        System.out.println("8的平方根：" + new MySqrt_69().mySqrt(8));
    }

    public int mySqrt(int x) {
        int low = 0, high = x, ans = -1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if ((long) mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;

    }
}
