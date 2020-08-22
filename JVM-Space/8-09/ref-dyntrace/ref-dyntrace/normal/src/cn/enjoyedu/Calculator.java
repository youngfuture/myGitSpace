package cn.enjoyedu;

import java.util.Scanner;

/**
 * 类说明：
 */
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator roboot = new Calculator();
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = roboot.add(a, b);
            System.out.println(String.format("%d + %d = %d", a, b, c));
        }
    }
}
