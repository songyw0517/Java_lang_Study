import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassReflect {
    public static void main(String[] args) {
        // 클래스 뜯기
        Object obj = new Object();
        System.out.println("Object 클래스 이름 : " + obj.getClass().getName()+"\n");
        System.out.println("*************************** 클래스 메소드 출력 ******************");
        for(Method method : obj.getClass().getMethods()){
            System.out.print(method.getName() + " ");
        }
        System.out.println("\n\n************************ 클래스 SimpleName *********************");
        System.out.println(obj.getClass().getSimpleName());

        System.out.println("\n************************ 클래스 변수 출력 *********************");
        for(Field field : obj.getClass().getDeclaredFields()){
            System.out.println(field);
        }
    }


}
