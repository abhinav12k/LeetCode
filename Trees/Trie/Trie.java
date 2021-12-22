package Trees.Trie;

import java.util.Arrays;

public class Trie {

    static final int ALPHABET_SIZE = 26;

    static class TrieNode {

        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
        int num;

        TrieNode() {
            num = 0;
            isEndOfWord = false;
            Arrays.fill(children, null);
        }
    }

    static TrieNode root;

    static void insert(String key) {

        int n = key.length();

        TrieNode pCrawl = root;

        for (int level = 0; level < n; level++) {
            int idx = key.charAt(level) - 'a';
            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }
            pCrawl.children[idx].num++;
            pCrawl = pCrawl.children[idx];
        }

        pCrawl.isEndOfWord = true;
    }

    static boolean search(String key) {
        int n = key.length();

        TrieNode pCrawl = root;

        for (int i = 0; i < n; i++) {
            int idx = key.charAt(i) - 'a';
            if (pCrawl.children[idx] == null)
                return false;
            pCrawl = pCrawl.children[idx];
        }

        return pCrawl.isEndOfWord;
    }

    static int countWordsWithPrefix(String prefix){

        int n = prefix.length();

        TrieNode pCrawl = root;

        for(int i=0;i<n;i++){
            int idx = prefix.charAt(i)-'a';
            if(pCrawl.children[idx]==null){
                return -1;
            }
            pCrawl = pCrawl.children[idx];
        }

        return pCrawl.num;
    }

    public static void main(String[] args) {

        String keys[] = {"gee", "geek", "geezer", "geeksforgeeks", "geekiness", "geekgod"};

        root = new TrieNode();

        for (String key : keys) {
            insert(key);
        }

        if (search("this")) {
            System.out.println("there is Found");
        } else {
            System.out.println("Not Found");
        }

        System.out.println(countWordsWithPrefix("geek"));

    }

}
