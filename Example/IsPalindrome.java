/*
EXAMPLE
Girilen sayının palindrom olup olmadığını kontrol eden Java programı
Palindrom sayılar: 121, 1331 gibi tersten yazıldığında aynı kalan sayılar
*/
import java.util.*;
class Main {
    public static void main(String[] args) {
        int max = 100;
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String exit = "a";
        while (!exit.equals("e")) {
            System.out.println("Bir tamsayiyi giriniz: (Sayinin mutlak degeri alinacaktir)");
            int n = Math.abs(s1.nextInt());
            int[] array = new int[max];
            int[] newArray = null;
            boolean pali = true;
            int m = n;
            int l = 0, p = 0;
            while (m > 0) {
                array[l++] = m % 10;
                m = m / 10;
            }
            if (l > 0) {
                newArray = new int[l];
                for (int i = 0; i < l; i++) {
                    newArray[i] = array[i];
                }
            }
            if (l % 2 == 0) {
                p = l / 2;
            } else {
                p = l / 2 + 1;
            }
            int i = 0, j = l - 1;
            while (i < p) {
                if (newArray[i] != newArray[j]) {
                    pali = false;
                    break;
                }
                i++; j--;
            }
            if (pali == false) {
                System.out.println("\n" + n + " Sayisi Palindrom Degil");
            } else {
                System.out.println("\n" + n + " Sayisi Palindrom");
            }
            System.out.println("\nKapatmak icin e'ye devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        }
        System.out.println("Kapattiniz");
        s1.close();
        s2.close();
        System.exit(0);
    }
}
