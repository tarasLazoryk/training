package ua.training.TextParser.model;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ua.training.textParser.model.TextParserModel;
import ua.training.textParser.model.entity.composite.Sentence;
import ua.training.textParser.model.entity.leaf.Word;


/**
 * Created by Taras Lazoryk 
 */
public class ParserModelTest {
    Sentence sentence;
    TextParserModel model;
    String testString;

    @Before
    public void init() {
        testString = "После списка модификаторов указывается ключевое слово class,"
        		+ "а затем имя класса - корректный Java-идентификатор? Таким образом, кратчайшим"
        		+ "объявлением класса может являться такой модуль компиляции:Example class A {}"
        		+ "EndExample Фигурные скобки обозначают тело класса, но о нем позже.";
        sentence = new Sentence();
        sentence.parse(testString);
        model = new TextParserModel();
    }

    @Test
    public void removeCode() throws Exception {   
    	String result = model.processText(testString);           
        String expectedString = "После списка модификаторов указывается ключевое слово class,"
        		+ "а затем имя класса - корректный Java-идентификатор? Таким образом, кратчайшим"
        		+ "объявлением класса может являться такой модуль компиляции:"
        		+ " Фигурные скобки обозначают тело класса, но о нем позже.";   
        Assert.assertEquals(expectedString, result);
    }    
    
    @Test
    public void findWordsWithLends() throws Exception {   
    	model.processText(testString); 
    	List<Word> result = model.getWordsWithLettersAmount(5);        
        Assert.assertEquals(4, result.size());
    }    

  
}