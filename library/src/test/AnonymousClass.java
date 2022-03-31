package test;
interface Printable1{
    void print();
}
class Papers{
    private String con;
    public Papers(String s) { con = s;}

    public Printable1 getPrinter(){
        /** 익명 클래스 **/
        return new Printable1(){
            @Override
            public void print(){
                System.out.println(con);
            }
        };
    }
}
public class AnonymousClass {
    public static void main(String[] args) {
        Papers p = new Papers("서류 내용 : 행복합니다.");
        Printable1 prn = p.getPrinter();
        prn.print();
    }
}
