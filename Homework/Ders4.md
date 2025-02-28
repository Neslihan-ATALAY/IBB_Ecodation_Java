
SWITCH - CASE VE IF - ELSEIF - ELSE KARŞILAŞTIRMASI

AKIŞ KONTROL MEKANİZMALARI
Bir programın çoğu zaman çeşitli koşullara göre farklı komutlar ile çalıştırılması gerekir. Benzer şekilde çoğu komutun da yalnızca bir kez çalıştırılması yeterli gelmez, belli koşulları sağladığı sürece sürekli çalıştırılması isteteilen komutlar olabilir. İşte bu gibi durumlar için C#’ta akış kontrol mekanizmaları vardır.

If – Else If – Else Blokları
if else deyimi sayesinde belli bir koşul sağlandığında söz konusu komutlar çalıştırılır, o belli koşullar sağlanmadığında çalıştırılmaz ya da başka komutlar çalıştırılır. Kullanılışı şu şekildedir:

if(koşul)
    komut1;//Tek satır kodlarda  {} gerek yoktur.
else
    komut2;//Tek satır kodlarda  {} gerek yoktur.

if(koşul)
{
   komutlar1;
   komutlar2;
   komutlar3;
}
else
{
   Komutlar4;
}

Yukarıdaki örneklerde eğer koşul sağlanırsa 1. komutlar, sağlanmazsa 2. komutlar çalıştırılır. if veya else’in altında birden fazla komut varsa bu komutları parantez içine almak gerekir. if veya else‘in altında tek komut varsa bu komutları parantez içine almak gerekmez.

if else yapılarında else kısmının bulunması zorunlu değildir. Bu durumda sadece koşul sağlandığında bir şeyler yapılacak, koşul sağlanmadığında bir şeyler yapılmayacaktır.

if bloklarının diğer kullanım şekli ile else if formatındadır. Bu formattan birçok koşula göre program dallanma gerçekleştirir.

C# iç içe if else kullanılmasına izin verir. Yani iç içe birçok koşul eklenebilir. Bu koşullar dıştan içe doğru belirlenen şart sağlandığı sürece işler.

if(koşul1)
{
    if(koşul2)
        komut1;
    else
    {
        if(koşul3) {
            komut2;
            komut3;
            komut4;
        }
    }
 }
 else
    komut5;

Switch Case Bloğu
Switch deyimi bazı if else deyimlerinin yaptığı işi daha az kodla yapar. Genellikle bazı karmaşık if else bloklarını kurmaktansa switch’i kullanmak programın anlaşılırlığını artırır. Ancak tabii ki basit if else bloklarında bu komutun kullanılması gereksizdir.
Switch case if’e benzer şekilde bir değişkenin almış olduğu değere uygun kodları icra eder. Burada değişken switch deyiminde parentez içerisine yazılır, değişkenin almış olduğu değer case ile belirtilen koşullarla karşılaştırılır. Koşul sağlandığında koşulun ait olduğu case bloğu çalışacaktır. Diğer case blokları çalıştırılmaz.
Her bir case deyimi break; ile sonlandırılmalıdır. Eğer case ile belirtilen koşulların hiç biri sağlanmaz ise default ile belirtilen komutlar çalışacaktır. Her bir koşuldan sonra ve default deyiminden sonra iki nokta üstüste (:) işareti kullanıldığına dikkat ediniz.


switch(ifade)
 {
    case sabit1:
        komut1;
        break;
    case sabit2:
        komut2;
        break;
    default:
        komut3;
        break;
 }

SIK YAPILAN HATALAR
– if bloklarının sonunda “;” kullanılması. if ();
– if bloğunun sonunu belirleyen küme parantezlerinden sonra “;” kullanmak {};
– Çok satırlı if kullanımında { } parantezlerinin kullanılmaması durumunda sadece bir satır işletilir.
– Else bloğundan sonra “;” kullanılması. (Else;)
– if bloğunda karşılaştırma operatörü olarak “==” yerin “=” kullanmak.
– Else if bloğunu bitişik yazman. Elseif()
– Break komutu unutulursa koşula bakılmaksızın diğer case bloğu işletilir.
– Switch (Koşul); ifadesinin sonuna “;” koyulması.
– Case satırının sonuna “;” koyulmaması.
– Case etiketinin birleşik yazılması. CaseDeger;

