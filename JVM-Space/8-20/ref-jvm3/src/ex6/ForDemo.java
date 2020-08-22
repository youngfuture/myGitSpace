package ex6;
import java.util.List;

public class ForDemo {
    void loop(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
    void loop(List<Integer> arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
