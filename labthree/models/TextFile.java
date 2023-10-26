package labthree.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class TextFile extends Document {

    public TextFile(Path path) {
        super(path);
    }

    public long getLineCount() {
        long lineNr = -1;
        
        try {
            try (Stream<String> fileStream = Files.lines(toPath(), StandardCharsets.UTF_8)) {
                lineNr = fileStream.count();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineNr;
    }

    public int getWordCount() {
        int count = 0;

        try(BufferedReader reader = Files.newBufferedReader(toPath(), StandardCharsets.UTF_8)) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                count += words.length;
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getCharacterCount() {
        int characterCount = 0;

        try (BufferedReader reader = Files.newBufferedReader(toPath(), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                characterCount += line.length();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characterCount;
    }






}