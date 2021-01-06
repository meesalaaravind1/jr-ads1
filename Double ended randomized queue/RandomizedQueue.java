import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item>{
    private class Node<Item>{
        Node<Item> next;
        Node<Item> prev;
        Item value;

        Node(Item value){
            this.next=null;
            this.prev=null;
            this.value=value;

        }
    }

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    public RandomizedQueue(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void enqueue(Item item){
        if (item==null){throw new IllegalArgumentException();}
        Node<Item> x= new Node<>(item);
        if (isEmpty()){
            this.head=x;
            this.tail=x;
        }
        else{
            tail.next=x;
            x.prev=tail;
            tail=x;
        }
        size++;
    }

    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException();
        Random r=new Random();
        int index=r.nextInt(size);
        int count=0;
        Node<Item> temp=head;
        while(temp.next!=null && count!=index){
            temp=temp.next;
        }
        if(temp.prev!=null)
        temp.prev.next=temp.next;
        if (temp.next!=null)
        temp.next.prev=temp.prev;
        size--;
        return temp.value;
    }

    public Item sample(){
        if (isEmpty()) throw new NoSuchElementException();
        Random r=new Random();
        int index=r.nextInt(size);
        int count=0;
        Node<Item> temp=head;
        while(temp.next!=null && count!=index){
            temp=temp.next;
        }
        return temp.value;
    }

    public Iterator<Item> iterator(){
        return new RandomizedQueueIterator<Item>(head);
    }

    private class RandomizedQueueIterator<Item> implements Iterator<Item>{
        private Node<Item> temp;
        public RandomizedQueueIterator(Node <Item> head){
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
    public static void main(String[]args){
        RandomizedQueue<String> randq= new RandomizedQueue<String>();
        randq.enqueue("krish");
        randq.enqueue("Aravind");
        randq.enqueue("Vizianagaram");
        randq.enqueue("IIIT");
        randq.dequeue();
        randq.isEmpty();
        randq.size();
        randq.sample();

    }
}