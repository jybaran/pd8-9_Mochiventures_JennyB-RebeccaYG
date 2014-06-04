import java.io.*;
import java.util.*;

public class Board {
    
    Level _root;
    int _size;
    int _rightSize;
    int _leftSize;
    //always want to have a somewhat balanced board
    
    public Board() {
	_root = null;
	_size = 0;
	_rightSize = 0;
	_leftSize = 0;
    }

    public void add(Level lev){
	if ( _size == 0 ) {
	    _root = lev;
	}
	else if ( _rightSize >= _leftSize ) {//r = l or is one larger than l
	    Level temp = _root;

	    while ( temp.getLChild() != null ) {
		temp = temp.getLChild(); // goes to the last element 
	    }
	    
	    temp.setLChild(lev);		
	    lev.setParent(temp);
	    _leftSize++;
	}
	else {
	    Level temp = _root;

	    while ( temp.getRChild() != null ) {
		temp = temp.getRChild();
	    }
	    
	    temp.setRChild(lev);		
	    lev.setParent(temp);
	    _rightSize++;
	}
	_size++;
    }	    

    public void levelUpLeft() {//moving to the next level
	Level temp = _root.getLChild();
	temp.visit();
	temp.setRChild( _root.getRChild() );
	_root.getRChild().setParent(temp);
	temp.setParent(null);
	_root = temp;
    }

    public void levelUpRight() {//moving to the next level;
	Level temp = _root.getRChild();
	temp.visit();
	temp.setLChild( _root.getLChild() );
	_root.getLChild().setParent(temp);
	temp.setParent(null);
	_root = temp;
    }
	    
}