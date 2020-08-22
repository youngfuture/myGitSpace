package cn.enjoyedu;

import java.util.Scanner;

/**
 * 类说明：
 */
public class CatchException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator roboot = new Calculator();
        while (scanner.hasNext()) {
            try {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = roboot.add(a, b);
                System.out.println(String.format("%d + %d = %d", a, b, c));
                System.out.println(1/0);
                System.out.println("hello,world!");
            } catch (Exception e) {

            }
        }
    }
}
