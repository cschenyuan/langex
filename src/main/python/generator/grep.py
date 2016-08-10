#!/usr/bin/env python
# encoding : UTF-8
#
# grep.py - coroutine example
# Created by Yuan Chen <cschenyuan@gmail.com> on 14/06/16

def grep(pattern):
    print "Looking for %s" % pattern
    while True:
        line = (yield)
        if pattern in line:
            print line

if __name__ == '__main__':
    g = grep('python')
    g.next()
    g.send('no pythog')
    g.send('Yeah, I am')
    g.send('Not includes python...')

