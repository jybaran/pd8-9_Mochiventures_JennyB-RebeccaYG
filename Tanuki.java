import java.io.*;
import java.util.*;

public class Tanuki {

    String _question;
    String _answer;
    int _mochiTax;

    public Tanuki( String filename ) {
	_mochiTax = (int)( Math.random() * 5 ) + 1;
	
	String[] splitString = new String[2]; //change if more data
	int count = 0;
	try {
	    Scanner sc = new Scanner( new File( filename ) );
	    while ( sc.hasNext() ) {
		splitString[count] = sc.nextLine();
		count++;
	    }

	    _question = splitString[0];
	    _answer = splitString[1];
	}
	catch (Exception e) 
	    System.out.println("File not found, you are a failure and should feel bad.");
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
    
    public int getMTax() {
	return _mochiTax;
    }

    public boolean isCorrect( String ans ) {
	return ans.equals(_answer);
    }

    public static void main( String[] args ) {
	Tanuki teddy = new Tanuki("teddy.txt");
	System.out.println( teddy.getQuestion() );
	System.out.println( teddy.getAnswer() );
	System.out.println( teddy.getMTax() );
	System.out.println( teddy.isCorrect("fox") );
	System.out.println( teddy.isCorrect("LITERAL DONKEY BALLS.") );
    }

}