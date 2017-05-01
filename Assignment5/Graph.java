import java.util.Iterator;
import java.util.Vector;
import java.util.Stack;

public class Graph implements GraphADT {
	// Global variables
	Stack<Edge> edges = new Stack();
	Vector<Node> nodes;
	int n;

	/**
	 * Constructor creates an empty graph with n nodes and no edges The name of
	 * the nodes are 0, 1, ..., n-1
	 * */
	public Graph(int n) {
		// The number of nodes in the graph
		this.n = n;
		// create a set of new, empty nodes
		nodes = new Vector(n);
		for (int i = 0; i < n; i++) {
			nodes.add(i/* i=index of Vector list */, new Node(i)/* i=Node.name */);
		}
	}

	// u is the source, v is the destination
	@Override
	public void insertEdge(Node u, Node v, String type) throws GraphException {
		// If the name of the node is higher than the amount of nodes in the
		// graph, then the node does not exist and the edge cannot be added

		// This is based off of the Vector class method "get"
		try {
			getNode(u.getName());
			getNode(v.getName());
		} catch (GraphException e) {
			throw new GraphException("Nodes do not exist");
		}
		Edge e = new Edge(u, v, type);
		// Check if the edge e already exists
		if (areAdjacent(u, v)) {
			throw new GraphException("Edge already exists");
		}
		// add the edge to the Vector list
		// System.out.println("Inserting edge " + e.firstEndpoint().getName() + " " + e.secondEndpoint().getName());
		edges.push(e);
	}

	@Override
	public Node getNode(int name) throws GraphException {
		// The only way for a node to not exist in the Vector is if the node is
		// higher or lower than the amount of nodes (n) in the graph

		// Solution based of "get" method from Vector class (index < 0 || index
		// >=size())
		if (name >= n || name < 0)
			throw new GraphException("Node does not exist");

		return nodes.get(name);
	}

	@Override
	public Iterator incidentEdges(Node u) throws GraphException {
		try {
			getNode(u.getName());
		} catch (GraphException e) {
			throw new GraphException("Node does not exist");
		}
	    Iterator <Edge> iter = edges.iterator();
		Stack adjacent = new Stack();
		while(iter.hasNext())
		{
			Edge temp = iter.next();
			if (temp.firstEndpoint().equals(u) || temp.secondEndpoint().equals(u))
			{
				adjacent.push(temp);
			}
		}
		return adjacent.iterator();
	}

	@Override
	public Edge getEdge(Node u, Node v) throws GraphException {
		try {
			// Check if the nodes u and v exist
			getNode(u.getName());
			getNode(v.getName());
		} catch (GraphException e) {
			throw new GraphException("nodes do not exist");
		}

		// check if the edge is adjecent
		Iterator<Edge> iter = edges.iterator();
		while (iter.hasNext()) {
			Edge temp = iter.next();
			if (temp.firstEndpoint().equals(u)
					&& temp.secondEndpoint().equals(v)) {
				return temp;
			}
		}
		// if the iterator is finished and nothing has been returned, then the
		// edge does not exist
		throw new GraphException("edge does not exist");
	}

	@Override
	public boolean areAdjacent(Node u, Node v) throws GraphException {
		try {
			// Check if the nodes u and v exist
			getNode(u.getName());
			getNode(v.getName());
		} catch (GraphException e) {
			throw new GraphException("nodes do not exist");
		}
		Iterator<Edge> iter = edges.iterator();
		while (iter.hasNext()) {
			Edge temp = iter.next();
			// check if the first end point is u
			// and if the second end point is v
			if (temp.firstEndpoint().equals(u)
					&& temp.secondEndpoint().equals(v))
				return true;
			// check if the second end point is u
			// and if the first end point is v
			else if (temp.secondEndpoint().equals(u)
					&& temp.firstEndpoint().equals(v))
				return true;
		}
		return false;
	}
}
