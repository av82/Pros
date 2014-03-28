#include<stdio.h>
#include<math.h>

int change(int *x)
{
*x=21;
return 1;
}

int* larger(int *a, int *b)
{
if(*a>*b)
return a; 
else return b;

}


int main()
{
int a=500,z=200,*pi;
pi=larger(&a,&z);
printf(" %d is larger",*pi);
change(&a);
printf("%d",a);





}
