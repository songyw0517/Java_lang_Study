package test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ThrowsExample {
    public static void main(String[] args) {
        try{
            md1();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void md1() throws IOException{
        md2();
    }
    public static void md2() throws IOException{
        Path file = Paths.get("C:\\Users\\sng22\\Desktop\\git\\Java_lang_Study\\library\\src\\Simple.txt");
        BufferedWriter writer = null;
        writer = Files.newBufferedWriter(file);
        writer.write('A');
        writer.write('Z');
        if(writer != null){
            writer.close();
        }

    }
}

