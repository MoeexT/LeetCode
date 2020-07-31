'''
记忆搜索法求解0-1背包问题
'''

info = [
    [3, 8],
    [2, 5],
    [5, 12],
]

mem = {}

def search(depth, rest):
    # if (key :="({},{})".format(depth, rest)) in mem:
    #     return mem[key]
    if depth == len(info)-1:
        return info[depth][1] if rest >= info[depth][0] else 0
    else:
        value = []
        value.append(search(depth+1, rest))
        if rest >= info[depth][0]:
            value.append(search(depth + 1, rest - info[depth][0]) + info[depth][1])
        return max(value)


if __name__ == "__main__":
    print(search(0, 5))
