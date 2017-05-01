import java.util.Iterator;

public class OrderedDictionary implements OrderedDictionaryADT {
	private BinaryTreeNode<DictEntry> root;
	/*
	 * Creating an empty binary tree
	 */
	public OrderedDictionary() {
		root = null;
	}

	private int size() {
		// all nodes are null
		if (root == null)
			return 0;
		// return root + children
		else
			return 1 + root.numChildren();
	}

	private boolean isEmpty() {
		if (root == null || size() == 0)
			return true;
		else
			return false;
	}

	@Override
	/**
	 * Returns the definition of the given word, or it returns
	 * an empty string if the word is not in the dictionary.
	 * */
	public String findWord(String word) {
		BinaryTreeNode<DictEntry> current = root;
		String c = current.getElement().word();

		if (!c.equals(word)) {
			if (current.getLeft() != null && c.compareToIgnoreCase(word) > 0) {
				current = current.getLeft();
				c = find(word, current).getElement().word();
			} else if (current.getRight() != null) {
				current = current.getLeft();
				c = find(word, current).getElement().word();
			}
		}
		String result = "";
		if (c.equals(word))
			result = current.getElement().definition();
		return result;
	}

	private BinaryTreeNode<DictEntry> find(String word,
			BinaryTreeNode<DictEntry> next) {
		if (!next.getElement().word().equals(word)) {
			if (next.getLeft() != null
					&& next.getElement().word().compareTo(word) > 0)
				next = find(word, next.getLeft());
			else if (next.getRight() != null)
				next = find(word, next.getRight());
		}
		return next;
	}

	@Override
	public int findType(String word) {
		BinaryTreeNode<DictEntry> current = root;
		String c = current.getElement().word();

		if (!c.equals(word)) {
			if (current.getLeft() != null && c.compareToIgnoreCase(word) > 0) {
				current = current.getLeft();
				c = find(word, current).getElement().word();
			} else if (current.getRight() != null) {
				current = current.getLeft();
				c = find(word, current).getElement().word();
			}
		}
		int result = -1;
		if (c.equals(word))
			result = current.getElement().type();
		current = root;
		return result;
	}

	@Override
	public void insert(String word, String definition, int type)
			throws DictionaryException {
		DictEntry entry = new DictEntry(word, definition, type);
		BinaryTreeNode<DictEntry> temp = new BinaryTreeNode<DictEntry>(entry);
		// Helper strings to store the word of the specified element
		String t;
		String c;

		if (isEmpty()) {
			root = temp;
		} else {
			// check if the word is already there
			if (findWord(word).equals(definition))
				throw new DictionaryException("word exists");
			// a helper node to know what the root is
			BinaryTreeNode<DictEntry> current = root;
			// true if the element has been added
			boolean added = false;

			while (!added) {
				c = current.getElement().word();
				t = temp.getElement().word();
				if (t.compareTo(c) < 0) {
					if (current.getLeft() == null) {
						current.setLeft(temp);
						added = true;
					} else
						current = current.getLeft();
				} else {
					if (current.getRight() == null) {
						current.setRight(temp);
						added = true;
					} else
						current = current.getRight();
				}
			}// end while
		}// end else if
	}

	@Override
	public void remove(String word) throws DictionaryException {
	    if (!isEmpty()) {
	        //checks if the word is equal to the entrie's word
	        if (root.getElement().word().equals(word))
	            root = replacement(root);
	        else {
	            // parent is the node above current
	            BinaryTreeNode<DictEntry> current, parent = root;
	            boolean found = false;
	            // if lexicographically smaller than the root's word
	            if (word.compareTo(root.getElement().word()) < 0)
	                current = root.getLeft();
	            // if lexicographically higher than the root's word
	            else
	                current = root.getRight();
	            while (current != null && !found)
	            {
	                if (word.equals(current.getElement().word()))
	                {
	                    found = true;
	                    if (current == parent.getLeft())
	                        parent.setLeft(replacement(current));
	                    else
	                        parent.setRight(replacement(current));
	                } else {
	                    parent = current;

	                    if (word.compareTo(current.getElement().word()) < 0)
	                        current = current.getLeft();
	                    else
	                        current = current.getRight();
	                }// end if else
	            }// end while
	            if (!found)
	                throw new DictionaryException("The entry was not found");
	        }
	    }
	}

	private BinaryTreeNode<DictEntry> replacement(BinaryTreeNode<DictEntry> node) {
	    BinaryTreeNode<DictEntry> result = null;
	    // check if both sides are empty
	    if (node.getLeft() == null && node.getRight() == null)
	        result = null;
	    else if (node.getLeft() != null && node.getRight() == null)
	        result = node.getLeft();
	    else if (node.getLeft() == null && node.getRight() != null)
	        result = node.getRight();
	    // if both sides have an entry
	    else {
	        //helper positions
	        BinaryTreeNode<DictEntry> current = node.getRight();
	        BinaryTreeNode<DictEntry> parent = node;

	        //moving positions
	        while (current.getLeft() != null) {
	            parent = current;
	            current = current.getLeft();
	        }// end while

	        if (node.getRight() == current)
	            current.setLeft(node.getLeft());
	        else {
	            parent.setLeft(current.getRight());
	            current.setRight(node.getRight());
	            current.setLeft(node.getLeft());
	        }
	        result = current;
	    }// end if else
	    return result;
	}

	@Override
	public String successor(String word) {
		String result = "";
		ArrayUnorderedList<String> list = new ArrayUnorderedList<String>();
		// The only thing that changes is inOrder
		inOrder(root,list);
		if (!isEmpty()) {
			Iterator iter = list.iterator();
			if(list.contains(word))
				if(iter.hasNext()){
					result = (String) iter.next();
				}
		}
		return result;
	}

	@Override
	public String predecessor(String word) {
		String result = "";
		ArrayUnorderedList<String> list = new ArrayUnorderedList<String>();
		// Sort the list in reverse
		inOrderReverse(root,list);
		if (!isEmpty()) {
			Iterator iter = list.iterator();
			if(list.contains(word))
				if(iter.hasNext()){
					result = (String) iter.next();
				}
		}
		return result;
	}
	
	private void inOrder(BinaryTreeNode<DictEntry> node, ArrayUnorderedList <String> list) {
		if (node != null) {
			//left side
			inOrder(node.getLeft(), list);
			// Add the content from the node to the list
			list.addToRear(node.getElement().word());
			// right side
			inOrder(node.getRight(), list);
			}
		}
		
	private void inOrderReverse(BinaryTreeNode<DictEntry> node, ArrayUnorderedList <String> list) {
			if (node != null) {
				//right side
				inOrder(node.getRight(), list);
				// Add the content from the node to the list
				list.addToRear(node.getElement().word());
				// left side
				inOrder(node.getLeft(), list);
		}
	}
}