JAVA ITERATOR DÖNGÜ VE FOREACH DÖNGÜ

Iterator bir koleksiyonu (örneğin array, array list, map) gezmek için kullanılan araçlardan biridir. Koleksiyon gösteriminin özelliğini ortaya çıkarmaksızın sıra ile koleksiyon elemanlarına erişmek için standart bir yöntem sağlayan Iterator tasarım örüntüsünü düzenlemektedir.

Iterator döngü örneği:
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    String item = it.next();
    // Karmaşık operasyonlar çalıştırılır.
}

Iterator iterasyon sırasında koleksiyonu değiştirme için yeteneğe ve ayrıntılı iterasyon kontrolüne izin vermektedir.

Bir başka Iterator döngü örneği:
Iterator it = list.iterator();
while (it.hasNext()) {
    String item = it.next();
    if (item.equals("unwanted")) {
      it.remove(); // eleman silindi.
  }
}

Ayrıntılı yapısı özellikle karmaşık iterasyon mantığı ile kodu daha az okunabilir yapabilmektedir.

forEach()
Java 8 ile başlayan tekrarlayan arayüz (iterable interface) herbir koleksiyon elemanı için bir faaliyet uygulayan forEach() metodu içermektedir. 

ForEach() döngü örneği:
list.forEach(item -> {
    // Basit operasyonlar çalıştırılır.
    System.out.println(item);
});

forEach() kod okunurluğunu artırmak için yardımcı olur. Özlü söz dizimi ile iterasyonu basitleştirir ve koleksiyon değişikliği olmaksızın açık gezinmeler için idealdir.

forEach() koleksiyonu tekrarlama ile değiştirmeyi doğrudan desteklemez. Bir forEach() döngüsü sırasında koleksiyondan eleman silme ve koleksiyona eleman eklemeye çalışmak bir derleme hatasına neden olabilmektedir. "Bir lambda ifadesine başvurulan yerel değişkenler final veya etkin olarak final olmalıdır."

list.forEach(item -> {
    if (item.equals("unwanted")) {
      // Doğrudan silme bir derleme hatasına neden olacaktır.
      // list.remove(item);
  }
});

Döngünün nedeni koleksiyona herhangi bir yapısal değişikliğin farkında olmak için tasarlanmamıştır.

Bir forEach() iterasyonu sırasında bir koleksiyonu değiştirmek için başka bir teknik vardır. Orjinal listeyi değiştirmek için ayrı bir listede elemanları toplamak gereklidir. Fakat daha az verimli ve daha kullanışsızdır.

Listelenecek elemanlar için koleksiyon oluşturma
List<String> toRemove = new ArrayList<>();
// Silinecek elemanları tanımlamak için forEach() kullanma
list.forEach(item -> {
    if (item.equals("unwanted")) {
      toRemove.add(item);
  }
});
// Orjinal listeden tanımlı elemanları silme
list.removeAll(toRemove);

Bir Iterator ve forEach() döngüsü kullanımı arasında performans farkı minimaldir ve diğerinden birini seçmede birinci unsur olmamalıdır.

Karşılaştırma tablosu:
Döngü Elemanı - Söz Dizimi - Değişiklik Yeteneği - Performans
Iterator - Daha az okunaklı - Destekler - Neredeyse aynı
forEach() - Daha okunaklı - Desteklenmez - Neredeyse aynı

Iterator, koleksiyonu dinamik olarak değiştirmek için esneklik gerekiyor ise en iyi seçenektir. 

ForEach() döngüsü, kod açıklığını ve basitliğini vurgulayan durumlar için daha uygun bir seçenektir.

Kaynak:  https://www.baeldung.com/java-iterator-vs-foreach

//////////////////////////////
