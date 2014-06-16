/*****************************************************
 * interface Queue
 * Includes only methods listed in AP subset of Java
 * (Local version, to override built-in Java implementation.)
 ******************************************************/

public interface Queue<T> {

    public T dequeue();

    public void enqueue( T x );

    public boolean isEmpty();

    public T peekFront();

}//end interface Queue