/**
 * @author Daveman
 *
 */
public class Edge{
	//Global Variables
	private Node u, v;
	private String label, type;
	/**
	 * Constructor. The nodes are the endpoints of the edge.
	 * The type of edge will be stored as a string
	 * - "free" if the road is free
	 * - "toll" if the road charges
	 * 
	 * The program initially sets the string empty
	 * */
	public Edge (Node u, Node v, String type){
		/* 
		 * In the following diagram;
		 * - u is the first endpoint of edge a
		 * - v is the second endpoint of edge a
		 * 
		 *       u
		 *      /
		 *   a /
		 *    /
		 *   v
		 * 
		 * */
		
		this.u = u;
		this.v = v;
		this.type = type;
		this.label = "";
	}
	
	/** Return the first endpoint, node u
	 * */
	public Node firstEndpoint (){
		return u;
	}
	
	/** Return the second endpoint, node v
	 * */
	public Node secondEndpoint(){
		return v;
	}
	
	/** Return type of the edge; free or toll
	 * */
	public String getType (){
		return this.type;
	}
	
	/** Sets the label of the edge to the specified value
	 *  This method labels as "discovery" or "back"
	 * */
	public void setLabel (String label){
		this.label = label;
	}
	
	/** Gets the label of the edge
	 * */
	public String getLabel (){
		return label;
	}
}
