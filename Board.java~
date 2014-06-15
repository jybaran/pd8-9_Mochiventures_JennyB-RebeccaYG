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
		temp = temp.getLChild(); //goes to the last element
	    }
	    
	    temp.setLChild(lev);		
	    _leftSize++;
	}
	else {
	    Level temp = _root;

	    while ( temp.getRChild() != null ) {
		temp = temp.getRChild();
	    }
	    
	    temp.setRChild(lev);		
	    _rightSize++;
	}
	_size++;
    }	    

    public Level levelUpLeft() {//moving to the next level
	Level newLevel = _root.getLChild();
	newLevel.setRChild( _root.getRChild() );
	_root = newLevel;
	return newLevel;
    }

    public void levelUpRight() {//moving to the next level;
	Level newLevel = _root.getRChild();
	newLevel.setLChild( _root.getLChild() );
	_root = newLevel;
	return newLevel;
    }

    public Level getRoot() {
	return _root;
    }
	    
}