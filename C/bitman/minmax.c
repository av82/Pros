#include<stdio.h>
#include<stdlib.h>

void minmax(int x, int y, int *res)
{

res[0] = y^((x^y)&-(x<y));
res[1] = x^((x^y)&-(x<y));


}

int main (int argc, char **argv)
{
int *p=malloc(2*sizeof(int));
minmax(atoi(argv[1]),atoi(argv[2]),p);

printf("min :%d, max: %d\n",p[0],p[1]);


}