Kaynak: https://www.kodyaz.net/c-akis-kontrol-mekanizmalari-if-else-switch-case/

//////////////////////////////

FOR VE WHILE DÖNGÜLERİ

Döngüler, bir işlemi belirli bir sayıda veya belirli bir koşula göre tekrarlamak için kullanılan programlama yapı taşlarıdır. C# dilinde en sık kullanılan döngülerden ikisi for ve while döngüleridir. Her iki döngü de benzer amaçlara hizmet eder, ancak kullanım alanları ve yapıları farklıdır.

For Döngüsü

For döngüsü, genellikle bir işlemin belirli bir sayıda tekrarlanması gerektiğinde kullanılır. Döngü çalıştırılmadan önce sayaç değişkeni, koşul ve sayaç değişkeninin güncellenmesi tanımlanır.
for (int i = 0; i < 10; i++)
{
    Console.WriteLine($"Değer: {i}");
}
Yukarıdaki örnekte, sayaç i sıfırdan başlayarak 10'dan küçük olduğu sürece çalışır ve her adımda 1 artırılır.

While Döngüsü

While döngüsü, genellikle bir işlemin belirsiz bir süre boyunca tekrarlanması gerektiğinde kullanılır. Koşul doğru olduğu sürece döngü çalışmaya devam eder.
int counter = 0;
while (counter < 10)
{
    Console.WriteLine($"Değer: {counter}");
    counter++;
}
Yukarıdaki örnekte, counter değişkeni 10'dan küçük olduğu sürece döngü çalışır ve her adımda 1 artırılır.

For ve While Döngüsü Arasındaki Farklar

For Döngüsü: Sayaç değişkeninin başlangıç değeri, koşulu ve artışı tek bir satırda tanımlanır. Bu nedenle daha düzenlidir ve genellikle sayaçlı işlemler için tercih edilir.
While Döngüsü: Koşul doğru olduğu sürece çalışır. Sayaç veya koşul döngü dışında tanımlanır ve güncellenir. Bu, daha esnek ama dikkatli kullanılmazsa sonsuz döngü riskine açık bir yapıdır.
For döngüsü genellikle döngü sayısı biliniyorsa kullanılırken, while döngüsü genellikle koşula bağlı olarak çalıştırılır.
C# ile kod yazarken her iki döngüyü de ihtiyaçlarınıza göre tercih edebilirsiniz. Doğru döngüyü seçmek, kodunuzun daha okunabilir ve performanslı olmasını sağlar.

Kaynak: https://kodlamavakti.com/csharp/for-while-arasindaki-farklar/

//////////////////////////////////////////////

STRING BİRLEŞTİRME (CONCATENATION) TÜRLERİ

+ ve += İşleçleri

Dize değişkenlerini birleştirmek için + veya += işleçlerini, dize ilişkilendirme veya String.Format, String.Concat, String.Join veya StringBuilder.Append yöntemlerini kullanabilirsiniz. + operatörü kullanımı kolaydır ve sezgisel kod sağlar. Bir deyimde birkaç + işleci kullansanız bile, dize içeriği yalnızca bir kez kopyalanır. Aşağıdaki kod, dizeleri birleştirmek için + ve += işleçlerini kullanma örneklerini gösterir:

string userName = "<Type your name here>";
string dateString = DateTime.Today.ToShortDateString();

// Use the + and += operators for one-time concatenations.
string str = "Hello " + userName + ". Today is " + dateString + ".";
System.Console.WriteLine(str);

str += " How are you today?";
System.Console.WriteLine(str);

Dize Enterpolasyonu

Bazı ifadelerde, aşağıdaki kodda gösterildiği gibi dize ilişkilendirmesini kullanarak dizeleri birleştirmek daha kolaydır:
string userName = "<Type your name here>";
string date = DateTime.Today.ToShortDateString();

