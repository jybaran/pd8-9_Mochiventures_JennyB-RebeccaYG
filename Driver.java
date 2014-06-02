import java.io.*;
import java.util.*;

public class Driver {

    public static void main (String[] args) {
	/*Scanner sc = new Scanner(System.in);

	System.out.println("Hello! Welcome to Mochiventures");
	System.out.println("What is your name?");
	String s = sc.next();
	
	Player p = new Player(s);
	Board b = new Board();*/

	try{
	    Scanner sc = new Scanner(new File("Level1.txt"));
	    while ( sc.hasNext() )
		System.out.println(sc.nextLine());
	} catch (Exception e){
	    System.out.println("oops file not found");
	}
	
    }

}
