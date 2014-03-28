#include<stdio.h>
#define SIZE 10
#define MAX(a,b) { a>b?a:b }
void maxsub(int inary[],int size,int start, int end , int *maxval);

void maxsub(int inary[],int size, int start, int end,int *maxval)
{
int i=start, maxsofar=0,sofarind=0,sum=inary[start];
start=0, end=size;
maxsofar=sum;
while(i<size)
{
if(sum+inary[i]>inary[i])
{
sum=sum+inary[i];
}
else
{
sum=inary[i];
start=i;
}
if(maxsofar<sum)
{
maxsofar=sum; 
sofarind=i;
}


printf("\ni:%d, maxsofar:%d, sum:%d, start:%d,sofarind:%d",i,maxsofar,sum,start,sofarind);
i++;
}
*maxval=maxsofar;
}
int main()
{
int inary[SIZE]={-2,-3,4,-1,-2,1,5,-3,0,0};
int maxval;
maxsub(inary,SIZE,0,SIZE-1,&maxval);
printf("%d",maxval);
}
