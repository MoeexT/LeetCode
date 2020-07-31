package problemset.dfs;

import java.util.ArrayList;
import java.util.Arrays;

/** 
 * date: 2020-03-25
 * time: 17:07:55
 * author: MoeexT
 * Problem: 841
 * url: https://leetcode-cn.com/problems/keys-and-rooms/
 * 传入`ArrayList<ArrayList<Integer>> rooms`参数不对
 */

public class KeysAndRooms {
    boolean[] flag;
    public boolean canVisitAllRooms (ArrayList<ArrayList<Integer>> rooms) {
        flag = new boolean[rooms.size()];
        boolean res = true;
        // Stream.of(flag).reduce(true, (a, b) -> a && b);

        dfs(rooms, 0);

        for (boolean b : flag) {
            res = res && b;
        }
        return res;
    }

    public void dfs(ArrayList<ArrayList<Integer>> rooms, int idx) {
        for (int key : rooms.get(idx)) {
            if (flag[key])
                continue;
            flag[key] = true;
            dfs(rooms, key);
        }
    }

    public static void main(String[] args) {
        KeysAndRooms obj = new KeysAndRooms();
        System.out.println(obj.canVisitAllRooms(new ArrayList<ArrayList<Integer>>(Arrays.asList(
            new ArrayList<Integer>(Arrays.asList(1)),
            new ArrayList<Integer>(Arrays.asList(2)),
            new ArrayList<Integer>(Arrays.asList(3)),
            new ArrayList<Integer>(Arrays.asList())
        ))));
    }
}
