package queuemanager;
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {
    private final Object[] unsorted_storage;
    private int  size_number;
    private int top_priority;
    public UnsortedArrayPriorityQueue(int capacity) {
        size_number = 0;
        unsorted_storage = new Object[capacity];
        //top priority item value.
        top_priority=0;}
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if ( size_number >= unsorted_storage.length) {
            throw new QueueOverflowException();}
        //increase size and add new item with priority.
        unsorted_storage[ size_number++] = new PriorityItem<>(item, priority);}

    @Override
    public boolean isEmpty() {return  size_number <= 0;}

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();}
        PriorityItem<T> head_element = null;
        //iterate over each element in object array
        for (int element = 0; element < size_number; element++) {
            PriorityItem<T> nextElement = (PriorityItem<T>) unsorted_storage[element];
            //if iterated element is bigger than current head element assign to head element.
            if (head_element == null || nextElement.getPriority() > head_element.getPriority()) {
                head_element = nextElement;}}
        return head_element.getItem();}

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();}
        T top_priority_item = head();
        int i;
        for (i = 0; i <  size_number; i++) {
            PriorityItem<T> nextElement = (PriorityItem<T>)unsorted_storage[i];
            if (nextElement.getItem().equals(top_priority_item)) {break;}}
        for (; i <  size_number - 1; i++) {
            unsorted_storage[i] = unsorted_storage[i + 1];}
        size_number--;}

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size_number; i++) {
            result += unsorted_storage[i];
            if (i + 1 <  size_number) {
                result += ", ";}}
        result += "]";
        return result;}}