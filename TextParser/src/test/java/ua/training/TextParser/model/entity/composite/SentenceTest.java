package ua.training.TextParser.model.entity.composite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ua.training.textParser.model.entity.composite.Sentence;

/**
 * Created by Taras Lazoryk 
 */
public class SentenceTest {

    private Sentence sentence;
    String testString;

    @Before
    public void init() {
        testString = "Hello, my dear friend!";
        sentence = new Sentence();
        sentence.parse(testString);
    }

    @Test
    public void parseSizeTest() {
        int expectedSize = 9;
        int actualSize = sentence.getSubElements().size();
        Assert.assertEquals(expectedSize, actualSize);
    }


}