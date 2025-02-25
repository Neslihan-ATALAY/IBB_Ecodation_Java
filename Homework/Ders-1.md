MAVEN NEDİR?

Maven yoğunlukla java projelerini derlemek, build (inşa) etmek ve arşiv dosyaları oluşturmak için kullanılan bir build otomasyon aracıdır. Java dışında birçok dil için de kullanılabilir olsa da (Ruby, Scala vs.) yoğunlukla Java derlemesi, proje yönetimi gibi alanlarda kullanılmaktadır. Apache vakfı tarafından geliştirilmiş, yayınlanmış ve desteklenmeye devam etmektedir. 

Maven dosya yapısı:
/src/main/java — Java kodlarını içeren klasördür.
/src/main/resource —Java kodlarına ilişkin konfigürasyon dosyalarını içeren klasördür.
/src/main/webapp — İmaj, CSS, JavaScript gibi web dosyalarını, uygulamalarının web kısımlarını içeren dosyadır.
/src/test — Unit testleri içeren dosyadır.
/target — Maven ile derlediğimiz proje çıktılarını içeren klasördür.

Bu klasör yapısı sayesinde başka bir geliştirme ortamına import edilebilen projeler ile ide, ortam, konfigürasyon bağımsız geliştirme olanaklı hale gelmektedir. Derlemede pom.xml ile ortak paketler oluşturulabilmektedir. Java projeleri yazılır ve uygulama geliştirilir iken birçok kütüphaneye ihtiyaç vardır. .jar .war dosyaları olarak bilinen bu kütüphaneler, geliştirme yapısı içerisinde bağımlılıklar ile yönetilmektedir.

Maven Build Lifecycle temelde maven üzerinde yeni bir build almak istediğimizde bize pom.xml dışında yardımcı olarak komutları, fazları ve her bir fazın içerdiği ayrı adımları, o adımlar esnasında tamamlanan hedefleri ifade eden bir yaşam döngüsüdür. Buildlerimizi standartlaştırmak ile hatayı azaltmak, fazlarda gerekli olan adımları eksiksiz yerine getirmek, ve gerekli fazları sıralayarak sorunsuz build almak için oldukça iyi tanımlanmış bir yapıdır.

Build aşamasında kullanılan fazlar aşağıda sıralanmıştır;
validate: Proje bilgilerinin doğruluğunu ve derlemenin sağlıklı ilerleyeceğinin kontrol edildiği fazdır.
compile: Projenin kaynak kodunun derlendiği fazdır.
test: Unit testler ile maven projesinin testlerinin koşulduğu fazdır.
package: Projenin derlenmesi sonrası paketin oluşturulduğu fazdır.
verify: Entegrasyon testlerinin sonuçlarının doğrulandığı fazdır, kalite gereksinimini karşılayıp karşılamadığı incelenir.
install: Paketi yerel depoya kurmak, kullanmak ve başka projeler içinde bağımlılık olarak da göstermek için çalıştırma komutu ve fazıdır.
deploy: Yerelde çalışan derlenen, kurulan paketi uzak repoya push etme fazıdır.

Maven için gerekli olan Java kurulumu yapılır. Maven paketi indirilip çalışma ortamına çıkarılır ve çıkarılan alanı da environment variable olarak tanımladıktan sonra Maven kullanılmaya başlanabilir.

mvn archetype:generate
        -DgroupId={project-packaging}
        -DartifactId={project-name}
        -DarchetypeArtifactId={maven-template}
        -DinteractiveMode=false
ile bir proje yaratıp daha sonra aşağıdaki komutları kullanarak işlemler yapılabilir, temel maven komutlarını ve açıklamalar şöyle sıralanabilir;

