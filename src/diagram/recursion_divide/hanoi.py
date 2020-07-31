# -*- coding: utf-8 -*-


def hanoi(num, start, mid, end):
    if num == 1:
        print("1: {}-->{}".format(start, end))
        return
    else:
        hanoi(num-1, start, end, mid)
        print("{}: {}-->{}".format(num, start, end))
        hanoi(num-1, mid, start, end)


if __name__ == "__main__":
    hanoi(3, "A", "B", "C")
