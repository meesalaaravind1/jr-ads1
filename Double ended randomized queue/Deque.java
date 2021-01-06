import java.util.NoSuchElementException;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item>{
    private class Node<Item> {
        Node<Item> prev;
        Node<Item> next;
        Item value;

        Node(Item val){
            this.value=val;
            this.prev=null;
            this.next=null;
        }
    }
    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    public Deque(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addFirst(Item item){
        if (item==null){throw new IllegalArgumentException();}
        Node<Item> x= new Node<>(item);
        if (isEmpty()){
            this.head=x;
            this.tail=x;
        }
        else{
            head.prev=x;
            x.next=head;
            head=x;
        }
        size++;
    }

    public void addLast(Item item){
        if (item==null){throw new IllegalArgumentException();}
        Node<Item> x= new Node<>(item);
        if (isEmpty()){
            this.head=x;
            this.tail=x;
            size++;
        }
        else{
            tail.next=x;
            x.prev=tail;
            tail=x;
            size++;
        }
    }

    public Item removeFirst(){
        if (isEmpty()) throw new NoSuchElementException();
        if (head==tail){
            Node<Item> temp=head;
            head=null;
            tail=null;
            size--;
            return temp.value;
        }
        else{
        Node<Item> temp=head;
        head=head.next;
        head.prev=null;
        size--;
        return temp.value;
        }


    }

    public Item removeLast(){
        if (isEmpty()) {throw new NoSuchElementException();}
        Node<Item> x=tail;
        tail=tail.prev;
        if(tail!=null){
            tail.next=null;
        }
        else{
            head=null;
        }
        size--;
        return x.value;
    }

    public Iterator<Item> iterator(){
        return new DequeueIterator<Item>(head);
    }

    private class DequeueIterator<Item> implements Iterator<Item>{
        private Node<Item> temp;

        public DequeueIterator(Node<Item> head){
            temp=head;
        }
        public boolean hasNext(){return temp!=null;}

        public Item next(){
            if (temp==null){throw new NoSuchElementException();}
            Item item= temp.value;
            temp=temp.next;
            return item;
        }

        public void remove(){throw new UnsupportedOperationException();}
    }

public static void main(String[] args) {
        Deque<String> dq = new Deque<String>();
        dq.addFirst("krish");
        dq.addFirst("Aravind");
        dq.addFirst("Facebook");
        dq.addLast("Whatsapp");
        dq.addLast("Instagram");
        dq.removeFirst();
        dq.removeFirst();
        dq.removeLast();
        dq.size();
        dq.removeLast();
        dq.removeLast();
        dq.isEmpty();

    }
}