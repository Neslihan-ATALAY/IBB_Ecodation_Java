/*
EXAMPLE
Girilen sayının tek mi çift mi olduğunu kontrol etme
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
                    System.out.println(n + " sayisi " + FindEvenOddNumber(n));
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
    
    static String FindEvenOddNumber(int n) {
        String tekCift = "";
        int m = n;
        if (m % 2 == 1) {
            tekCift = "tek sayi.";
        } else if (m % 2 == 0) {
            tekCift = "cift sayi.";
        }
        return tekCift;
    }
}