$ mvn clean: Hedef dizini (target) silerek derlenmiş artifactı temizlemek için kullanılır.
$ mvn compiler:compile: Java source kodlarını derlemek için kullanılır.
$ mvn compiler:testCompile: Java source codeların içerisindeki test classlarını derlemek için kullanılır.
$ mvn package: Maven projesi oluşturmak ve onları .jar , .war olarak vs. olarak paketlemek için kullanılır.
$ mvn dependency:tree: Proje için pom.xml içerisinde bulunan bağımlılıklar ve altbağımlılıkların bir haritasını üretir.
$ mvn install: Lokal maven klasörünün, reposunun içerisine paketi yüklemek için kullanılır. $ mvn deploy ise bunları uzak repoya atmak için kullanılır.
$ mvn site:site: Maven projesi için site oluşturmak ve onu lokalde görüntülemek için kullanılır.
$ mvn test: Surefire-plugin yardımı ile proje içerisinde yazılan test caseleri çalıştırmak için kullanılır.
$ mvn -v: Bilgisayarımızda kurulu maven versiyonunu gösterir.
$ mvn -o: Offline modda lokalimizde çalışıp işlem yapılmasını, $mvn -q ise sadece test caselerinin çalıştırılıp sonuçların alınabilmemisini sağlar.
$ mvn -help: Maven komutları ile ilgili destek komutudur. Komutlar, açıklamalar ve fazlası bu komut ile listelenebilmektedir.

Bazı maven işlemleri için pluginlere ihtiyaç vardır. Pluginler mavenın güçlendiricisi olmanın yanısıra yapıtaşıdır, birçok işlem pluginler ile yapılır ve merkez repository ya da üçüncü parti araçlar maven pluginleri bulundurur. Bu pluginler mavenı zenginleştirmek ve belirli işlemleri gerçekleştirmek için kritiktir. Örneğin bir war çıktısı alabilmek için maven-war-plugin kurulması gerekir ya da jetty plugin ile web geliştirmeleri daha etkili olabilir. Spring framework web geliştirmelerini derleyebilmek için spring-boot-plugin kullanmak gerekir ya da uzak repoya bir paket göndermek için maven-deploy-plugin kullanmak gerekir. Bununla birlikte farklı işlemler için kullanılması gereken birçok eklenti vardır.

Maven'in avantajları:
Maven özellikle çok fazla bağımlılık içeren projeleri init etmek ve yönetmek için olağanüstü bir çerçeve ve kolaylık sunmaktadır.
Yapı olarak oldukça kolay kullanılır, kolay yönetilir bir yapı ile geliştiricilerin ve ekiplerin işini kolaylaştırır.
Standartları sayesinde ortam, IDE, servis bağımsız çalışmayı sağlar ve standartların temel faydalarından biri olarak anlaşılabilirliği artırır.
Sürüm güncellemelerini takip etmek ve özellikle bağımlılık ve alt bağımlılıkların da sürümlerini yönetmeyi takip etmek için oldukça efektiftir. 
Sürekli derleme, sürekli entegrasyon (CI/CD) ve bu süreçlere bağlı sürekli testleri çalıştırmak için harika bir altyapı sunar, bu işlemlerin yapıldığı (Jenkins vs.) araçlar ile de pluginler, entegrasyonlar sayesinde oldukça uyumlu çalışır.
Farklı formatlarda paketler, çıktılar oluşturmak için oldukça efektiftir.

POM.XML Nedir?

Pom.xml bir xml dosyasıdır ve içerisinde projenin adını, paketini, versiyon bilgisini, repoların bilgisini, bağımlılıkları, o bağımlılıkların versiyonlarını içerir. Maven bir build esnasında gider Pom.xml dosyasına bakar, oradaki proje detaylarını, kütüphaneleri, bağımlılıkları ilk olarak local maven repository denilen bilgisayarda oluşturulan maven dosyası içeriğine bakar, bulabildiklerini oradan alıp projeye ekler, bulamadığı paketler ve bağımlıklar için Central Maven Repository dediğimiz mavenrepository adresine gider, oradan indirerek projeye ekler. Böylece Pom.xml içerisinde verilen tüm kütüphaneleri, bağımlılıkları içeren bir proje yapısı oluşur, ve build alındığında tüm bu çerçeveye sahip bir paket oluşur.

