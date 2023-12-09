# ButonKontrolPaneli
YAZILIM MÜHENDİSLİĞİ BÖLÜMÜ NESNEYE YÖNELİK PROGRAMLAMA DERSİ 1. KISA  SINAV 2. ÖDEVİ

KODUN CALISMA MANTIGI (ALGORİTMASI) :

İlk önce ana pencereyi(jframe) oluştururuz. Bunu **`ButonKontrolPaneli`** sınıfı, bir **`JFrame`** öğesini miras alır (extends) ve pencerenin başlığını

**`ButonKontrolPaneli`**  sınıfının constructırı içinde belirtiriz(buton kontrol paneli) Pencere düzeni **`GridLayout`** kullanılarak belirlenir ve bir 4x4'lük matris oluşturularak her bir hücreye bir **`ButonOzellik`** eklenir.Sonra ise,

Buton özelliklerini belirteceğimiz **`ButonOzellik`** sınıfı, bir **`JButton`** öğesini genişleterek butonların özelliklerini tanımlarız. Her bir butonun durumu aktif olarak yeşil(renk) ve bir ikonu, pasif olarak ise kırmızı rengi ve bir ikonu bulunur.Burada bunları tanımladıktan sonra  yine her butonun hayali bir GraphQL şemasına gönderilecek bilgi gibi özellikleri bulunur.Sonra butonları oluştururuz  bunu ilk önce İç içe iki döngü kullanarak bir 4x4'lük matris oluşturdum ve Her bir hücreye, butonların özelliklerini taşıyan bir **`ButonOzellik`** örneği eklenir ve bu butonlar pencereye eklenir grid 4*4 lük bir düzende yerleşir.

Her bir buton da gercekleşecek işlemi **addActionListener metodunu override ederek bir `ActionListener` eklenir butona tıklanıldığında ise `butonuAktiflestir`** ve **`executeGraphQLMutation`** metodları sırasıyla çağrılır.

**`butonuAktiflestir` metodunda ise butona tıklanıldığında** : Tüm butonların durumu pasif yapılır ve sadece seçilen butonun durumu aktif yapılır. Renk ve ikonlar ayarlanır.

**`executeGraphQLMutation` metodunda ise**: Butona tıklandığında çağrılan bu metod, hayali GraphQL mutation sorgusunu oluşturur ve bu sorgu, değişkenler ve şema adresini konsola yazdırır. ve son olarak**`main`** metodunda , SwingUtilities.invokeLater metodu  kullanılarak ana pencereyi oluşturulur ve görünür hale gelir.

Nasıl Kullanacağız ve Test Edeceğiz: 

Kodu calıştırdığımızda 4*4 düzeninde karşımıza butonlar’dan oluşan bir pencere çıkacak ve ilk basta bütün butonlar pasif halde olacak ve ekranda pasif ikonları ve renkleri göreceksiniz burada pasif renk kırmızıdır. 

Herhangi bir butona tıkladığınızda o buton aktif olup  rengi ve ikonu aktif ikon ve renge göre ayarlanacak burda aktif rengimiz yeşildir  ve başka aktif olan buton varsa pasif hale gelecek sadece tıkladığınız buton aktif hale gelecek ve butona tıkladığnızda hayali graphql işlemleri gercekleşecek ve bu işlemler konsolda yazacak.

GRAPHQL MUTATİON SORGUSU AÇIKLAMASI :

Bu koddaki graphql ’den bahsetmeden önce graphql hakkında biraz bilgi vermek gerekirse kısaca graphql 2012’de facebook tarafından geliştirilmiştir ve 2015 de açık kaynaklı olmuştur.Graphql bir veri sorgulama dili olup ve genellikle bir API’nin arka planında kullanılır.Graphql herhangi bir veritabanına veya depolama motoruna bağlı değildir ve bunun yerine mevcut kodunuz ve verilerinizle desteklenir.GraphQL’in kısa tanımı şöyledir: “Query language for your API” yani “API’niz için bir sorgulama dili”. GraphQL, sunucudan veri çekerken istemcilere tam olarak istediklerini vermeyi önceliklen diren bir sorgu dilidir. İstemciler, sunucuya bir şema üzerinden hangi alanları istediklerine göre bir sorgu oluşturur. Sunucu, bu sorguyu işler ve yalnızca istenilen verileri yanıt olarak gönderir.esnek bir yapısı vardır 

