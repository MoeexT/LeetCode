# -*- coding: utf-8 -*-
'''
意在测试某函数的性能写的函数或装饰器
'''

from datetime import datetime


def time(times=1):
    def decorator(f):
        def wrapper(*args, **kwargs):
            start = datetime.now()
            for i in range(times):
                res = f(*args, **kwargs)
            print(f.__name__)
            print("It took ", (datetime.now()-start).total_seconds(), "second(s).")
            return res
        return wrapper
    return decorator


def time_costs(func, *args, times=1):
    start = datetime.now()
    for i in range(times):
        func(*args)
    print("It took ", (datetime.now()-start).total_seconds(), "second(s).")
