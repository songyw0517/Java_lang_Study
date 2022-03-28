import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodObject {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println("Object 클래스 이름 : " + obj.getClass().getName());
        System.out.println("*************************** 메소드 출력******************");
        for(Method method : obj.getClass().getMethods()){
            System.out.print(method.getName() + " ");
        }
        System.out.println("\n\n\n************************ Object SimpleName *********************");
        System.out.println(obj.getClass().getSimpleName());

        for(Field field : obj.getClass().getDeclaredFields()){
            System.out.println(field);
        }

    }
}
