'''An array of length at least 2 having distinct integers is said to be fantabulous iff the second highest element lies strictly to the left of the highest value. For example, [1, 2, 13, 10, 15] is fantabulous as the second-highest value 13 lies to the left of highest value 15.
For every fantabulous array, we define a fantabulous pair (a, b) where a denotes the index of the second-highest value (1-indexed) and b denotes the index of the highest value (1-indexed). In the above array, the fantabulous pair is (3, 5).
Mancunian challenges you to solve the following problem. Given an array, find the total number of distinct fantabulous pairs over all its subarrays.

Input: 
The first line contains an integer N denoting the length of the array. The next line contains N distinct integers denoting the elements of the array.

Output:
Output a single integer which is the answer to the problem.

Input:
4
1 3 2 4
Output:
3

Explanation
Let us consider all the subarrays of the given array.
The subarray [1] is not fantabulous.
The subarray [2] is not fantabulous.
The subarray [3] is not fantabulous.
The subarray [4] is not fantabulous.
The fantabulous pair for subarray [1, 3] is (1, 2).
The subarray [3, 2] is not fantabulous.
The fantabulous pair for subarray [2, 4] is (1, 2).
The subarray [1, 3, 2] is not fantabulous.
The fantabulous pair for subarray [3, 2, 4] is (1, 3).
The fantabulous pair for subarray [1, 3, 2, 4] is (2, 4).
So, there are the 3 distinct pairs, which are (1, 2), (1, 3) and (2, 4).     '''

n,l,ans,summaarr=int(input().strip()),list(map(int,input().strip().split())),[],[]
loopTill=2
decrease=n-1
for i in range(n-1):
    k=0
    for oo in range(decrease):
        arr=[]
        for j in range(k,k+loopTill):
            arr.append(l[j])
        s=list(set(arr))
        s.sort(reverse=True)
        index1=l.index(s[0])
        index2=l.index(s[1])
        if index2 < index1:
            summaarr=[]
            summaarr.append(arr.index(s[1])+1)
            summaarr.append(arr.index(s[0])+1)
            if summaarr not in ans:
                ans.append(summaarr)
        k=k+1    
    loopTill+=1
    decrease-=1
print(len(ans))    
