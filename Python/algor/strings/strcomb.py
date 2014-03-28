#!/usr/bin/python -tt
# Copyright 2010 Google Inc.
# Licensed under the Apache License, Version 2.0
# http://www.apache.org/licenses/LICENSE-2.0
import sys
import math
inpstring=""

def printComb(bitmap,k,n):
  if(k==n):
     bitmap[k]=0
     printstring(bitmap,n)
     bitmap[k]=1
     printstring(bitmap,n)
  bitmap[k]=0
  printComb(bitmap,k+1,n)
  bitmap[k]=1
  printComb(bitmap,k+1,n)


def printstring(bitmap,k,n):
  sum=0
  for i in range(1,n): 
	  if bitmap[k]==1:
	      print(inpstring[k])
	      sum+=1

def main():
   inpstring=sys.argv[1]
   bitmap=[]
   for m in range(0,len(inpstring)):
	bitmap.extend([0])
   print(bitmap)
   printComb(bitmap,0,len(inpstring))

if __name__ == '__main__':
  main()
