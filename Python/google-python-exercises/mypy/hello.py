#!/usr/bin/python -tt

import sys

def Hello(s):
  if s=='Arun' or s=='Ramms':
    s=s+s
  else:
    s='Hello'+s
  print s,'testing'

def main():
  Hello(sys.argv[1])
  print sys.argv[1][1:4]
if __name__=='__main__':
  main()
