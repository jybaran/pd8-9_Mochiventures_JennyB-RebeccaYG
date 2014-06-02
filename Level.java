
import java.io.*;
import java.util.*;

/*purpose of this class:
  like the "node" in the tree*/


public class Level {
    
    private String description = "";
    private final int number;
    private Level parent;
    //question: do we want to have a child instance variable?
    //not sure i understand this? we have inst vars for both children?
    //also, do we need parent? (also how do we track if we've visted all the locations)
    private Level rightChild;
    private Level leftChild;
    private boolean visited;

    public Level (String filename, int n){
	number = n;
	parent = null;
	rightChild = null;
	leftChild = null;
	visited = true;
	
	try{
	    Scanner sc = new Scanner(new File(filename));
	    while ( sc.hasNext() )
		description = description + sc.nextLine();
	} catch (Exception e){
	    System.out.println("oops file not found");
	    description = "you need to read a file in";
	}

    }

    // get methods
    public String getDescription() {
	return description;
    }

    public int getNumber() {
	return number;
    }

    public Level getParent() {
	return parent;
    }
    
    public Level getRChild() {
	return rightChild;
    }
    
    public Level getLChild() {
	return leftChild;
    }

    public boolean visited() {
	return visited;
    }
    //end of get methods

    //set methods
    public void setParent (Level l){
	parent = l;
    }

    public void setRChild(Level l){
	rightChild = l;
    }
    
    public void setLChild(Level l){
	leftChild = l;
    }

    public void visit() {
	visited = false;
    }
    //end of set methods
    
    public static void main(String[] args){
	System.out.println("running running");
    }

    

}