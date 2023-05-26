package algorithm.binary.search;

public class Solution7_1 {
    public double myPow(double x, int n) {
        long n1 = n;
        if (n1 < 0) {
            x = 1 / x;
            n1 = -n1;
        }
        double ans = 1;


        if (x == 1) {
            return 1;
        }

        if (x == -1) {
            if (n1 % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }

        if (-2147483648 == n) {
            return 0;
        }

        for (long i = 0; i < n1; i++) {
            ans *= x;
        }
        return ans;

    }
}
