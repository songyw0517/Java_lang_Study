package test;

class prevGenericBox{
    private Object ob;
    public void set(Object o){
        ob = o;
    }
    public Object get(){
        return ob;
    }
}
class GenericBox <T> {
    /*
    * <T> : 타입 매개변수
    * */
    private T ob;
    public void set(T o){
        ob = o;
    }
    public T get(){
        return ob;
    }
}
class Apple{
    private String fruit;
    public Apple(){
        fruit = "I am apple";
    }
}
class Orange{
    private String fruit;
    public Orange(){
        fruit = "I am orange";
    }
}
/*
- 제네릭 사용 이전:
    - Object를 이용하여 모든 객체를 받아들였다.
    - 이는 어떤 객체인지를 정하지 않음을 의미한다.
- 제네릭 사용 이후:
    - T를 필요에 따라 결정하겠다는 의미를 가진다.
    - 인스턴스 생성시에 T를 결정하겠다는 의미!
*/


/************** 제네릭 클래스의 타입 인자 제한하기 *******************/
class extendsGeneric<T extends Number>{
    private T ob;
    public void set(T o){
        ob = o;
    }
    public T get(){
        return ob;
    }
    // 제한을 함으로써(extends를 함으로써) Number내의 메소드인 intValue()를 사용할 수 있게 된다.
    public int toIntValue(){
        return ob.intValue();
    }
}

/******************* 제네릭 클래스의 타입 인자를 인터페이스로 제한하기 ****************/
interface Eatable{
    public String eat();
}
class AppleInterface implements Eatable{
    public String eat() {
        return "It tastes so good";
    }
}
class BoxInterface<T extends Eatable>{
    T ob;
    public void set(T o){
        ob = o;
    }
    public T get(){
        System.out.println(ob.eat()); // eatable로 제한했기에 eat호출 가능하다.
        return ob;
    }
}

/**************************** 제네릭 메소드의 정의 ***************************************/
class BoxFactory{
    public static <T> GenericBox<T> makeBox(T o){ // 맨 앞의 <T>는 이 메소드가 제네릭임을 표현한 것
        GenericBox<T> box = new GenericBox<>();
        box.set(o);
        return box;
    }
}
public class generic {
    public static void main(String[] args) {
        GenericBox<Apple> abox = new GenericBox<Apple>(); // T를 Apple로 결정하겠다.
        /* Apple : 타입 인자 / GenericBox<Apple> : 매개변수화 타입*/
        GenericBox<Apple> abox2 = new GenericBox<>(); // 위의 표현과 같다.
        GenericBox<Orange> obox = new GenericBox<Orange>();

        // 매개변수화 타입을 타입 인자로 전달
        GenericBox<String> sBox = new GenericBox<>();
        sBox.set("I am so happy");

        GenericBox<GenericBox<String>> wBox = new GenericBox<>();
        wBox.set(sBox);

        GenericBox<GenericBox<GenericBox<String>>> zBox = new GenericBox<>();
        zBox.set(wBox);

        System.out.println(zBox.get().get().get());

        System.out.println("*".repeat(10)+ "제네릭 클래스의 타입인자 제한하기" + "*".repeat(10));
        extendsGeneric<Integer> iBox = new extendsGeneric<>();
        iBox.set(24);

        // extendsGeneric<String> sBox2 = new extendsGeneric<String>(); String은 Number가 아니기 때문에 컴파일 에러가 난다.

        System.out.println("*".repeat(10)+ "제네릭 클래스의 타입인자를 인터페이스로 제한하기" + "*".repeat(10));
        AppleInterface appIter = new AppleInterface();
        BoxInterface<AppleInterface> boxInter = new BoxInterface<>();
        boxInter.set(appIter);
        boxInter.get();

        System.out.println("*".repeat(10)+ "제네릭 메소드의 정의" + "*".repeat(10));
        GenericBox<String> msBox = BoxFactory.<String>makeBox("Sweet"); // BoxFactory의 제네릭 메소드 makeBox를 통해 생성 및 반환
        GenericBox<String> msBox2 = BoxFactory.makeBox("Sweet"); // 생략 가능하다.
    }
}
