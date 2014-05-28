import java.io.*;
import java.util.*;

/*purpose of this class:
  like the "node" in the tree*/


public class Level {
    
    private final String name;
    private final int number;
    private Level parent;
    //question: do we want to have a child instance variable?
    //not sure i understand this? we have inst vars for both children?
    //also, do we need parent? (also how do we track if we've visted all the locations)
    private Level rightChild;
    private Level leftChild;

    public Level (String s, int n){
	name = s;
	number = n;
	parent = null;
	rightChild = null;
	leftChild = null;
    }

    // get methods
    public String getName() {
	return name;
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
    //end of set methods
    
    public static void main(String[] args){
	System.out.println("running running");
    }

    

}