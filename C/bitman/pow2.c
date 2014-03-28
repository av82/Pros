#include<stdio.h>

int pow2(int a)
{
if (a && !(a&(a-1))==1)
return 1;
else return 0;
}

int main(int argc,char **argv)
{

if(pow2(atoi(argv[1]))==1)
printf("yes power of 2");
else printf("Not a power of 2");

}


