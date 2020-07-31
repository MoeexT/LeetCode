'''
num = 7
1+1+1+1+1+1+1
1+1+5
3+4
......
'''

data = []


def div(num):
    if num == 0:
        print(data)
        return
    # else:
    for i in range(1, num+1):
        data.append(i)
        div(num-i)
        data.pop()


if __name__ == "__main__":
    div(7)
