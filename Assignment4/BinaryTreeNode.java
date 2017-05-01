/**
 * BinaryTreeNode represents a node in a binary tree with a left and 
 * right child.
 * 
 * Used with permission;
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 8/19/08
 * 
 * from CS 1027
 */

public class BinaryTreeNode<DictEntry>
{
   private DictEntry element;
   // Either left or right (or both) can be null
   private BinaryTreeNode<DictEntry> left, right;
/**
    * Creates a new tree node with the specified data.
    *
    * @param obj  the element that will become a part of the new tree node
   */
   BinaryTreeNode (DictEntry obj) 
   {
      setElement(obj);
      left = null;
      right = null;
   }

   /**
    * Returns the number of non-null children of this node.
    * This method may be able to be written more efficiently.
    *
    * @return  the integer number of non-null children of this node 
    */
   public int numChildren() 
   {
      int children = 0;

      if (left != null)
         children = 1 + left.numChildren();

      if (right != null)
         children += 1 + right.numChildren();

      return children;
   }
   
   // Setter and Getters
   public void setElement(DictEntry element) {
	this.element = element;
   }

   public DictEntry getElement() {
	return element;
   }

   public BinaryTreeNode<DictEntry> getLeft() {
	return left;
   }

   public void setLeft(BinaryTreeNode<DictEntry> left) {
	this.left = left;
   }

   public BinaryTreeNode<DictEntry> getRight() {
	return right;
   }

   public void setRight(BinaryTreeNode<DictEntry> right) {
	this.right = right;
   }
}

