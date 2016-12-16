package ua.training.textParser.model.entity.leaf;

import ua.training.textParser.model.entity.TextElement;

/**
 * Represents separator from which sentence consists of.
 * Implements ElementOfText.
 * It is a leaf of composite.
 *
 * @author Taras Lazoryk
 */
public class Separator implements TextElement {

    /**
     * String that contains separator
     */
    private String separator;

    /**
     * Default constructor
     */
    public Separator() {}

    /**
     * Constructor with parameters
     * 
     * @param separator separator string
     */
    public Separator(String separator) {
        this.separator = separator;
    }
  
    @Override
    public String toString() {
        return separator;
    }

	@Override
	public void parse(String separator) {		
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((separator == null) ? 0 : separator.hashCode());
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
		Separator other = (Separator) obj;
		if (separator == null) {
			if (other.separator != null)
				return false;
		} else if (!separator.equals(other.separator))
			return false;
		return true;
	}
	
	
}
