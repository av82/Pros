#include<stdlib.h>
#include<stdio.h>


char* removeChars(char* inString, char* remove)
{
int i=0,dst=0;
int flags[128]={0};


while(remove[i]!='\0')
{
flags[remove[i]]=1;
i++;
}
i=0;

while(inString[i]!='\0')
{
if(flags[inString[i]]==0)
   inString[dst++]=inString[i];
i++;
}
inString[dst++]='\0';
return inString;
}

int main(int argc, char **argv)
{
int count=0; 

char *out = removeChars(argv[1],argv[2]);

printf("The output string is %s \n", out);
return 0;
}

