package ex10.attach;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @author King老师
 * Attach使用入门
 */

public class JvmAttach {

    public static void main(String[] args)
            throws Exception {
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor vmd : list) {
            //只找对应启动类是JVMObject结尾的
            if (vmd.displayName().endsWith("JVMObject")) {
                VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
                Properties props = virtualMachine.getSystemProperties();
                //打印attach上的VM所有的系统属性
                System.out.println(getChildProcessConfig(props));
                //打印attach上的VM的JDK版本信息
                String version = props.getProperty("java.version");
                System.out.println("----version:"+version);
                virtualMachine.detach();
            }
        }
    }
    //获取所有属性
    private static Properties getChildProcessConfig( Properties props) {
        Properties properties = System.getProperties();
        Set<String> stringPropertyNames = properties.stringPropertyNames();
        Properties prop = new Properties();
        for (String string : stringPropertyNames) {
            prop.setProperty(string, properties.getProperty(string));
        }
        return prop;
    }

}

