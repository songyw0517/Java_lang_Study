package test;
class Person{
    String name;
    public Person(String name){
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("destroyed : "+name);
    }
}

public class finalizeExample {
    public static void main(String[] args) {
        Person p1 = new Person("Yoon");
        Person p2 = new Person("Park");
        p1 = null; // 참조대상을 가비지 컬렉션의 대상으로 만듦
        p2 = null; // 참조대상을 가비지 컬렉션의 대상으로 만듦

        System.gc();
         System.runFinalization();
        System.out.println("end of program");
    }
}
