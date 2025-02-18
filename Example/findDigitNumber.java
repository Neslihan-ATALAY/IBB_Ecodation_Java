/*
EXAMPLE
Girilen sayının basamak sayısını bulma
Kullanıcının girdiği sayının kaç basamaklı olduğunu bulan Java programı
*/
import java.util.*;
class Main {
    public static void main(String[] args) throws ArithmeticException {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String exit = "a";
        while (!(exit.equals("e") || exit.equals("E"))) {
            System.out.println("Bir tamsayi giriniz: (Sayinin mutlak degeri alinacaktir.)");
            long n = Math.abs(s1.nextLong());
            System.out.println("Sayi hangi tabandadir? (ikilik, ucluk, onluk vb.)");
            int k = Math.abs(s1.nextInt());
            long m = n;
            int l = 0;
            try {
                while (m > 0) {
                    m = m / k;
                    l++;
                }
                System.out.println(n + " onluk sayisi " + k + " tabaninda " + l + " basamaklidir.");
            } catch (ArithmeticException ae) {
                System.out.println("Istisna");
                ae.getMessage();
            }
            catch (Exception e) {
                System.out.println("Istisna");
                e.getMessage();
            }
            System.out.println("Kapatmak icin e tusuna, devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        } 
        if (exit.equals("e") || exit.equals("E")) {
            s1.close();
            s2.close();
            System.out.println("Kapattiniz");
        }
    }
}
