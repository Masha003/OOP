package labthree.enums;

import java.nio.file.Path;

public enum FileType {
    TEXT(".txt"),
    IMAGE(".png", ".jpg", ".jpeg"),
    SCRIPT(".java", ".py", ".go"),
    OTHER;

    private String[] extensions;

    FileType(String... ext){
        this.extensions = ext;
    }

    public static FileType getFileType(Path path){
        String fileName = path.getFileName().toString();
        for(FileType type : values()){
            for(String ext : type.extensions) {
                if(fileName.endsWith(ext)) {
                    return type;
                }
            }
        }
        return OTHER;
    }

}