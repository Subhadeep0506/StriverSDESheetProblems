class ValidAnagram:
    def isAnagram(self, s: str, t: str) -> bool:
        s_len = len(s)
        t_len = len(t)

        if s_len != t_len:
            return False

        s_map, t_map = {}, {}
        for i in range(s_len):
            s_map[s[i]] = s_map.get(s[i], 0) + 1
            t_map[t[i]] = t_map.get(t[i], 0) + 1
        
        return s_map == t_map