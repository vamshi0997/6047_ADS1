/**
 * List of elements.
 *
 * @param   <E>   generic type.
 */
public class LinkedList<E> {

    class Node<E> {
        E data;
        Node<E> next;
    }

    Node<E> head = null;

    Node<E> tail = null;

    public int size = 0;

    Node<E> insertrecur(Node<E> ref, int pos, int npos) {
        if(npos >= pos) {
            return ref;
        }
        ref = ref.next;
        npos++;
        return insertrecur(ref, pos, npos);
    } 

    void insert(E data, int position) {
        if(position > size || position < 0) {
            System.out.println("Can't insert at this position.");
            return;
        }

        if (position == 0) {
            //if head is null ie first addition.
            if (head == null) {
                head = new Node<E>();
                head.data = data;
                head.next = null;
                tail = head;
                size++;
            } else {
                //add before head element.
                Node<E> tmp = new Node<E>();
                tmp.data = data;
                tmp.next = head;
                head = tmp;
                size++;
            }
            return;
        } 

        if(position == size) {
            //at last.
            Node<E> tmp = new Node<E>();
            tmp.data = data;
            tail.next = tmp;
            tail = tmp;
            tail.next = null;
            size++;
            return;
        }
        Node<E> reference = head;
        int npos = 1;
        reference = insertrecur(reference, position, npos);
        Node<E> tmp = new Node<E>();
        tmp.data = data;
        tmp.next = reference.next;
        reference.next = tmp;
        size++;

    }

    void insertAtEnd(E data) {
        this.insert(data,this.size);
    }

    void insertAtStart(E data) {
        this.insert(data,0);
    }


    
    E remove(int position) {
        if(position > size || head==null) {
            return null;
        }

        //start position
        //handles only one element present in list
        //and also with n elemnts present.
        if (position == 0) {
            E element = head.data;
            try {
                head = head.next;    
            } catch (Exception e) {
                head = null;
            }
            size--;
            return element;
        }

        //normal cases and last position.
        Node<E> reference = this.head;
        for (int i = 1; i < position - 1; i++) {
            reference = reference.next;
        }
        
        E element = null;
        if (this.size != 1) {
            element = reference.next.data;
            reference.next = reference.next.next;    
        } else if (this.size == 1) {
            element = this.head.data;
            this.head = null;
        } 
        size--;
        return element;
    }

    E removeAtEnd() {
        return this.remove(this.size);
    }
    
    E removeAtStart() {
        return this.remove(0);
    }

    
    void print() {
        Node<E> reference = this.head;
        if (size == 1) {
            System.out.println(reference.data);
            return;
        }
        while (reference != null) {
            if(reference.next != null) {
               System.out.print(reference.data + ", ");
            } else {
                System.out.println(reference.data);
            }
            reference = reference.next;
        }
    }

    void reverse() {
        LinkedList<E> link = new LinkedList<E>();
        Node<E> temp = new Node<E>();
        temp = head;
        if (size == 0) {
            System.out.println("No elements to reverse.");
            return;
        }
        if (size == 1) {
            System.out.println(head.data);
            return;
        }
        while (temp != tail) {
            link.insertAtStart(temp.data);
            temp = temp.next;
        }
        link.insertAtStart(temp.data);
        link.print();
        
    }

}