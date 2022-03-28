package test;
class Point implements Cloneable{
    private int xPos;
    private int yPos;

    public Point(int x, int y){
        xPos=x;
        yPos=y;
    }
    public void showPosition(){
        System.out.printf("[%d %d]", xPos, yPos);
        System.out.println();
    }

    /*
    * clone메소드는 protected로 선언되어있어서, 외부에서 선언이 불가능
    * 그것을 public로 바꿔주기 위해 오버라이딩을 한다.
    * */
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
public class cloneExample {
    public static void main(String[] args) {
        Point org = new Point(3, 5);
        Point cpy;
        try{
            // 형변환을 하는 이유 : clone메소드는 Object를 반환하는데,
            // copy는 Point형이기 때문, (자식은 부모를 가질 수 없다.)
            cpy = (Point)org.clone();
            org.showPosition();
            cpy.showPosition();

        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
