import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        // 정수 입력받기
        int num = Integer.parseInt(scanner.nextLine());
        System.out.println(num);
        // 문자열 입력 받기
        String str = scanner.nextLine();
        System.out.println(str);

        // 문자열 비교
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(str1.equals(str2));

    }
}
