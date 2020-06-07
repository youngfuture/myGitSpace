package algorithm.offer;

import java.math.BigInteger;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 * 编号：JZ48
 * https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&&tqId=11201&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 *
 *  首先看十进制是如何做的： 5+7=12，三步走
 *
 * 第一步：相加各位的值，不算进位，得到2。
 *
 * 第二步：计算进位值，得到10. 如果这一步的进位值为0，那么第一步得到的值就是最终结果。
 *
 * 第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。
 * ----------------------------------------------------------------------------------
 * 同样我们可以用三步走的方式计算二进制值相加： 5-101，7-111
 *
 * 第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
 *
 * 第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
 *
 * 第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
 *      继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。
 *
 * 阿里云21届实习最后上车机会，还有大量HC，曾经投递过简历的，如果简历优秀还有起死回生的机会 https://www.nowcoder.com/discuss/416182
 *
 */

public class AddTwoNumWithOutSignal {
    public static void main(String[] args) {
        System.out.println(new AddTwoNumWithOutSignal().Add(3, 2));
    }

    public int Add1(int num1, int num2) {
        BigInteger bi1=new BigInteger(String.valueOf(num1));
        BigInteger bi2=new BigInteger(String.valueOf(num2));
        return bi1.add(bi2).intValue();
    }

    public int Add(int num1,int num2) {
        while (num2!=0) {
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = temp;
        }
        return num1;
    }
}
