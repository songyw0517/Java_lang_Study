import java.util.Arrays;

public class Function {
    public static void main(String[] args) {
        sayHello();
        sayHelloTo("test");
        System.out.println(Sum(10, 23));
        int[] sumAndProduct = addAndMultiply(2, 3);
        System.out.println(Arrays.toString(sumAndProduct));
    }
    // 반환x, 인자x  함수
    public static void sayHello(){
        System.out.println("Say hello");
    }
    // 반환x, 인자o 함수
    public static void sayHelloTo(String str){
        System.out.println(str);
    }
    // 반환o, 인자O 함수
    public static int Sum(int a, int b){
        return a+b;
    }

    // 반환 값 : 배열 함수
    // 두 정수를 더한 값과 곱한 값을 반환
    public static int[] addAndMultiply(int a, int b){
        int sum = a+b;
        int product = a*b;
        int[] result = {sum, product};
        return result;
    }
}
