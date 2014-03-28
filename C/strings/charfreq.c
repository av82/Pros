#include<stdio.h>

void charfr(char *inString);

void charfr(char *inString)
{
int ch[26]={0},ind=0;

while(*(inString+ind)!='\0')
{

if(inString[ind]>='a' && inString[ind]<='z')
{
ch[inString[ind]-'a']++;
}

ind++;
}


for(ind=0;ind<26;ind++)
{
printf("\n%c  %d occurs %d times ",ind+'a',ind+'a',ch[ind]);
}

}

int main()
{
char s[100]; 
printf("Ascii val of A is %d",'A');
printf("Enter the String to find frequency\n");
gets(s);

charfr(s);
}
