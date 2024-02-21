package main.java.algorithm;


//字节一面笔试题目  将三进制的数子 21 转换为十进制
public class Test {
    public static void main(String[] args) {

    }

    public int threeToInt(String threeNum) {
        if (threeNum == null) {
            return 0;
        }
        int length = threeNum.length();
        int result = 0;
        int j = 0;
        for (int i = length - 1; i >= 0; i--) {
            result += threeNum.charAt(i) * Math.pow(3, j);
            j++;
        }
        System.out.println(result);
        return result;
    }
}
