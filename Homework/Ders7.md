STATİK OLUŞTURUCU

Statik oluşturucu, statik verileri başlatmak veya yalnızca bir kez gerçekleştirilmesi gereken belirli bir eylemi gerçekleştirmek için kullanılır. İlk örnek oluşturulmadan veya statik üyelere başvurulmadan önce otomatik olarak çağrılır. Statik oluşturucu en fazla bir kez çağrılır.

class SimpleClass
{
    // Static variable that must be initialized at run time.
    static readonly long baseline;

    // Static constructor is called at most one time, before any
    // instance constructor is invoked or member is accessed.
    static SimpleClass()
    {
        baseline = DateTime.Now.Ticks;
    }
}
Statik başlatmanın parçası olan birkaç eylem vardır. Bu eylemler aşağıdaki sırayla gerçekleştirilir:

Statik alanlar 0 olarak ayarlanır. Çalışma zamanı genellikle bu başlatmayı yapar.
Statik alan başlatıcıları çalışır. En türetilmiş türdeki statik alan başlatıcıları çalıştırılır.
Temel tür statik alan başlatıcıları çalışır. Her taban türü aracılığıyla doğrudan taban ile başlayan statik alan başlatıcıları olarak System.Object.
Tüm statik oluşturucular çalışır. Her temel sınıfın nihai temel sınıfından tür çalıştırması Object.Object aracılığıyla tüm statik oluşturucular. Statik oluşturucu yürütme sırası belirtilmemiş. Ancak, hiyerarşideki tüm statik oluşturucular herhangi bir örnek oluşturulmadan önce çalışır.

Bir statik oluşturucunun herhangi bir örnek oluşturulmadan önce çalışması kuralında önemli bir özel durum vardır. Statik alan başlatıcı türün bir örneğini oluşturursa, bu başlatıcı statik oluşturucu çalışmadan önce (örnek oluşturucuya yapılan herhangi bir çağrı dahil) çalışır. Bu, aşağıdaki örnekte gösterildiği gibi tekil desende en yaygın olanıdır:

public class Singleton
{
    // Static field initializer calls instance constructor.
    private static Singleton instance = new Singleton();

    private Singleton()
    { 
        Console.WriteLine("Executes before static constructor.");
    }

    static Singleton()
    { 
        Console.WriteLine("Executes after instance constructor.");
    }

    public static Singleton Instance => instance;
}
Modül başlatıcı, statik bir oluşturucuya alternatif olabilir.

Statik oluşturucular aşağıdaki özelliklere sahiptir:
Statik oluşturucu erişim değiştiricileri almaz veya parametreleri yoktur.
Bir sınıf veya yapı yalnızca bir statik oluşturucuya sahip olabilir.
Statik oluşturucular devralınamaz veya aşırı yüklenemez.
Statik oluşturucu doğrudan çağrılamıyor ve yalnızca ortak dil çalışma zamanı (CLR) tarafından çağrılmak üzere tasarlanıyor. Otomatik olarak çağrılır.
Kullanıcının, statik oluşturucunun programda ne zaman yürütülürken denetimi yoktur.
Statik oluşturucu otomatik olarak çağrılır. İlk örnek oluşturulmadan önce sınıfı başlatır veya bu sınıfta bildirilen statik üyelere (temel sınıflarına değil) başvurulur. Statik oluşturucu, örnek oluşturucudan önce çalışır. Statik alan değişkeni başlatıcıları statik oluşturucunun sınıfında mevcutsa, sınıf bildiriminde göründükleri metin sırasına göre çalışırlar. Başlatıcılar statik oluşturucudan hemen önce çalışır.
Statik alanları başlatmak için statik bir oluşturucu sağlamazsanız, tüm statik alanlar varsayılan değerlerinde C# türlerinin Varsayılan değerlerinde listelendiği gibi başlatılır.
Statik bir oluşturucu özel durum oluşturursa, çalışma zamanı bunu ikinci kez çağırmaz ve uygulama etki alanının ömrü boyunca tür başlatılmamış olarak kalır. En yaygın olarak, statik TypeInitializationException bir oluşturucu bir tür örneği oluşturamadığında veya statik oluşturucuda oluşan işlenmeyen bir özel durum için bir özel durum oluşturulur. Kaynak kodunda açıkça tanımlanmayan statik oluşturucular için sorun giderme, ara dil (IL) kodunun incelenmesini gerektirebilir.
Statik bir oluşturucunun varlığı tür özniteliğinin eklenmesini BeforeFieldInit engeller. Bu, çalışma zamanı iyileştirmeyi sınırlar.
olarak static readonly bildirilen bir alan yalnızca bildiriminin bir parçası olarak veya statik bir oluşturucuda atanabilir. Açık bir statik oluşturucu gerekli olmadığında, daha iyi çalışma zamanı iyileştirmesi için statik bir oluşturucu yerine bildirimde statik alanları başlatın.
Çalışma zamanı, tek bir uygulama etki alanında en fazla bir kez statik oluşturucu çağırır. Bu çağrı, sınıfın belirli türüne göre kilitli bir bölgede yapılır. Statik bir oluşturucunun gövdesinde fazladan kilitleme mekanizması gerekmez. Kilitlenme riskini önlemek için statik oluşturucularda ve başlatıcılarda geçerli iş parçacığını engellemeyin. Örneğin, görevler, iş parçacıkları, bekleme tutamaçları veya olayları beklemeyin, kilitleri almayın ve paralel döngüler Parallel.Invoke ve Paralel LINQ sorguları gibi engelleyici paralel işlemleri yürütmeyin.

