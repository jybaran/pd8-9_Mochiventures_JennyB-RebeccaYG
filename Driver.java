import java.io.*;
import java.util.*;
import RandQ.*;

public class Driver {

    public static void main (String[] args) {
	*/**********
	  * SETTING UP BOARD W/ LVLS, LVLS W/ TANUKI
	  **********/
	//reads in file of lvl filenames, makes randq
	RQueue<String> lvlNames = new RQueue<String>;
	int count = 0;

	try {
	    Scanner lvlsc = new Scanner( new File("LevelNames.txt") );
	    while ( lvlsc.hasNext() ) {
		lvlNames.enQueue( lvlsc.nextLine() + ".txt" );
	    }
	}
	catch (Exception e) {
	    System.out.println("FILE NOT FOUND, YOU ARE A FAILURE AND SHOULD FEEL BAD.");
	}

	//reads in file of tanuki filenames, makes randq
	RQueue<String> tanFiles = new RQueue<String>;
	int count = 0;

	try {
	    Scanner tansc = new Scanner( new File("TanukiFiles.txt") );
	    while ( tansc.hasNext() ) {
		tanFiles.enQueue( tansc.nextLine() + ".txt" );
	    }
	}
	catch (Exception e) {
	    System.out.println("FILE NOT FOUND, YOU ARE A FAILURE AND SHOULD FEEL BAD.");
	}

	int tanLeft = tanFiles.getSize(); //# of tanuki to spawn over all lvls

	//building board from rqueue of lvls
	while ( ! lvlName.isEmpty() ) {
	    int rand = (int)(Math.random() * 2 );
	    //10% chance of getting a tanuki in any given level
	    /*something about how this biases you towards getting
	      tanuki in earlier levels??? will fix later*/
	    if ( rand == 0 && tanLeft != 0 ) {
		String tanString = tanFiles.dequeue(); //get tanuki string
		_board.add( new Level( lvlNames.dequeue(), tanString ) );
		tanLeft--;
	    }
	    else {
		_board.add( new Level( lvlNames.dequeue() ) );
	    }
	}
	//end board/lvl setup

	/**********
	 * ACTUAL GAMEPLAY STUFF
	 **********/
	InputStreamReader isr = new InputStreamReader( System.in );
	BufferedReader in = new BufferedReader(isr); //these read user input
	String s; //this is where text to print goes
	String input = "1"; //by default backup choice is first choice
	
	s = "\n\nHello! Welcome to Mochiventures!\n";
	s += "Would you like to read the rules before you begin?\n";
	s += "\t1: Sure.\n2: No thanks, let's play!\n";
	System.out.print(s);
	
	//play or rules?

	try {
	    input = in.readLine();
	}
	catch (IOException e) { }
	
	if ( !( input.equals("1") ) && !( input.equals("2") ) ) {
	    input = "1";
	} //if user inputs something invalid
	
	int inst = Integer.parseInt( input );

	if ( inst = 1 ) {
	    try {
		Scanner rc = new Scanner( new File("Rules.txt") );
		String rules = "";
		while ( rc.hasNext() ) {
		    rules += rc.nextLine() + "\n";
		}
	    }
	    else {
		rules = "RULES AND STUFF.";
	    }
	    System.out.println(rules);
	    System.out.println("Now, what is your name?");
	    String name = sc.next();
	}
	else {
	    System.out.println("What is your name?");
	    String name = sc.next();
	}

	Player _player = new Player( name, _board.getRoot() );
	Board _board = new Board();
	int lvlcount = 0; //determines how much mochi you can get in a lvl 
	Tanuki _opponent; //basically a pointer i guess??

	while ( (_player.getHealth() != 0) && ( _board.getSize() > 0 ) ) {
	    int randmochi = (int)(Math.
	    String lvltxt = "Welcome to " _player.getLevel().getName() + "!\n";
	    lvltxt += _player.getLevel().getDescription() + "\n";
	    lvltxt += "You find " 

	    if ( _player.getLevel().hasTanuki() ) {

	    }
	}
	
	//when leveling up, _player.setlevel( _board.lvlupr/l() ) 

	//if ( _player.getlevel().hastanuki() )
	//    _opponent = _player.getlevel().gettanuki()
	//    SOP you ran into a tanuki, what do you do
	//    choices:
	//        run (damages yr health)
	//            _player.adjustHealth( _opponent.getHEffect() )
	//        throw _opponent.getMTax() mochi
	//            _player.useMochi( _opponent.getMTax() )
	//        answer question
	//            SOP _opponent.getDescription()
	//            user input string
	//            if _opponent.iscorrect(input)
	//                _player.obtainMochi( _opponent.getMTax )
	//            else
	//                _player.useMochi( _opponent.getMTax )
	//    level up l/r?
	
    }

}
