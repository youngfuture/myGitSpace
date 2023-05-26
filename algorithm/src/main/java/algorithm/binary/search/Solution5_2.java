package algorithm.binary.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution5_2 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(ret
                , (a, b) -> a == b ? a - b : Math.abs(a - x) - Math.abs(b - x)
        );
        ret = ret.subList(0, k);
        Collections.sort(ret);
        return ret;
    }
}
