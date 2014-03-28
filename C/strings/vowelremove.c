#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char* removevowel(char *inString);
int chkvow(char c);

int chkvow(char c)
{
int flag;char tmp;
if(c>='A' && c<='Z')
{
c=c+'a'-'A';
}

if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
{
flag=1;
}
else
{

flag=0;
}

return flag;
}
char* removevowel(char *inString)
{
int c=0,flag,p=0;
char *new =malloc(strlen(inString)*sizeof(char));

while(*(inString+c)!='\0')

{
if(chkvow(*(inString+c))==0)
{
*(new+p)=*(inString+c);
p++;
}
c++;

}
*(new+p)='\0';
return new;
}




int main()
{
char s[100],*nu;
printf("Enter the String to remove vowels\n");
gets(s);
nu=removevowel(s);
printf("vowels removed\n%s\n",nu);
}
