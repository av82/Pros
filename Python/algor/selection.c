#include<stdio.h>

void selection(int *a, int n)
{
int temp=0,i=0,j=0,min=0; 
 printf("given: ");  
 for(temp=0; temp<n;temp++)
 printf("%d ",a[temp]);
 printf("\n");


for(i=0;i<n-1;i++)
 { 
     min=i;
    for(j=min+1;j<n;j++)
       {
        if(a[j]<a[min]) //so far minimum a[min] , min~~ min
          min=j;
        }
     if(min!=i) //swap elements at  min-- the index of minimum element  and element at current position --i
          {
            temp=a[i];
            a[i]=a[min];
            a[min]=temp;
           }
 
 printf("m idx:%d ",min);  
 for(temp=0; temp<n;temp++)
 printf("%d ",a[temp]);
 printf("\n");

 }

}



int main()
{
int a[8]={10,4,1,2,6,9,8,7}, n=8;

selection(a,n);

return 0;
}
