class Man{
    String name;
    public void tellYourName(){
        System.out.println("My name is " + name);
    }
}
class BusinessMan extends Man{
    String company;
    String position;
    public void tellYourInfo(){
        System.out.println("My company is "+company);
        System.out.println("My position is "+position);
        tellYourName();
    }
}
public class extendExample {
    public static void main(String[] args) {
        BusinessMan man = new BusinessMan();
        man.tellYourInfo();
    }

}
