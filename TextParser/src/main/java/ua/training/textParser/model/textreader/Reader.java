package ua.training.textParser.model.textreader;

import java.io.IOException;

/**
 * Text reader interface
 *
 * @author Taras Lazoryk
 */
public interface Reader {
    /**
     * Returns text from specified file
     *
     * @param filePath file path
     * @return text from file as String
     * @throws IOException reading exceptions
     */
    String getText(String filePath) throws IOException;
}
