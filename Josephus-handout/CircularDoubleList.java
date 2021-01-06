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