Örnek Pom.xml dosyası:
<project>
<modelVersion>4.0.0</modelVersion>
<groupId>com.isimsoyisim</groupId> - Proje adı (Paket adı kullanılır genellike)
<artifactId>MavenUygulamam</artifactId> - Proje adı
<version>0.0.1-SNAPSHOT</version> - Semantic versionlama kullanmak faydalı olacaktır. (5.0.0.RELEASE - 5.0.0.FINAL) SNAPSHOT(halen geliştiriliyor.)
<packaging>jar</packaging>
<name>MavenUygulamam</name>
<dependencies>
  <dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>itextpdf</artifactId>
    <version>5.5.13.3</version>
  </dependency>
</dependencies>
<!-- maven plugin'leri -->
</project>

Kaynaklar: 
https://medium.com/@fatihbildirici.dev/maven-%C3%B6zellikleri-yap%C4%B1s%C4%B1-nedir-neden-kullan%C4%B1r%C4%B1z-599b469bfee3
https://www.yusufsezer.com.tr/maven/

////////////////////////////////////////

JDK (Java Development Kit) Nedir?

Java Geliştirme Kiti (JDK) Java geliştiricilerine yönelik bir Oracle Corporation ürünüdür. Java'nın kullanıma sunulmasından beri en geniş kullanım alanı bulan Java SDK'dır. 17 Ekim 2006'da, Sun GNU General Public License (GPL) altında sunulacağını duyurdu ki bu özgür yazılım olacağı anlamına geliyordu. Bunun gerçekleşmesi ise 8 Mayıs 2007'de oldu; Sun kaynak kodu OpenJDK'ya bağışladı.

JDK içeriği
JDK'nın birincil bileşenleri programlama araçlarından oluşur, bunlar:
java – Java uygulamaları için yükleyici. Bu araç bir yorumlayıcıdır ve javac derleyicisi tarafından ortaya çıkarılmış olan sınıf dosyalarını yorumlar. Şu an hem geliştirme hem de konuşlandırma için aynı başlatıcı kullanılmaktadır.
javac – derleyici, kaynak kodu Java bytecode'a çevirir.
Uygulamacık görüntüleyicisi (applet viewer) – Bu araç İnternet tarayıcısı kullanılmadan Java uygulamacıklarını çalıştırmak ve hata ayıklamak için kullanılır.
apt – Java için yardımcı veri işleme aracı
extcheck – JAR dosyası çakışmalarını fark edebilen araç
idlj – IDL'den Java'ya çevrim sağlayan derleyici. Bu araç verilen Java IDL dosyasından Java ilişkilendirmeleri çıkarır.
javadoc – Dokümantasyon üreticisi; otomatik olarak kaynak kod yorumlarından dokümantasyon üretir.
jar – arşivleyici; ilgili sınıfları kütüphaneleri tek bir JAR dosyasına çevirir. Jar dosyalarını yönetmek için de kullanılır.
javah – C başlık ve koçan üreticisi; yerel metotları yazmak için kullanılır.
javap – sınıf dosyası ters çeviricisi
javaws – JNLP uygulamaları için Java Ağ Başlatıcı
jconsole – Java izleme ve yönetim konsolu
jdb – hata ayıklayıcı
jhat – Java Bellek Yığını Analiz Aracı (deneysel)
jinfo – Bu araç çalışmakta olan Java sürecinden ya da daha önce çökmüş olan Java sürecine ait bir dökümden konfigürasyon bilgisini alır.
jmap – Bu araç, Java'ya ait bellek haritasını çıkarır, verilen Java süreci ya da çökmüş bir sürece ait dökümden paylaşılan nesnelere ait bellek haritalarını veya bellek yığını ayrıntılarını çıkarabilir. (deneysel)
jps – Java Sanal Makine Süreç Durum Aracı hedef makinedeki HotSpot Java Sanal Makineleri'ni (JVM'ler) listeler. (deneysel)
jrunscript – Java komut satırı betiği kabuk.
jstack – Java iş parçacıklarına ait yığıt izlerini görüntülemeyi sağlayan araç. (deneysel)
jstat – Java Sanal Makinesi istatistik izleme aracı (deneysel)
jstatd – jstat geri plan yordamı (deneysel)
policytool – Direktif yaratma ve yönetme aracı; bir Java çalışma zamanı için direktifleri verir, bu şekilde farklı kaynaklara ait kodların hangi izinlere sahip olduğunu belirler.
VisualVM – Bazı komut satırlı JDK araçlarını bir araya getiren, performans ve bellek kesiti alma görsel aracı.
wsimport – Ağ hizmetini çağırmak için taşınabilir JAX-WS kodu üretir
xjc – XML ilişkilendirme Java API'sinin (JAXB) bir kısmını oluşturur. Bir XML şemasını kabul eder ve Java sınıfları üretir.

