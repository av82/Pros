#include<stdio.h>
void caseconv(char *inString);


void caseconv(char *inString)
{

while(*inString)
{
if(*inString!=' ')
{
if(*inString>='a' && *inString<='z')
{
*inString=*inString-32;

}
else
{
*inString=*inString+32;
}
}
inString++;
}


}

int main()
{
char inString[100]; 
printf("Enter the String to convert\n"); 
gets(inString);
caseconv(inString);
printf("Converted String is\n%s",inString);



}
