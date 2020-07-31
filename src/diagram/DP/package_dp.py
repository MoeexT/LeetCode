'''
DP求解0-1背包问题
'''

info = [
    [3, 8],
    [2, 5],
    [5, 12],
]
pre_max = [0]
total = 5

for i in range(1, info[-1][0]):
    pre_max.append(0)
for i in range(info[-1][0], total+1):
    pre_max.append(info[-1][1])

for k in range(len(info) - 1, -1, -1):
    new_pre_max = [0]
    start = 1
    if k == 0:
        start = total
    for i in range(start, total + 1):
        value_list = []
        if i >= info[k-1][0]:
            value_list.append(info[k-1][1] + pre_max[i-info[k-1][0]])
        value_list.append(pre_max[i])
        new_pre_max.append(max(value_list))
    pre_max = new_pre_max
print(pre_max)
