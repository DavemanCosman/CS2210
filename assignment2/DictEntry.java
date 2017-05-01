/**
 * @author Daveman
 * An entry of the dictionary, associating a configuration with its integer
 * score. Each board configuration will be represented as a String like so;
 * 1. starting from top left
 * 2. concatenate all characters placed
 * 3. moving from left to right and top to bottom.
 */
public class DictEntry {
	/**
	 * Constructor used to return a new DictEntry with a specified 
	 * configuration and score
	 * 
	 * String config is used as a key attribute for every DictEntry object
	 * int score is used to record the score of an entry;
	 * - 0 if human wins
	 * - 1 if undecided (no clear winner because of empty spaces)
	 * - 2 if draw
	 * - 3 if computer wins
	 * */
	// Variables declared to hold the entered config and score data.
	private String config;
	private int score;

	/* The config and score are entered upon creating a new Dic
	 * dictEntry
	 * */
	public DictEntry (String config, int score)
	{
		this.config = config;
		this.score = score;
	}
	
	/** Returns the configuration stored in the DictEntry
	 */
	public String getConfig()
	{
		return this.config;
	}
	
	/**
	 * Returns the score in the DicEntry
	 * 
	 * for reference, the scores are;
	 * 0 = HUMAN_WINS
	 * 1 = UNDECIDED (no clear win at this point)
	 * 2 = DRAW
	 * 3 = COMPUTER_WINS
	 * */
	public int getScore()
	{
		return this.score;
	}
}
