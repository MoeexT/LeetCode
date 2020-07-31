# -*- coding: utf-8 -*-


def test_walrus():
    judge = ['1', '2', '3', '4', '5', '6', '7', '8', '9']
    for i in range(9):
        if len(s := judge[i]) == 1:
            print(s)


if __name__ == "__main__":
    test_walrus()
