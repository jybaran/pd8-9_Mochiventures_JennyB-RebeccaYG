import java.io.*;
import java.util.*;
//import RandQ.*;

public class Driver {

    public static void main (String[] args) {
	Board _board = new Board();

	/**********
	  * SETTING UP BOARD W/ LVLS, LVLS W/ TANUKI
	  **********/
	//reads in file of lvl filenames, makes randq
	RQueue<String> lvlNames = new RQueue<String>();

	try {
	    Scanner lvlsc = new Scanner( new File("Levels/LevelNames.txt") );
	    while ( lvlsc.hasNext() ) {
		lvlNames.enqueue( "Levels/" + lvlsc.nextLine() + ".txt" );
	    }
	}
	catch (Exception e) {
	    System.out.println("FILE NOT FOUND, YOU ARE A FAILURE AND SHOULD FEEL BAD.");
	}

	//reads in file of tanuki filenames, makes randq
	RQueue<String> tanFiles = new RQueue<String>();

	try {
	    Scanner tansc = new Scanner( new File("Tanuki/TanukiFiles.txt") );
	    while ( tansc.hasNext() ) {
		tanFiles.enqueue("Tanuki/" + tansc.nextLine() + ".txt" );
	    }
	}
	catch (Exception e) {
	    System.out.println("FILE NOT FOUND, YOU ARE A FAILURE AND SHOULD FEEL BAD.");
	}

	int tanLeft = tanFiles.getSize(); //# of tanuki to spawn over all lvls

	//building board from rqueue of lvls
	while ( ! lvlNames.isEmpty() ) {
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
	s += "\t1: Sure.\n\t2: No thanks, let's play!\n";
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
	String name = "";

	if ( inst == 1 ) {
		String rules = "\n\n";
	    try {
		Scanner rc = new Scanner( new File("Rules.txt") );
		while ( rc.hasNext() ) {
		    rules += rc.nextLine() + "\n";
		}
	    }
	    catch ( IOException e ) {
		rules = "RULES AND STUFF.";
	    }
	    System.out.println(rules);
	    System.out.println("Now, what is your name?");
	    try {
		name = in.readLine();
	    }
	    catch (IOException e) {
		name = "Kia";
	    }
	}
	else {
	    System.out.println("What is your name?");
	    try {
		name = in.readLine();
	    }
	    catch (IOException e) {
		name = "Kia";
	    }
	}

	Player _player = new Player( name, _board.getRoot() );
	int lvlcount = 0; //determines how much mochi you can get in a lvl 
	Tanuki _opponent; //basically a pointer i guess??

	while ( (_player.getHealth() != 0) && ( _board.getSize() > 0 ) ) {
	    lvlcount++;
	    Level currentLvl = _player.getLevel();
	    int randmochi = (int)( Math.random() * lvlcount ) + 1;
	    
	    String lvltxt = "Welcome to " + currentLvl.getName() + "!\n";
	    lvltxt += currentLvl.getDescription() + "\n";
	    lvltxt += "You found " + randmochi + " piece(s) of mochi!";
	    _player.obtainMochi(randmochi);

	    System.out.println(lvltxt);

	    if ( currentLvl.hasTanuki() ) {

	    }
	    else { //lvl selection
		lvltxt = "Ready to move on? Pick where to go next!";
		lvltxt += "\n\t1: " + currentLvl.getLChild().getName();
		lvltxt += "\n\t1: " + currentLvl.getRChild().getName();
		System.out.println(lvltxt);

		try {
		    input = in.readLine();
		}
		catch (IOException e) { }
		
		if ( !( input.equals("1") ) && !( input.equals("2") ) ) {
		    input = "1";
		} //if user inputs something invalid
		
		int choice = Integer.parseInt(input);
		
		if ( choice == 1 ) {
		    _player.setLevel( _board.levelUpLeft() );
		}
		else {
		    _player.setLevel( _board.levelUpRight() );
		}
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
