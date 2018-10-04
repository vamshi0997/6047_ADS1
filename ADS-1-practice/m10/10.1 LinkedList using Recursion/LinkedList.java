class LinkedList{

    Node head;
    Node tail;
    int size;
    
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node insert(Node current, Node temp, int position, int nPos){
        if(current == null){
            return temp;
        }
        else if(nPos == position){
            temp.next = current;
            return temp;
        }
        nPos++;
        current.next = insert(current.next, temp, position, nPos);
        return current;

    }

    public void insert(int position, int data) throws Exception{

        if(position < 0 || position > size){
            throw new Exception("Can't insert at this position.");
        }

        head = insert(head, new Node(data), position, 0);
        size++;

    }

    public void print(){
        Node current = head;
        String result = "";
        while(current!=null){
            if(current.next == null){
                result += current.data;
            }
            else{
                result += current.data+", ";
            }
            current = current.next;
        }

        System.out.println(result);
    }

    private Node reverse(Node current, Node prev){



        if(current.next == null){
            head = current;
            head.next = prev;
            return null;
        }

        Node temp = current.next;
        current.next = prev;

        reverse(temp,current);
        return head;
    }

    public void reverse() throws Exception {
        if(head == null){
            throw new Exception("No elements to reverse.");
        }
        reverse(head, null);
    }
}
