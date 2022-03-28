# 제한된 와일드 카드 선언을 갖는 제네릭 메소드
```java
class Box<T>{
    private T ob;
    public void set(T o){ ob = o;}
    public T get() {return ob;}
}
class Toy{
    public String toString(){return "I am a Toy";}
}
class BoxHandler{
    public static void outBox(Box<? extends Toy> box){
        Toy t = box.get();
        System.out.println(t);
    }
    public static void inBox(Box<? super Toy> box, Toy n){
        box.set(n);
    }
}
```
## 코드의 이해 순서
```java
public static void outBox(Box<? extends Toy> box)
```
1. ?에 Toy가 올 수 있구나 -> Box<Toy> 가능하구나
2. extends니까 꺼내는 것(get)만 가능하겠구나 -> box.get()
```java
public static void inBox(Box<? super Toy> box, Toy n)
```
1. ?에 Toy가 올 수 있구나 -> Box<Toy> 가능하겠구나
2. super니까 넣기만(set)만 가능하겠구나 -> box.set()
<br><br>

### 만약 Box<? extends Toy> 부분에 Toy를 상속하는 Robot을 넣고싶으면 어떻게 해야할까?

## 1. 오버로딩을 하자 (안됨)

```java
class BoxHandler{
    /**************** 잘못된 오버로딩 *************************/
    public static void outBox(Box<? extends Toy> box){...}
    public static void outBox(Box<? extends Robot> box){...}

    /**************** 잘된 오버로딩 *************************/
    public static void inBox(Box<? extends Toy> box, Toy n){...}
    public static void inBox(Box<? extends Robot> box, Robot n){...}
}
```
### 왜 안될까?
- Type Erasure 때문이다. 
- 컴파일 과정에서 <? extends Toy> 내용이 모두 지워지기에
  - Box<? extends Toy> box => Box box
  - Box<? extends Robot> box => Box box
- 둘다 같은 메소드로 처리가 되어버린다.

## 2. 와일드 카드 선언을 갖는 제네릭 메소드를 사용하자
```java
// 일반 메소드 (와일드 카드)
public static void outBox(Box<? extends Toy> box){...}
public static void outBox(Box<? extends Robot> box){...}
        
                        ↓

// 와일드 카드 + 제네릭 메소드
public static <T> void outBox(Box<? extends T> box)
```
- Toy, Robot을 받기 위해 T를 사용하고
- 제네릭임을 표현하기 위해 함수 앞에 <T>를 표기

## [코드의 해석]
```java
public static <T> void outBox(Box<? extends T> box)
```
1. Box<T>로 생각하기, (T는 무엇이든 될 수 있음)
2. extends가 붙었으므로 가져오는 것만 가능하겠구나 (E -> Get)

# 제네릭 인터페이스의 정의와 구현
- 인터페이스도 제네릭으로 구현할 수 있다.
```java
interface Getable<T>{
    public T get();
}

// 인터페이스 Getable<T>를 구현하는 Box<T> 클래스
class Box<T> implements Getable<T>{
    private T ob;
    public void set(T o){ ob = o;}
    
    @Override
    public T get() { return ob;}
}
class Toy{
    @Override
    public String toString(){
        return "I am a Toy"
    }
}
public static void main(String[] args){
    Box<Toy> box = new Box<>();
    box.set(new Toy());
    
    // Box<Toy>가 Getable<T>를 구현하므로 참조가 가능하다.
    Getable<Toy> gt = box;
    System.out.println(gt.get());
}
```