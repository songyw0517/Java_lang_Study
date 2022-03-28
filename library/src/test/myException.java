/************************
* 예외 클래스 생성과 사용방법
*************************/
package test;

import java.util.Scanner;

// 예외 클래스 생성, Exception을 상속받는다.
class ReadAgeException extends Exception{
    public ReadAgeException(){
        // Throwable 클래스의 getMessage 메소드가 반환할 문자열을 지정한다.
        super("유효하지 않은 나이가 입력되었습니다.");
    }
}

public class myException {
    public static void main(String[] args) {
        System.out.println("나이 입력 ");
        try{
            int age = readAge();
            System.out.printf("입력된 나이 : %d \n", age);
        }catch (ReadAgeException e){
            System.out.println(e.getMessage());
        }
    }
    
    // ReadAgeException이 발생할 수 있는 함수,
    // 발생할 경우 이전함수로 ReadAgeException을 넘긴다.
    public static int readAge() throws ReadAgeException{
        Scanner kb = new Scanner(System.in);
        int age = kb.nextInt();

        // 컴파일적인 예외가 아닌, 요구사항에 대한 예외를 throw로 처리한다.
        if(age < 0){
            throw new ReadAgeException(); // 예외를 throw(던지며)하며 종료한다.
        }
        return age;
    }
}
