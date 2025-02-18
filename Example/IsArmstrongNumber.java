/*
EXAMPLE
Girilen sayının Armstrong sayı olup olmadığını kontrol etme
Kullanıcıdan alınan sayının Armstrong sayısı olup olmadığını kontrol eden Java programı
Armstrong sayısı: Basamaklarının küplerinin toplamı kendisine eşit olan sayılar, örneğin 153
/*
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String exit = "a";
        int n = 0, l = 0;
        while (!exit.equals("e")) {
            System.out.println("Bir tamsayi giriniz (Sayinin mutlak degeri alinacaktir.");
            long sum = 0; 
            n = Math.abs(s1.nextInt());
            l = n;
            while (l > 0) {
                sum += Math.pow((l % 10), 3);
                l = l / 10;
            }
            if (sum == n)
                System.out.println(n + " sayisi Armstrong sayidir.");
            else
                System.out.println(n + " sayisi Armstrong sayi degildir.");
            System.out.println("Kapatmak icin e'ye, devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        }
        System.out.println("Kapattiniz");
        s1.close();
        s2.close();
        System.exit(0);
    }
}
