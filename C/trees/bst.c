#include<stdlib.h>
#include<stdio.h>

typedef struct Tnode{

struct Tnode *left;
struct Tnode *right;
int value;
}Tnode;


void insertBSTnode(Tnode *root, int val);
int findBSTnode(Tnode *root,int val);
void removeBSTnode(Tnode *root, int val);
void printPREORDER(Tnode *root);


void insertBSTnode(Tnode *root, int val)
{
Tnode *newnode = (Tnode*)malloc(sizeof(Tnode)*1);
newnode->value=val;

Tnode *curnode=root;
Tnode *insnode=curnode;
int flag=0;

      if(newnode!=NULL)
       {
               
       while(curnode)
          {
            if(val<=curnode->value)
		{
                	insnode=curnode; curnode=curnode->left;
                        flag=0; 
                } 
            else if(val>=curnode->value)
                {
                       insnode=curnode; curnode=curnode->right; 
               	       flag=1;  
                }
          }
           
            if(flag==0) 
            {
             printf("adding at left"); insnode->left=newnode;
            } 
            else insnode->right=newnode; 
       }
	else 
	{
	printf("Insuff MEMORY");
	return;
	}
}


void printPREORDER(Tnode *root)
{
 if(root!=NULL)
   {
    printf("%d ",root->value);
   }
 else return;

printPREORDER(root->left);
printPREORDER(root->right);

}

int findBSTnode(Tnode *root, int val)
{

if(root==NULL) return 0;

else
{
Tnode *curnode=root;

while(curnode)
{
if(curnode->value>val) curnode=curnode->left;
else if(curnode->value<val) curnode=curnode->right;
else if(curnode->value==val) 
  {
  printf("got it");  return 1;
  }
}
return 0;
}

}
int main()
{
int ch; 
int val;

Tnode *root;
root=NULL;

printf("\n-----------MENU----------");
printf("\n1. Insert Node");
printf("\n2. Print Preorder");
printf("\n3. Find Node");
printf("\n-------------------------\n"); 
while(1)
{
 printf("\nEnter your Choice: ");

 scanf("%d",&ch);


 switch(ch)
 {

 case 1:
 	printf("\nEnter node value: "); 
        scanf("%d",&val);
        if(root==NULL) 

         {
            root=(Tnode*)malloc(sizeof(Tnode)*1);
            root->value=val;
         }
         else
         {
          printf("ROOT NODE: %d\n",root->value);
          insertBSTnode(root, val);
        } 
        break;
 case 2: printPREORDER(root);
         break;

 case 3:printf("\nEnter node value: "); 
        scanf("%d",&val);
	 if(findBSTnode(root, val)==1)
         printf("\nElement found!!");
         else printf("\n Element does not exist");
        break;

 case 4: exit(0);


 }
 
} 

return 0;

}
