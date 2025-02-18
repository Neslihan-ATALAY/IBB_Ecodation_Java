/*
EXAMPLE
Girilen sayının mükemmel olup olmadığını kontrol etme
Kullanıcının girdiği sayının mükemmel olup olmadığını kontrol eden Java programı
Mükemmel sayı: Kendisi hariç pozitif bölenlerinin toplamı kendisine eşit olan sayı (Örn: 6 = 1 + 2 + 3)
*/
import java.util.*;
class Main {
    public static void main(String[] args) throws ArithmeticException {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int max = 100;
        String exit = "a";
        while (!(exit.equals("e") || exit.equals("E"))) {
            String st = "";
            System.out.println("Onluk tabanda bir pozitif tamsayi giriniz: (Negatif sayi girerseniz sayinin mutlak degeri alinacaktir.)");
            int n = Math.abs(s1.nextInt());
            if (n != 0) {
                int m = n;
                int sum = 0;
                try {
                    for (int i = 1; i < m; i++) {
                        if (m % i == 0) {
                            sum += i;
                            st += "+" + i;
                        }
                    }
                    if (sum == n) {
                        System.out.println(n + " sayisi mukemmel sayidir. (" + n + " = " + st + ")");
                    } else if (sum != n) {
                        System.out.println(n + " sayisi mukemmel sayi degildir. (" + n + " != " + st + ")");
                    }
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
