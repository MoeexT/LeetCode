package problemset.string;

public class CompressStringLcci {
    public String compressString(String S) {
        /**
         * 6ms: 75.90%
         * 38.8MB: 100%
         */
        if (S == null || S.length() == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            char key = S.charAt(i - 1);
            if (S.charAt(i) != key) {
                sb.append(key).append(count);
                count = 0;
            }
            count ++;
        }
        sb.append(S.charAt(S.length()-1)).append(count);
        if (sb.toString().length() >= S.length()) {
            return S;
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        CompressStringLcci cString = new CompressStringLcci();
        String res = cString.compressString("aabcccccaaa");
        System.out.println(res);
    }
}
