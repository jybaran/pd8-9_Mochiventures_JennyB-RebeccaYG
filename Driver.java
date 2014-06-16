import java.io.*;
import java.util.*;
//import RandQ.*;

public class Driver {

    public static void main (String[] args) {
	Board _board = new Board();
	int numLvls = 0;

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
	lvlNames.sample();

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
	tanFiles.sample();

	int tanLeft = tanFiles.getSize(); //# of tanuki to spawn over all lvls

	numLvls = lvlNames.getSize();
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

	RQueue<String> itemFiles = new RQueue<String>();
	try {
	    Scanner filesc = new Scanner ( new File ("Items/Items.txt") ) ;
	    while (filesc.hasNext() ) {
		itemFiles.enqueue("Items/" + filesc.nextLine() + ".txt" );
	    } 
	} catch (Exception e) {
	    System.out.println("FILE NOT FOUND, YOU ARE A FAILURE AND SHOULD FEEL BAD" );
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
	Level currentLvl = _player.getLevel();
	ItemQueue iQ = new ItemQueue();


	while ( (_player.getHealth() != 0) && ( lvlcount < numLvls ) && (currentLvl != null)) {
	    lvlcount++;
	    currentLvl = _player.getLevel();
	    int randmochi = (int)( Math.random() * lvlcount ) + 1;
	    
	    //mochi
	    String lvltxt = "\n\nWelcome to " + currentLvl.getName() + "!\n";
	    lvltxt += currentLvl.getDescription() + "\n";
	    lvltxt += "\nYou found " + randmochi + " piece(s) of mochi!";
	    _player.obtainMochi(randmochi);

	    System.out.println(lvltxt);

	    //items
	    Random r = new Random();
	    int rand = r.nextInt(10);
	    String itemtxt = "";
	    if (rand < 7 && itemFiles.peekFront() != null){ // you will get an item
		String nextItem = itemFiles.dequeue();
		Item item = new Item(nextItem);
		itemtxt += "\nYou have found a new item, " + item.getName();
		itemtxt += "\nWhat would you like to do with it?";
		itemtxt += "\n\t1: Use it now";
		itemtxt += "\n\t2: Save it for later";
		System.out.println(itemtxt);
		try {
		    input = in.readLine();
		} catch (IOException e) { }
		
		if ( !(input.equals("1")) && !(input.equals("2"))){
		    input = "1";
		} else if (input.equals("1")){
		    System.out.println(item.getResponse());
		    System.out.println("You have gained " + item.getEffect() + " health points");
		} else {
		    System.out.println("Your item has been saved for later!");
		    iQ.enqueue(item);
		}
	    }
	    
	    //tanuki
	    if ( currentLvl.hasTanuki() ) {
		_opponent = currentLvl.getTanuki();
		int numMochi = _opponent.getMTax();
		String tantxt = "\nOh no! You ran into a tanuki!";
		tantxt += " The tanuki asks, \"" + _opponent.getQuestion() + "\"";
		tantxt += "\nWhat do you want do?";
		tantxt += "\n\t1: Give it " + numMochi + " piece(s) of mochi to leave you alone.";
		tantxt += "\n\t2: Run away!";
		tantxt += "\n\t3: Answer the question.";
		System.out.println( tantxt );

		try {
		    input = in.readLine();
		}
		catch (IOException e) { }
		
		if ( !( input.equals("1") ) && !( input.equals("2") ) && !(input.equals("3") ) ) {
		    input = "1";
		} //if user inputs something invalid
		
		int choice = Integer.parseInt(input);
		
		if ( choice == 1 ) {
		    _player.useMochi( numMochi );
		    System.out.println("You give the tanuki " + numMochi + " piece(s) of mochi and it goes away.");
		}
		else if ( choice == 2 ) {
		    int safe = (int)(Math.random() * 2);
		    if ( safe == 1 ) {
			System.out.println("You manage to get away safely.");
		    }
		    else {
			_player.useMochi( numMochi );
			System.out.println("The tanuki catches you and takes the " + numMochi + " piece(s) of mochi anyway.");
		    }
		}
		else {
		    System.out.println("What is your answer?");
		    String ans;
		    try {
			ans = in.readLine();
		    }
		    catch (IOException e) {
			ans = "wow yr face is hella cute";
		    }
		    
		    if ( _opponent.isCorrect(ans) ) {
			_player.obtainMochi(numMochi);
			System.out.println("Nice job! You get " + numMochi + " piece(s) of mochi, and the tanuki winks before walking away.");
		    }
		    else {
			_player.useMochi(numMochi);
			System.out.println("Aww, you were wrong. The correct answer was " + _opponent.getAnswer() + ". The tanuki takes " + numMochi + " piece(s) of mochi and shakes its head disapprovingly.");
		    }
		}
	    }

	    lvltxt = "Ready to move on? Pick where to go next!";
	    if ( currentLvl.getLChild() == null && currentLvl.getRChild() == null){
		lvltxt = "You have completed all the levels!";
		return;
	    } else if (currentLvl.getLChild() == null){
		lvltxt += "\n\t2: " + currentLvl.getRChild().getName();
	    } else if (currentLvl.getRChild() == null){
		lvltxt += "\n\t1: " + currentLvl.getLChild().getName();
	    } else {
		lvltxt += "\n\t1: " + currentLvl.getLChild().getName();
		lvltxt += "\n\t2: " + currentLvl.getRChild().getName();
	    }
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
	}//end while loop
	
    }//end main

}//end Driver
