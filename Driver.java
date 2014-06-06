import java.io.*;
import java.util.*;

public class Driver {

    Tanuki _opponent;

    public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);

	System.out.println("Hello! Welcome to Mochiventures");
	System.out.println("What is your name?");
	String name = sc.next();
	
	Player _player = new Player(name);
	Board _board = new Board();

	String[] lvlNames = new String[]; //ah shit gotta make it a queue
	int count = 0;

	//gotta make this read in file of filenames!
	try {
	    Scanner sc = new Scanner( new File("LevelNames.txt") );
	    while ( sc.hasNext() ) {
		lvlNames[count] = sc.nextLine() + ".txt";
	    }
	}
	catch (Exception e) {
	    System.out.println("FILE NOT FOUND, YOU ARE A FAILURE AND SHOULD FEEL BAD.");
	}

	for ( String lvlnm : lvlNames ) {
	    _board.add( new Level(lvlnm) );
	}

	//when leveling up, _player.setlevel( board.lvlupr/l() ) 

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
