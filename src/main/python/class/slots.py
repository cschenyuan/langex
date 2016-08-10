#!/usr/bin/env python
# encoding : UTF-8
#
# slots.py - perform the __slot__ magic
# Created by Yuan Chen <cschenyuan@gmail.com>
#

class MagicClass:
    __slots__ = ['name','age']

    def __init__(self):
        self.name = "pythoner"
        self.age = "2"

num = 1024 * 256
y = [MagicClass() for i in range(num)]
