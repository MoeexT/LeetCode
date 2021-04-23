package problemset.string;
// https://leetcode-cn.com/problems/zigzag-conversion/

public class ZigzagConversion {
    /**
     * 15ms: 35.5%
     * 41.1MB: 7.57%
     */
    public static String convert_(String s, int numRows) {
        if (s == null || s.equals("") || numRows == 1) {
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

    /*
     * 数学计算
     * @time: 3ms 98.08%
     * @mem: 38.7MB 81.47%
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int npg = (numRows - 1) << 1;  // nums per group 每组有几个字符
        int groupNum = s.length() / npg;  // 有几组，这里没有加1，但是下边循环里加上了
        char[] chs = s.toCharArray();
        int chl = chs.length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= groupNum; j++) {
                if ((i == 0 || i == numRows - 1) && j * npg + i < chl) {
                    sb.append(chs[j * npg + i]);
                } else {
                    if (j * npg + i < chl)
                        sb.append(chs[j * npg + i]);
                    if ((j + 1) * npg - i < chl) {
                        sb.append(chs[(j + 1) * npg - i]);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("AB", 2));
    }
}
