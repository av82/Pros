#include<stdio.h>

void insertion(int *a, int n)
{
int temp=0,i=0,j=0,key=0; 
 printf("given: ");  
 for(temp=0; temp<n;temp++)
 printf("%d ",a[temp]);
 printf("\n");


for(i=1;i<n;i++)
 { 
    key=a[i];
   for(j=i-1; j>=0&&a[j]>key;j--)
    {
         a[j+1]=a[j];
    }
    
    a[j+1]=key;
 
 printf("key:%d ",key);  
 for(temp=0; temp<n;temp++)
 printf("%d ",a[temp]);
 printf("\n");

 }

}



int main()
{
int a[8]={10,4,1,2,6,9,8,7}, n=8;

insertion(a,n);

return 0;
}
