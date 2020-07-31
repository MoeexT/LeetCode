'''
回溯法求解0-1背包问题
'''

info = [
    [3, 8],
    [2, 5],
    [5, 12],
]

data = []
m = 0
l = []

def search(depth, rest):
    global m
    if depth == 3:
        s = 0
        for i in range(len(data)):
            if data[i]:
                s += info[i][1]
        if s > m:
            global l
            m = s 
            l = data[:]
        print(data)
    else:
        data.append(0)
        search(depth+1, rest)
        data.pop()

        if rest >= info[depth][0]:
            data.append(1)
            search(depth+1, rest-info[depth][0])
            data.pop()


if __name__ == "__main__":
    search(0, 5)
    print(m, l)
