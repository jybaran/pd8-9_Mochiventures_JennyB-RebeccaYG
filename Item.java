import java.io.*;
import java.util.*;

public class Item {
    int health;
    String name;

    public Item(){
	health = 0;
	name = "generic name";
    }

    public String toString(){
	return name;
    }
}