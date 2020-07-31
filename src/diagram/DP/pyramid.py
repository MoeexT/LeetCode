# -*- coding:utf-8 -*-
'''
数字金字塔问题
'''

pyramid = [
    [13],
    [11, 8],
    [12, 7, 26],
    [6, 14, 15, 8],
    [12, 7, 13, 24, 11]
]
data = [13]
max = 0
Max = []

def search(depth, x, y):
    # 1. 选择下方的值
    if depth == 5:
        global max, Max
        if max < sum(data):
            max = sum(data)
            Max = data[:]
        return
    data.append(pyramid[x + 1][y])
    search(depth + 1, x + 1, y)
    data.pop()
    data.append(pyramid[x+1][y+1])
    search(depth + 1, x + 1, y + 1)
    data.pop()


if __name__ == "__main__":
    search(1, 0, 0)
    print(max, Max)
