/* To check if a given expression is balanced are not
Input:
[(())]
Output:
BALANCED

Input:
({)
Output:
NOT BALANCED    */


#include<stdio.h>
#include <stdlib.h>
#include <limits.h>

struct Node{
    char data;
    struct Node *next;
};


int check(char c1,char c2){
    if (c1 == '(' && c2 == ')'){
        return 1;
    }
    else if (c1 == '{' && c2 == '}'){
        return 1;
    }
    else if (c1 == '[' && c2 == ']'){
        return 1;
    }
    else{
        return 0;
    }
}


void push(struct Node **root_ref , char c){
    struct Node* new_node = (struct Node *)malloc(sizeof(struct Node));
    new_node->data = c;
    new_node->next = *root_ref;
    *root_ref = new_node;
}

char pop(struct Node **root_ref){
    struct Node *temp = *root_ref;
    char element = temp->data;
    *root_ref = (*root_ref)->next;
    free(temp);
    return element;
}


int isBalance(char str[]){
    int i=0;
    struct Node *result = NULL;
    while(str[i]){
        if(str[i] == '(' || str[i] == '{' || str[i] == '['){
            push(&result , str[i]);
        }
        if(str[i] == ')' || str[i] == '}' || str[i] == ']'){
            if(result == NULL){
                return 0;
            }
            else if(check(pop(&result) , str[i]) == 0){
                return 0;
            }
        }
        i++;
    }
    if(result == NULL){
        return 1;
    }
    else{
        return 0;
    }
}

int main()
{
    char a[1001];
    int i,j;
    scanf("%s",a);
    if(isBalance(a)){
        printf("BALANCED");
    }
    else{
        printf("NOT BALANCED");
    }
}
