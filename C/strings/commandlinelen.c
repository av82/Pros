#include<stdio.h>

void commandlinelen(char *inpArg);

void commandlinelen(char *inArg)
{
int c=0;

while(*(inArg+c)!='\0')
{
c++;
}
printf("length :%d",c);
}

int main(int argc, char *argv[])
{
int args;

if(argc<2)
{
printf("no input string");
}
else
{
commandlinelen(argv[1]);
}
}
