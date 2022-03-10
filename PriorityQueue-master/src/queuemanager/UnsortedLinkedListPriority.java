package queuemanager;
public class UnsortedLinkedListPriority<T> implements PriorityQueue<T> {
    private Node  head_element;

    @Override
    public String toString() {
        String result =  "[";
        Node current = head_element;
        while (current != null) {
            result += current.item.getItem();
            if (current.next != null) {
                result += ","; }
            current = current.next;}
        result += "]";
        return result;}

    @Override
    public boolean isEmpty() {return  head_element == null;}

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        Node new_node = new  Node(new PriorityItem(item,  priority));
        new_node.next =   head_element;
        head_element =  new_node;}

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) { throw new QueueUnderflowException();}
        PriorityItem<T>  element = null;
        Node current = head_element;
        while (current !=  null) {PriorityItem<T> nextItem = current.item;
            if (element == null || nextItem.getPriority()  >   element.getPriority( )) {element = nextItem; }
            current = current.next;}return element.getItem() ; }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {throw new QueueUnderflowException();}
        T headItem =  head();  Node previous = null;  Node  current =   head_element ;
        while (current != null) {if (current.item.getItem().equals(headItem)) {
                if (current == head_element) {
                    head_element =  head_element.next ; }  else {
                    previous.next = current.next; }return; }
            previous = current ;
            current = current.next ; } }

    private class Node {
        public PriorityItem<T> item ; public Node  next ; public Node(PriorityItem item) {
            this.item = item ;
            next = null;}
    }
}
