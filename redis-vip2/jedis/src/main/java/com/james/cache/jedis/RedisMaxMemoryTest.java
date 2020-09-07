package com.james.cache.jedis;

import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class RedisMaxMemoryTest {
    public static ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(5, new ThreadPoolExecutor.AbortPolicy());

    public static int period = 1;

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddHHmm");
                String preKey = df2.format(new Date()) + "_" + period + "_";
                System.out.println("-------------------------当前时间:" + df.format(new Date()) + " 周期:" + period + " key前缀:"+preKey+" 开始-------------------------");
                for (int i = 0; i < 5; i++) {
                    threadPoolExecutor.execute(new InitRedisData(period, 10000 * 2, preKey));
                }
                period += 1;

            }
        }, 0, 5, TimeUnit.MINUTES);
    }

    public static class InitRedisData implements Runnable {
        private int period;
        private int count;
        private String preKey;

        public InitRedisData(int period, int count, String preKey) {
            this.period = period;
            this.count = count;
            this.preKey = preKey;
        }


        public void run() {
            long start = System.currentTimeMillis();
            //redis 最大内存100*1024*1024 Byte
            Jedis jedis = new Jedis("127.0.0.1", 6379);
            try {
                for (int i = 0; i < this.count; i++) {
                    String key = UUID.randomUUID().toString().replace("-", "");
                    key = this.preKey + key;

                    //100 Byte/key
                    String value = new String(new byte[100]);

                    /**
                     * ex ： seconds 秒
                     * px :   milliseconds 毫秒
                     */
                    jedis.set(key, value, "NX", "EX", 60 * 10);

                    if (i % 5000 == 0) {
                        System.out.println("当前周期" + this.period + " 线程 " + Thread.currentThread().getName() + "-----------------存入第 " + i + " 个-----------------");
                    }
                }
                long end = System.currentTimeMillis();
                System.out.println("当前周期" + this.period + "线程 " + Thread.currentThread().getName() + "当前周期执行完，退出 耗时 " + (end - start) / 1000 + " 秒");
                jedis.close();
            } catch (Exception exception) {
                System.out.println(exception);
            } finally {
                jedis.close();
            }
        }
    }


}
