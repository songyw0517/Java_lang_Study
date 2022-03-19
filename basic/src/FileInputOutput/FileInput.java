package FileInputOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileInput {
    public static void main(String[] args) {
        /***********************************
        * FileInputStream : file을 읽는데 사용
        ************************************/
        FileInputStream inputStream = null;
        try {
            // FileInputOutput/test1 파일을 가져온다.
            inputStream = new FileInputStream("src/FileInputOutput/test1.txt");
        } catch (FileNotFoundException e) {
            System.out.println("파일이 존재하지 않습니다.");
        }
        System.out.println("파일 내용을 출력합니다.");
        Scanner reader = new Scanner(inputStream);
        while(reader.hasNextLine()){
            System.out.println(reader.nextLine());
        }
        System.out.println("\n");
        // reader 닫기
        reader.close();

        /************************************
        * FileWriter : file을 쓰는데 사용
        **************************************/
        System.out.println("파일 이름을 입력하세요");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        FileWriter writer = null;
        try {
            writer = new FileWriter("src/FileInputOutput/"+fileName);
        } catch (IOException e) {
            System.out.println("파일 생성에 실패했습니다.");
        }
        System.out.println("빈 줄에서 엔터치면 쓰기 종료");

        while(true){
            String input = scanner.nextLine();
            if (input.equals("")) {
                System.out.println("쓰기를 종료합니다.");
                break;
            }
            // 파일에 쓰기
            try {
                writer.write(input);
                // 개행 추가하기
                writer.write("\n");
            } catch (IOException e) {
                System.out.println("파일에 문자열을 쓰지 못했습니다.");
            }
        }
        // writer 닫기
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
