/*
EXAMPLE
Girilen sayıyı binary (ikilik) sisteme çevirme
*/
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        int max = 100;
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String exit = "a";
        while (!exit.equals("e")) {
            System.out.println("Bir tamsayi giriniz: (Sayinin mutlak degeri alinacaktir.)");
            int n = Math.abs(s1.nextInt());
            int m = n;
            String binary = "";
            int[] array = new int[max];
            //Arrays.fill(array, 9);
            for (int i = 0; i < max; i++) {
                array[i] = 9;
            } 
            if (m != 0) {
                int j = 0;
                while (m > 0) {
                    array[j++] = m % 2;
                    m = m / 2;
                }
            }
            System.out.print(n + " sayisini ikilik (binary) sisteme cevirme: ");
            for(int k = (array.length - 1); k >= 0; k--) {
                if(array[k] != 9)
                    System.out.print(array[k]);
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
