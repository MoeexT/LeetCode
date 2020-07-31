# 八皇后问题 Eight Queens Puzzle

total = 0
board = [
    [0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0]
]


def can_place(x, y):
    # 判断(x, y)能否放皇后
    # 1. 判断x行是否有皇后
    for i in range(0, y):
        if board[x][i] == 1:
            return False
    # 2. 判断y列是否有皇后
    for i in range(0, x):
        if board[i][y] == 1:
            return False
    # 3.判断"/"斜线方向是否有皇后
    for i in range(0, x):
        if x + y - i <= 7 and board[i][x+y-i] == 1:
            return False
    # 4.判断"\"斜线方向是否有皇后
    for index, i in enumerate(range(x-1, -1, -1)):
        # s_y = y - (index+1)
        if (s_y := y - (index+1)) >= 0:
            if board[i][s_y] == 1:
                return False
    return True


def print_board():
    for i in range(8):
        for j in range(8):
            if board[i][j] == 0:
                print("□", end=" ")
            else:
                print("■", end=" ")
        print()


def put_queen(step):
    if step == 8:
        print_board()
        global total
        total += 1
        print("NexT")
    else:
        for i in range(8):
            # 判断该位置是否能放皇后
            if can_place(step, i):
                # 1. 设置现场
                board[step][i] = 1
                # 2. 开始递归
                put_queen(step+1)
                # 3. 恢复现场
                board[step][i] = 0


if __name__ == "__main__":
    put_queen(0)
    print(total)
