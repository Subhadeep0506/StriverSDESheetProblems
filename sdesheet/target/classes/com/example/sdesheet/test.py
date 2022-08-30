def isPalindrome(s):
    if s.lower() == s.lower()[::-1]:
        return True

def countNumberOfPalindromeWords(s):
    cnt = 0;
    listofwords = s.split(" ")
    
    for i in listofwords:
        if(isPalindrome(i)):
            cnt += 1
	return cnt

s = "Madam oyo cat"
print(countNumberOfPalindromeWords(s))