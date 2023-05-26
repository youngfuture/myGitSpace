package algorithm.binary.search;

public class Solution9 {

    public static void main(String[] args) {
        new Solution9().nextGreatestLetter(new char[]{'a', 'f', 'j'}, 'd');
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;

        if (letters[0] > target) {
            return letters[0];
        } else if (letters[0] == target) {
            int i = 0;
            while ((letters[i] == target) && i < n) {
                i++;
            }
            return letters[i];
        }


        if (letters[n - 1] < target) {
            return letters[0];
        }

        int left = 0, right = n;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (letters[mid] == target) {
                int i = mid;
                while (i < n && letters[i] == target) {
                    i++;
                }
                if (i == n) {
                    return letters[0];
                } else {
                    return letters[i];
                }
            } else if (letters[mid] < target) {
                left = mid + 1;
            } else if (letters[mid] > target) {
                right = mid;
            }
        }
        return letters[left];
    }
}
