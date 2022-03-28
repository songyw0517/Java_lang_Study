package test;
class Box<T>{
    private T ob;
    public void set(T o){ ob = o;}
    public T get() {return ob;}
}
class EmptyBoxFactory{
    // 제네릭 메소드를 갖고 있는 클래스
    public static <T> Box<T> makeBox(){
        Box<T> box = new Box<>();
        return box;
    }
}
public class targetType {
    public static void main(String[] args) {
        Box<Integer> iBox = EmptyBoxFactory.makeBox();
        // Box<Integer> : 타겟타입
        iBox.set(245);
        System.out.println(iBox.get());
    }
}
