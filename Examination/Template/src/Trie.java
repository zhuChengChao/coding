public class Trie {

    // 前缀树
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {

        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode node = root;

        for(int i=0; i<word.length(); i++){

            if(node.children[word.charAt(i) - 'a'] == null){
                node.children[word.charAt(i) - 'a'] = new TrieNode();
            }

            node = node.children[word.charAt(i) - 'a'];
            node.preCount ++;
        }

        node.count++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode node = root;

        for(int i=0; i<word.length(); i++){

            if(node.children[word.charAt(i) - 'a'] == null){
                return false;
            }

            node = node.children[word.charAt(i) - 'a'];
        }

        return node.count > 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        TrieNode node = root;

        for(int i=0; i<prefix.length(); i++){

            if(node.children[prefix.charAt(i) - 'a'] == null){
                return false;
            }

            node = node.children[prefix.charAt(i) - 'a'];
        }

        return node.preCount > 0;
    }

    private class TrieNode{

        // 表示以该处节点构成的串的个数:完整的串
        int count;
        // 表示以该处节点构成的前缀的字串的个数
        int preCount;

        TrieNode[] children;

        TrieNode(){

            // 26个字母
            children = new TrieNode[26];
            count = 0;
            preCount = 0;
        }
    }
}
