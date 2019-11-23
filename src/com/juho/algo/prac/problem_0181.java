package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of words, for each word find the shortest unique prefix.
 * You can assume a word will not be a substring of another word (ie play and playing won't be in the same words list)
 *
 * Example
 * Input: ['joma', 'john', 'jack', 'techlead'], Output: ['jom', 'joh', 'ja', 't']
 *
 * @author Juho Lee
 * @since Nov 22, 2019
 */
public class problem_0181 {

    public class Trie {

        public int count;
        public String word;
        public Trie[] next;

        public Trie() {
            this.count = 0;
            this.word = null;
            this.next = new Trie[26];
        }
    }

    public List<String> shortestUniquePrefix(List<String> list) {
        List<String> result = new ArrayList<>();
        Trie trie = buildTrie(list);
        for(String word : list) {
            char[] chars = word.toCharArray();
            Trie pointer = trie;
            StringBuilder sb = new StringBuilder();
            for(char c : chars) {
                int i = c - 'a';
                sb.append(c);
                pointer = pointer.next[i];
                if(pointer.count == 1 || pointer.word != null)
                    break;
            }
            result.add(sb.toString());
        }
        return result;
    }

    private Trie buildTrie(List<String> list) {
        Trie trie = new Trie();
        for(String word : list) {
            char[] chars = word.toCharArray();
            Trie pointer = trie;
            for(char c : chars) {
                int i = c - 'a';
                if(pointer.next[i] == null)
                    pointer.next[i] = new Trie();
                pointer = pointer.next[i];
                pointer.count++;
                System.out.println(c + ": " + pointer.count);
            }
            pointer.word = word;
        }
        return trie;
    }

}