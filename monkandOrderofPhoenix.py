'''Voldemort has a big army, so he has maintained his people in N rows to fight Harry's army. Each row contains the
heights of the fighters and is sorted in non-decreasing order from the start to end, except for the first row,
which may contain the heights of the fighters in any arbitary order, as it contains all the legendry fighters.

During the war, at any time, Voldemort can remove a fighter from any row, and can also add any new fighter to any row
(maintaining the non-decreasing order of heights. except in the first row).

Note:

1  Voldemort will never remove any fighter from an empty row.

2  Voldemort can only remove or add a fighter from/to the end of row.

Now Harry has a special wand which can kill exactly N fighters in one go, but with following conditions:

1  There should be exactly N fighters, and exactly one fighter (which can be anyone in the row) should be chosen from each row.

2  The first fighter can only be chosen from the first row, the second one from second row, and so on. 
Basically the ith fighter should be chosen from ith the row, where i ranges from 1 to N.

. 3. The order of the heights of the chosen fighters should be strictly increasing.
Input Format:

The First line consists of a single integer N denoting the number of stacks.
In each of the next N lines, first integer X denotes the size of the stack, followed by the X space separated integers denoting the heights of the fighters in the stack.

The next lines consists of single integer Q, denoting the number operations. 
Each of the next Q lines will contain a integer v, which will decide the type of operation.

For v=1 , extra 2 integers k and h will be given , which shows that Voldemort will add one fighter of height h in  stack,
maintaining the order of the stack, if k is not equal to 1 .

For v=0, 1 more integer k will be given, which shows that Voldemort will remove a fighter from  stack.

For v=2, Monk needs to know whether Harry can use his special wand or not.

Output Format: :

For v=2 each , print "YES" (without quotes) if Harry can use his special wand or print "NO" (without quotes).

SAMPLE INPUT 
2
3 3 5 4
3 1 1 2
8
0 1
2
1 1 1
2
0 1
2
1 2 4
2
Output:
NO
YES
NO
YES      '''
 
n,arr=int(input().strip()),[]
for i in range(n):
    arr.append(input().strip().split())
q=int(input())
for i in range(q):
    l=[]
    l=(list(map(int,input().strip().split())))
    if l[0] == 0:
        arr[l[1]-1].pop()
    elif l[0] == 1:
        arr[l[1]-1].append(str(l[2]))
        if l[1]-1 != 0:
            duparr=[]
            for lll in range(1,len(arr[l[1]-1])):
                duparr.append(int(arr[l[1]-1].pop()))
            duparr.sort()
            for lll in duparr:
                arr[l[1]-1].append(str(lll))
    elif l[0] == 2 :
        duparr=[]
        for lll in range(1,len(arr[0])):
            duparr.append(int(arr[0].pop()))
        for lll in range(len(duparr)-1,-1,-1):
            arr[0].append(str(duparr[lll]))
        duparr.sort()
        strictlyIncreasing=[]
        strictlyIncreasing.append(duparr[0])
        for row in range(1,n):
            summaarr=[]
            for lll in range(1,len(arr[row])):
                summaarr.append(int(arr[row].pop()))
            for lll in range(len(summaarr)-1,-1,-1):
                arr[row].append(str(summaarr[lll]))    
            summaarr.sort()    
            for ele in summaarr:
                if strictlyIncreasing[len(strictlyIncreasing)-1] < ele:
                    strictlyIncreasing.append(ele)
                    break
        if len(strictlyIncreasing)==n:    
            print("YES")
        else:
            print("NO")