Graphql sorgusunda aslında mantık temel olarak baz alırsak çok basittir.Graphqlde sorgu ile sonuç birbirine cok benzerdir bu graphql için önemlidir çünkü herzaman beklediğinizi alırsınız ve sunucu tam olarak hangi alanları istediğinizi bilir mesela burdaki kodda ise sadece yeniKullanici adındaki mutation sorgusu ile sadece id ve isim bilgisi döner.

Graphql de gerçeklestirebileceğimiz 2 işlem vardır : sorgular ve mutasyonlar(mutations). Verileri getirmek için sorguları kullanırken sunucu tarafı verilerini değiştirmek için yani veri ekleme,veri silme veya güncelleme için mutationları kullanırız örnek olarak bu kodda hayali bir mutation sorgusu vardır yeniKullanici adındaki mutation sorgusu ile var olan veriyi silebilir,güncelleyebilir veya var olan veriye ekleme yapabiliriz.

Peki neden graphql kullanmalıyız faydalarından kısaca bahsetmek gerekirse:

-Graphql,küçük miktarlarda ayrık verileri içeren birden fazla uç noktayı korumak yerine,karmaşık sorgulara giren ve yalnızca sorgu için gereken kadar bilgi çıkaran tek bir uç nokta sağlar.

-Graphql veri getirmede etkilidir bir istekte bulunduğumuzda graphql sunucu sorgular ve sorgumuza özel bir yanıt döndürür.Yani verilerin gereğinden fazla veya az getirilmesine yer yoktur.

-Graphql çok yönlüdür yani graphql’in API’sinin arkasına birden fazla sistemi entegre edebiliriz.

Bu dil,RESTful API’ların bazı sınırlamalarını aşarak istemcilerin ihtiyaç duydukları verileri daha etkili bir şekilde almasına imkan verir.

burada graphql ile rest ‘i karşılaştırırsak eğer 

REST ile gerekli verileri almak için farklı uç noktalara isteklerde bulunmmamız gerekir ve istediğimizden daha fazla bilgi alabiliriz oysaki  graphql ile istediğimiz bilgiyi tek sorguda alabiliriz.

REST’te veriler doğrusal bir endpoint listesi olarak tanımlanır graphql’de ise bu ilişkileri olan bir şemadır.

Burada şema kavramı gecmişken ve  kodda bu kavram varken bazen graphql sorgusu ile graphql şeması aynı kavramlar gibi anlaşılabiliyor bu yüzden iki kavramı ve farkını açıklayalım : Graphql sorgusu ile graphql seması arasındaki temel fark: graphql sorgusu veri almak  veya değişiklik yapmak için kullanılan sorgu dilini temsil eder 

graphql seması ise veri modelini ve bu modele erisim kurallarını tanımlayan bir yapıyı ifade eder mesela bu kodda graphql mutaation sorgusu  değisiklik  için vardır graphql seması ise GraphQL servisinin sahip olduğu şema (schema) URL'sini belirtir.burada hayali bir graphqlden bahsettiğimşz için Örnek olarak, **`https://örnek şema URL'si`** şeklinde bir URL kullandım. Gerçekte, bu URL, GraphQL servisinin sunduğu şemayı tanımlayan bir endpoint olacaktır.

bu koddaki graphql işlemini anlatmak gerekirse bu kodda hayali bir graphql şeması kulalnılmıstır. burda kullanılan grapql şemasında ilk önce grahql semasını bir url olarak belirttik(kodda örnek url yazıyor cunku hayali bir graphql işlemi gerceklestiriyoruz)bu url graphql sorgularının gönderilecegi hedef servisi temsil eder.sonra ise graphql mutation sorgularını tanımladık örnek şemanın url’sine göndermek için.

bu sorgu YeniKullanici adında bir mutationu temsil eder ve id bilgisini alarak isim bilgisini döndürür.sonra sorguda kullanılacak olan “graphqlBilgi” değiskeni graphql mutationu’na gecirilecek olan bilgiyi temsil eder.Ve ve ensonda ise kullanıcı herhangi bir butona tıklayıp onu aktif hale getirdiğinde konsolda graphql mutation sorgusu,değişkenler ve sema adresi gibi bilgileri konsola yazdırır.
