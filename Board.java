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
	if (size == 0){
	    root = lev;
	    return;
	} else if (rightSize >= leftSize) {//slightly leans left
	    Level temp = root;

	    while (temp.getChild() != null) 
		temp = temp.getChild(); // goes to the last element 

	    temp.setChild(lev);
	    return;
	}
	    
	    
}