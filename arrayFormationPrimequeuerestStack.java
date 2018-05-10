/*Let the array A contains 5 integers : 7 , 21 , 18 , 3 , 12 then the content of queue and stack will be :
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
12 18 21        */


import java.util.*;
public class Hello {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         int n = Integer.parseInt(sc.nextLine().trim());
         String[] arr = sc.nextLine().split(" ");
         int[] a = new int[1000];
         int count=0,i,j;
         for(i=0; i<arr.length; i++){
         	a[i] = Integer.parseInt(arr[i]);
         }
         Stack<Integer> stack = new Stack<Integer>();
         Queue<Integer> queue = new LinkedList<Integer>();
         for(i=0; i<arr.length;i++){
             for(j=1;j<=a[i];j++){
                 if(a[i]%j == 0){
                     count++;
                 }
             }
             if(count==2){
                 queue.add(a[i]);
             }
             else{
                 stack.push(a[i]);
             }
             count=0;
         }
         for(Integer ii:queue){
             System.out.print(ii+" ");
         }
         System.out.println();
         while(stack.isEmpty()==false){
             System.out.print(stack.pop()+" ");
         }
    }
}
