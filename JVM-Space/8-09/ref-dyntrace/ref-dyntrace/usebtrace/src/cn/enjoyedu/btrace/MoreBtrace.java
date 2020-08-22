package cn.enjoyedu.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;
@BTrace
public class MoreBtrace {

    @OnMethod(
            clazz = "cn.enjoyedu.demo.controller.DemoController",
            method = "test",
            location = @Location(value = Kind.CALL,
                    clazz = "/.*/", method = "/.*/",
                    where = Where.AFTER))
    public static void onInvoke(@Self Object self, @TargetInstance Object instance,
                              @TargetMethodOrField String method,
                              @Duration long duration){
        BTraceUtils.println(strcat("self: ", str(self)));
        BTraceUtils.println(strcat("instance: ", str(instance)));
        BTraceUtils.println(strcat("method: ", str(method)));
        BTraceUtils.println(strcat("duration(ns): ", str(duration )));
        println("===========================");
        BTraceUtils.println();
    }
}
