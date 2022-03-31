# 열거형 enum
## 열거형이 등장하기 전의 문제점
- enum이 등장하기 전에는 interface에 상수를 보관했다.
```java
interface Animal{
    int DOG = 1;
    int CAT = 2;
}
interface Person{
    int MAN = 1;
    int WOMAN = 2;
}
public static void who(int man){
    switch(man){
        case Person.MAN:
            System.out.println("남성 손님입니다.");
            break;
        case Person.WOMAN:
            System.out.println("여성 손님입니다.");
            break;
    }
}
public static void main(String[] args) {
    who(Person.MAN);
    who(Animal.DOG);
}
```
- who에 Animal.DOG가 전달되었지만 (실수로?) 컴파일 오류가 발생하지 않았다.
- 이 문제에 대해 컴파일 오류를 나타내기 위해 enum이 등장했다.

## enum? 그게 뭔데
```java
enum Scale{
    // 열거형 값 : 
    DO, RE, MI, FA, SO, RA, TI
}

public static void main(String[] args) {
    Scale sc = Scale.DO;
    System.out.println(sc);
    
    switch (sc){
        case DO:
            System.out.println("도~");
            break;
        case RE:
            System.out.println("레~");
            break;
        case MI:
            System.out.println("미~");
            break;
        case FA:
            System.out.println("파~");
            break;
        default:
            System.out.println("솔라시");
    }
}
```
### [코드 설명]
- enum을 통해 'Scale' 이름을 가진 '열거 자료형'에 DO, RE, MI, 등의 열거형 값을 정의했다.
- 이렇게 정의할 경우, Scale 형의 변수에는 Scale.을 통하여 값을 넣을 수 있다.

## 열거형 등장 이후 개선된 코드
```java
enum Animal{
    DOG, CAT
}
enum Person{
    MAN, WOMAN
}
public static void who(Person man){ // Person형을 받는다.
    switch(man){
        case MAN:
            System.out.println("남성 손님입니다.");
            break;
        case WOMAN:
            System.out.println("여성 손님입니다.");
            break;
    }
}
public static void main(String[] args) {
    who(Person.MAN);
    
    /** who에는 Person형이 들어갈 수 있으므로, (자료형 불일치로 인한) 컴파일 에러가 발생한다. **/
    who(Animal.DOG);  
}
```

## enum을 클래스 안에 작성하면
- 그 클래스 내부에서만 사용하겠다는 의미를 가진다.
```java
class Customer{
    enum Gender{
        MALE, FEMALE
    }
    
    private String name;
    private Gender gen;
    
    Customer(String n, String g){
        name = n;
        
        if(g.equals("man"))
            gen = Gender.MALE;
        else
            gen = Gender.FEMALE;
    }
}
```

<hr>

# 열거형 뜯기
```java
enum Person{
    MAN(29), WOMAN(25);
    
    int age;
    
    private Person(int age){
        this.age = age;
    }
    
    
    @Override
    public String toString(){
        return "I am " + age + " years old";
    }
}
class EnumParamConstructor{
    public static void main(String[] args) {
        System.out.println(Person.MAN);
        System.out.println(Person.WOMAN);
    }
}
```
<hr>

## 열거형 값은 인스턴스 입니다.
### [짚고 가야할 것]
### 1. Person형 클래스에서 Person형 참조 변수 선언이 가능하다.
```java
/** Ex) 도입 **/
class Person{
    /** 만약 static이 빠질 경우 -> 계속 Person 객체가 생성되는 문제가 발생한다. **/
    // 결론)
    public static final Person MAN = new Person(); 
    public static final Person WOMAN = new Person();
    
    @Override
    public String toString(){
        return "I am a dog person";
    }
}
```
- '같은 클래스' 내에서 '같은 클래스'의 참조 변수 선언이 가능하다.
- '같은 클래스' 내에서 '같은 클래스'의 생성이 가능하다. (다만 static 선언이 필요하다.)
### 2. enum은 넓은 범위에서 봤을 때 클래스이다.
```java
enum Person{
    MAN, WOMAN;
    
    @Override
    public String toString() { return "I am a dog person"; }
}
class EnumConst{
    public static void main(String[] args) {
        /** 결과를 봤을 때, MAN, WOMAN은 인스턴스이다. **/
        System.out.println(Person.MAN);
        System.out.println(Person.WOMAN);
    }
}

/** 결과 **/
I am a dog person
I am a dog person
```
- 모든 열거형은 java.lang.Enum<E> 클래스를 상속하며, Enum<E>는 Object 클래스를 상속한다.
- 따라서 enum 내부의 toString을 오버라이딩을 하는 등의 클래스처럼 다룰 수 있다.

### 3. enum에도 생성자가 있습니다. 다만 private으로 선언합니다.
```java
enum Person{
    MAN, WOMAN;
    
    private Person(){
        System.out.println("Person constructor called");
    }
    
    @Override
    public String toString() { return "I am a dong person"; }
}
class EnumConstructor{
    public static void main(String[] args) {
        System.out.println(Person.MAN);
        System.out.println(Person.WOMAN);
    }
}
/** 결과 **/
Person constructor called
Person constructor called
I am a dog person
I am a dog person
```
- Person.MAN, Person.WOMAN을 통해 private 생성자가 호출됨을 확인할 수 있다.
[결론]
```java
public static final Person MAN = new Person(); 
public static final Person WOMAN = new Person();
```
- 으로 생각하면 편하다!


