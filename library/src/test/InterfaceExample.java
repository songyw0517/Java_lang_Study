package test;

import java.util.Locale;

interface InterfaceTest{
    public void print(String doc);
    default void print2(String doc){}
}

class InterfaceClass1 implements InterfaceTest{
    @Override
    public void print(String doc) {
        System.out.println(doc);
    }
}

class InterfaceClass2 implements InterfaceTest{
    @Override
    public void print(String doc) {
    }
    // default 메소드를 구현한 클래스
    @Override
    public void print2(String doc) {
        InterfaceTest.super.print2(doc);
    }
}


interface Upper{}
interface Lower{}
interface Printable{
    String getContents();
}

class Report implements Printable, Upper{
    String cons;
    Report(String cons){
        this.cons=cons;
    }

    public String getContents() {
        return cons;
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
    }

    public void printContents(Printable doc) {
        if (doc instanceof Upper) {
            System.out.println((doc.getContents()).toUpperCase());
        }
        else if (doc instanceof Lower){
            System.out.println((doc.getContents()).toLowerCase());
        }
        else{
            System.out.println(doc.getContents());
        }
    }
}




