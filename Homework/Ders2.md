
Yazılım geliştirme sürecinde değişken, fonksiyon, sınıf ve dosya isimlendirmesi, kodun okunabilirliği ve anlaşılabilirliği açısından büyük önem taşır. Farklı programlama dillerinde yaygın olarak kullanılan dört ana yazım formatı (case) bulunmaktadır:

1. CAMEL CASE

Camel Case, her kelimenin ilk harfinin büyük, geri kalan harflerin küçük olduğu ve kelimelerin bitişik yazıldığı bir yazım formatıdır. Ancak ilk kelimenin ilk harfi küçük yazılır. Örnek:
camelCaseExample
Kullanıldığı Yerler: Java, JavaScript, C#, PHP ve TypeScript gibi dillerde yaygın olarak kullanılır. Özellikle Java ve JavaScript'te değişken ve fonksiyon isimlerinde tercih edilir.

2. PASCAL CASE

Pascal Case, Camel Case'e benzerdir ancak her kelimenin ilk harfi büyük yazılır. Bu format genellikle sınıf ve tip isimlendirmelerinde kullanılır. Örnek:
PascalCaseExample
Kullanıldığı Yerler: C#, Java, Swift, Delphi ve .NET tabanlı dillerde sıkça kullanılır. Genellikle sınıf, struct, enum gibi yapıların isimlendirilmesinde tercih edilir.

3. SNAKE CASE

Snake Case, kelimelerin alt çizgi (_) ile ayrıldığı bir yazım formatıdır. Tüm harfler genellikle küçük yazılır, ancak bazı durumlarda büyük harfler de kullanılabilir. Örnekler:
Küçük harf: snake_case_example
Büyük harf: SNAKE_CASE_EXAMPLE
Kullanıldığı Yerler: Python, Ruby, C, Rust ve PostgreSQL gibi dillerde değişken ve fonksiyon isimlendirmelerinde sıkça kullanılır. Python'da özellikle değişken ve fonksiyon isimlerinde tercih edilir.

4. KEBAP CASE

Kebab Case, kelimelerin tire (-) ile ayrıldığı ve tüm harflerin küçük yazıldığı bir yazım formatıdır. Örnek:
kebab-case-example
Kullanıldığı Yerler: HTML, CSS ve URL'lerde yaygın olarak kullanılır. Özellikle CSS sınıf ve ID isimlerinde tercih edilir. Ayrıca, bazı JavaScript çerçeveleri ve URL yapılarında da kullanılır.

Yazım Formatlarının Karşılaştırması
Okunabilirlik:
Snake Case ve Kebab Case, kelimeler arasındaki boşluğu vurgulamak için alt çizgi veya tire kullandıkları için okunabilirliği artırır.
Camel Case ve Pascal Case, boşluk kullanmadan kelimeleri birleştirir, ancak büyük harflerle kelime başlangıçlarını belirginleştirir.
Kullanım Alanı:
Snake Case ve Camel Case, genellikle fonksiyonlar, değişkenler ve dosya isimlerinde kullanılır.
Pascal Case, sınıf ve tür isimlendirmelerinde yaygındır.
Kebab Case, özellikle web geliştirme ve URL yapılarında kullanılır.
Diller Arası Tercihler:
Programlama dillerinin topluluk standartları ve kılavuzları, hangi yazım formatının kullanılacağını belirler. Örneğin, Python'da Snake Case, Java'da Camel Case, C#'ta Pascal Case yaygındır.

Kaynak: https://appictohub.com/blog/31/yazim-formatlari-snake-case-camel-case-pascal-case-ve-kebab-case-arasindaki-farklar

///////////////////////////

STACK MEMORY - HEAP MEMORY

Stack bellek uzun bir kutu şeklinde gibidir. Yeni bir nesne eklenmek istendiğinde, bu nesne en üstte olacak şekilde sıralanır. En alttaki nesneye ulaşmak için en üstteki nesneleri tek tek çıkarmak gerekir. Basittir. Heap belleği ise geniş bir oda şeklinde gibidir. Boş bulunan her yere bir nesne yerleştirilir ve istenilen bir nesne de istenilen anda alınabilir. Tabiki geniş bir odada istenilen nesneyi aramak vakit alan bir işlemdir. Komplekstir.

