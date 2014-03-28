#include<stdio.h>
// source should have enough memory allocated
// check for while loop semicolon as the null statement 

char* stcat(char *dst, char *src)
{
char *rdst=dst;
while(*dst!='\0')
{
dst++;
}
while(*dst++=*src++);
return(rdst);
}

int main()
{
char dst[100]="arun", *src="velagapalli"; 

char *ret= stcat(dst,src);

printf("%s\n",ret);

}

