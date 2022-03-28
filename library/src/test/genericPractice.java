package test;
class Orange2{
    int sugarContent;
    public Orange2(int sugar){
        sugarContent = sugar;
    }
    public void showSugarContent(){
        System.out.println("당도 = "+sugarContent);
    }
}
class Apple2{
    int weight;
    public Apple2(int weight){
        this.weight = weight;
    }
    public void showAppleWeight(){
        System.out.println("무게 = "+weight);
    }
}
class FruitBox<T>{
    T ob;
    public FruitBox(T o){
        ob = o;
    }
    public T pullOut(){
        return ob;
    }

}
public class genericPractice {
    public static void main(String[] args) {
        FruitBox<Orange2> orBox = new FruitBox<>(new Orange2(10));
        Orange2 org = orBox.pullOut();
        org.showSugarContent();

        FruitBox<Apple2> apBox = new FruitBox<>(new Apple2(20));
        Apple2 app = apBox.pullOut();
        app.showAppleWeight();
    }
}
