#include<stdio.h>

int main()
{
int *p,*s;
int k=10,m=10;
p=&k;s=&m;
int *q=&k;
int **dp=&p;
int z=*p**s;
if(p==q)
printf("%d %d %d %d",*p,*q,**dp,z);
}
