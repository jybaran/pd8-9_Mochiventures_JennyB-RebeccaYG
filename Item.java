import java.io.*;
import java.util.*;

public class Item {
    String _name;
    String _response;
    int _healthEffect;

    public Item( String filename ) {
	String[] splitString = new String[3]; //change if more data
	int count = 0;
	try {
	    Scanner sc = new Scanner( new File( filename ) );
	    while ( sc.hasNext() ) {
		splitString[count] = sc.nextLine();
		count++;
	    }

	    _name = splitString[0];
	    _response = splitString[1];
	    _healthEffect = Integer.parseInt( splitString[2] );
	}
	catch (Exception e) {
	    System.out.println("File not found, you are a failure and should feel bad.");
	    _name = "TINY CAR.";
	    _response = "THE CAR WAS FULL OF CAMELS, YOU ARE DAZED AND CONFUSED.";
	    _healthEffect = 0;
	}
    }

    public String getName(){
	return _name;
    }

    public String getResponse() {
	return _response;
    }

    public int getEffect() {
	return _healthEffect;
    }

    public static void main( String[] args ) {
	Item tinyCar = new Item( "tinycar.txt" );
	System.out.println( tinyCar.getName() );
	System.out.println( tinyCar.getResponse() );
	System.out.println( tinyCar.getEffect() );
    }
}