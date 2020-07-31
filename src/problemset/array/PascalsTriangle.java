package problemset.array;

import java.util.ArrayList;
import java.util.List;

/** 
 * @date: 2020-04-01
 * @time: 14:33:19
 * @author: MoeexT
 * @problem: 118
 * @url: https://leetcode-cn.com/problems/pascals-triangle/
 */

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) {
            return list;
        } else if (numRows == 1) {
            list.add(new ArrayList<Integer>(1));
            return list;
        }

        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                
            }
            row.add(1);
            list.add(row);
        }
        
        return list;
    }

    public static void main(String[] args) {
        PascalsTriangle obj = new PascalsTriangle();
        System.out.println(obj.generate(5));
    }
}
