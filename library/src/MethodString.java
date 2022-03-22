import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MethodString {
    public static void main(String[] args) {
        // concat : 문자열을 합친다.
        String hello = "Hello";

        System.out.println("*".repeat(10)+"concat Example"+"*".repeat(10));
        System.out.println(hello.concat(" World!"));

        // split : 문자열을 '특정 문자'로 나눈다.
        System.out.println("*".repeat(10)+"split Example"+"*".repeat(10));
        String splitTest = "12,2,3,4,5,2";
        String[] splitTestArrary = splitTest.split(",");
        for(String str: splitTestArrary){
            System.out.println(str);
        }


    }
}
