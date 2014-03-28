#!/usr/bin/python -tt

import sys

def Hello(name):
  if name=='Alice':
    print 'Alice'+ '??'
  else:
    print 'Arun' + 'Yeah!'
  print 'Hello', name

def main():
 print "Hello"+sys.argv[2]
 print sys.argv[1] 
 Hello(sys.argv[1])
 
#This is standard boilerplate that calls the main function

if __name__ == '__main__':
  main()
 	
