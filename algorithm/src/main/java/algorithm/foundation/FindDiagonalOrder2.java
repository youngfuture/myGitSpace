//package algorithm.foundation;
//
//public class FindDiagonalOrder2 {
//    public static void main(String[] args) {
//        int mats[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//
//        new FindDiagonalOrder2().findDiagonalOrder(mats);
//    }
//
//    public int[] findDiagonalOrder(int[][] mat) {
//
//        int rowLength = mat.length - 1;
//        int colLength = mat[0].length - 1;
//
//        int[] a = new int[mat.length * mat[0].length ];
//
//        //关键点：求有多少条对角线 rowLength + colLength
//        int k = 0, l = 0;
//        int c = 0;
//
//        //i 表示对角线上每一个节点的坐标 x+y的和，也表示是第几条对角线
//        for (int i = 0; i <= rowLength + colLength; i++) {
//            if (i % 2 == 0) {
//                //当和是偶数,对角线向上走，行号逐渐减小
//                for (int j = k; j >= i - l; j--) {
//                    a[c] = mat[j][i - j];
//                    c++;
//                }
//            } else {
//                //当和是奇数,对角线向下走，列号逐渐减小
//                for (int j = l; j >= i - k; j--) {
//                    a[c] = mat[i - j][j];
//                    c++;
//                }
//            }
//            // k表示行
//            // l表示列
//            k = k >= rowLength ? rowLength : k + 1;
//            l = l >= colLength ? colLength : l + 1;
//        }
//        return a;
//    }
//
//}
