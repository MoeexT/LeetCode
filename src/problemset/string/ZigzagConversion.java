package problemset.string;
// https://leetcode-cn.com/problems/zigzag-conversion/

public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        /**
         * 15ms: 35.5%
         * 41.1MB: 7.57%
         */
        if (s == null || s == "" || numRows == 1) {
            return s;
        }
        StringBuilder S = new StringBuilder(s);
        StringBuilder sb = new StringBuilder();
        int num = (numRows - 1) << 1;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length() / num + 1; j++) {
                int idx1 = j * num + i;
                if (idx1 < s.length() && S.charAt(idx1) != ' ') {
                    sb.append(S.charAt(idx1));
                    S.replace(idx1, idx1 + 1, " ");
                }
                int idx2 = (j + 1) * num - i;
                if (idx2 != idx1 && idx2 < s.length() && S.charAt(idx2) != ' ') {
                    sb.append(S.charAt(idx2));
                    S.replace(idx2, idx2 + 1, " ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = ZigzagConversion.convert("LEETCODEISHIRING", 3);
        System.out.println(res.equals("LCIRETOESIIGEDHN"));
    }
}
