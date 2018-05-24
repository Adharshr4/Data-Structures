/* To perform some linked list operations in c like insert , delete , append, insert after,delete node,union,intersection,
find n th node from last,detect loop 
output after perfroming all operations will be like

Input:
5 6
12 23 34 76 4
66 23 34 99 210 334

Output:

After Inserting values:  4 76 34 23 12 
After Appending values:  4 76 34 23 12 90 55 
After Deleting a node:  4 76 34 12 90 55 
After deleting a node with a particular value:  4 34 12 90 55 
After Inserting  a node:  4 34 12 100 90 55 
The middle element is:   100
There is no loop
The 4th element from the last is :   12
After revesring the linked list:   55 90 100 12 34 4 
After reversing in chunks of size:   90 55 12 100 4 34 
After performing union of 2 lists:   66 23 99 210 334 34 4 100 12 55 90 
After performing intersection opertion:   34        */


#include<stdio.h>
#include <stdlib.h>

struct Node{
    int data;
    struct Node *next;
};

void push(struct Node **head_ref , int data){
    struct Node *new_node = (struct Node*)malloc(sizeof(struct Node));
    new_node->data = data;
    new_node->next = *head_ref;
    *head_ref = new_node;
}

void printList(struct Node *temp){
    while(temp != NULL){
        printf("%d ",temp->data);
        temp = temp->next;
    }
}

void append(struct Node **head_ref , int data){
    struct Node *temp = *head_ref;
    struct Node *new_node = (struct Node *)malloc(sizeof(struct Node));
    new_node->data = data;
    new_node->next = NULL;
    if(*head_ref == NULL){
        printf("The list is empty");
        return;
    }
    while(temp->next != NULL){
        temp = temp->next;
    }
    temp->next = new_node;
}

void deleteNode(struct Node **head_ref , int num){
    int count=1;
    struct Node *temp = *head_ref;
    struct Node *prev;
    if(num == 1){
        *head_ref = temp->next;
        free(temp);
        return;
    }
    while(count != num){
        prev=temp;
        temp = temp->next;
        count++;
    }
    prev->next = temp->next;
    free(temp);
}

void deleteNodeValue(struct Node **head_ref , int val){
    struct Node *temp = *head_ref;
    struct Node *prev;
    if(temp->data == val){
        *head_ref = temp->next;
        free(temp);
        return;
    }
    while(temp->data != val){
        prev=temp;
        temp = temp->next;
    }
    prev->next = temp->next;
    free(temp);
}

void insertAfter(struct Node **head_ref,int num,int data){
    int count=0;
    struct Node *new_node = (struct Node *)malloc(sizeof(struct Node));
    struct Node*temp = *head_ref;
    struct Node *prev;
    new_node->data =data;
    while(count != num){
        prev=temp;
        temp = temp->next;
        count++;
    }
    prev->next = new_node;
    new_node->next=temp;
    
}

void findMiddle(struct Node *temp){
    struct Node *fast_ptr = temp;
    struct Node *slow_ptr = temp;
    if(temp != NULL)
    {
        while(fast_ptr != NULL && fast_ptr->next != NULL){
            fast_ptr = fast_ptr->next->next;
            slow_ptr = slow_ptr->next;
        }
        printf("\nThe middle element is:   %d",slow_ptr->data);
    }
}

int detectLoop(struct Node *temp){
    struct Node* slow_ptr = temp;
    struct Node * fast_ptr = temp;
    while(slow_ptr != NULL && fast_ptr != NULL && fast_ptr->next != NULL){
        slow_ptr = slow_ptr->next;
        fast_ptr = fast_ptr->next->next;
        if(slow_ptr == fast_ptr){
            return 1;
        }
    }
    return 0;
}

void findNthFromLast(struct Node * head , int num){
    struct Node *temp = head;
    int count = 1,traverseCount=0;
    while(temp->next != NULL){
        count++;
        temp=temp->next;
    }
    int eleCount = count-num;
    while(traverseCount != eleCount){
        head=head->next;
        traverseCount++;
    }
    printf("\nThe 4th element from the last is :   %d",head->data);
}

void reverse(struct Node **head_ref){
    struct Node *prev = NULL;
    struct Node *current =*head_ref;
    struct Node *next = NULL;
    while(current != NULL){
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }
    *head_ref = prev;
}

struct Node *reverseInChunks(struct Node *head , int k){
    struct Node *prev = NULL;
    struct Node *current = head;
    struct Node *next = NULL;
    int count=0;
    while(current != NULL && count < k){
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
        count++;
    }
    if(next != NULL){
        head->next = reverseInChunks(next , k);
    }
    return prev;
}

struct Node *getUnion(struct Node *head1 , struct Node *head2){
    struct Node* result = NULL;
    struct Node *temp1 = head1 , *temp2 = head2;
    while(temp1 != NULL){
        push(&result , temp1->data);
        temp1 = temp1->next;
    }
    while(temp2 != NULL){
        if(isPresent(result , temp2->data) == 0){
            push(&result , temp2->data);
        }
        temp2 = temp2->next;
    }
    return result;
}

struct Node *getIntersection(struct Node *head1 , struct Node *head2){
    struct Node *result = NULL;
    struct Node *temp1 = head1, *temp2 = head2;
    while(temp1 != NULL){
        if(isPresent(head2 , temp1->data)){
            push(&result , temp1->data);
        }
        temp1 = temp1->next;
    }
    return result;
}

int isPresent(struct Node *head , int data){
    struct Node *temp = head;
    while(temp != NULL){
        if(data == temp->data){
            return 1;
        }
        temp = temp->next;
    }
    return 0;
}

int main()
{
    int i,n,a,n2;
    struct Node *head = NULL;
    struct Node *head2=NULL;
    struct Node *union_ = NULL;
    struct Node *intersection_ = NULL;
    scanf("%d %d" , &n,&n2);
    for(i=0; i<n; i++){
        scanf("%d" , &a);
        push(&head , a);
    }
    for(i=0;i<n2;i++){
        scanf("%d" , &a);
        push(&head2 , a);
    }
    printf("After Inserting values:  ");
    printList(head);
    append(&head , 90);
    append(&head , 55);
    printf("\nAfter Appending values:  ");
    printList(head);
    deleteNode(&head , 4); //deleting n'th node
    printf("\nAfter Deleting a node:  ");
    printList(head);
    deleteNodeValue(&head , 76);  //deleting the node with that value
    printf("\nAfter deleting a node with a particular value:  ");
    printList(head);
    insertAfter(&head , 3 , 100);//Inserting after 3rd node
    printf("\nAfter Inserting  a node:  ");
    printList(head);
    findMiddle(head);
    int isLopp = detectLoop(head);
    if(isLopp){
        printf("\nThere is a loop");
    }
    else{
        printf("\nThere is no loop");
    }
    findNthFromLast(head , 4);
    reverse(&head);
    printf("\nAfter revesring the linked list:   ");
    printList(head);
    head=reverseInChunks(head , 2);
    printf("\nAfter reversing in chunks of size:   ");
    printList(head);
    union_ = getUnion(head , head2); 
    printf("\nAfter performing union of 2 lists:   ");
    printList(union_);
    intersection_ = getIntersection(head , head2);
    printf("\nAfter performing intersection opertion:   ");
    printList(intersection_);
}
