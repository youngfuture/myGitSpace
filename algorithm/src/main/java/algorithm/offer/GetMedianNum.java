package algorithm.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * <p>
 * https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&tqId=11216&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * <p>
 * 几种思路：
 * 1.通过链表排序，再计算
 * <p>
 * 2.通过集合工具类排序，再计算
 * <p>
 * 3.构建平衡二叉搜索树，每个结点左子树均是小于等于其value的值，右子树均大于等于value值。
 * 每个子树均按其 “结点数” 调节平衡。 这样根节点一定是中间值中的一个。若结点数为奇数，则返回根节点的值
 * 若结点个数为偶数，则再从根结点左子数或右子数中个数较多的子树中选出最大或最小值既可。【最高级的思路】
 */

public class GetMedianNum {

    LinkedList<Integer> list = new LinkedList<>();

    // 通过一个链表实现了数字流的整体式从小到大排序的
    public void Insert(Integer num) {
        //如果比链表的第一个节点小，通过头插法将num挂到头部
        if (list.size() == 0 || num < list.getFirst()) {
            list.addFirst(num);
        } else {
            //遍历找到比当前节点大的节点的位置，将当前节点插入链表
            boolean insertFlag = false;
            for (Integer e : list) {
                if (num < e) {
                    int index = list.indexOf(e);
                    list.add(index, num);
                    insertFlag = true;
                    break;
                }
            }

            //如果找不到比当前节点大的节点，也就是当前节点是最大的一个节点，则将当前节点插入到链表尾部
            if (!insertFlag) {
                list.addLast(num);
            }
        }

    }

    //链表已经式有序的了，直接通过链表计算得出结果
    public Double GetMedian() {
        if (list.size() == 0) {
            return null;
        }

        if (list.size() % 2 == 0) {
            int i = list.size() / 2;
            Double a = Double.valueOf(list.get(i - 1) + list.get(i));
            return a / 2;
        }
        list.get(0);
        Double b = Double.valueOf(list.get((list.size() + 1) / 2 - 1));
        return Double.valueOf(list.get((list.size() + 1) / 2 - 1));

    }


    /**
     * 通过工具类Collection排序是最主要的特点
     */
    public class Solution {
        ArrayList<Integer> al = new ArrayList<Integer>();

        public void Insert(Integer num) {
            al.add(num);
            Collections.sort(al);
        }

        public Double GetMedian() {
            int mid = al.size() / 2;
            if ((al.size() & 1) == 0) {
                Integer n1 = al.get(mid);
                Integer n2 = al.get(mid - 1);
                double s = (Double.valueOf(n1 + "") + Double.valueOf(n2 + "")) / 2;
                return s;
            } else {
                double s = Double.valueOf(al.get(mid) + "");
                return s;
            }
        }


    }
}
