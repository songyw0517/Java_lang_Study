# 미리 정의되어 있는 함수형 인터페이스
- 정의되어 있는 모든 함수형 인터페이스를 암기할 필요는 없다.

## 대표적인 함수형 인터페이스
### Predicate<T>
- boolean test(T t) : 전달 인자를 근거로 참 또는 거짓을 반환
```java
public static int sum(Predicate<Integer> p, List<Integer> lst){
    int s = 0;
    for(int n : lst){
        if(p.test(n))
            s+=n;
    }
    return s;
}

public static void main(String[]args){
    List<Integer> list = Arrays.asList(1,5,7,9,11,12);
    int s;
    
    s = sum(n -> n%2 == 0, list); // Predicate에 람다식 전달
    System.out.println("짝수 합 : " + s);
        
    s = sum(n -> n%2 != 0, list);
    System.out.println("홀수 합 : " + s);
}
```
- #### Predicate<T> 의 친구들 (박싱, 언박싱 과정을 생략하기 위해..)
    - IntPredicate -> boolean test(int value) 
    - LongPredicate -> boolean test(long value)
    - DoublePredicate -> boolean test(double value)
    - BiPredicate<T, U> -> boolean test(T t, U u)

### Supplier<T>
- T get() : 메소드 호출시 무엇인가를 제공함
```java
public static List<Integer> makeIntList(Supplier<Integer> s, int n){
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<n; i++)
        list.add(s.get());
    return list;
}
public static void main(String[]args){
    Supplier<Integer> spr = () ->{
        Random rand = new Random();
        retrun rand.nextInt(50);
    };
    
    List<Integer> list = makeIntList(spr, 5);
    System.out.println(list);
    
    list = makeIntList(spr, 10);
    System.out.println(list);
}
```
- #### Supplier<T> 의 친구들 (박싱, 언박싱 과정을 생략하기 위해..)
    - IntSupplier -> int getAsInt()
    - LongSupplier -> long getAsInt()
    - DoubleSupplier -> double getAsInt()
    - BooleanSupplier -> boolean getAsInt()


### Consumer<T>
- void accept(T t) : 인자를 받아 들이기만 함
```java
public static void main(String[]args){
    Consumer<String> c = s -> System.out.println(s);
    c.accept("Pineapple");
    c.accept("Strawberry");
}
```
- #### Consumer<T> 의 친구들 (박싱, 언박싱 과정을 생략하기 위해..)
    - IntConsumer -> void accept(int value)
    - objIntConsumer -> void accept(T t, int value)
    - LongConsumer -> void accept(long value)
    - objLongConsumer -> void accept(T t, long value)
    - DoubleConsumer -> void accept(double value)
    - objDoubleConsumer -> void accept(T t, double value)
    - BiConsumer<T, U> -> void accept(T t, U u)
     
### Function<T, R> : T : 매개변수형, R : 반환형
- R apply(T t) : 입출력 출력이 있음
```java
class FunctionDemo{
  public static void main(String[] args) {
    // String을 받아 Integer로 반환할 것이다
    Function<String, Integer> f = s -> s.length();
    
    System.out.println(f.apply("Robot"));
    System.out.println(f.apply("System"));
  }
}
```
- #### Function<T, R> 의 친구들
  - IntToDoubleFunction
  - DoubleToIntFunction
  - IntUnaryOperator
  - DoubleUnaryOperator
  <br><br>
  - BiFunction<T, U, R>
  - IntFunction<R>
  - DoubleFunction<R>
  <br><br>
  - ToIntFunction<T>
  - ToDoubleFunction<T>
  - ToIntBiFunction<T, U>
  - ToDoubleBiFunction<T, U>
  <br><br>
  - UnaryOperator<T>
  - BinaryOperator<T>

# removeif 메소드
- Collection<E> 인터페이스의 디폴트 메소드이다.
```java
default boolean removeIf(Predicate<? super E> filter){ ... }
```
- Predicate<? super E>의 조건에 맞는 원소를 삭제하겠다는 의미를 가진다.

## removeif 메소드의 사용 1
```java
public static void main(String[]args){
    List<Integer> ls1 = Arrays.asList(1, -2, 3, -4, 5);
    ls1 = new ArrayList<>(ls1);
    
    List<Double> ls2 = Arrays.asList(-1.1, 2.2, 3.3, -4.4, 5.5);
    
    // 삭제 조건
    Predicate<Number> p = n -> n.doubleValue() < 0.0;
    ls1.removeIf(p);
    ls2.removeIf(p);
    
    System.out.println(ls1);
    System.out.println(ls2);
}
```
- 왜 Predicate<T>의 T에 Number을 전달했는가?
  - <? super E> 때문 (하한 제한)이다.
  - List<Integer>, List<Double> 둘 다 적용하기 위해 사용되었다.