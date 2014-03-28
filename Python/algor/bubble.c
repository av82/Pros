#include<stdio.h>

void bubble(int *a, int n)
{
int temp=0,i=0,j=0;
int swaps=0; 

for(i=0;i<n-2;i++)
{
 for(j=0;j<n-i-1;j++)
   {
    if(a[j]>a[j+1])
       { 
         temp=a[j]; 
         a[j]=a[j+1]; 
         a[j+1]=temp; 
        swaps++; 
        } 
   }
  if(swaps==0)
    break;
for(temp=0; temp<n;temp++)
printf("%d ",a[temp]);


printf("\n");
}
for(temp=0; temp<n;temp++)
printf("%d",a[temp]);

}



int main()
{
int a[8]={10,4,1,2,6,9,8,7}, n=8;

bubble(a,n);

return 0;
}
