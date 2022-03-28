# 와일드카드(Wild Card)란
## 왜 사용하는가?
- 제네릭 메소드와 합쳐져 큰 힘을 낼 수 있다.
- 와일드 카드만 떼놓고, 제네릭 메소드만 떼놓고 보면 '기능적인 측면에서' 차이점이 없다.
- but) 제네릭 메소드와 헷갈릴 수 있다.


## 와일드 카드의 문법
```java
public static void peekBox(Box<?> box){
    System.out.println(box);
}
```
- peekBox는 Box<>인스턴스를 받는데, Box<?>를 통해 Box안에 무엇을 넣어도 받겠다는 의미이다.

## 와일드 카드를 제네릭 메소드로 바꾸면...
```java
public static <T> void peekBox(Box<T> box){
    System.out.println(box);
}
```

## 와일드 카드 VS 제네릭 메소드
- '기능적인 측면에서' 와일드카드와 제네릭 메소드는 같다.
- 와일드 카드 -> 코드의 간결성의 장점을 가진다. (권장)
- 제네릭 메소드 -> 코드가 좀 복잡해 보인다.

## 와일드 카드의 상한과 하한의 제한 : Bounded Wildcards
- 제네릭 메소드에서는 extends만을 사용하여 제한했다.
- 와일드 카드에서는 extends와 super를 사용하여 제한할 수 있다.
## 상한 제한된 와일드 카드
```java
public static void peekBox(Box<? extends Number> box){
    /* 
    Box형 인스턴스를 인자로 받는데, 그 안의 인스턴스가 Number를 상속해야 한다.
    이는 제네릭 메소드에서의 extends와 같은 의미이다.        
    */
    System.out.println(box);
}
```
### 왜 상한 제한인가?
- 위 코드에서 extends Number을 통해 ?에 올 수 있는 인스턴스를 Number를 상속한 인스턴스만 올 수 있게 제한했다.
- 즉 Number을 상속하는 자식들만 올 수 있다는 것이다.
<pre>
Object
    - Number
        - Integer
        - Double
        - Float
        - ...
</pre>
- 따라서 ?에는 Number 또는 이를 상속하는 하위 클래스(Integer, Double, Float 등)이어야하며, 이를 상한 제한이라고 부른다.
## 하한 제한된 와일드 카드
```java
public static void peekBox(Box<? super Integer> box){
    /*
     Box형 인스턴스를 인자로 받는데, 그 안의 인스턴스가 Integer를 
     직접 or 간접으로 상속하는 클래스만 들어올 수 있다.
     
     */
    System.out.println(box);
```
### 왜 하한 제한인가?
- 위 코드에서 super Integer을 통해 ?에 올 수 있는 인스턴스가 Integer의 부모 인스턴스만 올 수 있게 제한했다.
- 즉 ?에는 Integer을 직접 혹은 간접으로 상속하는 부모들만 올 수 있다는 것이다.
<pre>
Object
    - Number
        - Integer
        - Double
        - Float
        - ...
</pre>
- super Integer을 통해 최하위 인스턴스가 Integer임을 말하며, 
- ?에 올 수 있는 것은 상위 클래스인 Integer, Number, Object가 올 수 있다.

## 와일드 카드 제한의 이유
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
    public static void outBox(Box<Toy> box){
        Toy t = box.get();
        System.out.println(t);
        // (실수 코드) box.set(new Toy()); 코드가 실행 가능하다. (오류가 나야한다.)
    }
    public static void inBox(Box<Toy> box, Toy n){
        box.set(n);
        // (실수 코드) Toy myToy = box.get(); 코드가 실행 가능하다. (오류가 나야한다.)
    }
}
```
[코드설명]
- outBox를 통해서는 Toy를 꺼내는 것이 목적이다. <br>
그런데 box.set()메소드의 접근으로 넣는 것이 가능하다. -> 에러가 발생해야한다.  
- inBox를 통해서는 Toy를 넣는 것이 목적이다. <br>
그런데 box.get()메소드의 접근으로 꺼내는 것이 가능하다 -> 에러가 발생해야한다.

### 결론
- '와일드 카드의 제한'은 프로그래머의 코드 실수를 '컴파일 에러'를 통해 잡을 수 있도록 하기 위함이다.

## 상한제한과 하한제한의 목적
### 상한제한의 목적
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
    public static void outBox(Box<? extends Toy> box){ // ? extends Toy
        Toy t = box.get();
        System.out.println(t);
        // (실수 코드) box.set(new Toy()); 이 컴파일 에러로 이어진다.
    }
    public static void inBox(Box<Toy> box, Toy n){
        box.set(n);
        // (실수 코드) Toy myToy = box.get(); 코드가 실행 가능하다. (오류가 나야한다.)
    }
}
```
[코드 설명]
```java
public static void outBox(Box<? extends Toy> box){...}
```
- extends Toy를 통해 상한제한을 했다.
- 이렇게 하면 get은 가능하지만 set은 불가능하다. (왜?)
    - ? 에는 Toy이거나 Toy를 상속하는 자식들만 올 수 있다. 예를들어 다음과 같은 클래스가 있다면
    ```java
    class Car extends Toy{}
    class Robot extends Toy{}
    ```
    - \<? extends Toy> 를 통해 ?에 Toy 뿐만 아니라 Car, Robot도 올 수 있게 된다.
    - 그러면 (실수코드)인 box.set(new Toy()); 부분에서<br> 
    Box\<Car>.set(new Toy());를 할 수 없기에 (자식은 부모를 가질 수 없다.) 컴파일러가 에러를 나타낸다.

### [결론]
- 상한제한을 하면(Box<? extends Toy> box) -> box 대상으로 넣는것(set)이 불가능하다. 

### 하한제한의 목적 
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
    public static void outBox(Box<? extends Toy> box){ // ? extends Toy
        Toy t = box.get();
        System.out.println(t);
        // (실수 코드) box.set(new Toy()); 이 컴파일 에러로 이어진다.
    }
    public static void inBox(Box<? super Toy> box, Toy n){ // ? super Toy
        box.set(n);
        // (실수 코드) Toy myToy = box.get(); 이 컴파일 에러로 이어진다.
    }
}
```
[코드 설명]
```java
public static void inBox(Box<? super Toy> box, Toy n){...}
```
- super Toy를 통해 하한제한을 했다.
- 이렇게 하면 set은 가능하지만 get은 불가능하다. (왜?)
    - 하한제한을 통해 ?에는 Toy와 Toy를 간접, 직접적으로 상속하는 부모들만 올 수 있다.
    - 예를 들어 다음과 같은 클래스가 있다고 가정한다면
    ```java
    class Plastic{...}
    class Toy extends Plastic{...}
    ```
    - \<? super Toy>를 통해 ?에는 Toy와 Plastic이 올 수 있다.
    - 그러면 (실수 코드)인 box.get();부분에서<br>
    Toy myToy = box.get();을 할 수 없기에 (자식은 부모를 가질 수 없다.) 컴파일러가 에러를 나타낸다.
### [결론]
- 하한제한을 하면(Box<? super Toy> box) -> box 대상으로 꺼내는 것(get)이 불가능하다.

## 상한, 하한 제한의 좋은 예시
```java
class BoxContentsMover{
    // from에 저장된 내용물을 to로 이동
    public static void moveBox(Box<? super Toy> to, Box<? extends Toy> from){
        // to는 set만 가능, from은 get만 가능
        to.set(from.get());
    }
}
```

# 결론
- SS(super - set)
- EG(extends - get)
