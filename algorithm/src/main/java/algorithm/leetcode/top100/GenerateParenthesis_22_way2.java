package algorithm.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22_way2 {
    public static void main(String[] args) {
        new GenerateParenthesis_22_way2().generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        getResult(n, result, 0, 0, "");
        for (String path : result) {
            System.out.println(path);
        }
        return result;
    }

    public void getResult(int n, List<String> result, int left, int right, String path) {
        if (path.length() == (2 * n)) {
            result.add(path);
            return;
        }

        if (left < n) {
            getResult(n, result, left+1, right, path + "(");
        }

        if (left > right) {
            getResult(n, result, left, right+1, path + ")");
        }
    }
}
