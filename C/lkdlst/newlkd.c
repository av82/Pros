#include<stdio.h>
#include<stdlib.h>

typedef struct
{
int data;
struct node *next;
}node; 

int len; 

void insert(node **head, int value);
void delete(node **head, int value); 
int  length(node **head);
void printlist(node **head);
void reverse(node **head);
void RemoveSortedDup(node **head); 

void RemoveSortedDup(node **head)
{
node *current;
    current=(*head)->next; 
if(current==NULL) return;

while((*head)-> next!=NULL)
{
     if((*head)->data==current->data)
 	{
	    printf("\ndeleting %d",current->data); 
	    current=current->next; 
	    free((*head)->next);
	    (*head)->next=current;   
	 }  

     else 
	{
	head=&(*head)->next;
        current=(*head)->next;  
   	    printf("\nrunning next element %d",(*head)->data); 
	}	
}
}
void reverse(node **head)
{
node *previous=NULL;
node *post=NULL;
int count=0;
previous=*head;
post=(*head)->next;
previous->next=NULL;

while(post!=NULL)
{
*head=post;
post=post->next;
(*head)->next=previous;
previous=*head;
}

}

void insert(node **head, int value)
{
node *newnode = (node*) malloc(sizeof(node)*1);
newnode->data= value;

do
{

if(newnode->data < (*head)->data )
{
newnode->next =*head; 
*head = newnode;
break;
}

else if( (*head)->next==NULL )
{
newnode->next= NULL;
(*head)->next=newnode;
break;
}

head=&(*head)->next;
}
while(*head!=NULL);

}


void delete(node **head, int value)
{
do
{
if((*head)->data==value)
{
*head=(*head)->next;
}
head =&(*head)->next;
}while(*head!=NULL);

}

int  length(node **head)
{
len=0; 
while(*head!=NULL)
{
len=len++;
head=&(*head)->next;
}
return len;
}

void printlist(node **head)
{
while(*head!=NULL)
{
printf(" %d",(*head)->data);
head=&(*head)->next;
}

}


int main()
{
node *root=(node*) malloc(sizeof(node)*1); 
root->data=0;
root->next=NULL;


int newval,ch; 
printf("\nroot: %p, &root: %p", root, &root);
 
while(1)
{
printf("\n********<MENU>***********"); 
printf("\n1. Insert a node"); 
printf("\n2. Delete a node"); 
printf("\n3. Print the current list"); 
printf("\n4. Find Length"); 
printf("\n5. Reverse the list");
printf("\n6. Remove Duplicates from Sorted List"); 
printf("\n7. Exit");
printf("\n\n Enter your choice");
scanf("\n%d",&ch);

switch(ch)
{ 
case 1:
 printf("\n Enter new node"); 
 scanf("\n%d",&newval); 
 insert(&root, newval); 
 break;
  
case 2:
 printf("\n Enter the value to be deleted");
 scanf("\n%d", &newval);
 delete(&root, newval); 
 break; 

case 3:
 printf("\n\n Printing the list....\n"); 
 printlist(&root); 
 break;
case 4:
 printf("\n current length of list is: %d", length(&root));
 break;

case 5:
 printf("\n Reversing the linked list");
 reverse(&root);   
 break;

case 6:
 printf("\n Removing duplicates in sorted list");
 RemoveSortedDup(&root);   
 break;


case 7:
 return; 
}
}

return 0;
}

