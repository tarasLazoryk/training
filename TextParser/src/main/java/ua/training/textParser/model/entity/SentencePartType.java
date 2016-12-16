package ua.training.textParser.model.entity;

/**
 * Enum with types of groups of regex for sentence
 *
 * @author Taras lazoryk
 */
public enum SentencePartType {
    WORD("word"), SEPARATOR("separator");

    private String type;

    SentencePartType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
