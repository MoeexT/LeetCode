package util;

public class TrieNode {
    char val;
    boolean end;
    TrieNode[] children;

    public TrieNode(char val) {
        this.val = val;
        this.end = false;
        this.children = new TrieNode[26];
    }

    public TrieNode() {
        this.end = false;
        this.children = new TrieNode[26];
    }

    public TrieNode getChild(char ch) {
        return children[ch - 'a'];
    }

    public void addChild(char ch) {
        this.children[ch - 'a'] = new TrieNode(ch);
    }

    public void setEnd() {
        end = true;
    }

    public boolean isEnd() {
        return end;
    }
}
