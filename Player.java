import java.io.*;
import java.util.*;

public class Player {
    String _name;
    Level _level;
    int _health;
    ItemQueue _iQ;
    int _mochi;

    public Player( Level lvl ) {
	_name = "Kia"; //shoutout to the bae
	_level = lvl;
	/**********
	 * when player is created in board/driver/wherever,
	 * lvl is the root of the board tree (additionally,
	 * this makes it easy if we ever want to test the game
	 * from the middle).
	 **********/
	_health = 100;
	_iQ = new ItemQueue();
    }

    public Player( String name, Level lvl ) {
	this(lvl);
	_name = name;
    }

    //for leveling up, we run this w/ next level (left or right child of prev)
    public void setLevel( Level lvl ) {
	_level = lvl;
    }

    /*********
     * Queue of items, sorry i wasn't able to do much in class,
     * I was in the middle of a really exciting part in my book
     * I'll work on it more at home tonight (i promise!)
     * I was thinking maybe having the driver create a player based
     * on the things it reads in
     * we should talk about moving from one level to another
     *********/

    //don't worry about it! elaborate on queue of items?

    public void obtainItem(String s){
	_iQ.enqueue(s);
    }
    public String peekItem() {
	return _iQ.peekFront();
    }

    public String useItem() {
	return _iQ.dequeue();
    }

    public void obtainMochi( int i ) {
	//you get mochi randomly at the start of a level
	//and also if you correctly answer a tanuki's question
	_mochi += i;
    }
        
    public void useMochi( int i ) {
	/*********
	 * throwing mochi at a tanuki calls this with
	 * i = 1 (so you throw mochi at the tanuki one
	 * at a time and hope it goes away)
	 *********/
	_mochi -= i;
    }

}