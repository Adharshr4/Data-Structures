/*   Various signal towers are present in a city.Towers are aligned in a straight horizontal line(from left to right) and each tower transmits a signal in the right to left direction.Tower A shall block the signal of Tower B if Tower A is present to the left of Tower B and Tower A is taller than Tower B. So,the range of a signal of a given tower can be defined as :

{(the number of contiguous towers just to the left of the given tower whose height is less than or equal to the height of the given tower) + 1}.

You need to find the range of each tower.

INPUT

First line contains an integer T specifying the number of test cases.

Second line contains an integer n specifying the number of towers.

Third line contains n space separated integers(H[i]) denoting the height of each tower.

OUTPUT

Print the range of each tower (separated by a space).

Sample Input:
1
7
100 80 60 70 60 75 85
Output:
1 1 1 2 1 4 6            */


import java.util.*;
public class Hello {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc=new Scanner(System.in);
		int nofTestCases=Integer.parseInt(sc.nextLine()),i,j,k;
		for(i=0;i<nofTestCases;i++){
		    int n=Integer.parseInt(sc.nextLine()),count=1;
		    List<Integer> l=new ArrayList<Integer>();
		    String[] st=sc.nextLine().trim().split(" ");
		    for(j=0;j<n;j++){
		        l.add(Integer.parseInt(st[j]));
		    }
		    System.out.print(count+" ");
		    for(j=1;j<n;j++){
		        k=j-1;
		        while(l.get(k) < l.get(j)){
		            count++;
		            if(k-1 == -1){
		                break;
		            }
		            k--;
		        }
		        System.out.print(count+" ");
		        count=1;
		    }
		    System.out.println();
		}
	}
}
