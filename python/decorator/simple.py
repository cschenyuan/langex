#!/usr/bin/env python
# encoding : UTF-8
#
# simple.py - simple case of python decorator
# Created by Yuan Chen <cschenyuan@gmail.com> on 03/06/16
#

from functools import wraps

# real decorator
def a_new_decorator_without_args(func):
    @wraps(func)
    def wrap():
        print "Do Plan A"
        func()
        print "Do Plan B"
    return wrap

def a_new_decorator_with_args(arg):
    print arg

    # real decorator
    def decorator(a_func):
        @wraps(a_func)
        def wrap_func():
            print "The front of decorated func"
            a_func()
            print "The behind of decorated func"
        return wrap_func

    #return decorator
    # or
    return a_new_decorator_without_args

# @a_new_decorator is a just sort way for saying:
#     func = a_new_decorator(func)
@a_new_decorator_with_args("func")
#@a_new_decorator_without_args
def func():
    print "I'm a func requiring decoration"

#func = a_new_decorator_with_args('wrapping func')(func)
func()

print "###"
print 'Wrapped func name: ' + func.__name__
print "###"
