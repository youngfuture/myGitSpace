package algorithm.leetcode.top100;

import java.nio.charset.StandardCharsets;

public class CountBits_338 {

    public static void main(String[] args) {
        //new CountBits_338().countBits(2);
    }

    public int[] countBits(int n) {

        int outArray[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            outArray[i] = Integer.bitCount(i);
        }
        return outArray;
    }


    public int[] countBits2(int n) {

        int outArray[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            outArray[i] = countOne(i);
        }
        return outArray;
    }

    private int countOne(int i) {
        int times = 0;
        while (i > 0) {
            i &= i - 1;
            times++;
        }
        return times;
    }


    public int[] countBits3(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    public int[] countBits4(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
