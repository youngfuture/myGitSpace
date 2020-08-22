package cn.enjoyedu;

/**
 * 类说明：
 */
public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void speak(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        Person personA = new Person(43, "lixunhuan");
        personA.speak("我是李寻欢");

        Person personB = new Person(23, "afei");
        personB.speak("我是阿飞");
    }
}
