# -*- coding: utf-8 -*-
import timeit


class Solution:
    def longestPalindrome(self, s: str) -> int:
        sb = ""
        odd = False
        dic = {}
        for S in s:
            if not odd and s.count(S) % 2 == 1:
                odd = True
                ln = len(sb) >> 1
                sb = sb[:ln] + S + sb[ln:]
            if (ct := s.count(S)) % 2 == 0:
                for i in range(ct//2):
                    sb = S + sb + S
                s.replace(S, ' ', ct)

        print(sb)
        return len(sb)


def t1(n):
    s = ""
    for i in range(n):
        s = s[:len(s) // 2]+'c'+s[len(s) // 2:]


def t2(n):
    s = ""
    for i in range(n):
        ln = len(s) // 2
        s = s[:ln] + 'c'+s[ln:]


def t3(n):
    s = ""
    for i in range(n):
        ln = len(s) >> 1
        s = s[:ln] + 'c' +s[ln:]


def t4(n):
    l = []
    for i in range(n):
        l.insert(len(l)//2, l)


if __name__ == "__main__":
    solotion = Solution()
    print(solotion.longestPalindrome("abccccdd"))

    """
    print(timeit.timeit("t1(100000)", setup="from __main__ import t1", number=1))
    0.4726434
    print(timeit.timeit("t2(100000)", setup="from __main__ import t2", number=1))
    0.45817709999999995
    print(timeit.timeit("t3(100000)", setup="from __main__ import t3", number=1))
    0.4404665
    print(timeit.timeit("t4(100000)", setup="from __main__ import t4", number=1))
    1.0145052999999997
    """
