import java.io.*;
import java.util.*;

public class Item {
    
    private String cargo;
    private Item next;

    public Item(String s, Item n){
	cargo = s;
	next = n;
    }

    public String getCargo() { return cargo; }
    public Item getNext() { return next; }

    public void setCargo( String newCargo ) {
	cargo = newCargo;
    }
    
    public void setNext(Item n) {
	next = n;
    }
    
}