package problemset.string;

public class GenerateStringFromHeadOrTail {
    public static String generate(String str) {
        StringBuilder sb = new StringBuilder();
        int left = 0, right = str.length() - 1;
        char ch = 0, cl, cr;
        while (left <= right) {
            cl = str.charAt(left);
            cr = str.charAt(right);
            if (cl < cr) {
                sb.append(cl);
                left++;
            } else if (cl > cr) {
                sb.append(cr);
                right--;
            } else {
                int l = left, r = right;  // cl === cr
                while (l < r && str.charAt(l) == str.charAt(r)) {
                    l++;
                    r--;
                }
                if (l == r) {
                    sb.append(str.charAt(left++));
                    continue;
                }
                if (str.charAt(l) < str.charAt(r)) {
                    sb.append(str.charAt(left++));
                } else {
                    sb.append(str.charAt(right--));
                }
            }
            System.out.printf("left: %d, right: %d\n", left, right);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(GenerateStringFromHeadOrTail.generate("abcbdacb"));
    }
}
