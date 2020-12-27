import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLOutput;

public class PathsMain {

    public static void main(String[] args) {
        try {
//            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.createFile(fileToCreate);
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples","Dir4");
//            Files.createDirectories(dirToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples","Dir2/Dir3/Dir4/Dir5/Dir6");
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples/Dir2/Dir3/Dir4/Dir5/Dir6/Dir7");
//            Files.createDirectories(dirToCreate);

            Path filePath = FileSystems.getDefault().getPath("Examples","Dir1/file1.txt");
            long size = Files.size(filePath);
            System.out.println("Size = " + size);
            System.out.println("Last modified = " + Files.getLastModifiedTime(filePath));

            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("size = " + attrs.size());
            System.out.println("Last modified = " + attrs.lastModifiedTime());
            System.out.println("Is directory = " + attrs.isDirectory());
//            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1","file1copy.txt");
//            Files.deleteIfExists(fileToDelete);
//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.move(fileToMove, destination);

//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//            Files.move(fileToMove, destination);
//            Path sourceFile = FileSystems.getDefault().getPath("Examples","file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples","file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            sourceFile = FileSystems.getDefault().getPath("Examples","Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples","Dir4");
//
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        //        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFIle.txt");
        //        printFile(path);
        //
        ////        Path filePath = FileSystems.getDefault().getPath("files","subDirectoryFile.txt");
        //        Path filePath = Paths.get(".","files", "subDirectoryFile.txt");
        //        printFile(filePath);
        //
        //        filePath = Paths.get("/Users/andrei.baltat/Desktop/AllJava/RepoMeditatii/OutThere.txt");
        //        printFile(filePath);
        //
        //        filePath = Paths.get(".");
        //        System.out.println(filePath.toAbsolutePath());
        //
        //        Path path2 = FileSystems.getDefault().getPath(".","files", "..", "files","subDirectoryFile.txt");
        //        System.out.println(path2.normalize().toAbsolutePath());
        //
        //        Path path3 = FileSystems.getDefault().getPath("thisfiledoesntexits.txt");
        //        System.out.println(path3.toAbsolutePath());
        //
        //        Path path4 = Paths.get("/volumes/TEST/ing","abcdf", "bla.txt");
        //        System.out.println(path4.normalize().toAbsolutePath());
        //
        //        filePath = FileSystems.getDefault().getPath("files");
        //        System.out.println("Exits = " + Files.exists(filePath));
        //
        //        filePath = FileSystems.getDefault().getPath("zaza");
        //        System.out.println("Exits = " + Files.exists(filePath));
    }

//    private static void printFile(Path path){
//        try(BufferedReader fileReader = Files.newBufferedReader(path)){
//            String line;
//            while ((line = fileReader.readLine()) != null){
//                System.out.println(line);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }
}
