package com.example.javaagent.app;

//VM参数中加入：-javaagent:F:\work_vip\javaagent-demo\agent\target\agent-1.0-SNAPSHOT.jar
public class MainRun {
    public static void main(String[] args) {
        hello("world");
    }
    private static void hello(String name) {
        System.out.println("hello " + name );
    }
}
