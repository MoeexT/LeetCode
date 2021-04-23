package problemset.trie;

/*
 * @date_time: 2021-03-27 22:17
 * @author: MoeexT
 * @problem: 208
 * @url: https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */

import util.TrieNode;

public class Trie {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode cur = root;
        char[] chars = word.toCharArray();

        for (char ch : chars) {
            TrieNode node = cur.getChild(ch);
            if (node == null) {
                cur.addChild(ch);
            }
            cur = cur.getChild(ch);
        }
        cur.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for (char ch : chs) {
            TrieNode node = cur.getChild(ch);
            if (node == null) {
                return false;
            }
            cur = node;
        }
        return cur.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chs = prefix.toCharArray();
        TrieNode cur = root;
        for (char ch : chs) {
            TrieNode node = cur.getChild(ch);
            if (node == null) {
                return false;
            }
            cur = node;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

