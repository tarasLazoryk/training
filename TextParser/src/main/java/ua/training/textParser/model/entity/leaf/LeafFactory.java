package ua.training.textParser.model.entity.leaf;

/**
 * Leaf factory interface
 * 
 * @author Taras Lazoryk
 *
 */
public interface LeafFactory {

	/**
	 * Checks is inputed word exist in words Map.
	 * If it is not add it to the words Map.
	 *
	 * @param text text of word
	 * @return reference to Word object
	 */
	Word createWord(String word);

	/**
	 * Checks is inputed separator exist in separators Map.
	 * If it is not add it to the separators Map.
	 *
	 * @param separator text of separators mark
	 * @return reference to Separator object
	 */
	Separator createSeparator(String separator);

}