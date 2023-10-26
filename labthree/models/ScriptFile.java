package labthree.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ScriptFile extends Document {

    public ScriptFile(Path path) {
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

    public int getClassCount() {
        int classCount = 0;

        try {
            BufferedReader reader = Files.newBufferedReader(toPath(), StandardCharsets.UTF_8);
            String line;

            while ((line = reader.readLine()) != null) {
                if ((line.contains(" class ") || line.trim().startsWith("class ") )&& !line.trim().startsWith("//")) {
                    classCount++;
                }
            }
            return classCount;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classCount;
    }

    public int getMethodCount() {
        int methodCount = 0;

        try {
            BufferedReader reader = Files.newBufferedReader(toPath(), StandardCharsets.UTF_8);
            String line;
            boolean insideMethod = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("def ") || (line.contains("public") && line.contains(" void "))) {
                    insideMethod = true;
                    methodCount++;
                } else if (insideMethod && line.trim().isEmpty()) {
                    insideMethod = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return methodCount;
    }

    @Override
    public String getInformation() {
        return super.getInformation() + "\nLine ount: " + getLineCount() + "\nClass count: " + getClassCount() + "\nMethod count: " + getMethodCount();
    }
    
}
