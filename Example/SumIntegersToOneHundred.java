/*
EXAMPLES
Kullanıcının verdiği pozitif bir sayıya kadar toplamı hesaplama
Şartlar-1) Kullanıcı eğer sayı olarak 100 fazla sayı girerse 100 kadar toplasın (break).
Şartlar-2) Kullanıcı verdiği sayılar içinde eğer 47 varsa bunu toplamaya dahil etmesin (continue).
*/
﻿import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int sum = 0;
        int n = 0;
        String exit = "a";
        while (!exit.equals("e")) {
            sum = 0;
            System.out.println("Bir tamsayi giriniz: (Tamsayinin mutlak degeri dikkate alinacaktir.)");
            n = Math.abs(s1.nextInt());
            for (int i = 0; i <= n; i++) {
                if (i > 100) {
                    System.out.println("100'den buyuk sayilar toplanmayacaktir, sayilar 100'e kadar toplanacaktir.");
                    break;
                }
                if (i == 47) {
                    System.out.println("47 sayisi toplama dahil edilmeyecektir.");
                    continue;
                }
                sum += i;
            }
            System.out.println("Toplam sonuc = " + sum);
            System.out.println("Kapatmak icin e tusuna, devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        }
        System.out.println("Kapattiniz");
		    s1.close();
		    s2.close();
		    System.exit(0);
    }
}
