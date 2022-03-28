import java.util.Random;

public class MethodRand {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("rand.nextBoolean() = " + rand.nextBoolean());
        System.out.println("rand.nextInt() = " + rand.nextInt());
        System.out.println("rand.nextLog() = " + rand.nextLong());
        System.out.println("rand.nextInt(100) = " + rand.nextInt(13, 17));
        System.out.println("rand.nextFloat() = " + rand.nextFloat());
        System.out.println("rand.nextDouble() = " + rand.nextDouble());


    }
}
