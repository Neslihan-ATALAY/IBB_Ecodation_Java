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
<groupId>com.yusufsezer</groupId> - Proje adı (Paket adı kullanılır genellike)
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

Kaynak: https://medium.com/@fatihbildirici.dev/maven-%C3%B6zellikleri-yap%C4%B1s%C4%B1-nedir-neden-kullan%C4%B1r%C4%B1z-599b469bfee3
