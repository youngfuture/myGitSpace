package main.java.algorithm;

import java.util.*;

public class ByteDanceTest {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] b = new int[]{11, 22, 13, 24, 15, 26, 27, 18, 19, 10};
        int[] c = new int[]{2, 3, 33, 34, 25, 11, 27, 48, 29, 17};
        int[] d = new int[]{13, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //目标和为 50
        int target = 50;

        Map<Integer, List<Integer>> abMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                List<Integer> sumab = new ArrayList<>();
                sumab.add(a[i]);
                sumab.add(b[j]);
                abMap.put(a[i] + b[j], sumab);
            }
        }

        Map<Integer, List<Integer>> cdMap = new HashMap<>();
        for (int k = 0; k < a.length; k++) {
            for (int m = 0; m < b.length; m++) {
                List<Integer> sumab = new ArrayList<>();
                sumab.add(c[k]);
                sumab.add(d[m]);
                cdMap.put(c[k] + d[m], sumab);
            }
        }

        List<List<Integer>> results = new ArrayList<>();


        Set<String> repeatSet = new HashSet<>();

        for (Map.Entry<Integer, List<Integer>> entry : cdMap.entrySet()) {
            if (abMap.containsKey(target - entry.getKey())) {

                //一种结果
                List<Integer> oneResult = new ArrayList<>();
                oneResult.addAll(abMap.get(target - entry.getKey()));
                oneResult.addAll(entry.getValue());

                //排序
                Collections.sort(oneResult);

                //拼接成字符串
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(oneResult.get(0))
                        .append(oneResult.get(1))
                        .append(oneResult.get(2))
                        .append(oneResult.get(3));

                //去重
                if (!repeatSet.contains(stringBuilder.toString())) {
                    repeatSet.add(stringBuilder.toString());
                    results.add(oneResult);
                }
            }
        }

        //打印
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
