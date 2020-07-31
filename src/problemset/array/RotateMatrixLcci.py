"""
-*- coding: utf-8 -*-
  @date_time: 2020-04-07 11:01
  @author: MoeexT
  @problem: 面试题01.07
  @url: https://leetcode-cn.com/problems/rotate-matrix-lcci/submissions/
"""
from typing import List


class Solution:
    def __init__(self):
        pass

    def rotate(self, matrix: List[List[int]]) -> None:
        """
        time: 36ms 13.6%",
        mem: 80.33MB 100.00%
        """
        matrix[::] = zip(*matrix[::-1])


if __name__ == "__main__":
    pass