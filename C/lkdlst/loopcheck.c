#include<stdio.h>

typedef struct 
{
int data;
struct node *next;
}node;

int IsLoop(node **head);

int IsLoop(node **head)
{
node *fast=*head;
int k;

while(1)
{
  k=fast->data;  
  if(!(fast=fast->next)) return 0;
  if(fast==*head) 
  { 
   printf("\nloop between %d, %d", (*head)->data,k);
   return 1;
  } 
  k=fast->data;  
  if(!(fast=fast->next)) return 0;
  if(fast==*head)
  { 
   printf("\nloop between %d, %d", (*head)->data,k);
   return 1;
  }

  head=&(*head)->next; 
}
return 0;
}

int main()
{

node *n1= (node*)malloc(sizeof(node)*1);

node *n2= (node*)malloc(sizeof(node)*1);
node *n3= (node*)malloc(sizeof(node)*1);
node *n4= (node*)malloc(sizeof(node)*1);
node *n5= (node*)malloc(sizeof(node)*1);

n1->data=1;
n2->data=2;
n3->data=3;
n4->data=4;
n5->data=5;

n1->next=n2;
n2->next=n3;
n3->next=n4;
n4->next=n5;
n5->next=n2;

if(IsLoop(&n1))
{
printf("\nThere exists a loop");
}
else printf("\nNo loop");

return 0;

}
