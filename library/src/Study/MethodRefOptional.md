# 메소드 참조
- 람다식을 잘 이해하고 보자
- 람다식보다 조금 더 코드를 단순하게 할 수 있다.

## 메소드 참조의 4가지 유형
- static 메소드의 참조
- 참조변수를 통한 인스턴스 메소드 참조
- 클래스 이름을 통한 인스턴스 메소드 참조
- 생성자 참조

## 1. static 메소드의 참조
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

class ArrangeList {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 3, 5, 7, 9);
        ls = new ArrayList<>(ls);
        
        /** static 메소드를 참조**/
        /** 이 부분을 간단히 바꿀 수 있다.**/        
        Consumer<List<Integer>> c = l -> Collections.reverse(l);
        
        c.accept(ls); // accept는 약속에 근거하여 reverse를 수행한다.
        System.out.println(ls);
    }
}
```

```java
/** 변경 후 **/
Consumer<List<Integer>> c = Collections::reverse;
```

## 2. 인스턴스 메소드의 참조

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

class JustSort {
    public void sort(List<?> list) {
        Collections.reverse(lst);
    }
}

class ArrangeList3 {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 3, 5, 7, 9);
        ls = new ArrayList<>(ls);
        JustSort js = new JustSort();

        /** 인스턴스 js의 sort() 메소드를 참조 **/
        /** 이 부분 또한 바꿀 수 있다. **/
        Consumer<List<Integer>> c = e -> js.sort(e);
        c.accept(ls);
        System.out.println(ls);
    }
}
```
```java
/** 변경 후 **/
Consumer<List<Integer>> c = js::sort;
```
- 조건 : 위의 js는 effectively final이어야 한다.
  - effectively final?
    - 사실상 상수임을 의미한다.
  - 왜 조건이 있을까?
    - 조건이 없을경우 예측 불가능한 코드가 될 수 있기 때문이다.
    - 즉, 안전성 때문에 조건이 붙었다.

## forEach 메소드

```java
import java.util.Arrays;

class ForEachDemo {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Box", "Robot");
        
        /** forEach메소드에 메소드를 전달한다. **/
        ls.forEach(s -> System.out.println(s)); // 람다식 기반
        ls.forEach(System.out::println); // 메소드 참조 기반
    }
}
```
- forEach : Python의 map과 같은 기능을 수행

## 3. 인스턴스 없이 인스턴스 메소드 참조

```java
import java.util.function.ToIntBiFunction;

class IBox {
    private int n;

    public IBox(int i) {
        n = i;
    }

    public int larger(IBox b) {
        if (n > b.n)
            return n;
        else
            return b.n;
    }
}

    public static void main(String[] args) {
        IBox ib1 = new IBox(5);
        IBox ib2 = new IBox(7);

        /** 인스턴스 없이 메소드 참조 **/
        /** 이 부분 또한 약속에 근거하여 간단히 할 수 있다. **/
        // 두 상자에 저장된 값을 비교하여 더 큰 값을 반환한다.
        ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2);
        int bigNum = bf.applyAsInt(ib1, ib2);
        System.out.println(bigNum);
    }
```
```java
/** 간단히 한 표현 **/
ToIntBiFunction<IBox, IBox> bf = IBox::larger;
```

## 4. 생성자 참조
- 람다식을 작성시, 인스턴스 생성 후, 참조 값을 반환하는 경우가 있다.
- 이때 메소드 참조 방식을 사용할 수 있다.
```java
class StringMaker{
    public static void main(String[] args) {
        
        /** 이 부분이 생성자 참조, 약속에 근거하여 간단히 할 수 있다. **/
        Function<cahr[], String> f = ar -> new String(ar);
        char[] src = {'R', 'O', 'B','O','T'};
        String str = f.apply(src);
        System.out.println(str);
    }
}
```
```java
/** 간단히 한 표현 **/
Function<char[], String> f = String::new; 로 변경 가능하다.
```