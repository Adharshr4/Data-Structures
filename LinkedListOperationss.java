/* To perform some linked list operations in c like insertafter ,inseetAfterNumber , append , push , delete node , union , intersection ,
find n th node from last , find middle , detect loop and reverse ...

Input:
5
12 23 34 60 40

Output:
After appending the values : 12 23 34 60 40 
After pushing the values: 340 210 60 12 23 34 60 40 
After inseerting the values: 340 210 444 60 2012 12 23 34 60 40 
After deleting the values: 340 210 444 60 2012 12 23 60 40 
The middle element in the list is 2012
Loop is not present
Nth node value from last is 23
Reversed list: 40 60 23 12 2012 60 444 210 340 
After inserting vals on second list:  40 100 240 1010 
Union of 2 list is:   1010 240 100 340 210 444 60 2012 12 23 60 40 
Intersection of 2 list is:   40         */


import java.util.*;
class LinkedList{
    
    Node head;
    
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d; 
            next = null;
        }
    }
    
    
    public void append(int data){
        Node new_node = new Node(data);
        if(head == null){ 
            head = new_node;
            return;
        }
        Node last=head; 
        while(last.next != null){ 
            last = last.next;
        }
        last.next = new_node;
    }
    
    
    public void push(int data){ 
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }
    
    
    public void insertAfter(Node prev , int data){ 
        if(prev == null){ 
            System.out.println("The previous node cannnot be null");
            return;
        }
        Node new_node = new Node(data); 
        new_node.next = prev.next;
        prev.next = new_node; 
    }
    
    
    public void insertAfterNumber(int val , int data){
        if(head == null){
            System.out.println("The list is empty"); 
            return;
        }
        Node new_node = new Node(data); 
        Node temp = head; 
        while(temp.data != val && temp != null){ 
            temp = temp.next;
        }
        new_node.next = temp.next;
        temp.next = new_node;
    }
    
    
    public void deleteNodeValue(int key){ 
        try{
            if(head == null){
                System.out.println("The list is empty");
                return; 
            }
            Node temp = head; 
            if(temp.data == key){ 
                head=temp.next;
                return; 
            } 
            Node prev=null; 
            while(temp.data != key && temp != null){ 
                prev=temp;
                temp = temp.next;
            }
            prev.next = temp.next;
        }
        catch(Exception e){
            System.out.print("\n"+e);
        }
    }
    
    
    public void findMiddle(){
        if(head == null){ 
            System.out.println("The list is empty");
            return;
        }
        Node slow_ptr = head;
        Node fast_ptr = head;
        while(fast_ptr != null && fast_ptr.next != null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        System.out.format("\nThe middle element in the list is %d",slow_ptr.data);
    }
    
    
    public boolean detectLoop(){
        Node slow_ptr = head; 
        Node fast_ptr = head;
        while(slow_ptr != null && fast_ptr != null && fast_ptr.next != null){
            slow_ptr = slow_ptr.next; 
            fast_ptr = fast_ptr.next.next;
            if(slow_ptr == fast_ptr){
                return true;
            }
        }
        return false;
    }
    
    
    public void findNthFromLast(int num){
        if(head == null){
            System.out.println("The list is empty");
            return; 
        } 
        int count=1,traverseCount=0; 
        Node temp = head;
        Node head_dup = head;
        while(temp.next != null){ 
            count++; 
            temp = temp.next; 
        } 
        int eleCount = count-num;
        while(traverseCount != eleCount){ 
            head_dup=head_dup.next;
            traverseCount++;
        }
        System.out.print("\nNth node value from last is "+head_dup.data); 
    } 
    
    
    public void reverse(){ 
        Node prev = null;
        Node current =head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev; 
            prev = current;
            current = next;
        }
        head = prev; 
    } 
    
    
    public void getUnion(Node temp1 , Node temp2){
        while(temp1 != null){
            push(temp1.data);
            temp1 = temp1.next;
        }
        while(temp2 != null){
            if(isPresent(head,temp2.data) == 0){
                push(temp2.data);
            }
            temp2 = temp2.next;
        }
    }
    
    
    void getIntersection(Node head1, Node head2)
    {
        Node t1 = head1;
        while(t1 != null)
        {
            if(isPresent(head2 , t1.data) == 1){
                push(t1.data);
            }
            t1 = t1.next;
        }
    }
    
    
    int isPresent(Node head , int data)
    {
        Node t = head;
        while(t != null){
            if(t.data == data){
                return 1;
            }
            t = t.next;
        }
        return 0;
    }
    
    
    public void printList(){
        Node tnode = head; 
        while (tnode != null) {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }
}


public class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,i,j,a; 
        LinkedList list = new LinkedList();
        LinkedList secondList = new LinkedList();
        LinkedList unionn = new LinkedList();
        LinkedList intersectionn = new LinkedList();
        n=sc.nextInt(); 
        for(i=0;i<n;i++){
            a=sc.nextInt(); 
            list.append(a);
        }
        System.out.print("After appending the values : ");
        list.printList();
        list.push(60);
        list.push(210);
        list.push(340); 
        System.out.print("\nAfter pushing the values: ");
        list.printList();
        list.insertAfter(list.head.next , 444);
        list.insertAfterNumber(60 , 2012);
        System.out.print("\nAfter inseerting the values: ");
        list.printList();
        list.deleteNodeValue(34); 
        System.out.print("\nAfter deleting the values: "); 
        list.printList(); 
        list.findMiddle();//TO find the middle element 
        boolean check = list.detectLoop(); //check if loop is present in the list
        if(check){
            System.out.print("\nLoop is present");
        }
        else{
            System.out.print("\nLoop is not present");
        }
        list.findNthFromLast(3); 
        list.reverse();
        System.out.print("\nReversed list: "); 
        list.printList(); 
        secondList.append(40);
        secondList.append(100);
        secondList.append(240);
        secondList.append(1010);
        System.out.print("\nAfter inserting vals on second list:  ");
        secondList.printList();
        unionn.getUnion(list.head , secondList.head);
        System.out.print("\nUnion of 2 list is:   ");
        unionn.printList();
        intersectionn.getIntersection(list.head , secondList.head);
        System.out.print("\nIntersection of 2 list is:   ");
        intersectionn.printList();
    } 
}
