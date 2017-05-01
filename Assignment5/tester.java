import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileInputStream file;
		DataInputStream in;
		BufferedReader read;
		LinkedList <String> list = new LinkedList<String>();
		String line;

		try {
			file = new FileInputStream("map0.txt");
			in = new DataInputStream(file);
			read = new BufferedReader(new InputStreamReader(in));
			while ((line = read.readLine()) != null) {
				list.add(line);
			}
			System.out.println("The size of the list is " + list.size());
			in.close();
			list.remove();
			list.remove();
			list.remove();
			list.remove();
			System.out.println("This is the length of the map " + list.size());
			// list.getSize() is the amount of columns in the graph
			for (int i = 0 ; i < list.size(); i++){
				System.out.println(list.get(i));
			}
			// TODO reading map coordinates
		} catch (Exception e) {
			System.err.println();
		}
	}
}