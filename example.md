EXAMPLES

https://github.com/hamitmizrak/ibb_ecodation_javacore/blob/master/example.md adresindeki Java sorularının çözümleridir.

*** Kullanıcının verdiği bir sayının pozitif mi negatif mi olduğunu hesaplama:
﻿import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int n = 0;
        String exit = "a";
        while (!exit.equals("e")) {
            System.out.println("Bir tamsayi giriniz: ");
            n = s1.nextInt();
            if (n < 0) {
                System.out.println(n + " bir negatif sayidir.");
            } else if (n > 0) {
                System.out.println(n + " bir pozitif sayidir.");
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

*** 


