/*
EXAMPLE
Sayı tabanı çevirme
*/
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner s1, s2 = null;
        int max = 100;
        s1 = new Scanner(System.in);
        s2 = new Scanner(System.in);
        String exit = "a";
        while(!exit.equals("e")) {
            try {
                System.out.println("Bir sayi giriniz: ");
                int n = Math.abs(s1.nextInt());
                System.out.println("Girdiginiz sayi hangi tabandadir? ");
                int k1 = Math.abs(s1.nextInt());
                System.out.println("Sayi hangi tabanda sayiya cevrilsin? ");
                int k2 = Math.abs(s1.nextInt());
                String result = "";
                int[] array = new int[max];
                Arrays.fill(array, -1);
                if (n != 0) {
                    int m = n;
                    int l = 0;
                    int i = 0;
                    while (m > 0) {
                        l += (m % 10) * Math.pow(k1, i++);
                        m = m / 10;
                    }
                    int p = l;
                    System.out.print(k1 + " tabaninda " + n + " sayisinin 10 (on) tabaninda sayisi " + p + ", " + k2 + " tabaninda sayisi: ");
                    i = 0;
                    while (p > 0) {
                        array[i++] = p % k2;
                        p = p / k2;
                    }
                    i = array.length - 1;
                    while(i > -1) {
                        if (array[i] != -1) {
                            result += (array[i]);
                        }
                        i--;
                    }
                    System.out.println(result);
                    System.out.println(n + "(" + k1 + ") = " + l + "(10) = " + result + "(" + k2 + ")");
                }
                System.out.println("\nKapatmak icin e'ye, devam etmek icin herhangi bir tusa basiniz.");
                exit = s2.nextLine();
            } catch (Exception e) {
                System.out.println("Istisna");
            }
        }
        if (exit.equals("e")) {
            s1.close();
            s2.close();
            System.out.println("Kapattiniz");
        }
    }
}
