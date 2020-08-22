package ex7;

import others.KingClassLoader;

public class ClassLoaderCheck {
    public static void main(String[] args) throws Exception {
        KingClassLoader classloader = new KingClassLoader("F:/jvm/", "kingClassLoader");
        Class c = classloader.loadClass("others.King");
        System.out.println(c.getClassLoader());
        System.out.println(c.getClassLoader().getParent());
        System.out.println(c.getClassLoader().getParent().getParent());
        c.newInstance();
    }
}
