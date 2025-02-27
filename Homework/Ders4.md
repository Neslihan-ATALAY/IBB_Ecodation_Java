
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

Kaynak: https://www.geeksforgeeks.org/string-vs-stringbuilder-vs-stringbuffer-in-java/
