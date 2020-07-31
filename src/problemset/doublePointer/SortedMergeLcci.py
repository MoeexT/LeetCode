'''
面试题 10.01. 合并排序的数组
https://leetcode-cn.com/problems/sorted-merge-lcci/
'''
from typing import List


class Solution:
    def merge(self, A: List[int], m: int, B: List[int], n: int) -> None:
        """
        32ms:   95.35%
        13.4MB: 100.00%
        """
        a, b = m - 1, n - 1
        # 40ms:   67.44%
        # for i in range(m+n-1, -1, -1):
        #     if a >= 0 and b >= 0:
        #         if A[a] > B[b]:
        #             A[i] = A[a]
        #             a -= 1
        #         else:
        #             A[i] = B[b]
        #             b -= 1
        #     elif a < 0:
        #         A[i] = B[b]
        #         b -= 1
        #     elif b < 0:
        #         A[i] = A[a]
        #         a -= 1
        i = m + n - 1
        while b >= 0:
            if a >= 0 and A[a] > B[b]:
                A[i] = A[a]
                a -= 1
            else:
                A[i] = B[b]
                b -= 1
            i -= 1

        print(A)


if __name__ == "__main__":
    sol = Solution()
    sol.merge([1, 2, 3, 0, 0, 0, 0, 0, 0, 0], 3,
              [1, 2, 3, 5, 6, 7, 9], 7)