Doğrudan erişilebilir olmasa da, başlatma özel durumlarının giderilmesine yardımcı olmak için açık bir statik oluşturucunun varlığı belgelenmelidir.

Kullanım
Statik oluşturucuların tipik bir kullanımı, sınıfın bir günlük dosyası kullanması ve oluşturucunun bu dosyaya girdi yazmak için kullanılmasıdır.
Statik oluşturucular, oluşturucu yöntemini çağırabildiğinde LoadLibrary yönetilmeyen kod için sarmalayıcı sınıfları oluştururken de yararlıdır.
Statik oluşturucular, tür parametresi kısıtlamaları aracılığıyla derleme zamanında denetlenmeyen tür parametresinde çalışma zamanı denetimlerini zorunlu kılmak için de uygun bir yerdir.

Örnek
Bu örnekte, sınıfın Bus statik bir oluşturucusu vardır. öğesinin ilk örneği Bus oluşturulduğunda ()bus1 sınıfını başlatmak için statik oluşturucu çağrılır. Örnek çıktı, iki örneği Bus oluşturulsa bile statik oluşturucunun yalnızca bir kez çalıştığını ve örnek oluşturucu çalışmadan önce çalıştığını doğrular.

public class Bus
{
    // Static variable used by all Bus instances.
    // Represents the time the first bus of the day starts its route.
    protected static readonly DateTime globalStartTime;

    // Property for the number of each bus.
    protected int RouteNumber { get; set; }

    // Static constructor to initialize the static variable.
    // It is invoked before the first instance constructor is run.
    static Bus()
    {
        globalStartTime = DateTime.Now;

        // The following statement produces the first line of output,
        // and the line occurs only once.
        Console.WriteLine("Static constructor sets global start time to {0}",
            globalStartTime.ToLongTimeString());
    }

    // Instance constructor.
    public Bus(int routeNum)
    {
        RouteNumber = routeNum;
        Console.WriteLine("Bus #{0} is created.", RouteNumber);
    }

    // Instance method.
    public void Drive()
    {
        TimeSpan elapsedTime = DateTime.Now - globalStartTime;

        // For demonstration purposes we treat milliseconds as minutes to simulate
        // actual bus times. Do not do this in your actual bus schedule program!
        Console.WriteLine("{0} is starting its route {1:N2} minutes after global start time {2}.",
                                this.RouteNumber,
                                elapsedTime.Milliseconds,
                                globalStartTime.ToShortTimeString());
    }
}

class TestBus
{
    static void Main()
    {
        // The creation of this instance activates the static constructor.
        Bus bus1 = new Bus(71);

        // Create a second bus.
        Bus bus2 = new Bus(72);

        // Send bus1 on its way.
        bus1.Drive();

        // Wait for bus2 to warm up.
        System.Threading.Thread.Sleep(25);

        // Send bus2 on its way.
        bus2.Drive();

        // Keep the console window open in debug mode.
        Console.WriteLine("Press any key to exit.");
        Console.ReadKey();
    }
}
/* Sample output:
    Static constructor sets global start time to 3:57:08 PM.
    Bus #71 is created.
    Bus #72 is created.
    71 is starting its route 6.00 minutes after global start time 3:57 PM.
    72 is starting its route 31.00 minutes after global start time 3:57 PM.
*/

Kaynak: https://learn.microsoft.com/tr-tr/dotnet/csharp/programming-guide/classes-and-structs/static-constructors

//////////////////////////////

IsEmpty

Bir değişken başlatılıp başlatılmadığını gösteren bir Boole değeri döndürür.

IsEmpty ( ifade )

Gerekli ifade bağımsız değişken sayısal veya dize ifadesi içeren bir değişkendir. Ancak bağımsız değişkenlerin başlatılıp başlatılmadığını belirlemek için IsEmpty kullanıldığından, ifade bağımsız değişkeni çoğunlukla tek bir değişken adıdır.

Açıklamalar
IsEmpty, değişken başlatılmamışsa veya açıkça Boş olarak ayarlandıysa True döndürür; aksi takdirde False döndürür. İfade birden fazla değişken içeriyorsa her zaman False döndürülür. IsEmpty yalnızca değişkenler için anlamlı bilgiler döndürür.

Kaynak: https://support.microsoft.com/tr-tr/topic/isempty-%C4%B0%C5%9Flevi-a86d5871-f6bd-455c-9256-a69a42e55e5

isEmpty() işlevini ve null değeri
class Main {
    public static void main(String[] args) {
        String emptyVariable = "";
        if (emptyVariable.isEmpty())
            System.out.println("empty");
        emptyVariable = null;
        if (emptyVariable == null)
            System.out.println("null");
            
        String empty2 = "";
        if (empty2!=null && !empty2.isEmpty())
            System.out.println(empty2);
        empty2 = null;
        if (empty2!=null && !empty2.isEmpty())
            System.out.println(empty2);
        empty2 = "not empty and not null";
        if (empty2!=null && !empty2.isEmpty())
            System.out.println(empty2);
    }
}
Programın Çıktısı:
empty
null
not empty and not null

////////////////////////////////

