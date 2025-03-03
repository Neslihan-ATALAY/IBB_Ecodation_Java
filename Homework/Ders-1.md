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

POM.XML NEDİR?

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

JDK (Java Development Kit) NEDİR?

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

JRE (Java Runtime Environment) NEDİR?

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

JVM (Java Virtual Machine) NEDİR?

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

JIT (Just-in-time Compilation) NEDİR?

JIT (just-in-time compilation; dinamik çeviri olarak da bilinir); bilgisayar kodunu çalıştırmanın bir yoludur. Yürütülmeden önce bir program yürütülürken çalışma zamanında derleyici içerir. Genellikle bu, kaynak kodu ve daha sonradan makine diline bytecode kod çevirisini içerir ve bu kod doğrudan doğruya çalıştırılır. Bir JIT derleyicisi uygulayan bir sistem genellikle yürütülen kodu sürekli olarak analiz eder, daha sonra derleme veya tekrar derlemeden elde edilen hızlanmanın bu kodun derlenmesinin yükünden daha ağır olacağı kod bölümlerini tanımlar.

Dinamik derleme türleri, kodun çalışma anında derlenmesini içerir ve JIT bu tür dinamik derlemenin bir örneğidir.
JIT derlemesi, makine koduna çevirı için iki geleneksel yaklaşımın birleşimidir - zamanında hazırlama derlemesi (AOT derlemesi) ve yorumlayıcı. Her ikisini de bazı avantaj ve dezavantajlarını birleştirir. Kabaca, JIT derlemesi, yorumlayıcı esnekliği ile derlenmiş kodun hızını, bir yorumlayıcının yükü ve derlemenin ilave yükü ile birleştirir. JIT derlemesi dinamik derlemenin bir biçimidir ve dinamik yeniden derleme gibi uyarlanabilir optimizasyona izin verir. Bu nedenle teori olarak JIT derlemesi statik derlemeden daha hızlı yürütülebilir. Yorumlama ve JIT derleme, çalışma zamanı sistemi geç veri türlerini işleyebileceğinden ve güvenlik garantilerini uygulayabildiğinden dinamik programlama dilleri için özellikle uygundur.

Kaynak: https://tr.m.wikipedia.org/w/index.php?title=JIT&wprov=rarw1

/////////////////////////////////

DERLEYİCİ (COMPILER) NEDİR?

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

YORUMLAYICI (INTERPRETER) NEDİR?

Yorumlayıcı (interpreter), yazılımı kısım kısım ele alarak doğrudan çalıştırır. Yorumlayıcılar standart bir çalıştırılabilir kod üretmezler. Yorumlama işlemi aşama aşama yapılmadığı için genellikle ilk hatanın bulunduğu yerde programın çalışması kesilir.

Derleyicilerin tersine kodun işlenmeyen satırları üzerinden hiç geçilmez ve buralardaki hatalar ile ilgilenilmez.

Yorumlayıcılar genelde kaynak koddan, makine diline anlık olarak dönüşüm yaptıkları için, derleyicilere göre daha yavaş çalışırlar. Ayrıca kodu iyileştirme (optimizasyon) imkânı da çoğu zaman yoktur.

Yorumlayıcılar, tasarımları itibarıyla, derleyicilere benzer veri yapılarını kullanırlar. Örneğin kelime analizi (lexical analysis) için sembol tablolarından veya sözdizim analizi için (syntactic analysis) BNF tanımlarından faydalanabilirler.

Kaynak: https://tr.m.wikipedia.org/wiki/Yorumlay%C4%B1c%C4%B1

///////////////////////////////////////

JAVA NEDİR?

Java, Sun Microsystems mühendislerinden James Gosling tarafından geliştirilmeye başlanmış açık kaynak kodlu, nesneye yönelik, platform bağımsız, yüksek verimli, çok işlevli, yüksek seviye, hem yorumlanan hem de derlenen bir dildir.

