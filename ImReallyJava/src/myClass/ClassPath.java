package myClass;


class AAA {
    public void printName() {
        System.out.println("AAA");
    }
}

class BBB {
    public void printName() {
        System.out.println("BBB");
    }
}

public class ClassPath
{
    public static void main(String[] args) {
        // 현재 디렉토리의 AAA, BBB를 찾는다.
        // but, 현재 디렉토리에 AAA, BBB 클래스가 없으므로 에러가 발생한다.
        // classpath(클래스패스)를 지정함으로써 jvm이 클래스를 찾을 수 있도록 할 수 있다.
        AAA aaa = new AAA();
        BBB bbb = new BBB();

        aaa.printName();
        bbb.printName();

    }
}
