package problemset.string;

/**
 * @date: 2020-03-30
 * @time: 22:38:56
 * @author: MoeexT
 * @problem: 67
 * @url: https://leetcode-cn.com/problems/add-binary/
 */

public class AddBinary {
    /** 
     * @time: 2ms 97.59%
     * @mem: 39.9MB 5.21%
     */
    public String addBinary(String a, String b) {
        char[] A, B;
        if (a.length() >= b.length()) {
            A = a.toCharArray();
            B = b.toCharArray();
        } else {
            A = b.toCharArray();
            B = a.toCharArray();
        }

        char[] ra = new char[A.length + 1];
        ra[0] = '0';
        for (int i = 0; i < A.length; i++) {
            ra[i + 1] = A[i];
        }

        int d = ra.length - B.length;

        for (int i = ra.length - 1; i > 0; i--) {
            if (i >= d) {
                ra[i] += B[i - d] - '0';
            }
            // System.out.println(Arrays.toString(ra));
            if (ra[i] == '2') {
                ra[i] = '0';
                ra[i - 1] += 1;
            } else if (ra[i] == '3') {
                ra[i] = '1';
                ra[i - 1] += 1;
            }
            // System.out.println(Arrays.toString(ra));
            // System.out.println("-----------");
        }
        if (ra[0] == '0') {
            return String.valueOf(ra).substring(1);
        }
        return String.valueOf(ra);
    }

    public static void main(String[] args) {
        AddBinary obj = new AddBinary();
        System.out.println(obj.addBinary("0", "0"));
    }
}
