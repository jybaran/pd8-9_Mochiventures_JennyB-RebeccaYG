import java.io.*;
import java.util.*;

public class ItemQueue {
    private Node _front, _end;
    private int _size;

    public ItemQueue() {
	_front = _end = null;
    }

    public void enqueue( Item i ){
	if ( isEmpty () ) {
	    _front = _end = new Node(i);
	} else {
	    _end.setNext( new Node(i) );
	    _end = _end.getNext();
	}
	_size ++;
    }

	   
    public Item dequeue() {
	Item result = _front.getCargo();
	_front = _front.getNext();

	if ( _front == null ) //last position
	    _end = null;

	_size --;
	return result;
    }

    public Item peekFront() {
	return _front.getCargo();
    }
    
   
    public boolean isEmpty() {
	return ( _size == 0 );
    }
    
}
