package ex16;
/**
 * @author  King老师
 * 锁消除
 *
 * -XX:+EliminateLocks开启锁消除（jdk1.8默认开启，其它版本未测试）
 * -XX:-EliminateLocks 关闭锁消除
 */
public class UnLock {
    public static void main(String[] args) {
        long timeStart1 = System.currentTimeMillis();
        for(int i=0; i<10000000; i++) {
            BufferString("king","zilu");
        }
        long timeEnd1 = System.currentTimeMillis();
        System.out.println("StringBuffer花费的时间" + (timeEnd1 - timeStart1));

        long timeStart2 = System.currentTimeMillis();
        for(int i=0; i<10000000; i++) {
            BuilderString("james","lison");
        }
        long timeEnd2 = System.currentTimeMillis();
        System.out.println("StringBuilder花费的时间" + (timeEnd2 - timeStart2));
    }
    public static String BufferString(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }

    public static String BuilderString(String s1, String s2) {
        StringBuilder sd = new StringBuilder();
        sd.append(s1);
        sd.append(s2);
        return sd.toString();
    }
}
