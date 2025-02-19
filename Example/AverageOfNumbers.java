/*
EXAMPLE
Kullanıcının girdiği n tane sayının ortalamasını hesaplayan Java programı
*/
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String exit = "a";
        double[] array = null;
        double number = 0;
        double sum = 0, average = 0;
        int countOfNumbers = 0;
        try {
            while (!exit.equals("e")) {
                System.out.println("Kac tane sayi girilecektir? ");
                countOfNumbers = Math.abs(s1.nextInt());
                array = new double[countOfNumbers];
                System.out.println("Ortalamasinin bulunmasini istediginiz sayilari (tamsayi, ondalikli sayi vb) alt alta sirasiyla giriniz: ");
                int i = 0;
                while (i < countOfNumbers) {
                    number = Math.abs(s1.nextDouble());
                    array[i++] = number;
                }
                if (countOfNumbers > 0) {
                    for (double item : array) {
                        System.out.print(item + " ");
                        sum += item;
                    }
                    average = sum / countOfNumbers;
                    System.out.printf("sayilarinin ortalama degeri = %-30.3f", average);
                }
                System.out.println("\nKapatmak icin e'ye, devam etmek icin herhangi bir tusa basiniz.");
                exit = s2.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Istisna");
        } finally {
            s1.close();
            s2.close();
            System.out.println("Kapattiniz");
        }
    }
}
