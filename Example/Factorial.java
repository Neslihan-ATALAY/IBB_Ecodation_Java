/*
EXAMPLES
Kullanicidan girilen sayinin faktöriyelini bulma
Kullanicidan bir tamsayi alarak faktöriyelini hesaplayan iterative ve recursive metota göre Java programı
*/
﻿
import java.util.*;

class Main {    
    public static void main(String[] args) {
        int remainingRight = 4;
        int choice = 0;
        Scanner s = new Scanner(System.in);
        Scanner ss = new Scanner(System.in);
        while (remainingRight != 0) {
            System.out.print("Sayi: ");
            int n = Math.abs(s.nextInt());
            System.out.println("1: Iterative Factorial\n2: Recursive Factorial\nDefault: Exit");
            choice = ss.nextInt();
            switch (choice) {
                case 1 :
                    iterative(n);
                    break;
                case 2 :
                    System.out.println(n + " sayisinin faktoriyeli: (" + n + "!) = " +  recursive(n));
                    break;
                default :
                    System.out.println("Kapattiniz.");
                    s.close();
                    ss.close();
                    System.exit(0);
            }            
            remainingRight--;
        }
        if (remainingRight == 0)
        {
            System.out.println("Hakkiniz doldu.");
            s.close();
            ss.close();
            System.exit(0);
        }
    }
    
    private static void iterative(int n) {
        long f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        System.out.println(n + " sayisinin faktoriyeli: (" + n + "!) = " + f);
    }
    
    private static long recursive(int m) {
        if (m == 0 || m == 1)
            return 1;
        else
            return m * recursive(m-1);
    }
}
