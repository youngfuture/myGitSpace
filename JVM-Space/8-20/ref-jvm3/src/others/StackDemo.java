package others;

public class StackDemo {
    public static void main(String[] args)throws Exception {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("abc");
        local =null;
        System.gc();
        Thread.sleep(1);
        System.out.println("------------------");
        String s =local.get();
        local.remove();
        System.out.println(s);
    }
    public static void a()
    {

    }
}
