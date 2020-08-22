import Controler.hibernateController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        hibernateController hc = new hibernateController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cześć witaj w programie Gift Finder \n Co chcesz zrobić ? \n 1 - Wybrać Prezent ? \n 2 - Dodać Prezent ?");
        int choose = scanner.nextInt();
        int ageGroup = 0;
        String giftName = "";
        switch (choose) {
            case 1: {
                System.out.println("Cześć jaki wiek osoby obdarowanej?");
                int age = scanner.nextInt();
                if (age >= 1) {
                    System.out.println(hc.get(1));
                }

            }
            case 2: {
                do {

                   if (ageGroup <= 0) {
                       System.out.println("Dodaj prezent \n\nJaka grupa wiekowa ?");
                       ageGroup = scanner.nextInt();
                   }
                   if (ageGroup > 0) { System.out.println("Jaki Prezent ? ");
                        giftName = scanner.nextLine();}


                } while(giftName.isEmpty());
            }
            hc.save(giftName, ageGroup);

            }


        }

    }
