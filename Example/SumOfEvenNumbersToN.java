/*
EXAMPLE
Girilen sayıya kadar olan çift sayıların toplamını bulma
*/
import java.util.*;
class Main {
    public static void main(String[] args) throws ArithmeticException {
        Scanner s1, s2 = null;
        s1 = new Scanner(System.in);
        s2 = new Scanner(System.in);
        String exit = "a";
        while (!(exit.equals("e") || exit.equals("E"))) {
            System.out.println("Onluk tabanda bir pozitif sayi giriniz: (Negatif sayi girerseniz sayinin mutlak degeri alinacaktir.)");
            Long n = Math.abs(s1.nextLong());
            if (n != 0) {
                try {
                    System.out.print(n + " sayisina kadar olan cift sayilarin toplami = ");
                    Long sumOfEvens = 0L;
                    if (n != 0) {
                        for (int i = 2; i <= n; i++) {
                            if (i % 2 == 0) {
                                sumOfEvens += i;
                            }
                        }
                    }
                    System.out.println(sumOfEvens);
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
}
