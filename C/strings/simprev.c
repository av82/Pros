#include<stdio.h>

int main(int argc, char **argv)
{
int i=0; 
while(*(argv[1]+i))
{
i++; 
}
printf("%d",i);

}
