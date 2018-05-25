/* To perform basic opertions like push , pop , peek , print 
Input:
5
12 23 34 66 88
Output:
After pushing the values:   88 66 34 23 12 
The popped element is ::  88  
After popping the element:  66 34 23 12 
Peek element is:  66       */


#include<stdio.h>
#include <stdlib.h>
#include <limits.h>

struct Node{
    int data;
    struct Node *next;
};

struct Node *newnode(int data){
    struct Node *new_node = (struct Node *)malloc(sizeof(struct Node));
    new_node->data = data;
    new_node->next = NULL;
    return new_node;
}

void push(struct Node **root_ref , int data){
    struct Node *new_node = newnode(data);
    new_node->next = *root_ref;
    *root_ref = new_node;
}

void printStack(struct Node *temp){
    while(temp != NULL){
        printf("%d ",temp->data);
        temp = temp->next;
    }
}

void pop(struct Node **root){
    if(isEmpty(*root)){
        printf("\nStack Underflow");
        return;
    }
    struct Node *temp = *root;
    int element = temp->data;
    *root = (*root)->next;
    free(temp);
    printf("\nThe popped element is :  %d",element);
}

int peek(struct Node *root){
    if(isEmpty(root)){
        return INT_MIN;
    }
    return root->data;
}

int isEmpty(struct StackNode *root)
{
    return !root;
}

int main()
{
    int n,i,j,a;
    struct Node *root = NULL;
    scanf("%d",&n);
    for(i=0;i<n;i++){
        scanf("%d",&a);
        push(&root , a);
    }
    printf("After pushing the values:   ");
    printStack(root);
    pop(&root);
    printf("\nAfter popping the list is :  ");
    printStack(root);
    printf("\nPeek element is:  %d",peek(root));    
}
