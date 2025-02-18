/*
EXAMPLES
Kullanıcının verdiği pozitif bir sayının tek sayi mı yoksa çift sayı mı olduğunu hesaplama
*/
﻿import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int n = 0;
        String exit = "d";
        while (!exit.equals("e")) {
            System.out.println("Bir tamsayi giriniz: (Tamsayinin mutlak degeri dikkate alinacaktir.)");
            n = Math.abs(s1.nextInt());
            if (n % 2 == 0) {
                System.out.println(n + " sayisi cift sayidir.");
            }
            else {
                System.out.println(n + " sayisi tek sayidir.");
            }
            System.out.println("Kapatmak icin e tusuna, devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        }
        System.out.println("Kapattiniz");
		s1.close();
		s2.close();
		System.exit(0);
    }
}
