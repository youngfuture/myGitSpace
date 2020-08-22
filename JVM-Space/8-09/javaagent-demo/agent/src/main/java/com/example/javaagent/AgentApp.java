package com.example.javaagent;

import java.lang.instrument.Instrumentation;
/**
 * instrument 一共有两个 main 方法，一个是 premain，另一个是 agentmain
 *  但在一个 JVM 中，只会调用一个
 */

public class AgentApp {
    //在main 执行之前的修改
    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("==============enter premain==============");
//        System.out.println(agentOps);
        inst.addTransformer(new Agent());
    }
    //控制类运行时的行为
    public static void agentmain(String agentOps, Instrumentation inst) {
        System.out.println("==============enter agentmain==============");
    }
}
