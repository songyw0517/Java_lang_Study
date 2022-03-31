# 람다의 여러가지 표현식
## 람다와 함수형 인터페이스
- ### 함수형 인터페이스?
  - '추상 메소드가 하나인 인터페이스'를 말한다.
- ### 람다?
  - 주로 '인스턴스' 역할보다는 기능(메소드)를 수행하기 위해 사용된다.
## 상황 1
```java
import java.util.ArrayList;
import java.util.Collections;

class SLenComp implements Comparable<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}

class SLenComparator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Robot");
        list.add("Lambda");
        list.add("Box");

        Collections.sort(list, new SLenComp());
        /** 오른쪽 매개변수인 new SLenComp()에는 기능(메소드) 하나만이 들어간다. **/
        
        for(String s : list)
            System.out.println(s);

    }
}
```
- 주석에 써있듯, sort메소드의 오른쪽에는 무엇을 기준으로 할지를 결정하는 기능(메소드) 하나만이 들어간다.
- 람다는 이 부분에 있어서 좋은 역할을 수행한다.

# 람다의 여러가지 표현식
## 1. 매개변수가 있고, 반환하지 않는 람다식
```java
Printable p;

p = (String s) -> {System.out.println(s); }; // 줄이지 않고 쓴 표현
p = (String s) -> System.out.println(s); // 중괄호를 생략한 표현
p = (s) -> System.out.println(s); // 매개변수 타입 생략
p = s -> System.out.println(s); // 매개변수 소괄호 생략
```
- 만약 기능을 수행하는 코드가 2줄 이상일 경우 -> 중괄호 써야한다.
- 만약 매개변수가 2개 이상일 경우 -> 소괄호 써야한다.
## 매개변수가 두 개 라면?
```java
interface Calculate{
    void cal(int a, int b);
}

public static void main(String[] args) {
    Calculate c;
    c = (a, b) -> {System.out.println( a + b );}; // 람다식으로 덧셈 기능 지정
    c.cal(4, 3);
    c = (a, b) -> {System.out.println( a - b );}; // 람다식으로 뺄셈 기능 지정
    c.cal(4, 3);
}
```

## 2. 매개변수가 있고, 반환하는 람다식
```java
interface Calculate{
    int cal(int a, int b); // 인터페이스에 값을 반환하는 추상 메소드가 있다.
}

  public static void main(String[] args) {
    Calculate c;
    c = (a, b) -> { return a + b; }; // return 문이 있을 경우 -> 중괄호 필요
    System.out.println(c.cal(a, b));
    
    c = (a, b) -> a + b; // 연산 값만 남을 경우 -> return 필요X, 중괄호 안 써도 된다.
    System.out.println(c.cal(a, b));
  }
```
## 매개변수가 있고, 반환하는 람다식 2
```java
interface HowLong{
    int len(String s);
}

  public static void main(String[] args) {
    HowLong h1 = s -> s.length();
    System.out.println(h1.len("I am so happy"));
  }
```
- return 문이 있을 경우 (첫번째 람다식) -> 중괄호를 써야한다.
- 연산 결과가 남이 있을 경우 (두번째 람다식) -> return을 사용하지 않아도 알아서 반환된다. 
<br>따라서 중괄호를 쓰지 않아도 된다.

## 3. 매개변수가 없는 람다식

```java
import java.util.Random;

interface Generate {
  int rand();
}

  public static void main(String[] args) {
    Generate gen = () -> {
        Random rand = new Random();
        return rand.nextInt(50);
    };
    
    System.out.println(gen.rand());
  }
```
- ()를 통해 매개변수가 없음을 알린다.

## 4. 람다식과 제네릭
```java
@FunctionalInterface
interface Calculate <T>{
    T cal(T a, T b);
}

  public static void main(String[] args) {
    // Culculate<Integer>로 인터페이스의 T를 Integer로 결정했다.
    Calculate<Integer> ci = (a, b) -> a + b; 
    System.out.println(ci.cal(4, 3));
  }
```

