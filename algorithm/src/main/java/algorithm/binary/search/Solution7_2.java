package algorithm.binary.search;

public class Solution7_2 {
    public double myPow(double x, int n) {
        long N = n;

        //1.0 / quickMul(x, -N) 当N等于负数的时候
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
