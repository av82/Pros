#include<stdio.h>

int result=0;

void printbin(int num)
{
unsigned int sz=1<<(sizeof(int)*8-1);
while(sz>0)
{
printf("%d ",(num&sz)?1:0);
sz>>=1;
}
printf("\n");
}

void bitset(int num, int pos)
{
result = num | (1<<(pos-1));
}

void bitclear(int num, int pos)
{
result = num & ~(1<<(pos-1));
}


void bitfind(int num, int pos)
{
result=num & (1<<(pos-1));
}

void bitflip(int num, int pos)
{
result=num^(1<<(pos-1));
}

void msbpos(int num)
{
result=0;
while(num!=0)
{
num>>=1;
result++;
}
}
int main(int argc, char **argv)
{
printf("Binary format of given number\n");
printbin(atoi(argv[1]));

printf("Setting bit position at :%d\n", atoi(argv[2]));
bitset(atoi(argv[1]),atoi(argv[2]));
printbin(result);

printf("Clearing bit position at : %d\n",atoi(argv[2]));
bitclear(atoi(argv[1]),atoi(argv[2]));
printbin(result);

bitfind(atoi(argv[1]),atoi(argv[2]));
printf("finding the value of bit at position :%d is %d\n", atoi(argv[2]),result);

printf("Flipping the value of bit at position:%d\n", atoi(argv[2]));
bitflip(atoi(argv[1]),atoi(argv[2]));
printbin(result);

msbpos(atoi(argv[1]));
printf("The msb position of %d is %d\n",atoi(argv[2]),result);
}
