/* T convert a infix exp to postfix expression 
Input:
a+b*c
Ouput:
abc*+

Input:
a+b*(c^d-e)^(f+g*h)-i
Output:
abcd^e-fgh*+^*+i-      */


#include<stdio.h>
#include <stdlib.h>
#include <limits.h>

char stack[30];
int top=-1;

void push(char c){
    stack[++top] = c;
}

char pop(){
    if(top == -1){
        return -1;
    }
    return stack[top--];
}

int priority(char ch)
{
    switch (ch)
    {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
    }
    return -1;
}

int main(){
    char a[1001],ch;
    int i,j,length;
    scanf("%s%n",a,&length);
    for(i=0;i<length;i++){
        if(isalnum(a[i])){
            printf("%c",a[i]);
        }
        else if(a[i] == '('){
            push(a[i]);
        }
        else if(a[i] == ')'){
            while((ch = pop()) != '('){
                printf("%c",ch);
            }
        }
        else{
            while(priority(a[i]) <= priority(stack[top])){
                printf("%c",pop());
            }
            push(a[i]);
        }
    }
    while(top != -1){
        printf("%c",pop());
    }
}
