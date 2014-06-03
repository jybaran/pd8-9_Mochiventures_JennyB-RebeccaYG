import java.io.*;
import java.util.*;

public class Queue {
    private Node _front, _end;
    private int _size;

    public Queue() {
	_front = _end = null;
    }

    public void enqueue(String s){
	if ( isEmpty () ) {
	    _front = _end = new Node(s, null);
	} else {
	    _end.setNext( new Node(s, null) );
	    _end = _end.getNext();
	}
	_size ++;
    }

	   
    public String dequeue() {
	String result = _front.getCargo();
	_front = _front.getNext();

	if ( _front == null ) //last position
	    _end = null;

	_size --;
	return result;
    }

    public String peekFront() {
	return _front.getCargo();
    }
    
   
    public boolean isEmpty() {
	return ( _size == 0 );
    }
    
}