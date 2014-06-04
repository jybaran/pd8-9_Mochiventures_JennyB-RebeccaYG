import java.io.*;
import java.util.*;

public class Tanuki {

    String _question;
    String _answer;

    public Tanuki( String filename ) {
	String file = "";
	try {
	    Scanner sc = new Scanner( new File(filename) );
	    while ( sc.hasNext() ) {
		file = file + sc.nextLine();
	    }
	    String[] splitString = file.split("\n");
	    _question = splitString[0];
	    _answer = splitString[1];
	}
	catch (Exception e){
	    System.out.println("oops file not found");
	    file = "you need to read a file in";
	    _question = "WHAT IS THE AIRSPEED VELOCITY OF AN UNLADEN SWALLOW?";
	    _answer = "LITERAL DONKEY BALLS.";
	}
    }

    public String getQuestion() {
	return _question;
    }

    public String getAnswer() { //for testing purposes only
	return _answer;
    }

    public boolean isCorrect( String ans ) {
	return ans == _answer;
    }

    public static void main( String[] args ) {
	Tanuki teddy = new Tanuki("teddy");
	System.out.println( teddy.getQuestion() );
	System.out.println( teddy.getAnswer() );
	System.out.println( teddy.isCorrect("fox") );
	System.out.println( teddy.isCorrect("bear") );
	System.out.println( teddy.isCorrect("LITERAL DONKEY BALLS.") );
    }

}