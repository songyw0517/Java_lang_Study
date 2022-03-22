class Number{
    int num;
    public Number(){
        num = 10;
        System.out.println("생성자가 호출되었습니다. 인자가 없으므로 10으로 초기화합니다.");
    }
    public Number(int num){
        this.num = num;
        System.out.println("생성자가 호출되었습니다. 인자가 있으므로 "+num+"으로 초기화 합니다.");
    }
    public int getNumber(){
        return num;
    }
}
public class Constructor {
    public static void main(String[] args) {
        Number num1 = new Number();
        System.out.println(num1.getNumber());

        Number num2 = new Number(20);
        System.out.println(num2.getNumber());
    }
}
