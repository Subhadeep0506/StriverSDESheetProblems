class PalindromicPairs:
	def palindromePairs(self, words: List[str]) -> List[List[int]]:
        word_dict = {w : i for i, w in enumerate(words)}
        res = []
        
        for i, word in enumerate(words):
            word_rev = word[::-1]
            
            # case 1: if the reverse of current word exists, and the reverse of
            # curr word is not the same word
            if word_rev in word_dict and word_dict[word_rev] != i:
                res.append([i, word_dict[word_rev]])
            
            # Case 2: if current word is not empty string and is itself a palindrome
            # and an empty string already exists in the dictionary,
            # then we add the word and empty string to res
            # we add [word, ""] and ["", word] to res
            if word != "" and word == word_rev and "" in word_dict:
                res.append([i, word_dict[""]])
                res.append([word_dict[""], i])
            
            """ 
             Case 3: suppose we have string "abade" and "ed" "edabade" will be palindrome
             Here, we split the current word into two parts from index 1 and check if 
               1. 1st part is palindrome and 2nd part's reverse is present in dict
               2. 2nd part is palindrome and 1st part's reverse is present in dict
             If true in any case, we add that case to result.
             word -> "abade", "ed"
             "a" "bade" -> 1st string is palindrome but reverse of 2nd is not present in dict:
                           ignored
             "ab" "ade" -> ignored
             "aba" "de" -> 1st string is palindrome and reverse of 2nd is present in dict: 
                           it is added to res
             "abad" "e" -> ignored
             "abade" "" -> ignored
            """
            for k in range(1, len(word)):
                s1, s2 = word[:k], word[k:]
                s1_rev, s2_rev = s1[::-1], s2[::-1]
                
                if s1 == s1_rev and s2_rev in word_dict:
                    res.append([word_dict[s2_rev], i])
                if s2 == s2_rev and s1_rev in word_dict:
                    res.append([i, word_dict[s1_rev]])
        
        return res