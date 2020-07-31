package problemset.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * date: 2020-03-28 time: 15:30:58 author: MoeexT problem: 820 url:
 */

public class ShortEncodingOfWords {
    /**
     * help:
     * https://leetcode-cn.com/problems/short-encoding-of-words/solution/dan-ci-de-ya-suo-bian-ma-by-leetcode-solution/
     * time: 33ms 50.75%
     * mem: 41.7MB 16.66%
     */
    public int minimumLengthEncoding_(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        int ans = 0;
        for (String word : set) {
            ans += word.length() + 1;
        }
        return ans;
    }

    public int minimumLengthEncoding(String[] words) {
        int len = 0;

        Trie trie = new Trie();
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());

        for (String word : words) {
            len += trie.insert(word);
        }
        return len;
    }

    public static void main(String[] args) {
        ShortEncodingOfWords obj = new ShortEncodingOfWords();
        System.out.println(obj.minimumLengthEncoding(new String[] {}));
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public int insert(String word) {
        TrieNode cur = root;
        boolean isNew = false;
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                isNew = true;
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        return isNew ? word.length() + 1 : 0;
    }
}

class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }
}
