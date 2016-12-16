package ua.training.textParser.model.textreader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * Class created to read text from the file.
 * Reader implementation
 *
 * @author Taras Lazoryk
 */
public class TextParserReader implements Reader {

    /**
     * Exception String constants
     */
    private static final String FILE_NOT_EXISTS = "Specified file doesn't exist";

    /**
     * File encoding
     */
    private static final String ENCODING = "UTF-8";

    /**
     * Reader getText() realization.
     */
    @Override
    public String getText(String filePath) throws IOException {
        Objects.requireNonNull(filePath);
        File file = new File(filePath);
        
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file),
                                        Charset.forName(ENCODING)))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
                result.append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage() + FILE_NOT_EXISTS);
        }
        return result.toString();
    }
}
