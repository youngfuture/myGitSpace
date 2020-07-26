package algorithm.offer;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 题目链接：https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8?tpId=13&&tqId=33257&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 * <p>
 * 题解：https://www.nowcoder.com/questionTerminal/57d85990ba5b440ab888fc72b0751bf8?answerType=1&f=discussion
 */
public class CutRopeSolution {

    int back_track(int n) {
        // n <= 4, 表明不分，长度是最大的
        if (n <= 4) {
            return n;
        }

        int ret = 0;
        for (int i = 1; i < n; ++i) {
            ret = max(ret, i * back_track(n - i));
        }
        return ret;
    }

    int cutRope(int target) {
        // target = 2 和 3 时，分 2 段和分 1 段的结果是不一样的，所以需要特判一下
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        }
        return back_track(target);
    }

    int max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }
}
