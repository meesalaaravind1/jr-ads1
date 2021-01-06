import java.util.Scanner;

/**
 * Author: Roll No: Date:
 */

 /**
 * @author Aravind Meesala
 */
class Node {
    /**
     * this is the data in the
     * Node.
     *
     */
    int value;
    /**
     * this the reference to
     * the next Node.
     */
    Node next;
    /**
     * this the reference to
     * the previous Node.
     */
    Node previous;
    /**
     * this is the constructor.
     * @param value1 the data in the data.
     */
    Node(final int value1) {
        this.value = value1;
    }
}
/**
 * @author Aravind Meesala
 */
class CircularDoubleList {
    /**
     * this is the head.
     */
    Node head;
    /**
     * this is the tail of
     * linked list.
     */
    Node tail;
    /**
     * this to added to
     * the node to the end.
     * @param val the data to the
     * node.
     */
    public void add(final int val) {
        Node node = new Node(val);

        if (this.head == null) { // if empty circular dd ll
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node; // pervious
            node.previous = tail; // keeping next node as tail
            this.tail = node;
        }

    }
    /**
     * this is to adding the
     * tail to the head.
     */
    public void formCircle() {
        this.tail.next = this.head;
        this.head.previous = this.tail;
    }
}


public class Josephus {

    public static String Josephus(final int a, final int b) {
		// fill you code Here
		CircularDoubleList cdll = new CircularDoubleList();// new circular linked list

		for (int i = 0; i < a; i++) {		//adds elements to the linked list
			cdll.add(i);
		}
		cdll.formCircle();					//creates circular linked list with compexity N

		int pos = 1;
		Node temp = cdll.head;

		int eliminated = 0;
		String toReturn = "";
		while (eliminated != a) {			//till eliminated=a, temp increments with complexity N
			temp = temp.next;
			pos++;
			if (pos == b) {					//if position = b, update pos=1 and add the value of temp to string
				pos = 1;

				toReturn += temp.value + " ";

				Node prevNode = temp.previous;	//taking temporary prev link
				Node nextNode = temp.next;		//taking temporary next link

				prevNode.next = nextNode;		//update prev node next with "next link"
				nextNode.previous = prevNode;	//update next node prev with "prev link"

				eliminated++;
				temp = temp.next;				//again incrementing temp
			}
		}
		toReturn = toReturn.trim();				//if any end spaces are left it will be removed here
		return toReturn;
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // your code goes here
        int n=sc.nextInt();
        int t=sc.nextInt();
        System.out.println(Josephus(n,t));
        sc.close();
    }
}
