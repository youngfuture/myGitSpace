package cn.enjoyedu.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

//java -jar -Xms200m -Xmx8000m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/heapdump.hprof  -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -Xloggc:/tmp/heapTest.log demo-0.0.1-SNAPSHOT.jar

@RestController
@RequestMapping("/oom")
public class OomController {

    @RequestMapping("/test")
    public String test(){
        ThreadLocal localVariable = new ThreadLocal();
        localVariable.set(new Byte[1024*1024]);// 为线程添加变量
        return "success";
    }
}
