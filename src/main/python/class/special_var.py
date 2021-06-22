#!/usr/bin/env python
# encoding : utf-8
#
# special_var.py - show specifications of some special variables
# Created by Yuan Chen <cschenyuan@gmail.com> on 20/08/16
#

class ClassA:
    pass

class ClassB(ClassA):

    def func(self):
        pass

c = ClassA()
print ClassB.__bases__
print c.__class__


