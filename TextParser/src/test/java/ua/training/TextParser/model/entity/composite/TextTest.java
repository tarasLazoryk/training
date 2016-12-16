package ua.training.TextParser.model.entity.composite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ua.training.textParser.model.entity.TextElement;
import ua.training.textParser.model.entity.composite.Sentence;
import ua.training.textParser.model.entity.composite.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taras Lazoryk.
 */
public class TextTest {

    private Text text;
    private String testString;

    @Before
    public void init() {
        text = new Text();
        testString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do" +
                " eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo" +
                " consequat.";
    }


    @Test
    public void parseTest() throws Exception {
        text.parse(testString);
        Assert.assertEquals(testString.split("\\.").length, text.getSubElements().size());
    }

    @Test
    public void parseTestEquals() {
        text.parse(testString);
        List<TextElement> expectedList = new ArrayList<>();
        Sentence sentence1 = new Sentence();
        sentence1.parse("Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        Sentence sentence2 = new Sentence();
        sentence2.parse(" Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                "laboris nisi ut aliquip ex ea commodo consequat.");
        expectedList.add(sentence1);
        expectedList.add(sentence2);
        Assert.assertEquals(expectedList, text.getSubElements());
    }

}