import java.io.*;
import java.util.*;

public class Player {
    String _name;
    Level _level;
    int _health;
    //    ItemQueue _iQ;
    int _mochi;

    public Player( Level lvl ) {
	_name = "Kia";
	_level = lvl;
	_health = 100;
	//	_iQ = new ItemQueue();
    }

    public Player( String name, Level lvl ) {
	this(lvl);
	_name = name;
    }

    public Level getLevel() {
	return _level;
    }

    //for leveling up, we run this w/ next level (left or right child of prev)
    public void setLevel( Level lvl ) {
	_level = lvl;
    }

    /*
    public void obtainItem(Item i){
	_iQ.enqueue(i);
    }

    public String peekItem() {
	Item accessed = _iQ.peekFront();
	return accessed.getName();
    }

    public String useItem() {
	Item accessed = _iQ.dequeue();
	String retStr = accessed.getResponse();
	_health += accessed.getEffect();
	return retStr;
    }
    */

    public void obtainMochi( int i ) {
	//you get mochi randomly at the start of a level
	//and also if you correctly answer a tanuki's question
	//uses same randint as tanuki's mochi tax
	_mochi += i;
    }
        
    public void useMochi( int i ) {
	_mochi -= i;
    }

    public int getMochi() {
	return _mochi;
    }

    public void adjustHealth( int i ) {
	_health += i;
    }

    public int getHealth() {
	return _health;
    }
}