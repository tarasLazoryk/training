package ua.training.textParser.model.entity.composite;

import ua.training.textParser.model.entity.TextElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents abstract composite
 *
 * @author Taras Lazoryk
 */
public abstract class CompositeTextElement implements TextElement {

    /**
     * List of sub elements of composite 
     */
    private List<TextElement> subElements = new ArrayList<>();

    @Override
    public abstract void parse(String text);

    public List<TextElement> getSubElements() {
        return subElements;
    }

    /**
     * Calls toString() method to all subElements.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextElement element :
        		subElements) {
            stringBuilder.append(element.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeTextElement)) return false;

        CompositeTextElement that = (CompositeTextElement) o;

        return subElements.equals(that.subElements);

    }

    @Override
    public int hashCode() {
        return subElements.hashCode();
    }
}
