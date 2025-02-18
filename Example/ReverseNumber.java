/*
EXAMPLE
Girilen sayının tersini yazdırma
*/
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String exit = "a";
        while (!exit.equals("e")) {
            System.out.println("Bir sayi giriniz: ");
            int m = 0;
            String reverseNumberString = "";
            int n = Math.abs(s1.nextInt());
            m = n;
            while(m > 0) {
                reverseNumberString += m % 10;
                m = m / 10;
            }
            int reverseNumber = Integer.parseInt(reverseNumberString);
            System.out.println(n + " sayisinin tersi = " + reverseNumber);
            System.out.println("\nKapatmak icin e'ye, devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        }
        System.out.println("Kapattiniz");
        s1.close();
        s2.close();
        System.exit(0);
    }
}
