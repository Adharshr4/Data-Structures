/*Dumbledore gave Harrry a set of instructions which contains two types of strings: 
1) "Harry" (without quotes): It means Harry will remove ith coin from his bag and throw it towards Monk and Monk will add it in his bag, where i will start from 1 and go up to N. 
2) "Remove" (without quotes): it means Monk will remove the last coin he added in his bag.
Once the worth of the coins in Monk's bag becomes equal to X, Monk will go to sleep. In order to report Dumbledore, Harry wants to know the number of coins in Monk's bag, the first time their worth becomes equal to X.

Help Harry for the same and print the required number of coins. If the required condition doesn't occur print "-1" (without quotes).

Input:
The first line will consists of one integer N denoting the number of gold coins in Harry's Bag. 
Second line contains N space separated integers, denoting the worth of gold coins.
Third line contains 2 space separated integers Q and X, denoting the number of instructions and the value of X respectively. 
In next Q lines, each line contains one string either "Harry" (without quotes) or "Remove" (without quotes).

Output:
In one line, print the the number of coins in the Monk's bag, the first time their worth becomes equal to X.

Input:
4
3 1 1 4
6 7
Harry
Harry
Harry
Remove
Remove
Harry

Output:
2                */


import java.util.*;
public class Hello {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine()),i,j;
		int[] arr=new int[10000];
		String[] str=sc.nextLine().trim().split(" ");
		for(i=1;i<=n;i++){
		    arr[i]=Integer.parseInt(str[i-1]);
		}
		String[] second=sc.nextLine().trim().split(" ");
		int nofWords=Integer.parseInt(second[0]);
		int totalWorth=Integer.parseInt(second[1]);
		LinkedList stack=new LinkedList();
		int sum=0,iCount=1;
		LinkedList queue=new LinkedList();
		for(i=0;i<nofWords;i++){
		    queue.add(sc.nextLine());
		}
		for(i=0;i<nofWords;i++){
		    if(queue.remove().equals("Harry")){
		        stack.push(arr[iCount]);
		        sum=sum+arr[iCount++];
		    }
		    else{
		        sum=sum-(int)stack.pop();
		       
		    }
		    if(sum==totalWorth){
		        System.out.println(stack.size());
		        return;
		    }
		}
		System.out.println("-1");
	}
}
