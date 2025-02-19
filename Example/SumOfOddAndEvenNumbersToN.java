/*
EXAMPLE
Kullanıcının girdiği sayıya kadar olan tek ya da çift sayıları yazdırma
*/
import java.util.*;
class Main {
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
                    FindOddAndEvenNumbersToN(n);
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
    
    static void FindOddAndEvenNumbersToN(int n) {
        int m = n;
        String odds = "", evens = "";
        if (m != 0) {
            for (int i = 1; i <= m; i++) {
                if (i % 2 == 1) {
                    odds += i + " ";
                }
                if (i % 2 == 0) {
                    evens += i + " ";
                }
            }
            System.out.println(n + " sayisina kadar tek sayilar:");
            System.out.println(odds);
            System.out.println(n + " sayisina kadar cift sayilar:");
            System.out.println(evens);
        }
    }
}
