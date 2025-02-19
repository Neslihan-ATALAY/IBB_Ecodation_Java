/*
EXAMPLE
Sayının rakamlarının çarpımını bulma
Kullanıcının girdiği sayının rakamlarının çarpımını bulan Java programı
*/
import java.util.*;
class Main {
    public static void main(String[] args) throws ArithmeticException {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int max = 100;
        String exit = "a";
        while (!(exit.equals("e") || exit.equals("E"))) {
            System.out.println("Onluk tabanda bir pozitif tamsayi giriniz: (Negatif sayi girerseniz sayinin mutlak degeri alinacaktir.)");
            int n = Math.abs(s1.nextInt());
            if (n != 0) {
                int m = n;
                int[] array = new int[max];
                boolean isPrime = true;
                try {
                    int k = 0;
                    double multiple = 1;
                    while (m > 0) {
                        array[k++] = m % 10;
                        m = m / 10;
                    }
                    for (int i = k - 1; i > -1; i--) {
                        multiple *= array[i];
                    }
                    System.out.println(n + " sayisinin rakamlarinin carpimi = " + (int) multiple);
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
        if (exit.equals("e") || exit.equals("E")){
            s1.close();
            s2.close();
            System.out.println("Kapattiniz");
        }
    }
}
