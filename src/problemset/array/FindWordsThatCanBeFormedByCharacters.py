# -*- coding: utf-8 -*-
# https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/submissions/
from typing import List


class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        '''
        132ms: 79.39%
        13.7MB: 5.11%
        '''
        res = 0
        for string in words:
            alphabet = chars
            count = 0
            for i in range(len(string)):
                char = string[i]
                if char not in alphabet:
                    break
                alphabet = alphabet.replace(char, " ", 1)
                string = string.replace(char, " ", 1)
                count += 1
            if len(string.strip()) == 0:
                res += count
        return res


if __name__ == "__main__":
    solotion = Solution()
    print(solotion.countCharacters(["hello","world","leetcode"], "welldonehoneyr"))
