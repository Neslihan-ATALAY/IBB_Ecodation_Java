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

POM.XML

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

Java Runtime Environment (JRE)

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