Paradigması: Nesne yönelimli (çok paradigmalı), yapısal, fonksiyonel, zorunlu
İlk çıkışı: 23 Mayıs 1995 (29 yıl önce)
Tasarımcı: James Gosling & Sun Microsystems
Geliştirici: Oracle Corporation
Önemli uygulamaları: OpenJDK, HotSpot ve daha fazlası
Lehçeleri: Generic Java, Pizza
Etkilendikleri: Ada 83, C++, Delphi Object Pascal, Eiffel, Generic Java, Mesa, Modula-3, Oberon, Objective-C, UCSD Pascal, Smalltalk
Etkiledikleri: Ada 2005, BeanShell, C#, Clojure, D, ECMAScript, Groovy, J#, JavaScript, PHP, Python, Scala, Seed7, Vala
Platformu: Çapraz platform
Lisans: GNU Genel Kamu Lisansı / Java Community Process
Olağan dosya uzantıları: .java, .class, .jar, .jmod
Web sitesi:  https://www.oracle.com/java/technologies/

Java, Sun Microsystems'den James Gosling tarafından geliştirilen bir programlama dilidir ve 1995 yılında Sun Microsystems'in çekirdek bileşeni olarak piyasaya sürülmüştür. Bu dil C ve C++'dan birçok sözdizim türetmesine rağmen bu türevler daha basit nesne modeli ve daha az düşük seviye olanaklar içerir. Java uygulamaları bilgisayar mimarisine bağlı olmadan herhangi bir Java Sanal Makinesi (Java Virtual Machine - JVM) üzerinde çalışabilen tipik bytecode'dur (sınıf dosyası).

Java'nın sık kullanılan sloganlarından biri olan, çevirisi "bir defa yaz, her yerde çalıştır" olan "write once, run anywhere - WORA", Java'nın; derlenmiş Java kodunun, Java'yı destekleyen bütün platformlarda tekrar derlenmeye ihtiyacı olmadan çalışabileceğini ima eder (Platform Independent). 2016 yılında bildirilen 9 milyon geliştiricisi ile, özellikle istemci sunucu web uygulamaları için olmak üzere, kullanımda olan en popüler programlama dillerinden birisidir.

Java ilk çıktığında daha çok küçük cihazlarda kullanılmak için tasarlanmış ortak bir düzlem dili olarak düşünülmüştü. Ancak düzlem bağımsızlığı özelliği ve tekbiçim kütüphane desteği C ve C++'tan çok daha üstün ve güvenli bir yazılım geliştirme ve işletme ortamı sunduğundan, hemen her yerde kullanılmaya başlanmıştır. Özellikle kurumsal alanda ve mobil cihazlarda son derece popüler olan Java özellikle J2SE 1.4 ve 5 sürümü ile masaüstü uygulamalarda da yaygınlaşmaya başlamıştır.

Java'nın ilk sürümü olan Java 1.0 (1995) Java Platform 1 olarak adlandırıldı ve tasarlama amacına uygun olarak küçük boyutlu ve kısıtlı özelliklere sahipti. Daha sonra düzlemin gücü gözlendi ve tasarımında büyük değişiklikler ve eklemeler yapıldı. Bu büyük değişikliklerden dolayı geliştirilen yeni düzleme Java Platform 2 adı verildi ama sürüm numarası 2 yapılmadı, 1.2 olarak devam etti. 2004 sonbaharında çıkan Java 5, geçmiş 1.2, 1.3 ve 1.4 sürümlerinin ardından en çok gelişme ve değişikliği barındıran sürüm oldu. Java SE 8 ise Java teknolojisinin günümüz sürümüdür. 13 Kasım 2006'da Java düzlemi GPL ruhsatıyla açık kodlu hale gelmiştir.

Java Tarihi:
James Gosling ve Patrick Naughton Java projesini Haziran 1991'de başlattı. Java ilk olarak interaktif televizyonlar için tasarlandı ancak dijital kablo televizyon endüstrisi için o zamanlar çok gelişmişti. Java'nın ilk hali Oak ismini taşıyordu ve bu ismi Gosling'in ofisinin hemen yanında bulunan bir meşe ağacından almıştı. Daha sonra projenin ismi Green oldu ve en son Java adını aldı. Gosling, Java'yı C/C++'a benzer bir sözdizimi ile tasarladı ve böylece programcılar için kolaylıkla öğrenilebilen bir dil oldu.

