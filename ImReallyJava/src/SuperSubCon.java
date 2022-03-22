class SuperCLS{
    // 상위 클래스 생성자
    public SuperCLS(){
        System.out.println("상위 클래스 생성자");
    }
}
class SubCLS extends SuperCLS{
    public SubCLS(){
        System.out.println("하위 클래스 생성자");
    }
}
public class SuperSubCon {
    public static void main(String[] args) {
        new SubCLS();

    }
}