// Use string interpolation to concatenate strings.
string str = $"Hello {userName}. Today is {date}.";
System.Console.WriteLine(str);

str = $"{str} How are you today?";
System.Console.WriteLine(str);
Not
Dize birleştirme işlemlerinde C# derleyicisi null dizeyi boş dizeyle aynı şekilde işler.
Yer tutucular için kullanılan tüm ifadeler de sabit dizeler olduğunda, sabit bir dize başlatmak için dize ilişkilendirmesini kullanabilirsiniz.

String.Format

Dizeleri birleştirmenin başka bir yöntemi de String.Format. Az sayıda bileşen dizesinden bir dize oluştururken bu yöntem iyi çalışır.

String Builder

Diğer durumlarda, dizeleri birleştirdiğiniz kaynak dize sayısını bilmediğiniz bir döngüde birleştiriyor olabilirsiniz ve gerçek kaynak dize sayısı büyük olabilir. StringBuilder sınıfı bu senaryolar için tasarlanmıştır. Aşağıdaki kod, dizeleri birleştirmek için StringBuilder sınıfının Append yöntemini kullanır.
// Use StringBuilder for concatenation in tight loops.
var sb = new System.Text.StringBuilder();
for (int i = 0; i < 20; i++)
{
    sb.AppendLine(i.ToString());
}
System.Console.WriteLine(sb.ToString());
Dize birleştirmeyi veya StringBuilder sınıfını seçmek için nedenleri hakkında daha fazla bilgi edinebilirsiniz.

String.Concat veya String.Join

Bir koleksiyondan dizeleri birleştirmenin bir diğer seçeneği de String.Concat yöntemi kullanmaktır. Sınırlayıcının kaynak dizeleri ayırması gerekiyorsa String.Join yöntemini kullanın. Aşağıdaki kod, her iki yöntemi de kullanarak bir sözcük dizisini birleştirir:
string[] words = { "The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog." };

var unreadablePhrase = string.Concat(words);
System.Console.WriteLine(unreadablePhrase);

var readablePhrase = string.Join(" ", words);
System.Console.WriteLine(readablePhrase);

LINQ ve Enumerable.Aggregate

Sonunda, bir koleksiyondaki dizeleri birleştirmek için LINQ ve Enumerable.Aggregate yöntemini kullanabilirsiniz. Bu yöntem bir lambda ifadesi kullanarak kaynak dizeleri birleştirir. Lambda ifadesi, her dizeyi var olan birikmeye ekleme işini yapar. Aşağıdaki örnek, dizideki her sözcük arasına boşluk ekleyerek bir sözcük dizisini birleştirir:
string[] words = { "The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog." };
var phrase = words.Aggregate((partialPhrase, word) =>$"{partialPhrase} {word}");
System.Console.WriteLine(phrase);
Bu seçenek, her yineleme için bir ara dize oluşturduğundan koleksiyonları birleştirmek için diğer yöntemlerden daha fazla ayırmaya neden olabilir. Performansı iyileştirmek kritikse, Enumerable.Aggregateyerine bir koleksiyonu birleştirmek için StringBuilder sınıfını veya String.Concat veya String.Join yöntemini göz önünde bulundurun.

Kaynak:https://learn.microsoft.com/tr-tr/dotnet/csharp/how-to/concatenate-multiple-strings

String Buffer

String buffer değiştirilebilir yapılardır. String buffer oluşturarak elde edilen Stringler manipule edildiklerinde değerleri tamamen değişir. Örneğin;
StringBuffer stringBuffer = new StringBuffer("string buffer");
stringBuffer.append(" changed");
System.out.println(stringBuffer);// string buffer changed

String Buffer - String Builder Farkı Nedir?

String builder, String buffer’den daha hızlıdır,
String buffer ise String builder’a göre biraz daha güvenlidir,
String builder, String buffer'a göre daha verimlidir

Sebebi ise, String Buffer tüm işlemler için kendini kilitleyerek korumaya alır, bu sebepten dolayı hızında yavaşlama olur, güvenlik artar. String builder ise gerektiğinde kendini korumaya alır, bu yüzden hızları daha yüksektir, ama güvenliği biraz daha düşüktür.

