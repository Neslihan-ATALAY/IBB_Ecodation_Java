/*
EXAMPLE
Girilen sayının rakamlarının toplamını bulma (Recursive-Özyinelemeli metot ile)
*/
import java.util.*;
class Main {
    static int sumOfIntegers = 0;
    
    public static void main(String[] args) throws ArithmeticException {
        Scanner s1, s2 = null;
        s1 = new Scanner(System.in);
        s2 = new Scanner(System.in);
        String exit = "a";
        while (!(exit.equals("e") || exit.equals("E"))) {
            System.out.println("Onluk tabanda bir pozitif tamsayi giriniz: (Negatif sayi girerseniz sayinin mutlak degeri alinacaktir.)");
            int n = Math.abs(s1.nextInt());
            if (n != 0) {
                try {
                    sumOfIntegers = 0;
                    FindSumOfIntegersForN(n);
                    System.out.println(n + " sayisinin rakamlari toplami = " + sumOfIntegers);
                } catch (ArithmeticException ae) {
                    System.out.println("Istisna");
                    ae.getMessage();
                } catch (Exception e) {
                    System.out.println("Istisna");
                    e.getMessage();
                }
            } else {
                System.out.println("Sifirdan (0) farkli bir sayi giriniz.");
            }
            System.out.println("\nKapatmak icin e tusuna, devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        } 
        if (exit.equals("e") || exit.equals("E")) {
            s1.close();
            s2.close();
            System.out.println("Kapattiniz");
        }
    }
    
    static void FindSumOfIntegersForN(int n) {
        if (n > 0) {
            sumOfIntegers += n % 10;
            FindSumOfIntegersForN(n / 10);
        }
    }
}
