import java.io.*;
import java.util.*;

public class Node {
    
    private String cargo;
    private Node next;

    public Node(String s, Node n){
	cargo = s;
	next = n;
    }

    public String getCargo() { return cargo; }
    public Node getNext() { return next; }

    public void setCargo( String newCargo ) {
	cargo = newCargo;
    }
    
    public void setNext(Node n) {
	next = n;
    }
    
}