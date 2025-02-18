/*
EXAMPLE
Girilen sayının tam bolenlerini bulma
*/
import java.util.Scanner;
import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int max = 100;
        String exit = "a";
        while(!exit.equals("e")) {
            int[] divide = new int[max];
            System.out.println("Bir tamsayi giriniz: ");
            int n = Math.abs(s1.nextInt());
            if (n != 0) {
                int j = 0;
                for (int i = -n; i <= n; i++) {
                    if (i != 0 && i != 1 && i != -1) {
                        if (n % i == 0) {
                            divide[j++] = i;
                        }
                    }
                }
            }
            if (divide.length > 0) {
                System.out.println(n + " sayisinin tam bolenleri:");
                for(int k = 0; k < divide.length; k++) {
                    if (divide[k] != 0) {
                        System.out.println(divide[k]);
                    }   
                }
            }
            System.out.println("Kapatmak icin e'ye devam etmek icin herhangi bir tusa basiniz");
            exit = s2.nextLine();
        }
        System.out.println("Kapattiniz");
		    s1.close();
		    s2.close();
		    System.exit(0);
    }
}
