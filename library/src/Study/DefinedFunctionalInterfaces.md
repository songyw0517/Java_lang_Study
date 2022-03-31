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
     
### Function<T, R>
- R apply(T t) : 입출력 출력이 있음

