import java.io.*;
import java.util.*;

public class Board {
    
    Level root;
    int size;
    int rightSize;
    int leftSize;
    //always want to have a somewhat balanced board
    
    public Board() {
	root = null;
	size = 0;
	rightSize = 0;
	leftSize = 0;
    }

    public void add(Level lev){
	if ( size == 0 ) {
	    root = lev;
	}
	else if ( rightSize >= leftSize ) {//r = l or is one larger than l
	    Level temp = root;

	    while ( temp.getLChild() != null ) {
		temp = temp.getLChild(); // goes to the last element 
	    }
	    
	    temp.setLChild(lev);
	    leftSize++;
	}
	else {
	    Level temp = root;

	    while ( temp.getRChild() != null ) {
		temp = temp.getRChild();
	    }
	    
	    temp.setRChild(lev);
	    rightSize++;
	}
	size++;
    }	    
	    
}