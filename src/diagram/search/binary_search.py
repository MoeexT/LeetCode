#!py -3

import random
from typing import List


def random_list(start, end, length):
    data_list = []
    for i in range(length):
        data_list.append(random.randint(start, end))

    return sorted(data_list)


def binary_search(array: List[int], x: int) -> int:
    p = 0
    q = len(array) - 1
    while q >= p:
        r = p + (q - p) >> 1
        if array[r] == x:
            return r
        elif array[r] < x:
            p = r + 1
        else:
            q = r - 1

    return -1


def search_rec(data_list, target, left, right):
    if left > right:
        return -1
    mid = left + (right - left) >> 1
    if data_list[mid] == target:
        return mid
    elif data_list[mid] < target:
        return search_rec(data_list, target, mid + 1, right)
    else:
        return search_rec(data_list, target, left, mid - 1)


if __name__ == "__main__":
    print(search_rec([1, 3, 4, 5, 6, 8, 9, 12, 16], 2, 0, 8))
    # print(random_list(0, 100, 20))
