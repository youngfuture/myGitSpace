package ex10.attach;


import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;
import java.util.Properties;

//Java Attach API
public class AttachDemo {
    public static void main(String[] args) throws Exception {
        //VM进程号，通过 jps命令获取
        //attach向目标 JVM ”附着”（Attach）代理工具程序
        VirtualMachine vm = VirtualMachine.attach("8900");
        // get system properties in target VM
        Properties props = vm.getSystemProperties();
        String version = props.getProperty("java.version");
        System.out.println(version);
        // VirtualMachineDescriptor是一个描述虚拟机的容器类，配合 VirtualMachine 类完成各种功能
        List<VirtualMachineDescriptor> vmDescriptors = vm.list();
        //从JVM上面解除代理
        vm.detach();
    }
}
