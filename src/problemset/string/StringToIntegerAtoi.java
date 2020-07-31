package problemset.string;

public class StringToIntegerAtoi {
    /*
    @time: 2ms, 96.91%
    @40.1MB, 5.18%
     */
    public int myAtoi(String str) {
        int head = -1, len = str.length();
        boolean minus = false;
        int res = 0;

        while (++head < len && str.charAt(head) == ' ');
        if (head == len) {
            return 0;
        }

        if (str.charAt(head) == '-') {
            minus = true;
            head++;
        } else if (str.charAt(head) == '+') {
            head++;
        } else if (!Character.isDigit(str.charAt(head))) {
            return 0;
        }
        while (head < len && Character.isDigit(str.charAt(head))) {
            int digit = str.charAt(head) - '0';
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + digit;
            head++;
        }
        return minus ? -res : res;
    }

    public static void main(String[] args) {
        StringToIntegerAtoi atoi = new StringToIntegerAtoi();
        System.out.println(atoi.myAtoi("   -2135 m"));
    }
}
