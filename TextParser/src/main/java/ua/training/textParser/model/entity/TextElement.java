package ua.training.textParser.model.entity;

/**
 * Composite elements interface
 *
 * @author Taras Lazoryk
 */
public interface TextElement {

    /**
     * Method which assembles composite element from String parameter
     *
     * @param text data that is needed to assemble the element
     */
    void parse(String text);
}
