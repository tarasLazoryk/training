package ua.training.textParser.model.entity.composite;

import ua.training.textParser.model.entity.TextElement;
import ua.training.textParser.model.entity.RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CompositeTextElement implementation
 * Represents text
 *
 * @author Taras Lazoryk
 */
public class Text extends CompositeTextElement {

	/**
     * Parses text with RegularExpression.
     * Creates new Sentence objects 
     *
     * @param text text to form sentence
     */
    @Override
    public void parse(String text) {
        Pattern pattern = Pattern.compile(RegularExpression.TEXT_REGEXP);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            TextElement sentence = new Sentence();
            sentence.parse(matcher.group());
            this.getSubElements().add(sentence);
        }
    }
}
