import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("src/chicken.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // inputStream을 보내어 src/chicken.txt를 읽어온다.
        Scanner scanner = new Scanner(inputStream);

        // scanner로부터 읽을 수 있는지 확인하는 메소드 : hasNextLine
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
