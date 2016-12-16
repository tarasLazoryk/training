package ua.training.textParser.model;

import ua.training.textParser.model.entity.TextElement;
import ua.training.textParser.model.entity.RegularExpression;
import ua.training.textParser.model.entity.composite.CompositeTextElement;
import ua.training.textParser.model.entity.composite.Sentence;
import ua.training.textParser.model.entity.composite.Text;
import ua.training.textParser.model.entity.leaf.Separator;
import ua.training.textParser.model.entity.leaf.Word;
import ua.training.textParser.model.textreader.TextParserReader;
import ua.training.textParser.model.textreader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Implementation of Model
 *
 * @author Taras Lazoryk
 */
public class TextParserModel implements Model {

	/**
	 * Reader of text from file
	 */
	private Reader reader = new TextParserReader();

	/**
	 * Text composite
	 */
	private CompositeTextElement text = new Text();

	/**
	 * Model getText() realization 
	 */
	@Override
	public String getText(String filePath) throws IOException {
		return reader.getText(filePath);
	}

	/**
	 * Model processText() realization 
	 */
	@Override
	public String processText(String inputText) {
		this.text.parse(clearSpaces(inputText));
		removeCode();
		return this.text.toString();
	}

	/**
	 * Model getWordsWithLettersAmount() realization 
	 */
	@Override
	public List<Word> getWordsWithLettersAmount(int amountOfLetters) {
		return getWordsWithLength(amountOfLetters);
	}

	String clearSpaces(String input) {
		String replacement = " ";
		return input.replaceAll(RegularExpression.CLEAR_SPACES_PATTERN, replacement);
	}

	/**
	 * Removes code from sentence
	 *
	 * @param sentence Sentence
	 */
	public void removeCode() {
		boolean delete = false;
		for (TextElement sentence : this.text.getSubElements()) {
			delete = removeFromSentence((Sentence)sentence, delete);
		}	
		
	}
	
	/**
	 * Method which detects start by a special word of code in sentence
	 * sets flag delete as true and delete sentenceParts until find word
	 * which represents end of code block. Returns true if code block do
	 * If code block doesn't end in the sentence returns true, if not 
	 * returns false., 
	 * 
	 * @param sentence sentence from which words will be deleted
	 * @param delete flag which equals true if start of code block
	 * started in previouse sentence and false if it is not.
	 * @return true if end code block started and didn't finished and
	 * false is code block isn't started.
	 */
	private boolean removeFromSentence(Sentence sentence, boolean delete) {
		//boolean delete = delete;
		for (int i = 0; i < sentence.getSubElements().size(); i++) {
			if (sentence.getSubElements().get(i).toString().matches(RegularExpression.CODE_START)) {
				delete = true;			
				
			}else if (sentence.getSubElements().get(i).toString().matches(RegularExpression.CODE_END)){
				delete = false;
				sentence.getSubElements().remove(i);
				i--;
			}
			if (delete) {
				sentence.getSubElements().remove(i);
				i--;
			}
		}
		return delete;
	}
	
	/**
	 * Method which gets words with specified length
	 * from questions.
	 * 
	 * @param length length
	 * @return list of words 
	 */
	List<Word> getWordsWithLength(int length) {
		List<Word> result = new ArrayList<>();
		for (TextElement element : text.getSubElements()) {
			if (isQuestion((Sentence) element)) {
				addSuitableWords((Sentence) element, length, result);
			}
		}
		return result;
	}

	/**
	 * Checks is the sentence is a question
	 * 
	 * @param sentence
	 * @return
	 */
	boolean isQuestion(Sentence sentence) {
		int sentenceIndex = sentence.getSubElements().size() - 1;
		while (sentenceIndex >= 0 && sentence.getSubElements().get(sentenceIndex) instanceof Separator) {
			if (sentence.getSubElements().get(sentenceIndex).toString().equals(RegularExpression.ASKING_SEPARATOR)) {
				return true;
			}
			sentenceIndex--;
		}
		return false;
	}

	/**
	 * Method which adds suitable words to the list.
	 * 
	 * @param sentence sentence from which words will be got.
	 * @param amountOfLetters amount of letters of the suitable word
	 * @param words List which will be filled with suitable words
	 */
	void addSuitableWords(Sentence sentence, int amountOfLetters, List<Word> words) {
		for (TextElement element : sentence.getSubElements()) {
			if (element instanceof Word) {
				Word wordElement = (Word) element;
				if (wordElement.size() == amountOfLetters) {
					words.add(wordElement);
				}
			}
		}
	}

}
