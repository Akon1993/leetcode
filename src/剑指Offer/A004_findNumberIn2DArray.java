package 剑指Offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A004_findNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1,  4,  7, 11, 15},
                { 2,  5,  8, 12, 19},
                { 3,  6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 18;
//        System.out.println(matrix.length);
//        System.out.println(matrix[0].length);
//        System.out.println(matrix[0][4]);
        System.out.println(findNumberIn2DArray(matrix, target));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int x = matrix[0].length - 1, y = 0;
        while (y < matrix.length && x > -1) {
            if (matrix[y][x] > target) {
                x--;
            } else if (matrix[y][x] < target) {
                y++;
            } else {
                return true;
            }

        }
        return false;
    }

    public static boolean findNumberIn2DArray_0(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int maxY = matrix.length;// y
        int maxX = matrix[0].length;// x
        // (x,y)从(0,maxX)开始，左移x-1，下移y+1
        int x = maxX - 1, y = 0;
        boolean xEndFlag = false, yEndFlag = false;
        while (true) {
            if (matrix[y][x] == target)
                return true;
            if (++y == maxY) {
                yEndFlag = true;
                y = maxY - 1;
            }
            if (--x == -1) {
                xEndFlag = true;
                x = 0;
            }
            if (xEndFlag && yEndFlag) {
                return false;
            }
            int y2 = y;
            int x2 = x;
            if (matrix[y2][x2] > target) {// 往上找，y--
                while (--y2 != -1) {
                    if (matrix[y2][x2] == target)
                        return true;
                }
            } else {// 往右找，x++
                while (++x2 != maxX) {
                    if (matrix[y2][x2] == target)
                        return true;
                }
            }
        }
    }

}
