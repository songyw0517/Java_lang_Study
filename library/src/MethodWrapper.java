public class MethodWrapper {
    public static void main(String[] args) {
        /*********** Integer **********/
        Integer iObj = new Integer(10); // 박싱
        int num = iObj.intValue(); // 언박싱
        Integer iObjAuto = 10; // 오토 박싱
        int auto1 = iObjAuto; // 오토 언박싱
        int test1 = iObj; // 오토 언박싱
        iObj++;

        /************ Double ***********/
        Double dObj = new Double(3.14); // 박싱
        double num2 = dObj.doubleValue(); // 언박싱
        Double dObjAuto = 3.14; // 오토 박싱
        double auto2 = dObjAuto; // 오토 언박싱
        double test2 = dObj; // 이렇게도 오토 언박싱이 된다.

        /************* Methods ***********/
        // valueOf : new 대신 사용하는 방법
        Integer n1 = Integer.valueOf(5);
        Integer n2 = Integer.valueOf("12344");

        // max, min, sum : 연산
        int Max = Integer.max(n1, n2);
        int Min = Integer.min(n1, n2);
        int Sum = Integer.sum(n1, n2);

        // 2진, 8진, 16진수 반환
        String bin = Integer.toBinaryString(12);
        String oct = Integer.toOctalString(12);
        String hex = Integer.toHexString(12);

        /*
        이론:
        - 래퍼인스턴스의 값은 '이뮤터블(immutable)'인스턴스이기에 변경이 불가능하다.
        - but 자동으로 지원해준다. ++, --, +, -, +=, -= 등의 연산을 지원해준다. // 오토 박싱과 오토 언박싱을 동시에 진행해준다.
        - 박싱
        - 언박싱
        - 오토 박싱
        - 오토 언박싱

        메소드
        - intValue() 등 : 값 가져오기
        - valueOf() : new Integer(5); 쓰기 싫어서 만듬
            - 장점 : Integer.valueOf("12123"); 하면 알아서 정수형으로 만들어줌
        - max
        - 

        */

        /*********** Number 클래스 ************/
        /*
        이론 : 모든 Wrapper 클래스의 부모 클래스

        추상 메소드 - 상속하는 자식이 모두 구현을 해야하는 메소드
        - intValue()
        - longValue()
        - doubleValue()
        - ...
        * */

    }
}
