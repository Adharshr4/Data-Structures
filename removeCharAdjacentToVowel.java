/*  To remove the characters that are adjacent to string 

Input:
thinker
Output:
tie

Input 2:
table
Output:
ae    */


import java.util.*;
public class Hello {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().trim();
		String ans = "";
		int i = 0;
		List<Character> list = new ArrayList<Character>();
		list.add('a');
		list.add('e');
		list.add('i');
		list.add('o');
		list.add('u');
		list.add('A');
		list.add('E');
		list.add('I');
		list.add('O');
		list.add('U');
		int length = input.length();
		if(!list.contains(input.charAt(i+1))){
		    ans += input.charAt(i);
		}
		for( i=1;i<length-1;i++){
		    if(!list.contains(input.charAt(i-1)) && !list.contains(input.charAt(i+1))){
		        ans += input.charAt(i);
		    }
		}
		if(!list.contains(input.charAt(i-1))){
		    ans += input.charAt(i);
		}
		System.out.println(ans);
	}
}
