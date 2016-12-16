package ua.training.textParser.view;

/**
 * Interface of view
 *
 * @author Taras Lazoryk
 */
public interface View {

    String INPUT_PATH_TO_THE_FILE = "Text from file: ";
    String INPUT_AMOUNT_OF_LETTERS = "Input amount of letters, in words which you are looking for: ";
    String INCORRECT_VALUE = "Amount must be integer. Pleasa write again: ";
    String EDITED_TEXT_MESSAGE= "Edited text: ";

    /**
     * Prints message
     *
     * @param message message
     */
    void printMessage(String message);
}
