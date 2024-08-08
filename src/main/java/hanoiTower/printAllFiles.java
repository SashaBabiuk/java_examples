package hanoiTower;

import java.io.File;
import java.nio.file.Files;

public class printAllFiles {
    public static void main(String[] args) {
        printAllFiles(new File(System.getProperty("user.home")));
    }

    public static void printAllFiles(File dir){
        for (File file : dir.listFiles()) {
            if(file.isDirectory()){printAllFiles(file);}
            else System.out.println(file);
        }
    }
}
