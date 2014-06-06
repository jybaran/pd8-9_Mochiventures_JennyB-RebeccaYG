/*****************************************************
 * interface Queue
 * Includes only methods listed in AP subset of Java
 * (Local version, to override built-in Java implementation.)
 ******************************************************/

public interface Queue<Quasar> {

    public Quasar dequeue();

    public void enqueue( Quasar x );

    public boolean isEmpty();

    public Quasar peekFront();

}//end interface Queue