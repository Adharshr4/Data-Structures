'''Let the array A contains 5 integers : 7 , 21 , 18 , 3 , 12 then the content of queue and stack will be :
Queue : 7 , 3
Stack : 12 , 18 , 21
Now if you follow the rules of stack and queue then you see that you can generate the array using the pop operations of stack and dequeue operation of queue as follows : 

dequeue from queue : 7
pop from stack : 7 , 21
pop from stack : 7 , 21 , 18
dequeue from queue : 7 , 21 , 18 , 3
pop from stack : 7 , 21 , 18 , 3 , 12

Thus for every array A you have to print the contents of queue in the first line and contents of stack in the second line.

Input Format
First line contains an integer n as input denoting total numbers of integers in the array.
Next line contains n space separated integers denoting the elements of array A.
Your output should print two arrays , one in each line. First line should be the contents of queue and second line should be the contents of stack.

Output Format
In the first line print the contents of queue and in second line print the contents of the stack.

Sample input:
5
7 21 18 3 12
Output:
7 3
12 18 21      '''


from collections import deque
n,l,c,stack,queue=int(input().strip()),list(map(int,input().strip().split())),0,[],deque([])
for i in l:
    for j in range(1,i+1):
        if i%j == 0:
            c+=1
    if c==2:
        queue.append(i)
    else:
        stack.append(i)
    c=0    
for i in queue:
    print(i,end=" ")
print()
for i in range(len(stack)):
    print(stack.pop(),end=" ")
