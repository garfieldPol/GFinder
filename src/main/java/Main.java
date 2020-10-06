import Model.Gender;
import Controler.hibernateController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        hibernateController hc = new hibernateController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cześć witaj w programie Gift Finder \n Co chcesz zrobić ? \n 1 - Wybrać Prezent ? \n 2 - Dodać Prezent ?");
        int choose = scanner.nextInt();
        int ageGroup = 0;
        Gender male = Gender.M;
        Gender female = Gender.F;
        Gender gender = Gender.U;
        boolean addGender = false;
        String giftName = "";
        switch (choose) {
            case 1: {
                System.out.println("Szukanie według wieku wpisz - 1 \nSzukanie według płci wpisz - 2 \n");
                int search = scanner.nextInt();
                switch (search) {
                    case 1: {
                        System.out.println("Wpisz wiek");
                        int age = scanner.nextInt();
                        System.out.println(hc.findAllByAgeGroup(age));
                        break;
                    }
                    case 2: {
                        System.out.println("Wybierz płeć \n 1 - Chłopak \n 2 - Dziewczyna \n 3 - Unisex");
                        int genderType = scanner.nextInt();
                        if(genderType == 1) {
                            System.out.println(hc.findAllByGender(Gender.M));
                        } else if(genderType == 2) {
                            System.out.println(hc.findAllByGender(Gender.F));
                        } else if(genderType == 3) {
                            System.out.println(hc.findAllByGender(Gender.U));
                        }
                        }

                        break;
                    }
                }


                break;

            case 2: {
                do {

                   if (ageGroup <= 0) {
                       System.out.println("Dodaj prezent \n\nJaka grupa wiekowa ?");
                       ageGroup = scanner.nextInt();

                   }
                   else if(!addGender) {
                       System.out.println("Jaka płeć? \n Dziewczyna wciśnij - 1 \n Chłopak wciśnij - 2 \n Zabawki dla obu płci wciśnij - 3 ");
                       int maletype = scanner.nextInt();
                       switch (maletype) {
                           case 1:
                               gender = female;
                               addGender = true;
                               break;
                           case 2:
                               gender = male;
                               addGender = true;
                               break;
                           case 3:
                               addGender = true;

                       }

                       }
                   else if (ageGroup > 0) { System.out.println("Jaki Prezent ? ");
                        giftName = scanner.next();}


                } while(giftName.isEmpty());
            }
            hc.save(giftName, ageGroup, gender);

            }


        }

    }
