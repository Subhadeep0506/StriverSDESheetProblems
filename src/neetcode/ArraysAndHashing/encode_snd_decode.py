"""
https://www.lintcode.com/problem/659/
Design an algorithm to encode a list of strings to a string. The encoded string 
is then sent over the network and is decoded back to the original list of strings.

Please implement encode and decode
"""


class EncodeAndDecode:
    def encode(self, strs):
        string = ""
        for word in strs:
            string += str(len(word)) + "#" + word
        return string
    
    def decode(self, str):
        res, i = [], 0
        while i < len(str):
            j = i
            while str[j] != "#":
                j += 1
            length = int(str[i : j])
            word = str[j + 1: j + length + 1]
            res.append(word)
            i = j + length + 1
        return res


input = ["lint","code","love","you"]
obj = EncodeAndDecode()
encoded = obj.encode(input)

print("Encoded string:", encoded)

decoded = obj.decode(encoded)
print("Decoded list:", decoded)
