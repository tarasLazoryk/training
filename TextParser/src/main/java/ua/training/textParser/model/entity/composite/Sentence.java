package ua.training.textParser.model.entity.composite;

import ua.training.textParser.model.entity.TextElement;
import ua.training.textParser.model.entity.SentencePartType;
import ua.training.textParser.model.entity.leaf.LeafFactory;
import ua.training.textParser.model.entity.RegularExpression;
import ua.training.textParser.model.entity.leaf.Word;
import ua.training.textParser.model.entity.leaf.Separator;
import ua.training.textParser.model.entity.leaf.TextParserLeafFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CompositeTextElement implementation
 * Represents sentence
 *
 * @author Taras Lazoryk
 */
public class Sentence extends CompositeTextElement {

    /**
     * Parses text with RegularExpression.
     * Creates new Word objects and Separator objects
     * objects
     *
     * @param text text to form sentence
     */
    @Override
    public void parse(String text) {
        Pattern pattern = Pattern.compile(RegularExpression.SENTENCE_REGEXP);
        Matcher matcher = pattern.matcher(text);
        LeafFactory leafFactory = new TextParserLeafFactory();
        while (matcher.find()) {
            if (matcher.group(SentencePartType.WORD.toString()) != null) {
                TextElement word = leafFactory.createWord(
                		matcher.group(SentencePartType.WORD.toString()));
                this.getSubElements().add(word);
            } else if (matcher.group(SentencePartType.SEPARATOR.toString()) != null) {
                TextElement separator = leafFactory.createSeparator(
                        matcher.group(SentencePartType.SEPARATOR.toString()));
                this.getSubElements().add(separator);
            }
        }
    }
}
