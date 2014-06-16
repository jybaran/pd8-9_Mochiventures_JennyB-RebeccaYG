/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class LLNode<T> {

    private T _cargo;
    private LLNode<T> _nextNode;

    public LLNode( T value, LLNode<T> next ) {
	_cargo = value;
	_nextNode = next;
    }

    //--------------v  ACCESSORS  v--------------
    public T getValue() { return _cargo; }

    public LLNode<T> getNext() { return _nextNode; }
    //--------------^  ACCESSORS  ^--------------

    //--------------v  MUTATORS  v--------------
    public T setValue( T newCargo ) {
	T foo = getValue();
	_cargo = newCargo;
	return foo;
    }

    public LLNode<T> setNext( LLNode<T> newNext ) {
	LLNode<T> foo = getNext();
	_nextNode = newNext;
	return foo;
    }
    //--------------^  MUTATORS  ^--------------

    public String toString() { return _cargo.toString(); }

}//end class LLNode