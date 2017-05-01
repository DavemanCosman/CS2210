import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author David Cosman
 * 
 *         Hash Table that stores the possibilities for the AI's moves. Uses an
 *         array of Linked Lists to create the Hash Table and avoid cases of
 *         collisions overwriting entries.
 */
public class Dictionary implements DictionaryADT {

	// The size of the table
	private int M;
	/*
	 * Array of LinkedLists; the Dictionary
	 * 
	 * I chose a Linked List because every time there is an entry added in a
	 * position where something ALREADY exists, there is a collision When there
	 * is a collision, the LinkList will store it in the same part of the array
	 * on a node FOLLOWING the previous entry in that position.
	 * 
	 * Every time there is a collision, there will be another node connecting it
	 * to the previous entry. This way, a straight list is kept and there is no
	 * entries are overwritten.
	 */
	private LinkedList<DictEntry> library[];

	/**
	 * Constructor of Dictionary.
	 * 
	 * Initialises the Hash Table called library by creating new instances of
	 * new Linked Lists with DictEntry elements.
	 * 
	 * @param length
	 *            The length of the dictionary, initialised here and called back
	 *            to a variable named M declared at the top to avoid calling
	 *            Dictionary.length all the time.
	 * */
	@SuppressWarnings("unchecked")
	public Dictionary(int length) {
		// Set the length
		this.M = length;
		// declare the library
		library = (LinkedList<DictEntry>[]) new LinkedList[M];
		// fill the library with entries
		for (int i = 0; i < M; i++) {
			library[i] = new LinkedList<DictEntry>();
		}
	}

	/*
	 * Steps;
	 * 1. Check square for emptiness
	 * 2. Check to the right of the square if the row allows for a win condition
	 * 3. If true, check the following squares for the same symbol
	 * If no win;
	 * 4. Check to the bottom of the square if the row allows for a win condition
	 * 5. Repeat step 3.
	 * If no win;
	 * 6. Check to the bottom right of the square if the diagonal allows for a win
	 * 7. Repeat step 3.
	 * If no win;
	 * 8. Check to the bottom left of the square if the diagonal allows for a win
	 * 9. Repeat step 3.
	 * If no win, then there is no winner.
	 * 10. Keep playing or call a draw.
	 */
	
	/**
	 * Method h (Horner's Method)
	 * 
	 * Create a hash value for DictEntry elements using Horner's Method
	 * 
	 * @param config
	 *            the gameboard in String format
	 * 
	 * @return The modulo of the whole sum and the total length (M)
	 * */
	private int h(String config) {
		int sum = (int) config.charAt(config.length() - 1);
		// Loop to compute the sum of the Hash value of the gameboard
		for (int i = config.length() - 1; i >= 0; i--) {
			// Prime number 131 causes the fewest amount of collisions
			sum = (sum * (131) + (int) config.charAt(i)) % M;
		}
		return sum % M;
	}

	/**
	 * Method insert
	 * 
	 * Inserts the given DictEntry pair in the dictionary. This method throws a
	 * DictionaryException if the configuration in pair, pair.getConfig(), is
	 * already in the library
	 * 
	 * @param pair
	 *            the entry in the Dictionary being entered
	 * 
	 * @return 1 if a collision happens, 0 if no collision
	 * */
	@Override
	public int insert(DictEntry pair) throws DictionaryException {
		int position = h(pair.getConfig());
		// This is an iterator to help go through the list
		ListIterator<DictEntry> catalog = library[position].listIterator();
		// Temporary book value to help iterate the iterator
		DictEntry book = null;
		// When the slot at the hash table has a value in it, there's a
		// collision
		if (!library[position].isEmpty()) {
			// check if there are more values in the linked list iterator
			while (catalog.hasNext()) {
				// go to the next book in the library
				book = catalog.next();
				if (book.getConfig().equals(pair.getConfig()))
					throw new DictionaryException("Pair exists already");
			}
			// add the pair to the library's iterator, which references back to
			// the library
			catalog.add(pair);
			// collision happened, so returns 1.
			return 1;
		}
		// If the position is empty, then there are no collisions
		else {
			// If there is nothing
			library[position].add(pair);
			// No collisions
			return 0;
		}
	}

	/**
	 * method remove
	 * 
	 * Removes a book (dictEntry) from the library (Dictionary)
	 * 
	 * @param config
	 *            the entry in the Dictionary being removed
	 * */
	@Override
	public void remove(String config) throws DictionaryException {
		int position = h(config);
		ListIterator<DictEntry> catalog = library[position].listIterator();
		DictEntry book = null;

		// If the pair does exists
		if (!library[position].isEmpty()) {
			// While there are more items ahead
			while (catalog.hasNext()) {
				book = catalog.next();
				if (book.getConfig().equals(config)) {
					// Remove the entry from the iterator that references to the
					// library
					catalog.remove();
					return;
				}
			}
		}
		// If the pair is not found
		throw new DictionaryException("The entry does not exist");
	}

	@Override
	public int find(String config) {
		int position = h(config);
		ListIterator<DictEntry> catalog = library[position].listIterator();
		// Temporary book value to help iterate
		DictEntry book = null;
		// Check if the position isn't empty
		if (!library[position].isEmpty()) {
			while (catalog.hasNext()) {
				book = catalog.next();
				// Check if pair entry exists
				if (book.getConfig().equals(config))
					return book.getScore();
			}
		}
		// when pair entry doesn't exist
		return -1;
	}

	@Override
	public int numElements() {
		// The amount of spaces that contain DictEntries
		int entries = 0;
		for (int i = 0; i < M; i++) {
			// size function returns the number of entries in the dictionary
			entries += library[i].size();
		}
		return entries;
	}
}
