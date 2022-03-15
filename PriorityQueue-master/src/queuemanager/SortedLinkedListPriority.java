package queuemanager;

public class SortedLinkedListPriority<T> implements PriorityQueue<T> {
    private Node head_node;

    @Override
    public String toString() {
        String result = "[";
        Node current = head_node;
        while (current != null) {
            result += current.item.getItem();
            if (current.next != null) {
                    result += ",";}
                current = current.next;}
            result += "]";
            return result;}

    @Override
    public boolean isEmpty() {
        return head_node == null;
    }

    @Override
    public void add(T item, int  priority) throws QueueOverflowException {
        if (head_node == null   ) {
            head_node = new Node(new PriorityItem(item, priority)) ;
            return;
        }
            Node newNode = new Node(new PriorityItem(item, priority ) ) ;
            Node previous_node = null ; Node current_node = head_node ;

        while (current_node != null) {
            if (current_node.item.getPriority() <=  priority )  {
                if (current_node == head_node ) {newNode.next = current_node;head_node = newNode;
                } else {
                     previous_node.next = newNode;
                    newNode.next = current_node;}
                return;}
            previous_node = current_node;
            current_node =  current_node.next;}
        previous_node.next =  newNode;}

    @Override
    public T head() throws  QueueUnderflowException {
        if ( isEmpty()) {
            throw new QueueUnderflowException() ;}
        return head_node.item.getItem(); }

    @Override
    public void remove () throws QueueUnderflowException {
        if (isEmpty()) {
            throw new    QueueUnderflowException() ;}
        head_node = head_node.next  ;  }
    private class Node {
        public PriorityItem<T> item ;
        public Node  next;
        public Node(PriorityItem item) {
            this.item = item;
            next = null;}}}