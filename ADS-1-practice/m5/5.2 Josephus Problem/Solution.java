import java.util.Scanner;
class NQueue {
    private Node head = null;
    private Node tail = null;
    private Node current = null;

    class Node {
        int data;
        Node next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(int element) {
        if (head == null) {
            head = new Node();
            tail = new Node();
            head.data = element;
            tail = head;
            return;
        }
        current = new Node();
        current.data = element;
        tail.next = current;
        tail = current;
    }


    public int dequeue() {
        Node temp = new Node();
        if(head == tail) {
            temp = head;
            head = null;
            tail = null;
            return temp.data;
         }
         temp = head;
         head = head.next;
         return temp.data;
    }

    // public int getNext() {
    //     if (current == null) {
    //         current = head;
    //     }
    //     Node tmp = current;
    //     current = tmp.next;
    //     return tmp.data;
    // }
    void display() {
        if(head.next == null) {
            System.out.println(head.data);
            System.out.println("hi");
            return;
        }
        Node temp = new Node();
        temp = head;
        while(temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
        return;

    }
}

public final class Solution {
    private Solution() {

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while (scan.hasNext()) {
        	NQueue n = new NQueue();
        	int count = scan.nextInt();
        	int cut = scan.nextInt();
            // n.enqueue(0);
            // n.enqueue(1);
            // n.enqueue(2);

            for(int i = 0; i < count; i++) {
                n.enqueue(i);
            }
            //n.display();
            // for(int i = 0; i < count; i++) {
            //     System.out.println(n.dequeue());
            // }


            String display = "";
            while (!n.isEmpty()) {
                int t2 = 0, t1 = 0;
                for (int i = 0; i < cut; i++) {
                    if(i != cut - 1) {
                        t1 = n.dequeue();
                        n.enqueue(t1);
                    }
                    else {
                        t2 = n.dequeue();
                    }
                }
                display += t2 + " ";
            }
            System.out.println(display);
            
        }
    }
}