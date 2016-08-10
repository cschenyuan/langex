#!/usr/bin/env python
# encoding : UTF-8
#
# simple.py -
# Created by Yuan Chen <cschenyuan@gmail.com> on 14/06/16

def fib(n):
    a,b = 0,1
    while n > 0:
        yield a
        a,b = b,a + b
        n -= 1

# 运行时逐个生成
for i in fib(10): print i

