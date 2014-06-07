import java.io.*;
import java.util.*;
import RandQ.*;

public class Driver {

    private Tanuki _opponent;

    public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);

	System.out.println("Hello! Welcome to Mochiventures");
	System.out.println("What is your name?");
	String name = sc.next();
	
	Player _player = new Player(name);
	Board _board = new Board();

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
	    while ( tansc.hasNExt() ) {
		tanFiles.enQueue( tansc.nextLine() + ".txt" );
	    }
	}
	catch (Exception e) {
	    System.out.println("FILE NOT FOUND, YOU ARE A FAILURE AND SHOULD FEEL BAD.");
	}

	int tanLeft = 5; //number of tanuki to spaw in entire game

	while ( ! lvlName.isEmpty() ) {
	    int rand = (int)(Math.random() * 10 );
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