Java Sürümler:
Mayıs 2022 itibarıyla resmî olarak Java SE 8, Java SE 11 ve Java SE 17 sürümleri uzun vadeli (LTS) olarak, Java SE 18 ise süreli bir şekilde desteklenmektedir. Java'nın ana sürümleri aşağıdaki gibidir:

Versiyon	Yayın Tarihi
JDK Beta	1995
JDK1.0	23 Ocak 1996
JDK 1.1	19 Şubat 1997
J2SE 1.2	8 Aralık 1998
J2SE 1.3	8 Mayıs 2000
J2SE 1.4	6 Şubat 2002
J2SE 5.0	30 Eylül 2004
Java SE 6	11 Aralık 2006
Java SE 7	28 Temmuz 2011
Java SE 8 (LTS)	18 Mart 2014
Java SE 9	21 Eylül 2017
Java SE 10	20 Mart 2018
Java SE 11 (LTS)	25 Eylül 2018
Java SE 12	19 Mart 2019
Java SE 13	17 Eylül 2019
Java SE 14	17 Mart 2020
Java SE 15	15 Eylül 2020
Java SE 16	16 Mart 2021
Java SE 17 (LTS)	14 Eylül 2021
Java SE 18	22 Mart 2022
Java SE 19	13 Eylül 2022
Java SE 20	07 Haziran 2022 **
Java SE 21 (LTS)	07 Aralık 2022 **
Java SE 22	03 Mart 2024 **
Çalışmaları devam etmektedir.
LTS (Long-Term Support), "Uzun Vadeli Destek" anlamına gelir. Bir programın veya yazılımın dağıtıcısı tarafından uzun vade de desteklenecek olan sürümüdür.

Java Çalışma Mantığı:

Bir Java yazılımı şu şekilde geliştirilir:
Yazılımcı Java kodunu yazar.
Bu kod bir Java derleyicisi ile derlenir. Derleme sonucunda "bytecode" adı verilen bir tür sanal makine kodu ortaya çıkar. Platform bağımsızlığını sağlayan bytecode'dur. Çünkü bir kere bytecode oluştuktan sonra yazılım, sanal makine içeren tüm işletim sistemlerinde çalışabilmektedir.
Bu bytecode Java Sanal Makinesi (Java Virtual Machine - JVM) tarafından işletilir. Bu aşama, her bir bytecode komutunun teker teker yorumlanması ile icra edilebileceği gibi, anında derleme (Just-in-time compilation - JIT) kullanılarak da gerçekleştirilebilir.

Java Yazımı (Sözdizimi): 

Sınıf temelli nesneye yönelik bir dil olan Java, yazım olarak C++ ile benzerlikler arz eder. Java'nın yanında C#, Perl, JavaScript gibi diller de aynı dil ailesine aittir. "{}" şeklinde süslü parantezler içerisindeki bloklar, ++ arttırma ve-azaltma işleçleri bu dilin belirgin özelliklerindendir.

Merhaba Dünya
 // MerhabaDünya.java
 public class MerhabaDünya{
     public static void main(String[] args) {
         System.out.println("Merhaba Dünya!");
     }
 }
 
