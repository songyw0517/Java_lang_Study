package test;
interface Printable3 {
    void print(String s);
}
public class Lambda{
    public static void main(String[] args) {
        Printable3 prn = (s) -> { System.out.println(s); };
        prn.print("What is Lambda?");
    }
}
