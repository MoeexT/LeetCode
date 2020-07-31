pyramid = [
    [13],
    [11, 8],
    [12, 7, 26],
    [6, 14, 15, 8],
    [12, 7, 13, 24, 11]
]


def search():
    for i in range(len(pyramid) - 2, -1, -1):
        for j in range(i + 1):
            pyramid[i][j] += max(pyramid[i + 1][j], pyramid[i + 1][j + 1])
    return pyramid[0][0]


if __name__ == "__main__":
    print(search())
    print(pyramid)
