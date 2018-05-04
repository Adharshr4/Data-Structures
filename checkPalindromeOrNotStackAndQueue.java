/* To check a number is palindrome or not by using stack and queue
Input:
121
Output:
Palindrome  */

import java.util.*;
public class Hello {
    
    private LinkedList stack;
    private LinkedList queue;
    
    public Hello(){
        this.stack = new LinkedList();
        this.queue = new LinkedList();
    }
    private void pushNum(int a){
        this.stack.push(a);
    }
    private int popNum(){
        return (int) this.stack.pop();
    }
    private void enqueueNum(int a){
        this.queue.add(a);
    }
    private int dequeueNum(){
        return (int) this.queue.remove();
    }

    public static void main(String[] args) {
		//Your Code Here
		Scanner s=new Scanner(System.in);
		int n=s.nextInt(),k=0;
		boolean isPalindrome=true;
		Hello h=new Hello();
		
		while(n>0){
		    h.pushNum(n%10);
		    h.enqueueNum(n%10);
		    n=n/10;
		    k++;
		}
        for(int i=0;i<k/2;i++){
            if(h.popNum() != h.dequeueNum()){
                isPalindrome=false;
            }
        }
        if(isPalindrome){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not palindrome");
        }
	}
}
