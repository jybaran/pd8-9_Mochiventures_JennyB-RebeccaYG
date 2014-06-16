/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 ******************************************************/


public class RQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;
    private int _size;

    public RQueue() { 
	_front = _end = null;
	_size = 0;
    }


    public void enqueue( T enQVal ) {
	if ( isEmpty() ) {
	    _front = _end = new LLNode<T>( enQVal, null );
	}
	else {
	    _end.setNext( new LLNode<T>( enQVal, null ) );
	    _end = _end.getNext();
	}
	_size++;
    }

    public T dequeue() { 

	T retVal = _front.getValue();
	_front = _front.getNext();

	if ( _front == null ) {
	    _end = null;
	}
	_size--;

	if ( _size > 1 )  sample();

	return retVal;
    }


    public T peekFront() {
	return _front.getValue();
    }

    public void sample () {
	int cycles = (int)( _size * Math.random() );
	for( int i = 0; i < cycles; i++ )
	    enqueue( dequeue() );
    }

    public boolean isEmpty() { return _front == null; }

    public int getSize() { 
	return _size;
    }

    public String toString() { 
	String foo = "";
	LLNode<T> tmp = _front;
	while ( tmp != null ) {
	    foo += tmp.getValue() + " ";
	    tmp = tmp.getNext();
	}
	return foo;
    }

}//end class RQueue