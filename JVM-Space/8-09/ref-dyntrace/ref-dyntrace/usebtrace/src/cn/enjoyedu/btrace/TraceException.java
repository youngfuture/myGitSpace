package cn.enjoyedu.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * 类说明：
 */
@BTrace
public class TraceException {
    @TLS
    static Throwable currentException;

    // introduce probe into every constructor of java.lang.Throwable
    // class and store "this" in the thread local variable.
    @OnMethod(
            clazz="java.lang.Throwable",
            method="<init>"
    )
    public static void onthrow(@Self Throwable self) {  // @Self其实就是拦截了this
        //new Throwable()
        currentException = self;
    }

    @OnMethod(
            clazz="java.lang.Throwable",
            method="<init>"
    )
    public static void onthrow1(@Self Throwable self, String s) {
        //new Throwable(String msg)
        currentException = self;
    }

    @OnMethod(
            clazz="java.lang.Throwable",
            method="<init>"
    )
    public static void onthrow1(@Self Throwable self, String s, Throwable cause) {
        //new Throwable(String msg, Throwable cause)
        currentException = self;
    }

    @OnMethod(
            clazz="java.lang.Throwable",
            method="<init>"
    )
    public static void onthrow2(@Self Throwable self, Throwable cause) {
        //new Throwable(Throwable cause)
        currentException = self;
    }

    // when any constructor of java.lang.Throwable returns
    // print the currentException's stack trace.
    @OnMethod(
            clazz = "cn.enjoyedu.demo.controller.DemoController",
            method = "exception",
            location=@Location(Kind.ERROR)
    )
    public static void onthrowreturn() {
        if (currentException != null) {
            // 打印异常堆栈
            BTraceUtils.Threads.jstack(currentException);
            BTraceUtils.println("=====================");
            // 打印完之后就置空
            currentException = null;
        }
    }
}