Kaynak: https://tr.linkedin.com/pulse/string-buffer-ve-builder-nedir-yusuf-aslan

Karşılaştırma:

String nesneler değişmezdir ama StringBuffer ve StringBuilder nesneler değişebilir.

StringBuffer ve StringBuilder benzerdir. Fakat StringBuilder daha hızlı ve tek threadli program için StringBuffer'ın yerine tercih edilir. Eğer thread safety (thread güvenliği) gerekli ise StringBuffer kullanılır.

String özellikleri: Değişmez, thread güvenli, yüksek bellek verimliliği, yüksek performans (senkronizasyon yok). String değişmezlik istendiğinde kullanılır. String'ler JDK 1.0 ile tanıtıldı.

String builder özellikleri: Değişebilir, thread güvenli değil, verimli bellek kullanımı, yüksek performans (senkronizasyon yok). Thread güvenliği gerekli olmadığında kullanılır. String builder'lar JDK 1.5 ile tanıtıldı.

String buffer özellikleri: Değişebilir, thread güvenli, az verimli bellek kullanımı, düşük performans (senkronizasyon sayesinde). Thread güvenliği gerekli olduğunda kullanılır. String buffer'lar JDK 1.0 ile tanıtıldı.

Kaynak: https://www.geeksforgeeks.org/string-vs-stringbuilder-vs-stringbuffer-in-ja

/////////////////////////////

BREAK, CONTINUE

Java'da break deyimi , döngü içerisinde koşul sağlanmadan döngüyü bitirmek için kullanılır.

Java'da "continue" deyimi , döngü içinde bir koşul oluştuğunda o döngüyü tamamlamadan bir sonraki kademeye geçmeye yarar.

Kaynak: https://kodlamavakti.com/java/donguler-break-continue-kullanimi/

RETURN

Java'da oluşturduğumuz bir metodun bir değer üretmesini istendiğinde, "return" deyimi kullanılır. Metot içerisinde yazılan kod parçacıkları çalışacaktır, buna ek olarak metot içinde oluşturduğumuz bir veriyi dışarıya aktarma ihtiyacı duyabiliriz, bu durumlarda "return" deyimi kullanılır. Geri dönecek değerin veri tipi, metot tanımlarken verdiğimiz veri tipi ile aynı olmalıdır. Aksi halde derleyici tarafından hata alınır.

Kaynak: https://academy.patika.dev/courses/java101/return-void

////////////////////////////////

STATİK YAPI

Java'da statik değiştirici, bir şeyin doğrudan bir sınıfla ilgili olduğu anlamına gelir: eğer bir alan statikse, o zaman sınıfa aittir; bir yöntem statik ise, o zaman sınıfa aittir. Sonuç olarak, statik bir yöntemi çağırmak veya statik bir alana başvurmak için sınıfın adını kullanabilirsiniz. 

Statik değiştirici hakkında bilinmesi gerekenler:

1. Statik bir yöntem veya blok gibi statik bir bağlamda bir sınıfın statik olmayan üyelerine ERİŞEMEZSİNİZ. Aşağıdaki kodu derlemek bir hataya neden olur:

2. (thread safe) Yerel değişkenlerin aksine, statik alanlar ve yöntemler Java'da DEĞİLDİR . Pratikte bu, çok iş parçacıklı programlamadaki güvenlik sorunlarının en yaygın nedenlerinden biridir. Bir sınıfın her örneğinin bir statik değişkenin aynı kopyasına başvurduğu düşünülürse, böyle bir değişkenin sınıf tarafından korunması veya "kilitlenmesi" gerekir. (synchronized) Bu nedenle, statik değişkenleri kullanırken, gibi sorunlardan kaçınmak için doğru olduklarından emin olun (race conditions).

3. Statik yöntemlerin pratik bir avantajı vardır, çünkü onları her çağırmak istediğinizde yeni bir nesne oluşturmaya gerek yoktur. Statik bir yöntem, onu bildiren sınıfın adı kullanılarak çağrılabilir. (factory) Bu nedenle bu yöntemler, yöntemler ve utility yöntemler için mükemmeldir . Sınıf java.lang.Math harika bir örnektir: neredeyse tüm yöntemleri statiktir. Java'nın yardımcı program sınıfları da (final) aynı nedenle işaretlenir.

