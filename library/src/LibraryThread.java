public class LibraryThread {
    public static void main(String[] args) {
        /************** Thread.sleep *****************/
        System.out.println("잔다");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("일어났다.");
    }
}
