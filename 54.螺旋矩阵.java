import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int[][] flag = new int[matrix.length][matrix[0].length];
        int i = 0, j = 0;
        int pathI = 0, pathJ = 1;
        while(true) {
            res.add(matrix[i][j]);
            flag[i][j] = 1;
            if ((i - 1 < 0 || flag[i - 1][j] == 1) && (i + 1 == matrix.length || flag[i + 1][j] == 1) && (j - 1 < 0 || flag[i][j - 1] == 1) && (j + 1 == matrix[0].length || flag[i][j + 1] == 1)) {
                break;
            } else if(i + pathI == matrix.length || i + pathI < 0 || j + pathJ == matrix[0].length || j + pathJ < 0 || flag[i + pathI][j + pathJ] == 1) {
                System.out.println(i);
                System.out.println(j);
                if (pathI == 0 && pathJ == 1) {
                    pathI = 1;
                    pathJ = 0;
                } else if (pathI == 1 && pathJ == 0){
                    pathI = 0;
                    pathJ = -1;
                } else if (pathI == 0 && pathJ == -1){
                    pathI = -1;
                    pathJ = 0;
                } else if (pathI == -1 && pathJ == 0){
                    pathI = 0;
                    pathJ = 1;
                }
            }
            i += pathI;
            j += pathJ;
        }
        return res;
    }
}
// @lc code=end

