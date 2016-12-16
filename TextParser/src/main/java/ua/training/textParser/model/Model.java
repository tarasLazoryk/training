package ua.training.textParser.model;

import java.io.IOException;
import java.util.List;

import ua.training.textParser.model.entity.leaf.Word;

/**
 * Model interface
 *
 * @author Taras Lazoryk
 */
public interface Model {

	/**
	 * Method which gets text from file.
	 * 
	 * @param filePath path of the file to be readed.
	 * @return text from the file as String
	 * @throws IOException throws FileNotFoundException if file wasn't found.
	 */
	String getText(String filePath) throws IOException;

	/**
	 * Edit text
	 *
	 * @param text  to be edited.
	 * @return edited text.
	 */
	String processText(String text);

	/**
	 * Method which returns List of words, with specified amount of letters from
	 * the questions.
	 * 
	 * @param amountOfLetters  amount of letters
	 * @return List of words
	 */
	List<Word> getWordsWithLettersAmount(int amountOfLetters);
}
