import java.io.*;
import java.util.*;

/*purpose of this class:
  like the "node" in the tree*/

public class Level {
    
    private String _name;
    private String _description;
    private Level _rightChild;
    private Level _leftChild;
    private Tanuki _tanuki;
    

    public Level ( String filename ) {
	_rightChild = null;
	_leftChild = null;
	_tanuki = null;

	String[] splitString = new String[2]; //change if more data
	try {
	    Scanner sc = new Scanner( new File( filename ) );
	    while ( sc.hasNext() ) {
		splitString[count] = sc.nextLine();
		count++;
	    }
	    _name = splitString[0];
	    _description = splitString[1];
	}
	catch (Exception e) {
	    System.out.println("File not found, you are a failure and should feel bad.");
	    _name = "307";
	    _description = "The CS Semiformal is in full swing but you didn't pay your dues so the drinks sheriff gives you dirty looks instead of cider.";
	}
    }

    public Level ( String filename, String tanukiFile) {
	this(filename);
	_tanuki = new Tanuki(tanukiFile);
    }

    // get methods
    public String getName() {
	return _name;
    }
    
    public String getDescription() {
	return _description;
    }

    public Level getRChild() {
	return _rightChild;
    }
    
    public Level getLChild() {
	return _leftChild;
    }

    public boolean hasTanuki() {
	return _tanuki != null;
    }

    public Tanuki getTanuki() {
	return _tanuki;
    }
    //end of get methods

    //set methods
    public void setRChild(Level l){
	_rightChild = l;
    }
    
    public void setLChild(Level l){
	_leftChild = l;
    }
    //end of set methods
    
    public static void main(String[] args){
	System.out.println("running running");
    }

    

}