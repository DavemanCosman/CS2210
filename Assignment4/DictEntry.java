/**
 * @author Daveman
 * An entry of the dictionary
 */
public class DictEntry {
	// Variables declared to hold the entered config and score data.
	private String w;
	private String d;
	private int t;

	/* The constructor with data entered upon creating a new
	 * dictEntry
	 * */
	public DictEntry (String w, String d, int t)
	{
		this.w = w;
		this.d = d;
		this.t = t;
	}
	
	/** Returns the word stored in the DictEntry
	 */
	public String word()
	{
		return this.w;
	}
	
	/** Returns the definition for the word
	 * */
	public String definition ()
	{
		return this.d;
	}
	
	/** Returns the  in the type
	 * */
	public int type()
	{
		return this.t;
	}
}
