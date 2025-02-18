/*
EXAMPLES
Birinci Dereceden Bir Bilinmeyenli Denklemi Çözme
Kullanıcıdan ax + b = 0 denklemindeki a ve b değerlerini alıp x'i hesaplayan Java programı
*/
﻿import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        double a = 0, b = 0, x = 0;
        String exit = "a";
        while (!exit.equals("e")) {
            System.out.println("Bir a sayisi giriniz: ");
            a = s1.nextDouble();
            System.out.println("Bir b sayisi giriniz: ");
            b = s1.nextDouble();
            x = ((-1) * b) / a;
            System.out.println("(" + a + ")x + (" + b + ") = 0 ise ");
            System.out.println("x = " + x);
            System.out.println("Kapatmak icin e tusuna, devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        }
        System.out.println("Kapattiniz");
		    s1.close();
		    s2.close();
		    System.exit(0);
    }
}
