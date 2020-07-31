package structure.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    // private final int R = 26;
    private boolean isEnd;
    private Map<Character, TrieNode> links;
    
    TrieNode() {
        links = new HashMap<>();
    }

    public boolean containsKey(char ch) {
        return links.getOrDefault(ch, null) != null;
    }

    public TrieNode get(char ch) {
        return links.get(ch);
    }

    public void put(char ch, TrieNode node) {
        links.put(ch, node);
    }
    
    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}
