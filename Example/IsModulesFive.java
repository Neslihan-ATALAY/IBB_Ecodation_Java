/*
EXAMPLE
Girilen sayının 5 (Beş) sayısının katı olduğunu kontrol etme
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
                    System.out.println(n + " sayisi 5 (bes) sayisinin bir kati midir?\nCevap: " + (FindModulesFive(n) ? "Evet" : "Hayir"));
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
    
    static boolean FindModulesFive(Long n) {
        Long m = n;
        boolean fiveX = false;
        if (m != 0) {
            if (m % 5 == 0) fiveX = true;
        }
        return fiveX;
    }
}
