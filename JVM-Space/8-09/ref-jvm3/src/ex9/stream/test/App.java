package ex9.stream.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author King老师
 * 性能测试对比
 */
public class App 
{
    public static void main( String[] args )
    {
		//一个亿
    	int[] arr = new int[100000000];
		//parallelStream的地方都是使用同一个Fork-Join线程池，而线程池线程数仅为cpu的核心数
		//可以通过一下配置修改这个值
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","240");
    	Random r = new Random();
		for(int i=0; i<arr.length; i++){
			arr[i] = r.nextInt();
		}

    	IteratorTest.IteratorForIntTest(arr);//1
    	SerialStreamTest.SerialStreamForIntTest(arr);//2
    	ParallelStreamTest.ParallelStreamForIntTest(arr);//3




    }
}
