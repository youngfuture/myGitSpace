package algorithm.offer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * <p>
 * <p>
 * <p>
 * https://blog.csdn.net/qq_27984879/article/details/86232076
 * <p>
 */
public class IsNumeric {

    int index = 0;

    public boolean isNumeric2(char[] str) {
        String s = String.valueOf(str);
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }


    /**
     * 代码简简洁，但是相比 isNumeric1 可读性要查一些
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        // +-标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1) return false; // e后面一定要接数字
                if (hasE) return false;  // 不能同时存在两个e
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                sign = true;
            } else if (str[i] == '.') {
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') // 不合法字符
                return false;
        }
        return true;
    }


    public boolean isNumeric1(char[] str) {
        if (str.length < 1)
            return false;

        boolean flag = scanInteger(str);

        // . 后面是无符号整数
        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        // E、e 后面是整数
        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;

    }

    private boolean scanInteger(char[] str) {
        // 遇到 +- 符号index向前移动一位
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return scanUnsignedInteger(str);

    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;

        //从index开始扫描，如果是0-9就继续，扫描退出的时候判断从index开始到退出是否存在一个整数就可以
        return start < index; //是否存在整数
    }
}
