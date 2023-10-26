package labthree.handlers;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;

import labthree.enums.FileType;
import labthree.models.Document;
import labthree.models.TextFile;
import labthree.utils.Utils;
import labthree.models.Image;
import labthree.models.ScriptFile;


public class FileHandler {
    private Path folderPath;
    private long lastSnapshotTime;

    private List<Document> docs;
    private WatchService watchService;

    public FileHandler(Path path) {
        this.folderPath = path;
        this.lastSnapshotTime = System.currentTimeMillis();
        this.docs = new ArrayList<>();

        try {
            this.watchService = FileSystems.getDefault().newWatchService();
            folderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        populateDocuments();
    }

    private void populateDocuments() {
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath)) {
            for(Path path : stream) {
                FileType type = FileType.getFileType(path);
                docs.add(createDocument(type, path));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private Document createDocument(FileType type, Path path) {
        return switch (type) {
            case TEXT -> new TextFile(path);
            case IMAGE -> new Image(path);
            case SCRIPT -> new ScriptFile(path);
            default -> new Document(path);
        };
    }

    public void checkStatus() {
        System.out.println("Created snapshot at: " + Utils.formatTime(lastSnapshotTime));
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath)) {
            for(Path path : stream) {
                FileType type = FileType.getFileType(path);
                
                Document existingDoc = findDocByName(path.getFileName().toString());
                if(existingDoc != null) {
                    long lastModifiedTime = existingDoc.lastModified();
                    handleExistingDocument(existingDoc, lastModifiedTime);
                } else {
                    handleNewDocument(type, path);
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        removeDeletedDocuments();
    }

    public void printInformation(String fileName) {
        Document doc = docs.stream().filter(d -> d.getName().equals(fileName)).findFirst().orElse(null);

        if(doc != null) {
            System.out.println(doc.getInformation());
            return;
        } else {
            System.out.println("There is no file with such name: " + fileName);
        }
    }

    public void commitChanges() {
        lastSnapshotTime = System.currentTimeMillis();
        System.out.println("Snapshot time updated: " + Utils.formatTime(lastSnapshotTime));
    }

    private Document findDocByName(String fileName) {
        return docs.stream()
                .filter(doc -> doc.getName().equals(fileName))
                .findFirst()
                .orElse(null);
    }

    private void handleExistingDocument(Document doc, long lastModifiedTime) {
        if (lastModifiedTime > lastSnapshotTime) {
            System.out.println(doc.getName() + " - Modified at " + Utils.formatTime(lastModifiedTime));
        } else {
            System.out.println(doc.getName() + " - No change since " + Utils.formatTime(lastModifiedTime));
        }
    }

    private void handleNewDocument(FileType type, Path path) {
        docs.add(createDocument(type, path));
        Document lastAddedRecord = docs.get(docs.size() - 1);
        System.out.println(lastAddedRecord.getName() + " - New file created at " + lastAddedRecord.getCreationTime());
    }

    private void removeDeletedDocuments() {
        List<Document> files = new ArrayList<>();
        for(Document doc : docs) {
            boolean found = false;
            try(DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath)) {
                for(Path path : stream) {
                    if(doc.getName().equals(path.getFileName().toString())) {
                        found = true;
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(!found) {
                System.out.println("Deleted file: " + doc.getName());
                files.add(doc);
            }
        }
        
        docs.removeAll(files);
    }        
}
