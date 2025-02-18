/*
EXAMPLE
Girilen sayının asal olup olmadığını kontrol etme
Kullanıcının girdiği bir sayının asal olup olmadığını kontrol eden Java programı
*/
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int n = 0;
        String exit = "a";
        while (!exit.equals("e")) {
            System.out.println("0 ve 1 haricinde bir tamsayi giriniz (Tamsayinin mutlak degerini giriniz.");
            n = Math.abs(s1.nextInt());
            for (int i = (n-1); i > 0; i--) {
                if (i == 1) {
                    System.out.println( n + " sayisi asal sayidir.");
                    break;
                }
                if (n != 2 && n % i == 0) {
                    System.out.println(n + " sayisi asal sayi degildir.");
                    break;
                } else {
                    continue;
                }
            }
            System.out.println("Kapatmak icin e'ye devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        }
        System.out.println("Kapattiniz");
    }
}
