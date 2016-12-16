package ua.training.textParser.model.entity.leaf;

import ua.training.textParser.model.entity.TextElement;

/**
 * Represents word from which sentence consists of.
 * Implements ElementOfText.
 * It is a leaf of composite.
 *
 * @author Taras Lazoryk
 */
public class Word implements TextElement {
	
    /**
     * String that contain word
     */
    private String word;

    /**
     * Default constructor
     */
    public Word() {}

    /**
     * Constructor with parameters. 
     * @param word word
     */
    public Word(String word) {
       this.word = word;
    }
    
    /**
     * Method which gets length of the word.
     * 
     * @return length of the word.
     */
    public int size(){
    	return word.length();
    }
    
    @Override
    public void parse(String word) {
        
    }

    @Override
    public String toString() {
        return word;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

}
