package problemset.string;

public class FormatDollar {
    public String format(String dollar) {
        int len = dollar.length();
        if (len == 0) return dollar;

        StringBuilder sb = new StringBuilder("$");
        char[] chs = dollar.toCharArray();
        int dot = len, mod = 3;

        for (int i = 0; i < len; i++) {
            if (chs[i] == '.') dot = i;
        }
        if (dot < mod + 1) {  // has not ','
            sb.append(dollar);
        } else {  // has ','
            int start = dot % mod;
            if (start != 0) sb.append(dollar, 0, dot % mod);

            for (int i = start; i < dot; i++) {
                if ((i - start) % mod == 0)
                    sb.append(',');
                sb.append(chs[i]);
            }
            if (start == 0) sb.delete(1, 2);
            if (dot != len) sb.append(dollar, dot, dollar.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FormatDollar formatDollar = new FormatDollar();
        System.out.println(formatDollar.format("1"));
        System.out.println(formatDollar.format("1.00"));
        System.out.println(formatDollar.format("1234"));
        System.out.println(formatDollar.format("1234.23"));
        System.out.println(formatDollar.format("123456789.23"));
    }
}
