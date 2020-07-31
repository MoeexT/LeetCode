package problemset.math;

/**
 * date: 2020-03-27 time: 11:12:04 author: MoeexT problem: 914 url:
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */

public class XOfAKindInADeckOfCards {
    /** map
     * time: 13ms 46.15%
     * mem: 42.4MB 5.64%
     */
    /** 数组
     * help: https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/comments/310831
     * time: 4ms 66.52%
     * mem: 41.4MB 5.64%
     */
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length == 0)
            return false;
        // Map<Integer, Integer> map = new HashMap<>();
        int[] map = new int[10000];
        for (int i : deck)
            map[i] ++;
        int flag = map[deck[0]];
        for (int i : map) {
            if (i>0) {
                flag = gcd(flag, i);
                if (flag == 1)
                    return false;
            }
        }
        return true;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        XOfAKindInADeckOfCards obj = new XOfAKindInADeckOfCards();
        System.out.println(obj.hasGroupsSizeX(new int[] { 1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3 }));
        // System.out.println(obj.gcd(2,10));
    }
}