4. (@Override) Bir diğer önemli nokta ise ( ) statik metotları geçersiz kılamazsınız. (subclass) Böyle bir yöntemi a'da, yani aynı ada ve imzaya sahip bir yöntemde bildirirseniz, bu yöntemi (super class) geçersiz kılmak yerine yalnızca "gizlersiniz". Bu fenomen olarak bilinir (method hiding). Bu, hem üst hem de alt sınıflarda statik bir yöntem bildirilirse, çağrılan yöntemin her zaman derleme zamanındaki değişken türüne dayalı olacağı anlamına gelir. Yöntem geçersiz kılmanın aksine, bu tür yöntemler program çalışırken yürütülmez.

5. Üstelik, üst düzey sınıflar dışında, sınıfları statik olarak ilan edebilirsiniz. Bu tür sınıflar olarak bilinir (nested static classes). Daha iyi uyum sağlamak için kullanışlıdırlar. İç içe bir statik sınıfın çarpıcı bir örneği HashMap.Entry, içinde bir veri yapısı olan HashMap. İç sınıflar gibi statik iç içe sınıfların ayrı bir .class dosyasında bildirildiğini belirtmekte fayda var. Böylece, ana sınıfınızda iç içe beş sınıf bildirirseniz, .class uzantılı 6 dosyanız olur.

6. Statik değiştirici, sınıf yüklendiğinde yürütülen, daha çok "statik başlatma bloğu" olarak bilinen statik bir blokta da belirtilebilir. Böyle bir blok bildirmezseniz, Java tüm statik alanları tek bir listede toplar ve sınıf yüklendiğinde bunları başlatır. Statik bir blok, kontrol edilen istisnaları atamaz, ancak kontrol edilmeyen istisnaları atabilir. Bu durumda bir durum ExceptionInInitializerError oluşacaktır. Uygulamada, statik alanların başlatılması sırasında meydana gelen herhangi bir istisna, Java tarafından bu hataya sarılır (NoClassDefFoundError). Bu aynı zamanda, sınıfın başvurulduğu zaman bellekte olmayacağı için en yaygın nedenidir.

7. Gerçek bir nesne üzerinde çağrıldığında çalışma zamanında bağlanan sanal veya statik olmayan yöntemlerin bağlanmasından farklı olarak, statik yöntemlerin derleme zamanında bağlandığını bilmek yararlıdır. Buna göre, Java'da statik yöntemler geçersiz kılınamaz, çünkü çalışma zamanında çok biçimlilik onlar için geçerli değildir. Bu, statik bir yöntem bildirirken dikkate alınması gereken önemli bir sınırlamadır. Bunu yapmak, yalnızca bir alt sınıfta yöntemi geçersiz kılma yeteneği veya ihtiyacı olmadığında anlamlıdır. Fabrika yöntemleri ve yardımcı yöntemler, statik değiştiricinin doğru kullanımına iyi örneklerdir. Joshua Bloch, her Java programcısı için zorunlu okuma olan Etkili Java adlı kitabında statik fabrika yöntemlerinin kuruculara göre sahip olduğu çeşitli avantajlara dikkat çekiyor.

8. Başlatma, statik bir bloğun önemli bir yönüdür. Statik alanlar veya değişkenler, sınıf belleğe yüklendikten sonra başlatılır. Başlatma sırası, Java sınıfının kaynak dosyasında bildirildikleri sırayla yukarıdan aşağıya doğrudur. Statik alanlar iş parçacığı açısından güvenli bir şekilde başlatıldığından, bu işlem aynı zamanda Singletondeseni uygulamak için de kullanılır. EnumHerhangi bir nedenle an kullanmıyorsanız Singleton, iyi bir alternatifiniz var demektir. Ancak bu durumda, bunun "tembel" bir başlatma olmadığını dikkate almalısınız. Bu, statik alanın birisi "sormadan" ÖNCE bile başlatılacağı anlamına gelir. Bir nesne kaynak ağırlıklıysa veya nadiren kullanılıyorsa, onu statik bir blokta başlatmak sizin lehinize çalışmaz.

