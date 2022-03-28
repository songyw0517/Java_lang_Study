public class MethodMath {
    public static void main(String[] args) {
        System.out.println("원주율 = " + Math.PI);
        System.out.println("2의 제곱근 = " + Math.sqrt(2));
        System.out.println();
        System.out.println("파이에 대한 Degree = " + Math.toDegrees(Math.PI));
        System.out.println("2 파이에 대한 Degree = " + Math.toDegrees(2.0 * Math.PI));
        System.out.println();

        double radian45 = Math.toRadians(45); // 45도의 라디안,
        // sin, cos, tan 등의 삼각함수의 매개변수에는 "라디안" 값이 들어가야한다!
        System.out.println("싸인 45 = " + Math.sin(radian45));
        System.out.println("코싸인 45 = " + Math.cos(radian45));
        System.out.println("탄젠트 45 = " + Math.tan(radian45));
        System.out.println();
        System.out.println("로그 25 = " + Math.log(25));
        System.out.println("2의 16승 = " + Math.pow(2, 16));

    }
}
