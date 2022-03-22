package queuemanager;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class QueueManagerTest_JUnit5 {

    private void testOperations(PriorityQueue<Person> queue) {
        Person p1 = new Person("Mac");
        Person p2 = new Person("John");
        Person p3 = new Person("Anna");
        int next_item = 0;
        try {
            queue.add(p1, 1);
            queue.add(p3, 3) ;
            queue.add(p2, 2);
        } catch (Exception ex) {
            fail() ;}
        if (!(queue  instanceof UnsortedLinkedListPriority )
                && !(queue instanceof  SortedLinkedListPriority ) ) {
            try {
                queue.add(p3, 3);
                fail();
            } catch (QueueOverflowException ex) {
            } catch (Exception ex) {
                fail();}}
        Person[]    expectedSequence = {p3,p2, p1};
                ;
        while (! queue.isEmpty() ) {
            try {
                assertEquals(expectedSequence[next_item++ ],  queue.head() ) ;
                queue.remove();
            } catch     (QueueUnderflowException   ex)    {
                    fail();}}   }
    //All tests bellow.
    @Test
    public void testSortedArrayPriorityQueue() {
        testOperations(new SortedArrayPriorityQueue<Person>(3));}
    @Test
    public void testUnsortedArrayPriorityQueue() {
        testOperations(new UnsortedArrayPriorityQueue<Person>(3));}
    @Test
    public void testUnsortedLinkedListPriorityQueue() {
        testOperations(new UnsortedLinkedListPriority<Person>());}
    @Test
    public void testSortedLinkedListPriorityQueue() {
        testOperations(new SortedLinkedListPriority<Person>());}
    /**
     * Create Test for heap_pq below.
     */
}
