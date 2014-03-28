#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int length(char *src)
{
int i=0;
while(*src!='\0')
       {
	src++;i++;
       }

return i;
}

void revSentence(char *src)
{
int len=length(src);

int tokenReadPos=0, wordReadPos=0, wordEnd=0, writePos=0;

char *buf;
buf=(char*) malloc(len+1);

tokenReadPos=len-1;

while(tokenReadPos>=0)
{
   if(src[tokenReadPos]==' ')
     {
       buf[writePos++]=src[tokenReadPos--];  
    
     }
    
   else
    {
     wordEnd=tokenReadPos;
     
     while(tokenReadPos>=0 && src[tokenReadPos]!=' ')
       tokenReadPos--;
  
     wordReadPos= tokenReadPos+1;

     while(wordReadPos<=wordEnd)
      {
       buf[writePos++]=src[wordReadPos++]; 

      }  

    }
}


buf[writePos]='\0';
strncpy(src,buf,len+1);
free(buf);

}

int main()
{
char s[100];

printf("\n Enter String to reverse");
gets(s);
revSentence(s);
printf("reverse string: %s",s);
return 0;

}
