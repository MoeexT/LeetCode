package problemset.array;

public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        for (String string : words) {
            StringBuilder sb = new StringBuilder(chars);
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                sb.replace(0, chars.length(), Character.toString(ch));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindWordsThatCanBeFormedByCharacters fw = new FindWordsThatCanBeFormedByCharacters();
        int res = fw.countCharacters(new String[] {"cat","bt","hat","tree"}, "atach");
        System.out.println(res);
    }
}
