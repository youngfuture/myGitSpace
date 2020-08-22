package ex9.stream;

import ex9.stream.test.Student;

import java.util.*;
import java.util.stream.Collectors;
/**
 * @author King老师
 * Stream使用
 */
public class StuWithStream {
    public static void main(String[] args) {
        List<Student> studentList =Datainit();
        groupBy(studentList);
       // filter(studentList);
        total(studentList);
        MaxAndMin(studentList);

    }
    public static List<Student> Datainit(){
        List<Student> students = Arrays.asList(
                new Student("小明", 168, "男"),
                new Student("大明", 182, "男"),
                new Student("小白", 174, "男"),
                new Student("小黑", 186, "男"),
                new Student("小红", 156, "女"),
                new Student("小黄", 158, "女"),
                new Student("小青", 165, "女"),
                new Student("小紫", 172, "女"));
        return students;
    }
    //Stream实现分组
    public static  void groupBy(List<Student> studentsList){
        Map<String, List<Student>> groupBy = studentsList
                .stream()
                .collect(Collectors.groupingBy(Student::getSex));
        System.out.println("分组后："+groupBy);
    }

    //Stream实现过滤
    public static  void filter(List<Student> studentsList){
        List<Student> filter = studentsList
                .stream()
                .filter(student->student.getHeight()>180)
                .collect(Collectors.toList());
        System.out.println("过滤后："+filter);
    }

    //Stream实现求和
    public static  void total(List<Student> studentsList){
        int totalHeight = studentsList
                .stream()
                .mapToInt(Student::getHeight)
                .sum();
        System.out.println(totalHeight);
    }
    //Stream找最大和最小
    public static  void MaxAndMin(List<Student> studentsList){
        int maxHeight = studentsList
                .stream()
                .mapToInt(Student::getHeight)
                .max()
                .getAsInt();
        System.out.println("max:"+maxHeight);
        int minHeight = studentsList
                .stream()
                .mapToInt(Student::getHeight)
                .min()
                .getAsInt();
        System.out.println("min:"+minHeight);
    }



}
