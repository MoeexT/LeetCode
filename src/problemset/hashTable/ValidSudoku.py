"""
problem 36
https://leetcode-cn.com/problems/valid-sudoku/
"""
from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        '''
        176ms: 10.92%
        29.2MB: 5.11%
        '''
        for k in range(9):
            if not self.__check_row(board, k):
                return False
            if not self.__check_column(board, k):
                return False
            if not self.__check_matrix(board, k):
                return False
        return True

    def __check_row(self, matrix: List[List[str]], idx: int) -> bool:
        '''
        matrix: 输入矩阵
        idx: 行号
        '''
        judge = ['1', '2', '3', '4', '5', '6', '7', '8', '9']
        arr = matrix[idx]
        for s in arr:
            if s == '.':
                continue
            try:
                judge.remove(s)
            except ValueError as e:
                print("Row Error:")
                print(arr, idx)
                print(e.args)
                return False
        return True

    def __check_column(self, matrix: List[List[str]], idx: int) -> bool:
        judge = ['1', '2', '3', '4', '5', '6', '7', '8', '9']
        '''
        matrix: 输入矩阵
        idx: 列号
        '''
        for arr in matrix:
            if arr[idx] == '.':
                continue
            try:
                judge.remove(arr[idx])
            except ValueError as e:
                print("Column Error:")
                print(arr, idx)
                print(e.args)
                return False
        return True

    def __check_matrix(self, matrix: List[List[str]], idx: int) -> bool:
        '''
        matrix: 输入矩阵
        idx: 分块的序号
             idx
        行号X | 列号Y
              0               1               2
        0 1 2 | 0 1 2   0 1 2 | 3 4 5   0 1 2 | 6 7 8
              3               4               5
        3 4 5 | 0 1 2   3 4 5 | 3 4 5   3 4 5 | 6 7 8
              6               7               8
        6 7 8 | 0 1 2   6 7 8 | 3 4 5   6 7 8 | 6 7 8

        行号 X 和列号 Y 可根据下式得到
        {
            X = (idx // 3) + [0, 1, 2]
            Y = (idx % 3) + [0, 1, 2]
        }
        '''
        judge = ['1', '2', '3', '4', '5', '6', '7', '8', '9']

        X = self.__add_vector((idx // 3) * 3, [0, 1, 2])
        Y = self.__add_vector((idx % 3) * 3, [0, 1, 2])

        for i in X:
            for j in Y:
                if matrix[i][j] == '.':
                    continue
                try:
                    judge.remove(matrix[i][j])
                except ValueError as e:
                    print("Matrix Error:")
                    print(X, Y)
                    print(e.args)
                    return False
        return True

    def __add_vector(self, scator, vector: List[int]) -> List[int]:
        '''
        实现标量或向量与向量的相加
        scator: 标量或向量
        vector: 向量
        '''
        if type(scator) is int:
            return [i + scator for i in vector]
        elif type(scator) is list and len(scator) == len(vector):
            return [i + j for i, j in zip(scator, vector)]
        else:
            raise Exception("can't add scator and vector.")


if __name__ == "__main__":
    solution = Solution()
    Bool = solution.isValidSudoku([
        ["8", "3", ".", ".", "7", ".", ".", ".", "."],
        ["6", ".", ".", "1", "9", "5", ".", ".", "."],
        [".", "9", "8", ".", ".", ".", ".", "6", "."],
        ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
        ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
        ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
        [".", "6", ".", ".", ".", ".", "2", "8", "."],
        [".", ".", ".", "4", "1", "9", ".", ".", "5"],
        [".", ".", ".", ".", "8", ".", ".", "7", "9"]
    ])
    print(Bool)
