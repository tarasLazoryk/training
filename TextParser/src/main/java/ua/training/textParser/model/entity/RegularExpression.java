package ua.training.textParser.model.entity;

/**
 * Interface with regex constants
 *
 * @author Taras Lazoryk
 */
public interface RegularExpression {
    String TEXT_REGEXP = "[-A-Za-zа-яА-ЯёЁ0-9,;()={}\\[\\]\\\"\\s]+[.?!:]";
    String SENTENCE_REGEXP = "(?<" + SentencePartType.WORD + ">[A-Za-zа-яА-ЯёЁ0-9]+)|" +
            "(?<" + SentencePartType.SEPARATOR + ">[-\\s,;:={}\\[\\]()-\\.?!\\\"]{1,1})";
    String CODE_START ="Example";
    String CODE_END = "EndExample";
    String CLEAR_SPACES_PATTERN = "[\\s]{2,}";
    String ASKING_SEPARATOR ="?";
}