#include<stdio.h>

int absl(int a)
{
int const mask = a>>sizeof(int)*8-1;

a=(a+mask)^mask;

return a;

}

int main(int argc, char **argv)

{
printf("The abs value of %d is %d", atoi(argv[1]),absl(atoi(argv[1])));
return 0 ;

}
