/*
EXAMPLE
Girilen sayının basamaklarındaki en büyük rakamı bulma
Kullanıcının girdiği bir sayının içindeki en büyük rakamı bulan Java programı
*/
import java.util.*;
class Main {
    public static void main(String[] args) throws ArithmeticException {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int max = 100;
        String exit = "a";
        while (!(exit.equals("e") || exit.equals("E"))) {
            int[] array = new int[max];
            Arrays.fill(array, -1);
            System.out.println("Onluk tabanda bir tamsayi giriniz: (Sayinin mutlak degeri alinacaktir.)");
            int n = Math.abs(s1.nextInt());
            int k = 10;
            if (n != 0) {
                int m = n;
                int l = 0;
                try {
                    while (m > 0) {
                        array[l++] = m % k;
                        m = m / k;
                    }
                    int i = 0;
                    int maxNumber = -99;
                    while (i < array.length) {
                        if (array[i] != -1) {
                            if (array[i] > maxNumber)    {
                                maxNumber = array[i];
                            }
                        }
                        i++;
                    }
                    System.out.println(n + " sayisinin en buyuk rakami: " + maxNumber);
                } catch (ArithmeticException ae) {
                    System.out.println("Istisna");
                    ae.getMessage();
                } catch (Exception e) {
                    System.out.println("Istisna");
                    e.getMessage();
                }
            } else {
                System.out.println("Sifirdan (0) farkli bir sayi giriniz.");
            }
            System.out.println("Kapatmak icin e tusuna, devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        } 
        if (exit.equals("e") || exit.equals("E")){
            s1.close();
            s2.close();
            System.out.println("Kapattiniz");
        }
    }
}
