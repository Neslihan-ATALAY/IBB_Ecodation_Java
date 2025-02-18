/*
EXAMPLE
Girilen iki sayının EBOB (en büyük ortak bölen) ve EKOK (en küçük ortak kat) değerlerini bulma
*/
import java.util.*;
class Main {
    public static void main(String[] args) {
        int max = 100;
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String exit = "a";
        while (!exit.equals("e")) {
            System.out.println("Birinci tamsayiyi giriniz: ");
            int N = Math.abs(s1.nextInt());
            System.out.println("Ikinci tamsayiyi giriniz: ");
            int M = Math.abs(s1.nextInt());
            System.out.println();
            int[] array1 = new int[max];
            int[] arrayEbob = new int[max];
            int[] arrayEkok = new int[max];
            int EBOB = 1, EKOK = 1;
            int i = 0, j = 0;
            for (int k = 2; k <= Math.min(N, M); k++) {
                if ((N % k == 0) && (M % k == 0)) {
                    arrayEbob[i++] = k;
                }
            }
            int a = N, b = M;
            for (int n = 2; n < Math.max(N, M); n++) {
                while ((b % n == 0) || (a % n == 0)) {
                    System.out.println(a + "-" + b + "|" + n);
                    arrayEkok[j++] = n;
                    if (a % n == 0) a = a / n;
                    if (b % n == 0) b = b / n;
                }
            }
            System.out.println(a + "-" + b + "|1");
            Arrays.sort(arrayEkok);
            Arrays.sort(arrayEbob);
            //System.out.println(Arrays.toString(arrayEbob));
            //System.out.println(Arrays.toString(arrayEkok));
            int l = arrayEkok.length;
            for (int k = l-1; k > -1; k--) {
                if (arrayEkok[k] != 0) {
                    EKOK *= arrayEkok[k];
                }
            }
            System.out.println("\n" + N + " ve " + M + " sayilarinin EKOK Degeri: " + EKOK);
            int m = arrayEbob.length;
            EBOB = arrayEbob[m-1];
            for (int k = m-2; k > -1; k--) {
                if (arrayEbob[k] != 0 && arrayEbob[m-1] % arrayEbob[k] != 0) {
                    EBOB *= arrayEbob[k];
                }
            }
            System.out.println("\n" + N + " ve " + M + " sayilarinin EBOB Degeri: " + EBOB);
            System.out.println("\nKapatmak icin e'ye devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        }
        System.out.println("Kapattiniz");
        s1.close();
        s2.close();
        System.exit(0);
    }
}
