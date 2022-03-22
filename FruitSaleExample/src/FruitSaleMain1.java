class FruitSeller{
    int numOfApple = 20;
    int myMoney = 0;
    final int APPLE_PRICE=1000; // final 키워드를 이용하여 변경불가

    /*************** Method ***************/
    public int saleApple(int money){
        int num=money/APPLE_PRICE;
        numOfApple-=num;
        myMoney+=money;
        return num;
    }

    public void showSaleResult(){
        System.out.println("남은 사과 : "+numOfApple);
        System.out.println("판매 수익 : "+myMoney);
    }
}

class FruitBuyer{
    int myMoney = 5000;
    int numOfApple = 0;

    /*************** Method ****************/
    public void buyApple(FruitSeller seller, int money){
        // seller에게 money를 주고, 사과의 개수를 받아옴
        numOfApple += seller.saleApple(money);
        myMoney -= money;
    }
    public void showBuyResult(){
        System.out.println("현재 잔액 : "+myMoney);
        System.out.println("사과 개수 : "+numOfApple);
    }
}

public class FruitSaleMain1 {
    public static void main(String[] args) {
        // 객체 생성
        FruitSeller seller = new FruitSeller();
        FruitBuyer buyer = new FruitBuyer();

        // 상호작용
        buyer.buyApple(seller,2000); // buyer가 seller에게 2000원 만큼 사과 구매

        System.out.println("과일 판매자의 현재 상황"+"*".repeat(3));
        seller.showSaleResult();

        System.out.println("과일 구매자의 현재 상황"+"*".repeat(3));
        buyer.showBuyResult();

    }
}
