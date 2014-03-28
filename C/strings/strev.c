#include<stdio.h>
void reverse(char* inString,int len);
int stlen(char* inString);
int stlen(char* inString)
{
int len=0; 
while(*(inString+len)!='\0')
{
len++;
}
printf("\nlength:%d",len);
return len;

}

void reverse(char* inString,int len)
{
int cur=0;char temp;
while(cur<len/2)
{
temp=inString[cur];
printf("\n%c %c %c",temp,inString[cur],inString[(len-1)-cur]);

inString[cur]=inString[(len-1)-cur];
inString[(len-1)-cur]=temp;
cur++;
}
}
int main(int argc, char *argv[])
{
printf("Please enter a string"); 
char str[100];
gets(str);
int len=0;
len=stlen(str);
reverse(str,len);
printf("\n%s",str);
}
