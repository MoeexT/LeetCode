""" -*- coding: utf-8 -*-
@date: 2020-03-22
@time: 16:57:43
@author: MoeexT
Problem: 394.
url: https://leetcode-cn.com/problems/decode-string/
"""


class Solution:
    def decodeString(self, s: str) -> str:
        """
        @time: 36ms 53.38%
        @mem: 13.5MB 5.00%
        """
        """
         stack 为“顺序”, 元素从左到右与源字符串同
         hp_stack为“倒序”，与stack相反
         ∵ stack是 s 直接转化过来的，而hp_stack的元素是栈操作添加的
         ∴ chr_buf 和 int_buf 生成顺序相反
        """
        stack = list(s)
        hp_stack = []
        while stack:
            chr_buf = ""
            int_buf = ""
            ch = stack.pop()
            if ch == '[':
                # 辅助栈把多吃的东西吐出来
                while hp_stack[-1] != ']':
                    chr_buf = chr_buf + hp_stack.pop()
                hp_stack.pop()
                while stack and stack[-1].isnumeric():
                    int_buf = stack.pop() + int_buf
                """ 如果存在 "2[bc[de]]", 当chr_buf='de'时, int_buf=''
                int(int_buf)会报 ValueError: invalid literal for int() with base 10: ''
                但不知道是否存在这样的测试用例
                不存在…………
                int_buf = int_buf if int_buf else '1' """
                # 解码后装回去
                hp_stack.append(int(int_buf) * chr_buf)
            else:
                hp_stack.append(ch)

        return "".join(hp_stack[::-1])

    def to_list(self, string):
        lst = []
        hp_lst = []
        unit_cnt = 0
        for S in string:
            hp_lst.append(S)
            if S == '[':
                unit_cnt += 1
            elif S == ']':
                unit_cnt -= 1
            if unit_cnt == 0 and ']' in hp_lst:
                lst.append(hp_lst[:])
                hp_lst = []
        lst.append(hp_lst[:])
        return lst


if __name__ == "__main__":
    solution = Solution()
    print(solution.decodeString("2[abc3[a]z]3[cd]ef"))
    # print(solution.to_list("2[abc3[a]z]3[cd]ef"))
