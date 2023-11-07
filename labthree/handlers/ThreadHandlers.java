// package labthree.handlers;

// import java.nio.file.Path;
// import java.nio.file.StandardWatchEventKinds;
// import java.nio.file.WatchEvent;
// import java.nio.file.WatchKey;
// import java.nio.file.WatchService;

// import labthree.models.Document;
// import labthree.utils.Utils;

// public class ThreadHandlers extends FilesHandler{
//         public ThreadHandlers(Path path, WatchService watchService){
//             super(path.toString(), watchService);
//         }

//         public void threadMonitor() {
//         try {
//             WatchKey key = watchService.take();
//             for(WatchEvent<?> ev : key.pollEvents()) {
//                 handleFileEvent(ev);
//             }
//             key.reset();
//         } catch (InterruptedException e) {
//             Thread.currentThread().interrupt();
//         }
//     }

//     private void handleFileEvent(WatchEvent<?> event) {
//         Path path = (Path) event.context();

//         if(event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
//             createFileEvent(path);
//         } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
//             modifyFileEvent(path);
//         } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
//             deleteFileEvent(path);
//         }
//     }

//     private void createFileEvent(Path path) {
//         System.out.println(path.getFileName().toString() + " - new file created at: " + Utils.formatTime(System.currentTimeMillis()));
//     }

//     private void modifyFileEvent(Path path) {
//         for(Document doc : docs) {
//             if(doc.getName().equals(path.getFileName().toString())) {
//                 System.out.println(path.getFileName().toString() + " - file changed at: " + Utils.formatTime(System.currentTimeMillis()));
//                 break;
//             }
//         }
//     }

//     private void deleteFileEvent(Path path) {
//         System.out.println(path.getFileName().toString() + " - file deleted");
//     }

    
// }
