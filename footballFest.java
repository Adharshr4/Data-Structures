/*  Explanation :

for the first kind of pass, the player in possession of the ball passes the ball to player with  while for 
the second kind of a pass, the player in possession of the ball passes the ball back to the player who had passed the ball to him.

INPUT :

The first line of the input contains the number of test cases. For each test case, two space separated integers N and id
( of the player possessing the ball in the very beginning). N lines follow describing the passes. P and B P means pass and B means Back 
that is we have to pass the ball backward (that is from where we got);

OUTPUT :

Output to each test case should be a single line containing the "Player"  (quotes for clarity) of the player who possesses 
the ball after N passes.

SAMPLE INPUT 
1
10 23
P 86
P 63
P 60
B
P 47
B
P 99
P 9
B
B
SAMPLE OUTPUT 
Player 9

Explanation
Initially, Player having  posses ball. After pass 1, Player having  posses ball. After pass 2, Player having  posses ball.
After pass 3, Player having  posses ball. After pass 4, Player having posses ball. After pass 5, Player having  posses ball. 
After pass 6, Player having  posses ball. After pass 7, Player having  posses ball.
After pass 8, Player having  posses ball. After pass 9, Player having  posses ball. After pass , Player having  posses ball.    */

import java.util.*;
import java.io.*;
public class Hello {

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        LinkedList stack = new LinkedList();
        int top=-1,i;
        
        int temp=sc.nextInt();
        sc.nextLine();
        for(int j=0;j<temp;j++){
            String[] a=sc.nextLine().trim().split(" ");
            stack.push(Integer.parseInt(a[1]));
            for(i=0;i<Integer.parseInt(a[0]);i++){
                String[] b=sc.nextLine().trim().split(" ");
                if(b[0].charAt(0) == 'P'){
                    stack.push(Integer.parseInt(b[1]));
                    top++;
                }
                else{
                    int first=(int)stack.pop();
                    int second=(int)stack.pop();
                    stack.push(second);
                    stack.push(first);
                    stack.push(second);
                    top++;
                }
            }
            System.out.println("Player "+stack.pop());
        }
    }
}
