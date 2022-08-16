package com.example.sdesheet;

import java.util.*;

class Test {
    public List<Integer> findSubstring(String s, String[] words) {
        //base case
        if(s == null || s.length() == 0 || words == null || words.length == 0){
            return new ArrayList<>();
        }
        
        //init hashmap to store word as key and its frequency as val
        HashMap<String,Integer> freqMap = new HashMap<>();
        
        //loop over freq map and add all words in words list
        for(String word : words){
            freqMap.put(word, freqMap.getOrDefault(word,0)+1);
        }
        
        //store length of each word in words 
        int lenOfword = words[0].length();
        //count total num of words
        int totWords = words.length;
        //calculate total length of words in words list (words are of same length)
        int totWordLen = lenOfword * totWords;
        
        //init result array
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i <= s.length() - totWordLen; i++){
            //creating hashmap for seen words to ignore them if found repeating in s
            HashMap<String,Integer> seenWord = new HashMap<>();
            
            
            for(int j = 0; j < totWords; j++){
                //fetch word index
                int wordIdx = i + j * lenOfword;
                //get the word
                String word = s.substring(wordIdx, wordIdx + lenOfword);
                
                //if word not found in freqmap, simply break
                if(!freqMap.containsKey(word)) break;
                
                //otherwise put that word in seenword map
                seenWord.put(word, seenWord.getOrDefault(word,0)+1);
                
                //if word count in seenword map is more than it appears in freqmap, break
                if(seenWord.get(word) > freqMap.getOrDefault(word,0)) break;
                
                //if totWords are found then simply add idx of occurence to result
                if(j+1 == totWords){
                    res.add(i);
                }
                
            }
            
        }
        
        return res;
    }
}