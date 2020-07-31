'''
problem 1071
https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
'''


class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        # 32ms: 80.71%
        # 13.4MB: 7.48%
        # https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/comments/121973
        if str1 + str2 != str2 + str1:
            return ""
        return str1[0 : self.gcd(len(str1), len(str2))]

    def gcd(self, a, b):
        #https://zhuanlan.zhihu.com/p/31824895
        return a if b == 0 else self.gcd(b, a % b)

if __name__ == "__main__":
    sol = Solution()
    # print(sol.gcd(1, 25))
    print(sol.gcdOfStrings("ABCABC", "ABC"))
