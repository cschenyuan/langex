#!/usr/bin/env python
# encoding : UTF-8
#
# slots.py - perform the __slot__ magic
# Created by Yuan Chen <cschenyuan@gmail.com>
#


class RegularClass:
    def __init__(self):
        self.name = "pythoner"
        self.age = "2"


num = 1024 * 256
x = [RegularClass() for i in range(num)]
