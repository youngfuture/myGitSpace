package com.example.javaagent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class Agent implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        String loadName = className.replaceAll("/", ".");
        //System.out.println(className);
        if (className.endsWith("MainRun")) {
            try {
                //javassist 完成字节码增强(打印方法的执行时间<纳秒>)
                CtClass ctClass = ClassPool.getDefault().get(loadName);
                CtMethod ctMethod = ctClass.getDeclaredMethod("hello");
                ctMethod.addLocalVariable("_begin", CtClass.longType);
                ctMethod.insertBefore("_begin = System.nanoTime();");
                ctMethod.insertAfter("System.out.println(System.nanoTime() - _begin);");

                return ctClass.toBytecode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return classfileBuffer;
    }
}
