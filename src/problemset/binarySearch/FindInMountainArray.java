package problemset.binarySearch;

/*
 * @date_time: 2020-04-29 13:40
 * @author: MoeexT
 * @problem: 1095
 * @url: https://leetcode-cn.com/problems/find-in-mountain-array/
 */

import util.MountainArray;
import util.MountainArrayList;

import java.util.ArrayList;

public class FindInMountainArray {

    /*
     * @time: 0 ms 100.00%
     * @mem: 39.4MB 100.00%
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int low = 0, high = mountainArr.length() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                low = mid + 1;
            else
                high = mid - 1;
        }
        int peak1 = low, peak2 = low;
        low = 0;
        while (low <= peak1) {
            int mid = low + (peak1 - low) / 2;
            int M = mountainArr.get(mid);
            if (M == target)
                return mid;
            else if (M > target)
                peak1 = mid - 1;
            else
                low = mid + 1;
        }
        high = mountainArr.length() - 1;
        while (peak2 <= high) {
            int mid = peak2 + (high - peak2) / 2;
            int M = mountainArr.get(mid);
            if (M == target)
                return mid;
            else if (M > target)
                peak2 = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindInMountainArray solution = new FindInMountainArray();
        MountainArrayList array = new MountainArrayList();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(3);
        array.add(1);
        System.out.println(solution.findInMountainArray(6, array));
    }
}

