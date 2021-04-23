package interview;

import java.io.IOException;

public class Testing {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = "abc";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str3));
        System.out.println(str2 == "abc");
        System.out.println(str3 == "abc");
    }

}
