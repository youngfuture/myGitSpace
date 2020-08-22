package ex8;

public class LambdaCapture {
    public static void main(String[] args) {
        repeatMessage("捕获",3);
        repeatMessage();
    }
    public static void repeatMessage(String text, int count) {//捕获型

        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
            }
        };
        new Thread(r).start();
    }
    public static void repeatMessage() {//非捕获型
        Runnable r = () -> {
                System.out.println("hello king!");
        };
        new Thread(r).start();
    }
}
