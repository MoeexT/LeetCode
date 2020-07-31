# -*- coding: utf-8 -*-

'''
计算 Fibonacci 数列时间对比

for 循环计算：
time_costs(fibo_for, 100, times=1000)
It took  0.007998 second(s).

改进的递归：
time_costs(fibo_adv, 100, times=1000)
It took  0.136026 second(s).

经典递归方法，emm，不感动 不敢动
递归什么的，还是比不过循环大佬，红红火火恍恍惚惚
'''

from collections import defaultdict
from datetime import datetime
# from diagram.utils.time_cost import time_costs, time

times_run = 0
timeX_run = defaultdict(int)


def time(times=1):
    def decorator(f):
        def wrapper(*args, **kwargs):
            start = datetime.now()
            for i in range(times):
                print(';')
                res = f(*args, **kwargs)
            print("It took ", (datetime.now()-start).total_seconds(), "second(s).")
            return res
        return wrapper
    return decorator


def fibo_for(kf):
    """
    Fibonacci数列的for循环实现
    :param kf:
    :return:
    """
    assert kf > 0, "K must be greater than 0."
    if kf in [1, 2]:
        return 1

    kf_1 = 1
    kf_2 = 1
    for i in range(3, kf + 1):
        kf_1, kf_2 = kf_1 + kf_2, kf_1

    return kf_1


def fibo_rcs(kr):
    """
    Fibonacci数列的简单递归实现
    :param kr:
    :return:
    """
    # 用于统计函数调用次数
    global times_run, timeX_run
    times_run += 1
    timeX_run[kr] += 1

    assert kr > 0, "K must be greater than 0."
    if kr in [1, 2]:
        return 1
    kr_1, kr_2 = 1, 1
    return fibo_rcs(kr - 1) + fibo_rcs(kr - 2)


@time(8)
def fibo_adv(ka):
    """
    动态规划解决
    在递归中增加了“缓存数组”，节省了大量时间
    :param ka:
    :return:
    """
    # K <= 0抛出异常
    assert ka > 0, "K must be greater than 0."

    if ka in [1, 2]:
        return 1

    # 创建缓存数组，并为其赋初值
    fibo_list = [0 for i in range(ka)]
    fibo_list[0], fibo_list[1] = 1, 1

    def fibo_inner(ki):
        # 用于统计函数调用次数
        global times_run, timeX_run
        times_run += 1
        timeX_run[ka] += 1

        if (x := fibo_list[ki - 1]) != 0:
            return x
        else:
            fibo_list[ki - 1] = (fibo_k := fibo_inner(ki - 1) + fibo_inner(ki - 2))
            return fibo_k

    # print(fibo_inner(ka))
    return fibo_inner(ka)


def upstairs(n):
    """
    爬楼梯问题--动态规划
    假设你现在正在爬楼梯，楼梯有n级，每次你只能爬1级或2级，
    那么你有多少种方法爬到楼梯顶部？
    dp[i] = dp[i - 1] + dp[i - 2]
    n   times
    1   1
    2   2
    :return:
    """
    if n == 1:
        return 1

    stairs = [1 for i in range(n)]
    # stairs[0] = 1
    stairs[1] = 2
    for i in range(2, n):
        stairs[i] = stairs[i - 1] + stairs[i - 2]


def rabbit():
    """
    生兔子问题--递归
    有一对兔子，从出生后第三个月起每月都生一对兔子，小兔子长到第三个月后
    每个月又生一对兔子。假如兔子都不死，计算每月兔子的总数。
    Fibonacci 数列 * 2
    2
    2
    4
    10
    f(n) = f(n - 1) + f(n - 2)
    :return:
    """
    pass


if __name__ == "__main__":
    # time_costs(fibo_for, 100, times=1000)
    # time_costs(fibo_adv, 100, times=1000)
    # print(times_run, timeX_run)
    # time_costs(fibo_test, 6)
    print(fibo_adv(7))