9. Serileştirme sırasında değişkenler gibi statik alanlar transient serileştirilmez. Aslında, herhangi bir veriyi statik bir alana kaydederseniz, seri durumdan çıkarmadan sonraki ilk (varsayılan) değerini içerecektir. Örneğin, bir statik alan bir ise int, seriden çıkarmadan sonra değeri sıfır olur. Türü ise float, değer 0.0 olacaktır. Alan bir ise Object, değer olacaktır null. Temel nesne verilerini statik bir alanda saklamayın!

10. Statik içe aktarma. Bu değiştiricinin standart deyimle pek çok ortak noktası vardır import, ancak statik sınıf üyelerinden birini veya tümünü içe aktarmanıza izin vermesi bakımından farklıdır. Statik metotlar içe aktarıldıktan sonra, aynı sınıfta bildirilmiş gibi erişilebilirler. Benzer şekilde, statik alanları içe aktararak, sınıf adını belirtmeden bunlara erişebiliriz. Bu özellik Java 1.5'te ortaya çıktı ve doğru kullanıldığında kodun okunabilirliğini artırıyor. Bu yapı en çok JUnit testlerinde bulunur, çünkü neredeyse tüm test geliştiricileri, iddia yöntemleri, örneğin assertEquals() ve bunların aşırı yüklenmiş değişkenleri için statik içe aktarmayı kullanır.

Kaynak: https://codegym.cc/tr/groups/posts/tr.141.javadaki-statik-degistirici-hakknda-bilmeniz-gereken-10-sey

Java'da Static deyimi, sınıf değişkenlerini veya sınıf metotlarını tanımlarken kullanılır. Eğer bir sınıfa ait değişkenlerin başına "static" yazılırsa, o değişkenler artık sınıf değişkeni olurlar. Sınıf değişkeni olarak tanımlanan değişkenler, her nesne oluşturduğumuzda ayrı ayrı oluşmazlar. Sınıfa ait ne kadar nesne olursa olsun, sınıf değişkenleri 1 tanedir. Sınıfa ait herhangi bir nesne üzerinden bu değişkene ulaşılabilir. Sınıf değişkenlerinin bir diğer özelliği ise, ilgili sınıfa ait hiç nesne oluşturulmasa bile bellekte yer kaplarlar.

Eğer sınıfa ait metotlardan bir ya da birden fazlasının önüne "static" deyimi yazılırsa,  o metotlar sınıf metodu olurlar. Sınıf metotlarının en önemli özelliği, ilgili sınıfa ait nesne oluşturmadan sınıf metodu çağırılabilir. Bir sınıf değişkeninin, henüz nesne oluşturulmasa da bellekte fiziksel olarak yer kapladığını söylemiştik. Bir sınıf metodunun ise nesne oluşturulmadan, sınıf adı üzerinden çağrılabildiğini belirttik. Bu durumda, nesne var olmadan çağrılabilecek olan sınıf metotları, nesne var olmadan bellekte var olamayan olgu değişkenlerine erişmesi olanaklı değildir. Benzer şekilde, nesne var olmadan bellekte var olan sınıf değişkenleri üzerinde işlem yapan yöntemlerin, nesne var olmadan çağrılabilmeleri gerekir.

Dolayısıyla, sınıf değişkenleri üzerinde işlem yapan yöntemler sınıf yöntemleri olmalıdır. Öte yandan, bir olgu yönteminin sınıf değişkenine erişmesi olanaklıdır. Çünkü olgu yöntemi nesne oluştuktan sonra çağrılacaktır. Daha nesne oluşmadan fiziksel olarak bellekte var olan sınıf değişkenine nesne yöntemi ile de erişilebileceği açıktır. Bununla birlikte, sınıf değişkenlerine olgu yöntemlerinden erişilmesi tercih edilen bir durum değildir.

Kaynak: https://kodlamavakti.com/java/static-kullanimi/

/////////////////////////


