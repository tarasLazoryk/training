package ua.training.textParser.model.entity.leaf;

import java.util.HashMap;
import java.util.Map;

import ua.training.textParser.model.entity.TextElement;

/**
 * Class which controls creation of leaf elements
 *
 * @author Taras Lazoryk
 */
public class TextParserLeafFactory implements LeafFactory {

    /**
     * Map of already created Word objects
     */
	private static Map<String, TextElement> textElements = new HashMap<>();

    /** (non-Javadoc)
	 * @see ua.training.textParser.model.entity.leaf.LeafFactory#createWord(java.lang.String)
	 */
    @Override
	public Word createWord(String word) {
    	textElements.putIfAbsent(word, new Word(word));
        return (Word)textElements.get(word);
    }

    /** (non-Javadoc)
	 * @see ua.training.textParser.model.entity.leaf.LeafFactory#createSeparator(java.lang.String)
	 */
    @Override
	public Separator createSeparator(String separator) {
    	textElements.putIfAbsent(separator, new Separator(separator));
        return (Separator)textElements.get(separator);
    }
}
