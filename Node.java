import java.io.*;
import java.util.*;

public class Node {
    
    private Item cargo;
    private Node next;

    public Node(Item i){
	cargo = i;
	next = null;
    }

    public Item getCargo() { return cargo; }

    public Node getNext() { return next; }

    public void setCargo( Item newCargo ) {
	cargo = newCargo;
    }
    
    public void setNext(Node n) {
	next = n;
    }
    
}
