/*
EXAMPLE
Fibonacci serisi üretme
Kullanıcının girdiği bir sayı kadar elemanı olan Fibonacci serisini üreten Java programı
*/
import java.util.Scanner;
class Main {
    public static void main(String [] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int n = 0;
        long n1 = 0, n2 = 1, n3 = 0;
        String exit = "a";
        while (!exit.equals("e")) {
            n = 0; n1 = 0; n2 = 1; n3 = 0;
            String fibonacciSerie = "";
            System.out.println("Fibonacci serisi kac elemanli olsun?");
            n = Math.abs(s1.nextInt());
            for (int i = 0; i < n; i++) {
                n3 = n1 + n2;
                n1 = n2;
                n2 = n3;
                fibonacciSerie += " - " + n3 + " - ";
            }
            System.out.println(fibonacciSerie);
            System.out.println("Kapatmak icin e'ye devam etmek icin herhangi bir tusa basiniz.");
            exit = s2.nextLine();
        }
        System.out.println("Kapattiniz");
        s1.close();
        s2.close();
        System.exit(0);
    }
}
