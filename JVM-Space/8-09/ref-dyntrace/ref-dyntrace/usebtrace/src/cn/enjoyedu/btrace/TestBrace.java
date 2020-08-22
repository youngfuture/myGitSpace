package cn.enjoyedu.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.str;
import static com.sun.btrace.BTraceUtils.strcat;

@BTrace
public class TestBrace {

    @OnMethod(
            clazz = "cn.enjoyedu.demo.controller.DemoController",
            method = "test",
            location = @Location(Kind.ENTRY)
    )
    public static void checkEntry(
           @ProbeClassName String pcn,
           @ProbeMethodName String pmn,
           AnyType[] args
    ){
        BTraceUtils.println("Class: "+pcn);
        BTraceUtils.println("Method: "+pmn);
        BTraceUtils.printArray(args);
        BTraceUtils.println("===========================");
        BTraceUtils.println();
    }

}
