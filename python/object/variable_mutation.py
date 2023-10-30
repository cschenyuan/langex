#!/usr/bin/env python
# encoding : UTF-8
#
# variable_mutation.py -
# Created by Yuan Chen <cschenyuan@gmail.com> on 03/06/16

list1 = ['a']
list2 = list1

list2.append('b')
list1.append('c')

print list1
print list2
