package com.example.javaagent.app;




import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;
import java.util.Properties;

public class JvmAttach {

    public static void main(String[] args)
            throws Exception {
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor vmd : list) {
            if (vmd.displayName().endsWith("MainRun")) {
                VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
                Properties props = virtualMachine.getSystemProperties();
                String version = props.getProperty("java.version");

                virtualMachine.loadAgent("arthas-boot.jar ","...");
                System.out.println("version:"+version);
                virtualMachine.detach();
            }
        }
    }
}