Deneysel araçlar, JDK'nın ileriki versiyonlarında olmayabilir.

JDK, aynı zamanda tamamlanmış bir Java Çalışma Zamanı Ortamı ile birlikte gelir. Bu genellikle hususî çalışma zamanı olarak da adlandırılır, çünkü "olağan" JRE'den ayrıdır ve ilave içeriğe sahiptir. Bir Java Sanal Makinesi'nden ve konuşlandırma ortamındaki sınıf kütüphanelerinin hepsinden oluşur. Aynı zamanda geliştiricilerin işine yarayan uluslararasılaştırma kütüphaneleri ve IDL kütüphaneleri gibi ek kütüphaneleri de içermektedir.

JDK kopyaları aynı zamanda Java API'sinin hemen hemen her kısmının nasıl kullanılacağını gösteren birçok seçilmiş örnek programı da barındırmaktadır.

Kaynak: https://tr.m.wikipedia.org/wiki/Java_Geli%C5%9Ftirme_Kiti

///////////////////////////////////////

JRE (Java Runtime Environment) Nedir?

Java Runtime Environment yani JRE, birçok işletim sisteminde ve platformda kullanılan Java programlama diliyle geliştirilmiş uygulamalarının sağlıklı bir şekilde çalıştırılabilmesi için kullanılan ve Java kütüphanelerini içeren bir yazılım destek katmanıdır.

Java tabanlı kurgulanan uygulamalar bu katman sayesinde birçok değişik platformlarda sorunsuz bir şekilde çalışırlar. Böylece her işletim sistemine uyumlu olması için ayrı ayrı uygulama geliştirmek zorunda kalınmamış olur. Java dili, Sun Microsystems tarafından geliştirilen açık kaynak kodlu ve nesneye yönelik bir dildir.

Java’nın sloganı olan “Bir defa yaz, her yerde çalıştır” felsefesi sayesinde bu dil ile yazılmış uygulamalar farklı işletim sistemleri üzerinde JRE sayesinde sorunsuz bir şekilde çalışabilir.

JRE Nasıl Çalışır?

Java Runtime Environment tüm platformlarda kesintisiz Java deneyimi sağlayabilmek üzere üç bileşeni kullanarak işlev görür. Java Classloader, Byte Kodu Doğrulayıcı ve Yorumlayıcı bileşenleri sistemin çalışmasını kontrol eder.

Java Classloader
Java sınıf yükleyici olarak Türkçeye çevrilebilen Classloader, Java tabanlı programların çalışmasına olanak veren Sınıfların yüklenmesinden sorumludur. Classloader, sadece gerektiği zaman otomatik bir şekilde sınıfları yükleyerek uygulamaların çalışmasına uygun ortam sağlar. Java Classloader, derlenmiş java kodunu belleğe yükler ve kodu uygun Java sınıfının kitaplığına bağlar.

Byte Kodu Doğrulayıcı
Java kodunun doğruluğunu kontrol eden bu bileşen, kodların doğru olduğundan ya da biçiminin doğruluğundan sorumludur. Doğrulaması yapılan kodlar yüklenerek, kodların Byte yorumlayıcı tarafından yorumlamasına izin verilir.

Yorumlayıcı
Başarıyla yüklenen ve doğrulanan Byte kodlarının, yerel olarak yürütülmesini sağlar.

