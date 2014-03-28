#include<stdio.h>
#include<stdlib.h>


int length(char *inpString)
{
int len=0;
while(*inpString!='\0')
     {
	len++;
        }
return len;
}

void permute(char *inpString, int len)
{




}

int main(int argc, char**argv)
{
char inString[100];
int len=0;

printf("Enter the String: ");
gets(inString);

len=length(inString);
permute(inString,len);
return 0;

}
