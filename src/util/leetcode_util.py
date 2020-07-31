# -*- coding: utf-8 -*-

import os
import re

NUMBER_BET = {
    "0": "zero",
    "1": "one",
    "2": "two",
    "3": "three",
    "4": "four",
    "5": "five",
    "6": "six",
    "7": "seven",
    "8": "eight",
    "9": "nine",
}


def create(test = False):
    os.chdir("./problemset")
    path = os.getcwd()
    no = ""
    problem = ""
    url = ""

    while True:
        no = input("Input NO. of problem: ")
        if 0 < len(no) < 3:
            no = "{:0>3s}".format(no)
            break
        elif len(no) in [3, 4]:
            break
        else:
            print("You may input wrong number.")

    while True:
        url = input("Problem URL: ")
        reobj = re.search(r'http(.+?)leetcode(.+?)problems(.+)\/', url)
        if reobj is None:
            print("You may have entered a malformed url.")
            continue
        elif reobj.group() == url:
            problem = url.split('/')[4]
            break
        else:
            print("You may have entered a malformed url.")

    dir_name = no + "-" + problem
    for k, v in NUMBER_BET.items():
        problem = problem.replace(k, v)

    while True:
        file = input("""Create Java(default, 0) or Python(1) file?""")
        if file == "" or file == "0":
            # file_name = ""
            # for s in problem.split('-'):
            #     file_name += s.capitalize()
            file_name = "Solution.java"
            break
        elif file == "1":
            # file_name = problem.replace('-', '_') + ".py"
            file_name = "Solution.py"
            break
        print("You may made a bad choice.")

    if not os.path.exists(dir_name):
        if test:
            print(dir_name)
        else:
            os.mkdir(dir_name)
    
    if not os.path.exists(dir_name + "\\" + file_name):
        if test:
            print(file_name)
        else:
            with open(dir_name + "\\" + file_name, 'w') as f:
                pass

if __name__ == "__main__":
    create(test=False)
