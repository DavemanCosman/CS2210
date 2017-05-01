import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Daveman
 * 
 */
public class Map {
	// Global Variables
	private LinkedList<String> s = new LinkedList<String>();
	private FileInputStream file;
	private DataInputStream in;
	private BufferedReader read;
	// w = width, l = length, k = # of toll roads allowed
	private int w, l, k;
	// reader for the input
	private String line;
	private Graph G;
	private char Map[][];
	// V are the nodes, start and end are reference nodes
	Node start, end;

	public Map(String inputFile) throws MapException {
		try {
			file = new FileInputStream(inputFile);
			in = new DataInputStream(file);
			read = new BufferedReader(new InputStreamReader(in));
			while ((line = read.readLine()) != null) {
				s.add(line);
			}
			in.close();
		} catch (Exception e) {
			throw new MapException("  File not found");
		}
		// The program does not need the scale factor
		s.remove(0);
		// Setting the width, length and # of toll roads allowed
		w = Integer.parseInt(s.removeFirst());
		l = Integer.parseInt(s.removeFirst());
		k = Integer.parseInt(s.removeFirst());

		// retrieves but does not remove the head of the list
		line = s.element();
		Map = new char[2 * w - 1][2 * l - 1];
		this.G = new Graph(w * l);
		
		try {
			// amount of rows
			for (int i = 0; i < (w * 2) - 1; i++) {
				line = s.removeFirst();
				for (int j = 0; j < (l * 2) - 1; j++) {
					Map [i][j]=line.charAt(j);
					if (line.charAt(j) == 's')
						start = G.getNode(i);
					else if (line.charAt(j) == 'e')
						end = G.getNode(i);
				}
			}
		} catch (Exception e) {
			throw new MapException("  error reading graph");
		}
	}

	public Graph getGraph() throws MapException {
		try {
			G.getNode(0);
		} catch (GraphException ex) {
			throw new MapException("Graph not defined");
		}
		return this.G;
	}

	public Iterator findPath() {
		// TODO pathFinder algorithm here
		return null;
	}
}
