import java.util.HashMap;

class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode(){
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode start = root;
        for(char c : word.toCharArray()){
            TrieNode node;
            if(!start.children.containsKey(c)){
                node = new TrieNode();
                start.children.put(c, node);
            } else{
                node = start.children.get(c);
            }
            start = node;
        }
        start.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode start = root;
        for(char c : word.toCharArray()){
            if(!start.children.containsKey(c))
                return false;
            start = start.children.get(c);
        }
        return start.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode start = root;
        for(char c : prefix.toCharArray()){
            if(!start.children.containsKey(c))
                return false;
            start = start.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */