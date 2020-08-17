import Controler.hibernateController;

public class Main {
    public static void main(String[] args) {
        hibernateController hc = new hibernateController();
        System.out.println(hc.get(1));
    }
}
