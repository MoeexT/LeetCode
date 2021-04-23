package problemset.string;

public class IndexOfStr {
    public int index(String string, String str) {
        int len1 = string.length(), len2 = str.length();
        if (len2 == 0) return 0;
        if (len1 == 0 || len1 - len2 < 0) return -1;
        for (int i = 0; i <= len1 - len2; i++) {
            if (str.charAt(0) == string.charAt(i)) {
                int j = i, idx = 0;
                while (idx < len2 && str.charAt(idx++) == string.charAt(j++)) ;
                if (idx == len2) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        IndexOfStr obj = new IndexOfStr();
        System.out.println(obj.index("123456", "4"));
    }
}
