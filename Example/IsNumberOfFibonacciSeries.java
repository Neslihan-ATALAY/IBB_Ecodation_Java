/*
EXAMPLE
Girilen sayının Fibonacci serisinde olup olmadığını kontrol etme
*/
import java.util.*;
class Main {
    private static int number = 0;
    public static void main(String[] args) throws ArithmeticException {
        Scanner s1, s2 = null;
        s1 = new Scanner(System.in);
        s2 = new Scanner(System.in);
        String exit = "a";
        while (!(exit.equals("e") || exit.equals("E"))) {
            System.out.println("Onluk tabanda bir pozitif tamsayi giriniz: (Negatif sayi girerseniz sayinin mutlak degeri alinacaktir.)");
            int n = Math.abs(s1.nextInt());
            number = n;
            if (n != 0) {
                try {
                    System.out.println(n + " sayisi " + (FindFibonacci(n) ? "Fibonacci sayidir.": "Fibonacci sayi degildir."));
                    System.out.println(n + " sayisi " + (FindRecursiveFibonacci(0, 1) ? "Fibonacci sayidir.": "Fibonacci sayi degildir."));
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
            System.out.println("\nKapatmak icin e tusuna, devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        } 
        if (exit.equals("e") || exit.equals("E")) {
            s1.close();
            s2.close();
            System.out.println("Kapattiniz");
        }
    }
    
    private static boolean FindFibonacci(int n) {
        boolean isFibonacci = false;
        int m = n;
        if (m != 0) {
            int n1 = 0, n2 = 1, n3 = 0;
            while (n3 < m) {
                n3 = n1 + n2;
                n1 = n2;
                n2 = n3;
                if (n3 == m) {
                    isFibonacci = true;
                    break;
                }
            }
        }
        return isFibonacci;
    }
    
    private static Boolean FindRecursiveFibonacci(int n1, int n2) {
        if ((n1 + n2) == number) {
            return true;
        } else if ((n1 + n2) > number) {
            return false;
        }
        return FindRecursiveFibonacci(n2, (n1 + n2));
    }
}
