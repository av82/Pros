#include<stdio.h>


int opposite(int a, int b)
{
if((a^b)<0)
return 1;
else return 0;

}

int main(int argc, char *argv[])
{
 if(opposite(atoi(argv[1]),atoi(argv[2]))==1)
   printf("\nopposite sign"); 
 else printf("\nsame sign");

return 0;
}
