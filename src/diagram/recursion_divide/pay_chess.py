# -*- codinf: utf-8 -*-


def go(m, n):
    if m == 0 and n == 0:
        return 0
    if m == 0 or n == 0:
        return 1
    return go(m-1, n) + go(m, n-1)


if __name__ == "__main__":
    print(go(4, 5))