Kaynak: https://www.yazilimuzmanlari.com/Articles/Detail/Stack_ve_Heap_Bellek/118

Stack ve Heap, bellek yönetiminde kullanılan iki farklı veri yapısıdır.

Stack, LIFO (Last In First Out) yapısına sahip bir veri yapısıdır. Yani en son eklenen veri, en önce çıkarılır. Stack bellekte yer kaplar ve programın çalışma zamanı sırasında kullandığı değişkenler, fonksiyon çağrıları gibi verileri saklar.

Stack, bellekte bir takım bölümleri ayırmaktadır. İşlemler için en üstteki bölüme ekleme ve çıkarma işlemi yapılır. Bu nedenle, stack aynı zamanda LIFO (Last In First Out) yapısına sahip olarak adlandırılır.

Stack veri yapısı çeşitli programlama dillerinde kullanılabilir. Örneğin; fonksiyon çağrıları, return adresleri, local değişkenler gibi işlemler için kullanılır. Ayrıca, backtracking, undo/redo gibi işlemlerde de kullanılabilir.

Heap ise, bellekte rastgele yer kaplar ve programın çalışma zamanı sırasında dinamik olarak oluşan verileri saklar. Heap, FIFO (First In First Out) yapısına sahip değildir. Programcının bellekte ne zaman ve ne kadar yer ayrılması gerektiğini kontrol etmesi gerekir.

Heap, bellekte bir takım bölümleri ayırmaktadır. İşlemler için herhangi bir bölüme ekleme ve çıkarma işlemi yapılır. Heap veri yapısı, dinamik bellek alocasyonu için kullanılır. Örneğin; new ve malloc gibi komutların arkasında heap kullanılır. Ayrıca, Priority Queue ve Huffman Coding gibi algoritmalarda da kullanılabilir.

Heap veri yapısı genellikle iki türde kullanılır: Max-Heap ve Min-Heap. Max-Heap, her düğümde en büyük değerin bulunduğu bir yapıdır, Min-Heap ise her düğümde en küçük değerin bulunduğu bir yapıdır.

Genel olarak, Stack bellekte daha az yer kaplar fakat okuma/yazma işlemleri daha hızlıdır. Heap ise daha fazla bellek yer kaplar ancak okuma/yazma işlemleri daha yavaştır.

Kaynak: https://ilaydakosar.com/stack-ve-heap-kavramlari/

////////////////////////////

JAVADA ESCAPE SEQUENCE KULLANIMI

"\n" Ekrana gelecek görüntünün bir satır aşağıya inmesini sağlar.
"\t" Ekrana gelecek görüntüyü sekiz karakter sağa götürür.
"\b" İmleci önceki satırın son sütununa taşır.
"\r" Satırın ilk sütununu taşımaya yarar.
"\f" Sonraki sayfayı başlatmaya yarar.
"\\" Metne \ işareti koymaya yarar.
\' Ekrana  ‘ (tek tırnak) işaretini koymamıza yarar.
\" Ekrana  “ (çift tırnak) koymamıza yarar.

Kaynak: https://www.dijitalders.com/icerik/44/2763/java_escape_sequence_kullanimlari.html

/////////////////////////////

SCANNER SINIFI

Java Konsoldan Veri Almak
Java’da konsoldan veri almak için Scanner sınıfı kullanılır. Ama bu sınıfı kullanmadan önce sınıfımıza Scanner sınıfını dahil etmemiz gerekir. Bunun için import deyimi kullanılır.
import java.util.Scanner;

Java Veri Alma Metotları
Method	      Açıklama
nextBoolean()	Kullanıcıdan boolean değişkenlere veri almak için kullanılır
nextByte()	Kullanıcıdan byte değişkenlere veri almak için kullanılır
nextDouble()	Kullanıcıdan double değişkenlere veri almak için kullanılır
nextFloat()	Kullanıcıdan float değişkenlere veri almak için kullanılır
nextInt()	Kullanıcıdan int değişkenlere veri almak için kullanılır
nextLine()	Kullanıcıdan String değişkenlere veri almak için kullanılır
nextLong()	Kullanıcıdan long değişkenlere veri almak için kullanılır
nextShort()	Kullanıcıdan short değişkenlere veri almak için kullanılır

Kaynak: https://kodlamavakti.com/java/konsoldan-veri-alma-scanner/

//////////////////////////
