# -*- coding: utf-8 -*-

import os


DIR = r"problemset"


def rename():
    for file in os.listdir(DIR):
        cdir = DIR + "\\" + file
        if os.path.isdir(cdir):
            os.rename(cdir, cdir.replace('-','_'))


if __name__ == "__main__":
    rename()
