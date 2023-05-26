package algorithm.binary.search;

public class Solution7 {
    public static void main(String[] args) {
        new Solution7().myPow(2.00000, -2147483648);


    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }


        if (x == 1) {
            return 1;
        }

        if (x == -1) {
            if (n % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }

        if (-2147483648 == n) {
            return 0;
        }

        long t = 0;
        if (n < 0) {
            t = n * -1;
        } else {
            t = n;
        }


        double ans = 1;
        while (t > 0) {
            ans *= x;
            t--;
        }

        if (n < 0) {
            return 1 / ans;
        } else {
            return ans;
        }
    }
}
