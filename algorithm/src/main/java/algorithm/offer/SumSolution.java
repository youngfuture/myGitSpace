package algorithm.offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&&tqId=11200&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 * <p>
 * 使用短路计算来构造递归:重点是输入0的时候输出0来结束递归
 * 缺点：递归的层数不能太深
 *
 *
 */
public class SumSolution {

    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new SumSolution().Sum_Solution(4000));
    }
}
