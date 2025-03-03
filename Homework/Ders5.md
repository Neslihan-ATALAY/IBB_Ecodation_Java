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

JAVA 8  İLE GELEN ÖZELLİKLER

1. Stream API
Java 8 ile birlikte gelen en büyük yeniliklerden birisi Stream API’dır. Arrayler ve collectionlar üzerinde daha okunabilir kod yazmayı sağlayan bir yapı sunar.
Array'lerde ve collection'larda .stream() ya da .parallelStream() yazarak stream API’ye erişebiliriz.
Stream<T> bir interfacedir. İçerisindeki tüm metotlara java.util.stream paketinin altında bulunan Stream interface'ine göz atarak erişilebilir.
Sıkça kullanılan bazı metotlar şunlardır:
– filter
– map
– sorted
– forEach
– toArray
– collect
– min
– max
– count
– findFirst
– findAny

2. Lambda Expressions & Functional Interfaces
Java 8 ile birlikte gelen bir diğer önemli yenilik de Lambda Expression'lar ve Fonksiyonel interface'lerdir. Bu yenilik ile beraber artık daha okunaklı ve anlaşılır kodların yazılabilmesi sağlanmaktadır.
Functional interface'ler, içinde sadece bir tane abstract metot içeren interface'lerdir ve bir lambda expression'ın tipi her zaman bir functional interface olmak zorundadır. Bir interface'in implementasyonu normalde bu interface'i implemente ederek yapılabilirken, aynı zamanda anonymous class kullanılarak da yapılabilir. Fakat bu yazım tarzının hem kötü bir görüntüsü vardır hem de okunabilirliği düşüktür. Lambda expression'lar sayesinde hem daha az kod yazılır hem de okunabilirlik oldukça arttırılır.

Peki bir lambda expression nasıl yazılır?
(parametreler) -> {yapılacaklar}
(parametreler): Burada kaç tane parametre geçilecekse, bunlar tanımlanır. Hiç parametre geçilmeyecekse () şeklinde yazılabilir.
-> : Eğer doğrudan bir metot referansı kullanılmazsa ok zorunludur.
{yapılacaklar} : Burada da yapılacak işlem belirtilir. Tek satır kod yazılacaksa süslü parantezler yazılmayabilir.

3. Interfaceler için Default ve Static Metotlar
Java 8'den önce interface'ler sadece soyut metotlar içerebiliyordu fakat Java 8 ile birlikte artık interface'ler içine statik ya da default metotlar tanımlanabiliyor.
Default metodun amacı aslında interface'lere yeni metotlar eklemenin daha kolay olabilmesi. Default bir metot override edilmezse, interface içinde tanımlandığı şekliyle kullanılır fakat istenildiği durumda override edilebilir. Bu da sadece gerekli yerlerde override edilerek, yeni metotların daha kolay eklenilebilmesine yardımcı olur.
Statik metotlar ise override edilemezler. Bu interface'i implemente eden tüm classların bu metodu, interface içindeki hali ile kullanılmasını garanti eder.

4. Metot Referansları
Java 8 ile gelen bir diğer yenilik ise metot referanslarıdır.
Bir nesne üzerindeki metodun referansı “::” yardımı ile alınabilir ve bu referans yardımı ile de başka yerlerde kullanılabilir.
Lambda expressionlar ile birlikte sıklıkla kullanılır.

5. Optional
Java’da belki de en çok karşılaşılan hata “NullPointerException” hatasıdır. Yazılımcılar genellikle bu hatadan kaçınmak için bir çok null kontrolü yaparlar ve bu da kodun daha kötü görünmesine neden olur.
Java 8 ile birlikte Optional kavramı hayatımıza girmiştir. Eğer değer null ise daha önceden tanımlanmış bazı işlemleri kolay bir şekilde yaptırabilir ya da null kontroller daha okunabilir bir şekilde yaptırılabilir.

6. Date & Time API
Java 8 ile birlikte gelen yeniliklerden birisi de java.time paketidir. java.util.date paketinde bulunan Date sınıfının kullanımı gerçekten zor ve karmaşık bir yapı sunuyordu. Basitçe bir tarih oluşturmak bile gerçekten çok karmaşıktı. Çünkü yıllar 1900’den ve aylar 0’dan başlıyordu.
java.time paketi ile birlikte LocalDate, LocalTime, LocalDateTime gibi çok kullanışlı sınıflar gelmiştir.

Kaynak: https://b-yaz.com/java-8-ile-gelen-buyuk-yenilikler-nelerdir/

////////////////////////

