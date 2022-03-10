package queuemanager;

/**
 * A wrapper for bundling up an item and its integer priority.
 * 
 * @param <T>
 */
public class PriorityItem<T> {

    private final T item;
    private final int priority;

    //PriorityItem returns whole cell. name+priority for example [Tom,5]
    public PriorityItem(T item, int priority) {
        this.item = item;
        this.priority = priority;
    }

    //Item is name for example Tom
    public T getItem() {
        return item;
    }

    //Priority is a value for example 5
    public int getPriority() {
        return priority;
    }

    //God knows what that is. Changes Object type to String type?
    @Override
    public String toString() {
        return "(" + getItem() + ", " + getPriority() + ")";
    }
}
