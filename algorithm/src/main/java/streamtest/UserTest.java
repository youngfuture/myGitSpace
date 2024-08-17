package streamtest;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.MapUtils;

import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collectors;

public class UserTest {
    static List<UserCourse> userCourseList = new ArrayList<>();

    static {
        UserCourse userCourse1 = new UserCourse();
        userCourse1.setId(1001);
        userCourse1.setName("张三");
        userCourse1.setAge(17);
        userCourse1.setCourse("语文");
        userCourse1.setScore(85);
        userCourseList.add(userCourse1);

        UserCourse userCourse2 = new UserCourse();
        userCourse2.setId(1002);
        userCourse2.setName("张三");
        userCourse2.setAge(17);
        userCourse2.setCourse("数学");
        userCourse2.setScore(90);
        userCourseList.add(userCourse2);

        UserCourse userCourse3 = new UserCourse();
        userCourse3.setId(1003);
        userCourse3.setName("张三");
        userCourse3.setAge(17);
        userCourse3.setCourse("英语");
        userCourse3.setScore(95);
        userCourseList.add(userCourse3);


        UserCourse userCourse4 = new UserCourse();
        userCourse4.setId(1004);
        userCourse4.setName("李四");
        userCourse4.setAge(18);
        userCourse4.setCourse("语文");
        userCourse4.setScore(75);
        userCourseList.add(userCourse4);

        UserCourse userCourse5 = new UserCourse();
        userCourse5.setId(1005);
        userCourse5.setName("李四");
        userCourse5.setAge(18);
        userCourse5.setCourse("数学");
        userCourse5.setScore(100);
        userCourseList.add(userCourse5);

        UserCourse userCourse6 = new UserCourse();
        userCourse6.setId(1006);
        userCourse6.setName("李四");
        userCourse6.setAge(18);
        userCourse6.setCourse("英语");
        userCourse6.setScore(80);
        userCourseList.add(userCourse6);


        UserCourse userCourse7 = new UserCourse();
        userCourse7.setId(1007);
        userCourse7.setName("王五");
        userCourse7.setAge(19);
        userCourse7.setCourse("语文");
        userCourse7.setScore(90);
        userCourseList.add(userCourse7);

        UserCourse userCourse8 = new UserCourse();
        userCourse8.setId(1008);
        userCourse8.setName("王五");
        userCourse8.setAge(19);
        userCourse8.setCourse("数学");
        userCourse8.setScore(85);
        userCourseList.add(userCourse8);

        UserCourse userCourse9 = new UserCourse();
        userCourse9.setId(1009);
        userCourse9.setName("王五");
        userCourse9.setAge(19);
        userCourse9.setCourse("英语");
        userCourse9.setScore(95);
        userCourseList.add(userCourse9);

    }

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        //构建Map<id,UserCourse>结构
        Map<Integer, UserCourse> userCourseMap = userCourseList.stream().collect(Collectors.toMap(UserCourse::getId, UserCourse -> UserCourse));
        userCourseMap.forEach((id, userCourse) -> System.out.println("ID: " + id + ", 映射对象userCourse: " + JSON.toJSONString(userCourse)));

        //构建Map<id,courseName>结构
        Map<Integer, String> idToCourseMap = userCourseList.stream().collect(Collectors.toMap(UserCourse::getId, UserCourse::getCourse));
        idToCourseMap.forEach((id, courseName) -> System.out.println("ID: " + id + ", 映射字段courseName: " + courseName));

        //构建Map<name,List<UserCourse>>结构
        Map<String, List<UserCourse>> nameToUserCourseListMap = userCourseList.stream().collect(Collectors.groupingBy(UserCourse::getName));
        nameToUserCourseListMap.forEach((name, userCourseList) -> System.out.println("name: " + name + ", 先分组userCourseList: " + JSON.toJSONString(userCourseList)));

        //对每个分组的List<UserCourse>按照score降序排序
        Map<String, List<UserCourse>> sortedUserCourseMapByName = nameToUserCourseListMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .sorted(Comparator.comparing(UserCourse::getScore).reversed())
                                .collect(Collectors.toList())
                ));
        sortedUserCourseMapByName.forEach((name, userCourseList) -> System.out.println("name: " + name + ", 再降序：userCourseList: " + JSON.toJSONString(userCourseList)));

        // 按name分组并对每个分组的List<UserCourse>按照score降序排序（分组和降序写在一起）
        Map<String, List<UserCourse>> sortedUserCourseMapByName2 = userCourseList.stream()
                .collect(Collectors.groupingBy(
                        UserCourse::getName,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparing(UserCourse::getScore).reversed())
                                        .collect(Collectors.toList())
                        )
                ));
        sortedUserCourseMapByName2.forEach((name, userCourseList) -> System.out.println("name: " + name + ", 分组和降序写在一起：userCourseList: " + JSON.toJSONString(userCourseList)));


        // 按name分组并对每个分组的List<UserCourse>按照score降序排序，并过滤分数小于80的
        Map<String, List<UserCourse>> sortedAndFilteredUserCourseMapByName3 = userCourseList.stream()
                .collect(Collectors.groupingBy(
                        UserCourse::getName,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .filter(userCourse -> userCourse.getScore() >= 80) // 过滤分数小于80的
                                        .sorted(Comparator.comparing(UserCourse::getScore).reversed()) // 按score降序排序
                                        .collect(Collectors.toList())
                        )
                ));
        sortedAndFilteredUserCourseMapByName3.forEach((name, userCourseList) -> System.out.println("name: " + name + ", 分组+过滤+降序写在一起：userCourseList: " + JSON.toJSONString(userCourseList)));


        //过滤掉分数小于80的,按name分组并对每个分组的List<UserCourse>按照score降序排序
        Map<String, List<UserCourse>> sortedAndFilteredUserCourseMapByName4 = userCourseList.stream()
                .filter(userCourse -> userCourse.getScore() >= 80) // 过滤分数小于80的
                .collect(Collectors.groupingBy(
                        UserCourse::getName,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparing(UserCourse::getScore).reversed()) // 按score降序排序
                                        .collect(Collectors.toList())
                        )
                ));
        sortedAndFilteredUserCourseMapByName4.forEach((name, userCourseList) -> System.out.println("name: " + name + ", 过滤+分组+降序写在一起：userCourseList: " + JSON.toJSONString(userCourseList)));

        // 过滤掉分数小于85的课程
        List<UserCourse> filteredUserCourses = userCourseList.stream()
                .filter(userCourse -> userCourse.getScore() >= 85) // 过滤分数小于85的
                .collect(Collectors.toList());
        System.out.println("过滤掉分数小于85的课程,filteredUserCourses:" + JSON.toJSONString(filteredUserCourses));

        // 过滤掉分数小于85的课程,然后再做id对象映射
        Map<Integer, UserCourse> filteredAndIdToUserCourse = userCourseList.stream()
                .filter(userCourse -> userCourse.getScore() >= 85) // 过滤分数小于85的
                .collect(Collectors.toMap(UserCourse::getId, UserCourse -> UserCourse));
        filteredAndIdToUserCourse.forEach((id, userCourse) -> System.out.println("id: " + id + ", 过滤掉分数小于85的课程,然后再做id对象映射：userCourseList: " + JSON.toJSONString(userCourse)));

        Set<String> nameSet = userCourseList.stream().collect(Collectors.mapping(UserCourse::getName, Collectors.toSet()));
        System.out.println("去重后的nameSet: " + JSON.toJSONString(nameSet));

    }


    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Alice", "Charlie");
        List<String> distinctNames = names.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctNames); // 输出: [Alice, Bob, Charlie]
    }


    }