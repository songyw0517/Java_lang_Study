import java.io.FileWriter;
import java.io.IOException;

public class FileOutput {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            // true : 파일을 덮어(새로) 쓰지 않고, 이어 붙이겠다는 뜻
            writer = new FileWriter("src/output1.txt", true);
        } catch (IOException e) {
            System.out.println("파일 생성에 실패했습니다.");
            System.exit(1);
        }

        try {
            writer.write("치킨을 살이 안찌나요?");
            writer.close();
        } catch (IOException e) {
            System.out.println("파일에 데이터를 쓰는데 실패했습니다.");
            System.exit(2);
        }

    }
}
