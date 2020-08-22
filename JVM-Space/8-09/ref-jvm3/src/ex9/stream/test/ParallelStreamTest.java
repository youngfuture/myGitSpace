package ex9.stream.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author King老师
 *Stream 并行迭代
 */
public class ParallelStreamTest {
	
	public static void ParallelStreamForIntTest(int[] arr) {
		long timeStart = System.currentTimeMillis();

		Arrays.stream(arr).parallel().min().getAsInt();
		
		long timeEnd = System.currentTimeMillis();
		System.out.println("ParallelStream 比较int最小值 花费的时间" + (timeEnd - timeStart));
	}
	
	public static void ParallelStreamForObjectTest(List<Student> studentsList) {
		long timeStart = System.currentTimeMillis();

		Map<String, List<Student>> stuMap = studentsList.parallelStream()
				.filter((Student s) -> s.getHeight() > 160)
				.collect(Collectors.groupingBy(Student::getSex));

		long timeEnd = System.currentTimeMillis();
		System.out.println("ParallelStream并行花费的时间" + (timeEnd - timeStart));
	}

}
