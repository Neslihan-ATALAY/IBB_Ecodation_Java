/*
EXAMPLE
Girilen Sayının Basamaklarının Küpleri Toplamını Bulma
Kullanıcının girdiği sayının basamaklarının küplerinin toplamını bulan Java programı
*/
import java.util.*;
class Main {
    public static void main(String[] args) throws ArithmeticException {
        Scanner s1, s2 = null;
        s1 = new Scanner(System.in);
        s2 = new Scanner(System.in);
        int max = 100;
        String exit = "a";
        while (!(exit.equals("e") || exit.equals("E"))) {
            System.out.println("Onluk tabanda bir pozitif tamsayi giriniz: (Negatif sayi girerseniz sayinin mutlak degeri alinacaktir.)");
            int n = Math.abs(s1.nextInt());
            if (n != 0) {
                int m = n;
                int[] array = new int[max];
                try {
                    double sumOfCubes = 0;
                    while (m > 0) {
                        sumOfCubes += Math.pow((m % 10), 3);
                        m = m / 10;
                    }    
                    System.out.println(n + " sayisinin rakamlarinin kuplerinin toplami = " + (int) sumOfCubes);
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