JRE Bileşenleri Nelerdir?

Java Development Kit (JDK)
Java diliyle çalışan ve uygulama geliştiren yazılımcıların kullanabileceği Java Development Kit ya da Java Geliştirme Kiti adı verilebilen bir araçtır. Çeşitli versiyonları ve sürümleri vardır.
Java Enterprise Edition (JEE)
Java Special Edition (JSE)
Java Mobile Edition (JME)

Java Virtual Machine (JVM) ise canlı olarak Java uygulamalarını yürütmek için kullanılan bir araçtır. Geliştiriciler JDK ile geliştirdikleri Java tabanlı bu sanal makine üzerinde çalıştırırlar.

Geliştirme Araçları
Swing
Swing basit bir kullanıcı arayüzüdür.  Birtakım özelleştirmeler yapmak için kullanılır. 

AWT
Abstract Window Toolkit, Düğme, nesne, kaydırma çubukları, düğme ve pencere oluşturmak için kullanılan bir GUI (Graphical User İnterface) Grafik kullanıcı arayüzüdür. 

Java 2D
Adı üstünde Java dilinde iki boyutlu 2D (2 Dimension) grafik çizebilmek için kullanılan bir APİ’dir. Bu araçla geliştiriciler çeşitli efektler, oyunlar vb geliştirebilirler. 

Kitaplıklar
JDBC API
Java Database Connectivity API, uzak veritabanlarına bağlantı kurabilmesi, sayfalara ve dosyalara erişim sağlayan uygulamalar geliştirebilmek için  için kullanılan bir API’dir.  

JNDI
Java Naming and Directory Interface, Java istemcilerinin bir ad aracılığı ile veri nesneleri ve kaynaklarını keşfetmesine, araştırmasına imkan veren bir Java API’sidir.

