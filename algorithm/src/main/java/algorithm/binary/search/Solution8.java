package algorithm.binary.search;

public class Solution8 {
    public static void main(String[] args) {
        System.out.println(new Solution8().isPerfectSquare(15));
    }

    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;

        while (left <= right) {
            long mid = (right - left) / 2 + left;
            long target = mid * mid;
            if (target == num) {
                return true;
            } else if (target < num) {
                left = mid + 1;
            } else if (target > num) {
                right = mid - 1;
            }
        }
        return false;

    }
}
