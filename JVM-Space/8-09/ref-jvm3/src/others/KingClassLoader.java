package others;

import java.io.*;

public class KingClassLoader extends java.lang.ClassLoader {

    private String path;
    private String classloaderName;

    public KingClassLoader(String path,String classloaderName){
        this.path = path;
        this.classloaderName = classloaderName;
    }

    //用于寻找类文件
    @Override
    public Class findClass(String name){
        byte[] b =loadClassData(name);
        return defineClass(name,b,0,b.length);
    }

    public byte[] loadClassData(String name) {
        name = path + name + ".class";
        InputStream in = null;
        ByteArrayOutputStream out = null;

        try {
            in = new FileInputStream(new File(name));
            out = new ByteArrayOutputStream();
            int i = 0;
            while ((i = in.read()) != -1){
                out.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }
}
