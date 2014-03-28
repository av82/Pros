#include<stdio.h>

void main()
{
int a[3][4]={{1,2,3,4},{24,34,53,23},{11,23,42,12}};
int b[3]={1,2,3};
int i,j;

printf("%d %p %p %d",**a, (*a),a[0],*(*(a+1)));
printf("\n %d %d %p",*b,*(b+1),&b);

for(i=0;i<3;i++)
for(j=0;j<4;j++)
printf("\nThe address of a[%d][%d] is %p", i,j,&a[i][j]);
}
