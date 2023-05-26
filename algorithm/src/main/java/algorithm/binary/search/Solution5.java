package algorithm.binary.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution5 {

    public static void main(String[] args) {
        //new Solution5().findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9);
        new Solution5().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        new Solution5().findClosestElements(new int[]{3, 5, 8, 10}, 2, 15);
    }


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        if (x < arr[0]) {
            for (int i = 0; i < k && i < arr.length; i++) {
                result.add(arr[i]);
            }
            sortByAsc(result);
            return result;
        }

        if (x > arr[arr.length - 1]) {
            for (int i = arr.length - 1; i >= 0 && i >= arr.length - k; i--) {
                result.add(arr[i]);
            }
            sortByAsc(result);
            return result;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid = left;

        while (left < right) {
            mid = (right - left) / 2 + left;
            if (arr[mid] == x) {
                break;
            } else if (x < arr[mid]) {
                right = mid;
            } else if (x > arr[mid]) {
                left = mid + 1;
            }
        }


        List<int[]> doubleResult = new ArrayList<>();
        for (int i = mid; i >= 0 && mid - i < k + 1; i--) {
            doubleResult.add(new int[]{Math.abs(arr[i] - x), arr[i]});
        }

        for (int j = mid + 1; j < arr.length && j < mid + 1 + k; j++) {
            doubleResult.add(new int[]{Math.abs(arr[j] - x), arr[j]});
        }

        doubleResult.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int[] o1Arr = (int[]) o1;
                int[] o2Arr = (int[]) o2;
                if (o1Arr[0] < o2Arr[0]) {
                    return -1;
                }
                if (o1Arr[0] > o2Arr[0]) {
                    return 1;
                }

                if (o1Arr[0] == o2Arr[0]) {
                    if (o1Arr[1] < o2Arr[1]) {
                        return -1;
                    }
                    if (o1Arr[1] > o2Arr[1]) {
                        return 1;
                    }

                    if (o1Arr[1] == o2Arr[1]) {
                        return 0;
                    }
                }
                return 0;
            }
        });


        for (int i = 0; i < k; i++) {
            result.add(doubleResult.get(i)[1]);
        }

        sortByAsc(result);

        return result;
    }

    void sortByAsc(List<Integer> result) {
        result.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if ((int) o1 < (int) o2) {
                    return -1;
                }
                if ((int) o1 > (int) o2) {
                    return 1;
                }
                return 0;
            }
        });
    }

}