Java IDL
Java IDL, dağıtık haldeki nesnelerin yani farklı platformlardaki birbiriyle iletişime giren nesneler için kullanılır. Java IDL dağıtılmış nesne modeli olan CORBA (Common Object Request Brokerage Architecture sayesinde Java IDL, nesnelerin dilden bağımsız olarak (Java, C, C+ veya başka dilde yazılmış nesnelerin) iletişime girmesine olanak tanır.

Kaynak: https://www.hosting.com.tr/bilgi-bankasi/jre/

///////////////////////////////////////////

JVM (Java Virtual Machine) Nedir?

Java Sanal Makinesi (JSM), Java platformunun nesne modülü (İng. object module) formatı olan class uzantılı sınıf dosyalarının belleğe yüklenip çalıştırılması için gereken hizmetleri sunan bir sistem programıdır ve temel görevinin sınıf dosyalarını yorumlamak olduğu söylenebilir. Ancak, JSM'ni salt bir yorumlayıcı olarak görmek büyük haksızlık olur. Zira, yorumlama ile birlikte JSM'nin şu görevleri de vardır.

Belleğe yükleme ve çalıştırma sırasında güvenlik denetimlerinin yapılması
Sınıf dosyalarının çalıştırılması esnasında yığın bellekte oluşabilecek çöplerin toplanması
Yorumlamanın getirdiği çalışma hızındaki düşüşü azaltmak amacıyla kodun anında derleme kullanılarak daha hızlı çalıştırılması (seçimlik)
Yukarıdaki maddelerin ayrıntısına girmeden önce sınıf dosyalarının bazı özelliklerine değinmekte yarar olacaktır. Java platformunun standardize edilmiş nesne modülü formatı olan bu dosya çeşidinin DLL, EXE ve a.out formatlarındaki nesne modülü dosyalarına benzer işlev gördüğü söylenebilir. Nasıl ki, DLL, EXE ve a.out dosyaları üstbilgilerin yanı sıra programın çalıştırılacağı bilgisayarın makine kodu komutlarından oluşur, sınıf dosyaları da tanımlanan türün üstbilgilerine ek olarak Java platformunun makine kodu olarak düşünülebilecek Bytecode komutlarını içerir. Her iki durumda da, nesne modülünün oluşturulmasında kullanılan kaynak dosyanın hangi programlama dilinde yazıldığı bilinmez.

Java platformunun nesne dosyası formatı olarak sınıf dosyaları
Örneğin, Pascal ile yazılmış bir dosyanın derlenmesi ile oluşturulmuş bir nesne modülü, daha sonra C ile yazılmış bir programın derlenmesiyle oluşturulan bir diğer nesne modülüyle bağlanarak kullanılabilir. Java platformu için geçerli olan benzer bir senaryo soldaki şekilde verilmiştir. Bu şekle göre, A şirketi tarafından Groovy kullanılarak yazılmış olan a.groovy dosyasının derlenmesi ile oluşturulan a.class ve B şirketi tarafından Jython kullanılarak üretilen b.py dosyasının derlenmesi ile oluşturulan b.class dosyaları, her iki şirketin de ortak müşterisi olan bir geliştiricinin yazdığı Prog.java içinden kullanılıyor. Dikkat edilecek olursa, şeklin müşteri tarafında bulunan sınıf dosyaları ilişkin kaynak dosyasının hangi dilde yazıldığını ele vermiyor.

Bütün bu koşutluklara karşın, sınıf dosyası formatı diğer nesne modülü formatlarından önemli farklılıklar gösterir. Öncelikle, herhangi bir mimariye ait makineler için işletim dizgesine bağlı olarak genelde birbirlerinden bağımsız geliştirilmiş ve birbirleriyle uyumsuz olan çeşit çeşit nesne modülü formatı bulunabilir. Bu, bir platform için oluşturulmuş nesne modülünün bir diğer platformda işe yaramayacağı anlamına gelir. Örneğin, IA32 mimarisinden işlemciye sahip bir bilgisayarda Linux altında oluşturulmuş a.out formatındaki bir nesne modülü, Windows XP altında doğrudan kullanılamayacaktır. Buna karşılık, formatı Java platformu ile birlikte standardize edilen sınıf dosyaları, Java Çalıştırma Ortamı'nın bulunduğu bütün platformlarda çalıştırılabilecektir.

Bir diğer farklılık, JSM'nin ve sınıf dosyası formatının baştan itibaren güvenlik düşünülerek tasarlanmış olmasından kaynaklanır. Dosyanın üstbilgisi ve içeriği arasındaki tutarlılığın denetimi ile başlayan denetimleri kod bölümlerindeki Bytecode komutlarının geçerliliği ve doğruluğu denetlenerek yapılan denetimler izler. Örneğin, sınıf dosyasının ilk dört sekizlisinde sınıf dosyası formatınca öngörülen 0xCAFEBABE değerinin olup olmadığı, altalan ve metotlara dair üstbilgilerin dosya içeriğindeki durumla uyuşup uyuşmadığı kontrol edilir; sıçrama komutlarının içinde bulunulan metodun sınırları dışına çıkmadığı veya tanımlayıcılara tür uyumlu değerler sağlandığı garanti edilir.

Sınıf dosyalarının kod içeriğini oluşturan Bytecode'un yüksek düzey kavramlara yönelik özellikler taşıyan bir ara dil olması, bu dili bildik makine kodu dillerinden farklı kılar. Örneğin, Bytecode dilinde nesne yaratmak amacıyla kullanılabilecek komutların yanı sıra çokbiçimliliğin gerçekleştiriminin temelindeki dinamik iletimi olanaklı kılan komutlar da vardır; ayrıca, yazılım güvenilirliğini sağlamakta yararlanılabilecek ayrıksı durum kotarımı ile ilgili komutlar da JSM için derleyici yazmak isteyen programcıların işini kolaylaştırır. Makine dillerince doğrudan desteklenmeyen bu tür komutların varlığı, diğer türden nesne modülleri fiziksel olarak var olan bir makine üzerinde yorumlanarak çalıştırılırken, sınıf dosyalarının Bytecode dilinden haberdar olan bir soyut makine üzerinde yorumlanarak çalıştırılması gerekliliğini doğurur. Bunun beklenen bir sonucu olarak, yüksek düzey bir dilin doğrudan yorumlanmasına oranla daha hızlı olmasına karşın, sınıf dosyalarının çalışma hızı diğer nesne modüllerinden daha yavaş olacaktır. İşte tam bu noktada, JSM gerçekleştirimleri çalıştırılmakta olan kodun anında derlenmesini yaparak çalışma hızını yükseltmeye çalışırlar.

JSM'nin değineceğimiz son özelliği, programcıların daha hızlı kod geliştirmelerine olanak tanıyan çöp toplama birimidir. JSM'nin bir parçası olarak gerçekleştirilen çöp toplayıcı, yığın bellekte kullanılmaz hale gelen bölgelerin geriye döndürülmesini sağlar. Böylece, yığın belleğin yönetiminden azat edilmiş olan programcılar, zamanlarını çözmek istedikleri soruna harcayacak ve daha kısa sürede daha sağlıklı bir kodun gerçekleştirilmesi mümkün olacaktır.

Kaynak: https://tr.m.wikipedia.org/wiki/Java_sanal_makinesi

//////////////////////////////////////

Derleyici (Compiler) Nedir?

Derleyici, kaynak kodu makine koduna dönüştüren yazılımdır. Bir programlama dilinin derleyicisi, o programlama dili kullanılarak yazılmış olan kodu hedef işlemci mimarisine göre uygun şekilde makine koduna derler ve genellikle çıktı olarak yürütülebilir dosyanın (executable file) oluşturulmasını sağlar. Bu eyleme derleme denir. Bir başka ifadeyle derleyici, bir tür yazı işleyicidir; girdi olarak yazı alır ve çıktı olarak yazı verir.

Çok dilli, çok hedefli bir derleyici diyagramı
Bilgi işlemde, yürütülebilir dosya doğrudan işlemci tarafından çalıştırılabilecek bir dosyayı ifade eder. Dosya makine kodu ile yazılmış komut seti talimatları bütününden oluşur.

Derleyiciler çalışma prensiplerine göre ayrılır. Bir derleyici, yorumlayıcı ve assembler'de olduğu gibi sözcüksel analiz (lexical analysis) ve ayrıştırma (parsing) aşamalarını gerçekleştirir.

Derleyicilerin ürettiği yürütülebilir dosyalar her zaman platforma özel olarak derlenmiş makine kodlarından oluşmaz, bazen kaynak kod bir ara temsil diline (intermediate representation) derlenir ve bu dil genellikle bytecode'lardan oluşur ve sanal bir makinede çalıştırılır. Ara dillerin bilinen örnekleri Microsoft .NET, Java Sanal Makinesi ve BEAM (Erlang Virtual Machine) şeklindedir. Bu platformlar kendilerine özgü bir ara dil kullanır. Örneğin JVM, Java Bytecode olarak adlandırılan bir ara dil kullanmaktadır. Bu şekilde derlenen diller tam zamanında derleme (Just in Time – JIT) tekniğini kullanır.

İki ana derleyici türü vardır, bunlar: yerel (native) ve çapraz (cross) derleyicilerdir. Yerel derleyiciler üzerinde çalıştığı platforma özgü derleme gerçekleştirir. Yerel bir derleyiciden elde edilecek çıktı yalnızca derleyicinin derleme zamanında yürütüldüğü sisteme yönelik olacaktır (Örn. Yerel bir derleyici ile C kodunun AMD64 mimarisini kullanan Linux çekirdeğinde çalışan bir makinede derlenmesi sonucu AMD64 ve Linux çekirdeğiyle uyumlu makine kodu elde edilmesi). Yerel derleyicilerin platform bağımsız düşünmeleri gerekmediğinden AOT derleme tekniği ile direkt olarak makine koduna derlenirler. Çapraz derleyiciler üzerinde çalıştıkları platformdan bağımsız bir şekilde destekledikleri tüm platformlara özel olarak makine kodu derlemeleri üretebilirler. Buna örnek olarak ARM64 üzerinde çalışan bir derleyicinin I386 için uyumlu makine kodu derlemesi gösterilebilir. Derleyici yalnızca kodu derlemekle ilgilenmez, aynı zamanda derleme zamanında gerekli gördüğü yerlerde kodu optimize edebilir ve daha optimum bir makine kodu üretmek için çabalayabilir. Buna derleyici optimizasyonu denir.

Makine üzerinde bulunan işlemcinin komut setine uygun şekilde derlenen saf makine kodlarının işlemci tarafından doğrudan yürütülebilir olduğundan en saf çalışma performansı bu şekilde derlenen dillerden elde edilebilir. Bu diller zamanından önce (Ahead of Time - AOT) derleme tekniğini kullanır.

Genellikle yürütülebilir dosya elde edilmesi şeklinde tanımlanmasının nedeni ise bir derleyicinin her zaman tam anlamıyla yürütülebilir dosya oluşturmamasından kaynaklanmaktadır.

Derleyicinin kullanılmasındaki amaç genellikle çalışabilir bir yazılım elde etmektir. Kullanıcıların programları kullanırken kolaylık sağlamak amaçlı geliştirilmiştir. Örneğin, şu satırı bir programın kaynak kodunda (programın okunabilir hali) düşünelim:

X=2+Y

Alttaki assembly'de yazılmış satırlar, aynı programın derlenmiş halidir:

 LOAD A [0]   ;; belleğin 0 adresindeki veriyi A yazmacına yükle
 ADD  A BX    ;; A yazmacına BX yazmacının adresinde bulunan veriyi ekle
 STOR A [100] ;; sonucu 100 adresine yaz
 
Bu örnekte assembly'nin hedefi, programcının anladığı kaynak kodundan işlemcinin anladığı 0 ile 1 den oluşan makine dili kodunu üretmek (LOAD, ADD ve STOR komutları 0001, 0011 ve 0010 olarak yorumlanır)

 0001 01 00 00000000
 0011 01 10 00000010
 0010 01 00 00000100
 ---- -- -- ---------
  |   |  |   |_________bellek adresi
  |   |  |____________işaret   
  |   |______________yazmaç
  |_________________komut
  
Bir programlama dili genellikle insan tarafından okunabilir yapılardır. Bilgisayarlar komut seti içerisinde yer alan talimatlar dışında herhangi bir komut yorumlama yeteneğine sahip değillerdir. İşlemcilerin mimarisine göre komut seti de farklılık gösterir, bu nedenle derleyicilerin desteklenen her farklı işlemci mimarisi için farklı derleme aşamalarını izlemesi ve farklı makine kodu sonuçları üretmesi gerekir.

Kaynak: https://tr.m.wikipedia.org/wiki/Derleyici

///////////////////////////////////////

Yorumlayıcı (Interpreter) Nedir?

Yorumlayıcı (interpreter), yazılımı kısım kısım ele alarak doğrudan çalıştırır. Yorumlayıcılar standart bir çalıştırılabilir kod üretmezler. Yorumlama işlemi aşama aşama yapılmadığı için genellikle ilk hatanın bulunduğu yerde programın çalışması kesilir.

Derleyicilerin tersine kodun işlenmeyen satırları üzerinden hiç geçilmez ve buralardaki hatalar ile ilgilenilmez.

Yorumlayıcılar genelde kaynak koddan, makine diline anlık olarak dönüşüm yaptıkları için, derleyicilere göre daha yavaş çalışırlar. Ayrıca kodu iyileştirme (optimizasyon) imkânı da çoğu zaman yoktur.

Yorumlayıcılar, tasarımları itibarıyla, derleyicilere benzer veri yapılarını kullanırlar. Örneğin kelime analizi (lexical analysis) için sembol tablolarından veya sözdizim analizi için (syntactic analysis) BNF tanımlarından faydalanabilirler.

Kaynak: https://tr.m.wikipedia.org/wiki/Yorumlay%C4%B1c%C4%B1

///////////////////////////////////////

