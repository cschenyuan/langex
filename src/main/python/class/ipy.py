#!/usr/bin/env ipython
# encoding : utf-8
#
# ipy.py - ipython executable file
# Created by Yuan Chen <cschenyuan@gmail.com> on 03/06/16
#

from slots import *
import ipython_memory_usage.ipython_memory_usage as imu

num = 1024 * 256
print 'number of instances is: ' + str(num)

imu.start_watching_memory()

print "--Regular class"
x = [ RegularClass() for i in range(num) ]

print "--Slots class"
y = [ MagicClass() for i in range(num) ]
