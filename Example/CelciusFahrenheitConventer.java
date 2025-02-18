/*
EXAMPLE
Santigrat (Celcius) - Fahrenheit Dönüştürücü
Kullanıcıdan Santigrat (Celcius) cinsinden sıcaklık değeri alıp Fahrenheit'a çeviren Java programı
FORMÜL: F = (C * 9/5) + 32
*/
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        double F = 0, C = 0;
        String exit = "n";
        while (!exit.equals("e")) {
            System.out.println("Santigrat tipinden (C) bir sicaklik degeri giriniz: ");
            C = s1.nextDouble();
            F = (C * 9/5) + 32;
            System.out.println(C + " Santigrat (C) sicaklik degeri " + F + " Fahrenheit (F) dir.");
            System.out.println("Kapatmak icin e tusuna, devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        }
        System.out.println("Kapattiniz");
	s1.close();
	s2.close();
	System.exit(0);
    }
}
