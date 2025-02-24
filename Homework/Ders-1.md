

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

Maven için gerekli olan Java kurulumunu yaptıktan ve Maven paketini indirip çalışma ortamımıza çıkardıktan ve çıkardığımız alanı da environment variable olarak tanımladıktan sonra Maven kullanmaya başlayabiliriz.
mvn archetype:generate
        -DgroupId={project-packaging}
        -DartifactId={project-name}
        -DarchetypeArtifactId={maven-template}
        -DinteractiveMode=false
ile bir proje yaratıp daha sonra aşağıdaki komutları kullanarak işlemlerimizi yapabiliriz, temel maven komutlarını ve açıklamalarını şöyle sıralayabiliriz;
$ mvn clean: Hedef dizini (target) silerek derlenmiş artifactı temizlemek için kullanılır.
$ mvn compiler:compile: Java source kodlarını derlemek için kullanılır.
$ mvn compiler:testCompile: Java source codeların içerisindeki test classlarını derlemek için kullanılır.
$ mvn package: Maven projesi oluşturmak ve onları .jar , .war olarak vs. olarak paketlemek için kullanılır.
$ mvn dependency:tree: Proje için pom.xml içerisinde bulunan bağımlılıklar ve altbağımlılıkların bir haritasını üretir.
$ mvn install: Lokal maven klasörünün, reposunun içerisine paketi yüklemek için kullanılır. $ mvn deploy ise bunları uzak repoya atmak için kullanılır.
$ mvn site:site: Maven projesi için site oluşturmak ve onu lokalde görüntülemek için kullanılır.
$ mvn test: Surefire-plugin yardımı ile proje içerisinde yazılan test caseleri çalıştırmak için kullanılır.
$ mvn -v: Bilgisayarımızda kurulu maven versiyonunu gösterir.
$ mvn -o: Offline modda lokalimizde çalışıp işlem yapmamızı, $mvn -q ise sadece test caselerimizi çalıştırıp sonuçlarını alabilmemizi sağlar.
$ mvn -help: Maven komutları ile ilgili destek komutudur, komutları, açıklamalarınızı ve fazlasını bu komut ile listeleyebiliriz.

Bazı maven işlemleri için pluginlere ihtiyaç vardır. Pluginler mavenın güçlendiricisi olmanın yanısıra yapıtaşıdır, birçok işlem pluginler ile yapılır ve merkez repository ya da üçüncü parti araçlar maven pluginleri bulundurur. Bu pluginler mavenı zenginleştirmek ve belirli işlemleri gerçekleştirmek için kritiktir. Örneğin bir war çıktısı alabilmek için maven-war-plugin kurulması gerekir ya da jetty plugin ile web geliştirmeleri daha etkili olabilir. Spring framework web geliştirmelerini derleyebilmek için spring-boot-plugin kullanmak gerekir ya da uzak repoya bir paket göndermek için maven-deploy-plugin kullanmak gerekir. Bununla birlikte farklı işlemler için kullanılması gereken birçok eklenti vardır.

Maven'in avantajları:
Maven özellikle çok fazla bağımlılık içeren projeleri init etmek ve yönetmek için olağanüstü bir çerçeve ve kolaylık sunmaktadır.
Yapı olarak oldukça kolay kullanılır, kolay yönetilir bir yapı ile geliştiricilerin ve ekiplerin işini kolaylaştırır.
Standartları sayesinde ortam, IDE, servis bağımsız çalışmayı sağlar ve standartların temel faydalarından biri olarak anlaşılabilirliği artırır.
Sürüm güncellemelerini takip etmek ve özellikle bağımlılık ve alt bağımlılıkların da sürümlerini yönetmeyi takip etmek için oldukça efektiftir. 
Sürekli derleme, sürekli entegrasyon (CI/CD) ve bu süreçlere bağlı sürekli testleri çalıştırmak için harika bir altyapı sunar, bu işlemlerin yapıldığı (Jenkins vs.) araçlar ile de pluginler, entegrasyonlar sayesinde oldukça uyumlu çalışır.
Farklı formatlarda paketler, çıktılar oluşturmak için oldukça efektiftir.
