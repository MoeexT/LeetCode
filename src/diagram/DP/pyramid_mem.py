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

info = {}


def search_max(depth, y):
    if depth == 4:
        return pyramid[depth][y]
    key = "({},{})".format(depth, y)
    if key in info:
        return info[key]
    else:
        max_value = pyramid[depth][y] + max(search_max(depth + 1, y),
                                            search_max(depth + 1, y + 1))
        info[key] = max_value
        return max_value


if __name__ == "__main__":
    print(search_max(0, 0))
    print(info)
