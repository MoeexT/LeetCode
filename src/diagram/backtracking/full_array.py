#   全排列问题

data_list = [1, 2, 3]
array = []


def search(depth, remnant):
    if depth == 3:
        array.append(remnant[0])
        print(array)
        array.pop()
    else:
        for data in remnant:
            # 1. 设置现场
            array.append(data)
            # 2. 递归
            next_data = remnant[:]
            next_data.remove(data)
            search(depth+1, next_data)
            # 3. 恢复现场
            array.pop()


if __name__ == "__main__":
    search(1, data_list)
