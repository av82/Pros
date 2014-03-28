#include<stdlib.h>
#include<stdio.h>
 
typedef struct node
{
int data; 
struct node *next;
}node; 


node *createlist(node **head)
{
node *current = (node*)malloc(sizeof(node)*1); 

current->data=100;
current->next=NULL; 
*head=current;
printf("\n In creation \n current: %p, head %p, *head %p, *head->data %d", current, head, *head,(*head)->data); 
}

void insert(node **head,int value)
{
node *newnode = (node*) malloc(sizeof(node)*1);

printf("\nb4,fun: head %p, *head  %p, newnode %p", head,*head,newnode);
newnode->data=value;
do
{
if(newnode->data < (*head)->data)
{
newnode->next =*head;
*head=newnode;
break;
}
else if ((*head)->next==NULL)
{
newnode->next=NULL;
(*head)->next=newnode;
break;
}
head=&(*head)->next;
}
while(*head!=NULL) ;
printf("\nafter,fun: head %p, *head  %p, newnode %p", head,*head,newnode);
}


void printlist(node **head)
{
while(*head!=NULL)
{
printf(" %d",(*head)->data);
head=&(*head)->next;
}

}
int main(int argc, char **argv)
{
node *root=NULL; 
int newval;
printf("\nbefore creation/initialization %p, &root %p", root,&root);
createlist(&root);
printf("\nroot %p, &root %p", root,&root);

printf("%d",root->data);
while(1)
{
printf("\nEnter new node"); 
scanf("%d",&newval);
insert(&root,newval);
printf("\nroot %p, &root %p", root,&root);
printlist(&root);
}
} 
