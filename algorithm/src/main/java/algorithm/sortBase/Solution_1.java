package algorithm.sortBase;

public class Solution_1 {

    public static void main(String[] args) {
        int arrays[] = new int[]{11, 8, 3, 9, 7, 1, 2, 5};
        new Solution_1().merge_sort(arrays, arrays.length);
    }


    /**
     * 归并排序算法, arrays是数组，length表示数组大小
     */
    public void merge_sort(int[] arrays, int length) {
        merge_sort_c(arrays, 0, length - 1);

        for (int i = 0; i < length; i++) {
            System.out.print(arrays[i] + "  ");
        }
    }

    // 递归调用函数
    public void merge_sort_c(int[] arrays, int startIndex, int endIndex) {
        // 递归终止条件
        if (startIndex >= endIndex) {
            return;
        }

        // 取startIndex 到 endIndex之间的中间位置 mid， 为了防止益处，这里可以 mid = startIndex + (endIndex - startIndex) / 2
        int mid = (startIndex + endIndex) / 2;

        // 分治递归
        merge_sort_c(arrays, startIndex, mid);

        merge_sort_c(arrays, mid + 1, endIndex);

        // 将arrays[startIndex...mid] 和 arrays[mid+1...endIndex] 合并为 arrays[startIndex...endIndex]
        merge(arrays, startIndex, mid, mid + 1, endIndex);
    }


    public void merge(int[] arrays, int start1, int end1, int start2, int end2) {
        // 初始化变量i, j, k
        int i = start1;
        int j = start2;
        int k = 0;

        // 申请一个大小跟 arrays[startIndex...endIndex]一样的临时数组
        int[] tmp = new int[end2 - start1 + 1];
        while (i <= end1 && j <= end2) {
            if (arrays[i] <= arrays[j]) {
                tmp[k++] = arrays[i++]; // i++ 等于 i=i+1
            } else {
                tmp[k++] = arrays[j++];
            }
        }


        // 判断哪个子数组中有剩余的数据
        int remainStart = i, remainEnd = end1;//默认第一个数组有剩余
        if (j <= end2) {
            //第二个数组有剩余
            remainStart = j;
            remainEnd = end2;
        }


        // 将剩余的数据拷贝到临时数组tmp
        while (remainStart <= remainEnd) {
            tmp[k++] = arrays[remainStart++];
        }

        // 将tmp中的数组拷贝回arrays[start1...end2]
        for (int m = 0; m <= end2 - start1; m++) {
            arrays[start1 + m] = tmp[m];
        }
    }
}