"MerhabaDünya.java" ile "public class MerhabaDünya" bu kısımda iki isim aynı olmalıdır aksi takdirde uygulama çalıştırılamaz.
class: Sınıf tanımlayabilmek için class ön eki şarttır.
public: Sınıfın dışarıdan erişebilir olduğu,
static: Sınıf tarafından paylaşıldığı,
void: Bir değer döndürmediği anlamına gelir.
Public ve Static'e erişim belirleyicisi (access specifier) de denir.
Void'e dönüş tipi (return type) de denir.
String args[]: Parantezin içinde yöntemin aldığı parametreleri belirleriz. "String" sınıf adı, "args" da parametre adıdır. "[]" ise args'ın bir dizi (array) olduğunu belirtiyor.
"System.out.println();" ile yazımızı yazdırıyoruz ve yeni satıra geçmesini sağlıyoruz.
Yazımızı "System.out.print("Merhaba Dunya!");" ile de yazdırabilirdik. Fakat imleç yeni satıra geçmezdi.
Java Türkçe karakterleri (C# gibi) "değişken adlarında, sınıf adlarında" da kullanmamıza imkân tanır.
Java'da yazdığımız yazılımları derlememiz için öncelikle sınıf adı ile aynı adı taşıyan dosya ismine sahip olmamız gerekmektedir. Yukarıdaki örnek yazılımı sınıf ismi olan "MerhabaDünya" ifadesini kullanıp uzantısı ile beraber "MerhabaDünya.java" ismi ile kaydedebiliriz. J2SDK veya benzer bir Java geliştirme ortamı kurulu sistemimizde yazılan uygulama aşağıdaki şekilde derlenebilir.

javac -encoding UTF-8 MerhabaDünya.java
javac, yazılan programı derleyerek ".class" uzantılı bir dosya üretir. ".class" sınıf dosyaları JVM'de çalışabilecek bytecode'lar içeren sınıf dosyalarıdır. Örnek uygulamayı çalıştırmak için:

java MerhabaDünya
yazabiliriz. Java komutu öncelikle sınıf yolunda "MerhabaDünya" sınıfını arayacaktır. Bulduğu takdirde "MerhabaDünya" sınıfında "main" metodunu arayacaktır. Eğer metot bulunur ise bu metot icra edilecektir.

Kaynak: https://tr.m.wikipedia.org/wiki/Java

///////////////////////////////

JAVA'NIN ÖZELLİKLERİ

Java Giriş

Java, Sun Microsystems ilk olarak 1995 yılında piyasaya sürdüğü bir programlama dili ve bilgi işlem platformudur. Taşınabilir olacak şekilde tasarlanmış, sınıf tabanlı, nesne yönelimli bir dildir, yani Java kodu çok çeşitli donanım ve işletim sistemlerinde çalışabilir. Java, kurumsal düzeyde uygulamalar, mobil uygulamalar, video oyunları ve diğer yazılım türleri geliştirmek için yaygın olarak kullanılır. Java kodu, Java Sanal Makinesini ( JVM) destekleyen herhangi bir platformda çalışacak şekilde derlenebildiğinden, "bir kez yaz, her yerde çalıştır" felsefesiyle bilinir. Ayrıca Java, geliştiriciler için zengin kitaplıklar ve çerçeveler içeren geniş ve aktif bir ekosisteme sahiptir.

Java, bellek yönetimi ve otomatik özel durum işleme gibi özelliklerle sıfırdan güvenli olacak şekilde tasarlandığından, güvenlik özellikleriyle de bilinir. Java'nın "çöp toplayıcı" olarak adlandırılan bellek yönetimi özelliği, artık kullanılmayan belleği otomatik olarak boşaltarak bellek sızıntısı olasılığını azaltır. Otomatik özel durum işleme özelliği, geliştiricilerin beklenmeyen hataları işleyebilecek sağlam kodlar yazmasını kolaylaştırır.

Java bir diğer önemli özelliği de, birden çok yürütme iş parçacığının tek bir program içinde aynı anda çalışmasına izin veren çoklu okuma desteğidir. Bu, kullanıcı programla etkileşim halindeyken bir arka plan görevi çalıştırmak gibi çeşitli görevleri aynı anda gerçekleştirmeyi mümkün kılar. Genel olarak Java, endüstride, açık kaynak kodlu ve akademide yaygın olarak kullanılan güçlü, çok yönlü ve olgun bir programlama dilidir. Taşınabilirliği, güvenliği ve performansı onu çeşitli projeler için mükemmel bir seçim haline getiriyor.

Java Terminolojisi

Java programlama diliyle ilişkili birkaç anahtar terim ve kavram vardır:

Class: Sınıf, nesneler oluşturmak için bir şablon veya plandır. Nesnenin özelliklerini ve yöntemlerini tanımlar.
Object: Bir sınıfın örneği. Nesneler, sınıf tarafından tanımlanan özelliklere ve yöntemlere sahiptir.
Method: Belirli bir görevi gerçekleştirmek için bir nesne üzerinde çağrılabilen bir işlev veya yordam.
Inheritance: Bir sınıfın, özellikleri ve yöntemleri bir üst sınıftan miras alma yeteneği. Bu, kodun yeniden kullanılmasına ve daha özel sınıfların oluşturulmasına izin verir.
Interface: Bir sınıfın uygulaması gereken bir dizi yöntem. Arayüzler, izlenecek bir kurs için bir sözleşme tanımlamak için kullanılır.
Package: İlgili sınıfların ve arayüzlerin bir gruplaması. Paketler, kodu düzenlemek ve adlandırma çakışmalarını önlemek için kullanılır.
JRE ( Java Runtime Environment): Java uygulamalarının çalıştığı yazılım ortamı. JVM ve bir dizi kitaplığı ve diğer dosyaları içerir.
JDK ( Java Development Kit): JRE, bir derleyici ve diğer araçlar dahil olmak üzere Java uygulamaları geliştirmek için bir dizi araç.
JIT (Just-In-Time) Compiler: Çalışma zamanında Java bayt kodunu makine koduna derleyen bir JVM özelliği. Bu, Java uygulamalarının performansını artırır.
Garbage Collection: Artık bir program tarafından kullanılmayan belleği otomatik olarak boşaltan bir JVM özelliği. Bu, bellek sızıntılarını ve bellekle ilgili diğer sorunları önlemeye yardımcı olur.

Java Birincil/Ana Özellikleri

Java, geliştiricilerin çeşitli uygulamalar oluşturmak için geniş çapta benimsediği popüler, genel amaçlı bir programlama dilidir. Java geliştiriciler için mükemmel bir seçim yapan temel özelliklerinden bazıları şunlardır:

Nesne Yönelimli Programlama : Java, sınıf tabanlı, nesne yönelimli bir programlama dilidir, yani nesneler, sınıflar ve kalıtım kavramlarına dayanır. Bu, diğer geliştiriciler tarafından kolayca anlaşılabilen ve korunabilen modüler, yeniden kullanılabilir kod oluşturmayı kolaylaştırır.

Platform Bağımsızlığı : Java kodu, bayt kodu adı verilen ve Java Virtual Machine ( JVM) kurulu olan herhangi bir platformda çalıştırılabilen bir ara biçimde derlenir. "Bir kez yaz, her yerde çalıştır" ( WORA) olarak bilinen bu özellik, geliştiricilerin herhangi bir değişiklik yapmadan kodu bir kez yazıp birden çok platformda çalıştırmasına olanak tanır.

Bellek Yönetimi : Java'nın otomatik bellek yönetimi ve çöp toplama özellikleri, bir programın artık kullanılmayan belleğini boşaltarak bellek sızıntılarını ve bellekle ilgili diğer sorunları önlemeye yardımcı olur. Bu, geliştiricilerin beklenmeyen hataları işleyebilen sağlam kodlar yazmasını kolaylaştırır.

Multithreading : Java'nın multithreading desteği, birden çok yürütme dizisinin tek bir program içinde aynı anda çalışmasına izin verir. Bu, kullanıcı programla etkileşim halindeyken bir arka plan görevi çalıştırmak gibi aynı anda birden çok görevi gerçekleştirmeyi mümkün kılar.

İstisna İşleme : Java'nın yerleşik istisna işleme mekanizması, geliştiricilerin kodlarındaki hataları ve istisnaları işlemesini kolaylaştırır. Bu özellik, geliştiricilerin daha sağlam ve güvenilir kod yazmasını sağlar.

Güvenlik : Java, güvenilmeyen kodu sistemin geri kalanından yalıtan Java sandbox ve bir Java uygulamasında güvenlik ilkelerini uygulayan Güvenlik Yöneticisi gibi özelliklerle sıfırdan güvenli olacak şekilde tasarlanmıştır.

API ve Kitaplıklar : Java, geliştiricilere çok çeşitli işlevler sağlayan zengin bir API'ye ve geniş açık kaynak kitaplıklara sahiptir. Bu kitaplıklar ve çerçeveler, geliştiricilerin bir veritabanına bağlanma, XML işleme ve daha fazlası gibi ortak görevleri gerçekleştirmesini kolaylaştırır.

Topluluk ve Ekosistem : Java, geniş ve aktif bir geliştirici topluluğuna sahiptir; bu, geliştiricilerin dili öğrenmesine ve kullanmasına yardımcı olacak çok sayıda kaynak, öğretici ve forum olduğu anlamına gelir. Ek olarak, aktif ekosistem, geliştiricilerin uygulamalarını oluşturmak için kullanabilecekleri çeşitli çerçeveler ve kitaplıklar içerir.

Tüm bu özellikler, Java endüstride, açık kaynak kodlu ve akademide yaygın olarak kullanılan güçlü, çok yönlü ve olgun bir programlama dili yapar. Taşınabilirliği, güvenliği ve performansı onu çeşitli projeler için mükemmel bir seçim haline getiriyor.

Java ne için kullanılır?

Java, çeşitli yazılım uygulamaları oluşturmak için yaygın olarak kullanılan evrensel bir programlama dilidir. Müşteri ilişkileri yönetimi sistemleri , kurumsal kaynak planlama sistemleri ve tedarik zinciri yönetim sistemleri gibi kurumsal düzeyde uygulamalar geliştirmek için yaygın olarak kullanılır. Ayrıca android mobil uygulamaları, web uygulamaları, web sunucuları ve uygulama sunucuları, oyunlar, bilimsel uygulamalar, finansal uygulamalar ve daha fazlasını geliştirmek için kullanılır. Ek olarak, Java'nın geniş kitaplıkları ve çerçeveleri, geliştiricilerin veritabanlarıyla etkileşim kurabilen, XML'i işleyebilen ve diğer genel görevleri gerçekleştirebilen uygulamalar oluşturmasını kolaylaştırır.

Kaynak: https://appmaster.io/tr/blog/java-tanimi-anlami-ozellikler-nedir

///////////////////////////////////////

JAVA VERİ TİPLERİ

Değişkenler tüm programlama dillerinde kullanılan bir yapı olup, kodlamanın temel yapısını oluşturmaktadır.Değişkenler programlamada geçici bilgileri tuttuğumuz yapılardır ve yazılımcı tarafından belirlenir.Değişkenler sayesinde program içinde yaptığımız işlemleri hafıza da tutar ve gerektiği yerlerde kullanırız. 

Değişkenlerin 4 özelliği bulunur; Veri Türü, İsim, Değer ve Adres.

Değişkenlerde Veri Türü, adından da anlaşılacağı üzere verinin saklanacağı türünü belirtmektedir bunlar sayılar, sözcükler ve programatik alanlar olabilir. Her değişkenin program içinde kullanıldığı ve çağrıldığı benzersiz bir ismi vardır. Bu değişkenlere birde değer atarız, işletim sistemimizde bu değişkeni hafızada tutar ve bir adres belirler.

Java Değişken Tanımlama ve Kullanımı

int sayi = 100; komutu ile sayi isminde türü int ve değeri 100 olan bir değişken tanımlanmıştır. Bu değişkenin hafızada nerede tutulduğu ise işletim sistemi tarafından belirlenir.

Java Değişken Tanımlama Yazım Kuralı (Syntax)

Java'da değişken tanımlamanın kuralı şu şekildedir,
veriTipi değişkenİsmi = değişkenDeğeri;

İlk önce değişkenin veri tipini ve değişkenin ismini yazarız ve aynı matematikteki gibi "=" eşittir ile değerini atarız.

Java Veri Tipleri

Java'da değişken tanımlamak için belirlenmiş veri tipleri mevcuttur. Java Veri Tipleri Nelerdir?

Tam Sayılar: ​Byte, Short, Integer, Long
Ondalıklı Sayılar: Float, Double
Karakterler: Char
Mantıksal Değerler: Boolean

Kaynak: https://kodlamavakti.com/java/degiskenler-ve-veri-tipleri/

///////////////////////////////////////

Java programlama dilinde, verileri saklamak ve işlemek için farklı veri tipleri kullanılır. Bu veri tipleri, temel (primitive) veri tipleri ve referans (non-primitive) veri tipleri olmak üzere iki ana kategoriye ayrılır.

TEMEL VERİ TİPLERİ (Primitive Data Types)

Temel veri tipleri, Java’nın dilinde yerleşik olarak bulunan ve basit veri türlerini temsil eden tiplerdir.

byte: 8 bit veya 1 byte bellek kullanır. -128 ile 127 arasında tamsayıları saklar. Özellikle dosya işlemleri ve ağ iletişimi gibi alanlarda kullanışlıdır.
short: 16 bit veya 2 byte bellek kullanır. -32,768 ile 32,767 arasında tamsayıları saklar. Genellikle yer tasarrufu gereken durumlarda kullanılır.
int: 32 bit veya 4 byte bellek kullanır. -2,147,483,648 ile 2,147,483,647 arasında tamsayıları saklar. Genel amaçlı bir tamsayı veri tipidir ve sıklıkla kullanılır.
long: 64 bit veya 8 byte bellek kullanır. Çok büyük tamsayıları saklamak için kullanılır. Örneğin, zaman damgalarını saklamak için idealdir.
float: 32 bit veya 4 byte bellek kullanır. Ondalık sayıları (kesirli sayıları) saklar. Kesirli değerlerde hassasiyet kaybı yaşanabilir.
double: 64 bit veya 8 byte bellek kullanır. Çift hassasiyetli ondalık sayıları saklar ve daha yüksek hassasiyet sunar. Bilimsel hesaplamalarda sıkça kullanılır.
char: 16 bit veya 2 byte bellek kullanır. Tek bir karakteri (Unicode karakterler dahil) saklar. Özellikle metin işleme için kullanılır.
boolean: Genellikle tam olarak belirli bir boyuta sahip değil, ancak çoğu durumda bir byte bellek kullanır. true veya false mantıksal değerlerini saklar.

REFERANS VERİ TİPLERİ (Reference Data Types)

Referans veri tipleri, bellekte bir nesnenin referansını saklar, bu nedenle veri türünün kendisi için sabit bir boyut yoktur. Ancak bu referanslar nesneleri işaret ettiği için, bellekteki nesnelerin büyüklüğü bu nesnelerin türüne ve içerdikleri veriye bağlıdır.

Bir String nesnesi metin verisi içerdiğinden ve bu veri boyutu değişebileceğinden, String türündeki bir referansın kendisi sabit bir boyuta sahiptir, ancak içerdiği verinin boyutu değişebilir.

String, dizi (array) ve sınıf nesnesi (ArrayList) gibi referans veri tipleri bulunmaktadır. Bu tipler, nesneleri işaret etmek veya daha karmaşık veri yapılarını temsil etmek için kullanılmaktadır.

Kaynak: http://ders.codingbytime.com/java-veri-tipleri/

/////////////////////////////////////

JAR VE WAR DOSYALARI

Bu dosyalar sadece dosya sıkıştırılmış java jar aracını kullanmaktadır. Bu dosyalar farklı amaçlar için oluşturulmuştur. Bu dosyaların açıklaması:

.jar dosyaları: jar dosyası içerir. Kütüphaneler, kaynaklar ve aksesuarlar dosyaları, özellik dosyalar gibi.

.war dosyalar: war dosyası içerir. Web uygulaması olabilir Herhangi bir sunucu uygulaması/jsp ile kurulan kap. .war dosyası jsp içerir. Html, javascript ve diğer dosyalar web gelişimi için gerekli uygulamalardır.

Kaynak: https://sorucevap.netgez.com/java-savas-vs-jar---fark-nedir

/////////////////////////////////




