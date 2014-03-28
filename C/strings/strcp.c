#include<stdio.h>
#include<string.h>
//check for overlapping memory source, destination 
// size of destination should be atleast as source.

void strcp(const char *src, char *dst,int n)
{
if(n>=strlen(src))
while(*dst++=*src++);
}




int main()

{
char dst[100], *src="TESTING THE STRING COPY";
printf("sizeof(dst): %d", sizeof(dst));
strcp(src,dst,sizeof(dst));
printf("%s", dst);


}



