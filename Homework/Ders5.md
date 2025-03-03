PARAMETRE VE ARGÜMAN

Metotlara istenilen anda istenilen verilerle işlem yaptırılabilir yani istenilen veri aktarılır. Bu argümanlar ile yapılabilir. Bir metoda gönderilen değere argüman denir. Bu değerleri alan ve işlem yapan değişkenlere ise parametre denir. Bir metoda birden çok ve değişik tipte argüman gönderilebilir. Örneğin;
int topla (int sayi1, int sayi2) 
{
   return sayi1 + sayi2;
}
Burada sayi1 ve sayi2 parametredir.
int a = 10 , b = 69; 
int toplam = topla (a, b);
Burada a ve b argümandır.

Kaynak: http://samedalanur.blogspot.com/2018/02/parametre-ve-arguman-arasindaki-fark.html

//////////////////////////////////

Java’da String’i int ve Integer’a Dönüştürme
JAVA VALUEOF VE PARSEINT

Java’da bir String’i int temel veri türüne veya Integer nesnesine dönüştürmek için iki temel yöntem vardır:

Integer.parseInt(), String’i alır ve int temel veri türünde bir değer döndürür.
Integer.valueOf(), String’i alır ve Integer nesnesi olarak bir değer döndürür.

Java’da String’i int ve Integer’a dönüştürmek için her iki yöntemi de aşağıdaki gibi kodunuzda kullanabilirsiniz:
javaCopy codepublic class Ornek {
    public static void main(String args[]) {
        int i = Integer.parseInt("3");
        int j = Integer.valueOf("4");
        System.out.println("i : " + i); // i : 3 olarak yazdırır
        System.out.println("j : " + j); // j : 4 olarak yazdırır
    }
}
Yukarıdaki örnekte, i ve j değişkenleri ilgili String’in değerini tutar. Şimdi, bu iki yöntemi daha iyi kullanmanıza yardımcı olacak bazı ipuçları öğrenelim.

İpuçları:
String’i int temel veri türüne dönüştürmek için Integer.parseInt() yöntemini, String’i Integer nesnesine dönüştürmek için ise Integer.valueOf() yöntemini kullanın.
Integer.valueOf() yöntemi, String’i int değere dönüştürmek için içeride parseInt() yöntemini çağırır.
Integer.valueOf() yöntemi, bir aralıkta -128 ile 127 arasında Integer nesnelerinin önbelleğini saklayabilir ve her zaman aynı nesneyi döndürebilir, benzer şekilde String sabitleri gibi. JDK kod tabanından alınan valueOf() yönteminde bunu görebilirsiniz.
Her iki yöntem de geçerli bir sayı değilse NumberFormatException fırlatır. 0 ile 9 arasındaki rakamlar dışında, sadece + ve – karakterleri kabul edilebilir.
int temel veri türüne dönüştürdükten sonra otomatik kutulamayı kullanarak onu Integer’a dönüştürebilirsiniz, ancak bu içsel olarak yine Integer.valueOf() yöntemini kullanır.

Kaynak: https://bilisimprofesyonelleri.com/javada-stringi-int-ve-integera-donusturme-nasil-yapilir/

////////////////////////////////////////

