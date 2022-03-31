# 매개변수의 가변 인자 선언과 호출
```java
class Varargs{
    /** String으로 들어오는 값을 vargs에 모두 담겠다. 
     * vargs는 배열 참조 변수이므로, 배열에 접근하듯이 사용하면 된다. **/
    public static void showAll(String...vargs){
        System.out.println("LEN : "+vargs.length);
        
        for(String s : vargs)
            System.out.print(s + '\t');
        System.out.println();
    }
    public static void main(String[] args) {
        showAll("Box");
        showAll("Box", "Toy");
        showAll("Box", "Toy", "Apple");
    }
}
```
## 컴파일러의 변환
```java
public static void showAll(String...vargs) {...} // 이 코드를
public static void showAll(String[] vargs) {...} // 이 코드로 바꾼다.
```
