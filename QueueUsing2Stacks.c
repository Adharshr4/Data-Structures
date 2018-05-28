/*  Implemene queue using 2 stack ...and perform basic operations like enquque and dequeue   

Input:
6
66 23 34 87 90 56

Output:
66
23
34
87
90
56      */

#include<stdio.h>
#include <stdlib.h>

struct Node{
    int data; 
    struct Node *next; 
};

struct queue{
    struct Node *stack1;
    struct Node *stack2;
};

void enqueue(struct queue *q , int data){
    push(&q->stack1 , data);
}

int dequeue(struct queue *q){
    if(q->stack1 == NULL && q->stack2 == NULL){
        printf("Q is empty");
        exit(0);
    }
    int ele;
    if(q->stack2 == NULL){
        while(q->stack1 != NULL){
            ele = pop(&q->stack1);
            push(&q->stack2 , ele);
        }
    }
    int poppedElement = pop(&q->stack2);
    return poppedElement;
}

void push(struct Node **q_ref , int data){
    struct Node * new_node = (struct Node*)malloc(sizeof(struct Node)); 
    new_node->data = data;
    new_node->next = *q_ref;
    *q_ref = new_node;
}

int pop(struct Node **q_ref){
    struct Node *temp;
    temp = *q_ref;
    int element = temp->data;
    *q_ref = temp->next;
    free(temp);
    return element;
}

int main()
{
    int n,i,j,a;
    scanf("%d",&n);
    struct queue *q = (struct Node*)malloc(sizeof(struct Node));
    q->stack1 = NULL; 
    q->stack2 = NULL;
    for(i=0;i<n;i++){
        scanf("%d",&a); 
        enqueue(q , a); 
    } 
    for(i=0;i<n;i++){
        printf("%d\n",dequeue(q));
    }
}
