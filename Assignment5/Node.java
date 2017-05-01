import java.util.List;
/**
 * @author Daveman
 */
public class Node {
	
	// Global variables
	private boolean mark;
	private int name;
	/** Constructor creates an unmarked node with the given name.
	 * - The name of the node is an integer between 0 and n-1
	 * - n is the number of vertices in the graph to which the node belongs.
	 * */
	public Node (int name)
	{
		this.mark = false;
		this.name = name;
	}
	
	/** Marks the node with the specified value
	 * */
	public void setMark (boolean mark){
		this.mark = mark;
	}
	
	/** Returns the value with which the node has been markd
	 * */
	public boolean getMark (){
		return this.mark;
	}
	
	/**
	 * */
	public int getName(){
		return this.name;
	}
}
