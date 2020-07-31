
value = [
    # 0, 10, 20, 30, 40, 50, 60
    # -------------------------
    [0, 20, 50, 65, 80, 85, 85],
    [0, 20, 40, 50, 55, 60, 65],
    [0, 25, 60, 85, 100, 110, 115],
    [0, 25, 40, 50, 60, 65, 70]
]

pre_max = value[-1]
for k in range(len(value) - 1, 0, -1):
    new_max = [0]
    for i in range(10, 61, 10):
        value_list = []
        for j in range(0, i + 1, 10):
            value_list.append(pre_max[j // 10] + value[k - 1][(i - j) // 10])
        new_max.append(max(value_list))
        # print(value_list)
    pre_max = new_max
    # print(new_max, '-------')

print(pre_max)


'''
# value[2], 第三家工厂
pre_max = [0]
for i in range(10, 61, 10):
    value_list = []
    for j in range(0, i + 1, 10):
        value_list.append(value[3][j // 10] + value[2][(i - j) // 10])
    pre_max.append(max(value_list))
    print(value_list)
print(pre_max)
# # value[1], 第二家工厂
# pre_max2 = [0]
# for i in range(10, 61, 10):
#     value_list = []
#     for j in range(0, i + 1, 10):
#         value_list.append(pre_max[j // 10] + value[1][(i - j) // 10])
#     pre_max2.append(max(value_list))

# # value[0], 第一家工厂
# pre_max3 = []
# for i in range(60, 61, 10):
#     value_list = []
#     for j in range(0, i + 1, 10):
#         value_list.append(pre_max2[j // 10] + value[0][(i - j) // 10])
#     pre_max3.append(max(value_list))

# print(pre_max3)

'''
