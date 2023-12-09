import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButonKontrolPaneli extends JFrame {//burada ButonKontrolPaneli jframe classını extends eder.
    private final int SATIR = 4;//burada 4 satırlık ve 4 sutunluk değiştirilmeyecek(final anahtar kelimesi) bir matris olusturdum.
    private final int SUTUN = 4;
    private ButonOzellik[][] butonlar;

    public ButonKontrolPaneli() {
        super("Buton Kontrol Paneli");//burada super anahtar kavramını kullanarak pencerenin baslıgını belirttik.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//bu method ile pencere kapatıldığında programın sonlanması sağlanır
        setLayout(new GridLayout(SATIR, SUTUN));//burada butonları grid düzenine göre yukarıda SATIR VE SUTUN  değişkenlerine atadıgımız değeri verdik
        //bu sayede 4*4 düzeninde bir grid oluşturduk.
        butonlar = new ButonOzellik[SATIR][SUTUN];


        for (int satir = 0; satir < SATIR; satir++) {
            //// SATIR ve SUTUN sayısı kadar ButonOzellik nesnesi oluşturup  pencereye ekledik.
            for (int sutun = 0; sutun < SUTUN; sutun++) {
                butonlar[satir][sutun] = new ButonOzellik("Buton " + (satir * SUTUN + sutun + 1));
                add(butonlar[satir][sutun]);
            }
        }

        setSize(500, 500);//pencerenin boyutunu belirttik.
        setLocationRelativeTo(null);

        setVisible(true);//pencereyi görünür hale getirdik.
    }


    private class ButonOzellik extends JButton {//burada ButonOzellik sınıfı JButton sınıfını extends ederek onun özelliklerine erişebilir hale geldi.
        private boolean aktifDurum = false;
        //burada butonun aktif olup olmadığını aktifDurum değiskeninde tutuyoruz.


        private String graphqlBilgi = "bilgi : id ve isim.";//burada hayali graphql şemasına(kullanıcı isterse bunu buradan degistirebilir) gönderilecek bilgiyi belirttik.

        private Color aktifRenk = Color.GREEN;
        private Color pasifRenk = Color.RED;

        private Icon aktifIcon = new ImageIcon("resim/resim1/aktif.png");
        private Icon pasifIcon = new ImageIcon("resim/resim1/pasif.png");
        //burada aktif veya pasif olursa hangi görseller çıkacak onları belirttik.

        public ButonOzellik(String metin) {
            super(metin);

            //başlangıcta durumu pasif olarak ayarladık.
            setPasifDurum();

            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //burada butona tıklandığında butonuaktiflestir metodu calısacak ve buton aktif hale gelecek
                    butonuAktiflestir();
                    executeGraphQLMutation();
                    // ve butona basıldığında hayali  GraphQL mutation'i calıstırır ve konsolda yazdırır
                }
            });
        }


        private void butonuAktiflestir() {
            for (int satir = 0; satir < SATIR; satir++) {
                for (int sutun = 0; sutun < SUTUN; sutun++) {
                    butonlar[satir][sutun].setPasifDurum();
                }
            }
            aktifDurum = true;

            // Aktif durumda renk ve ikonları ayarladık.
            setForeground(aktifRenk);
            setIcon(aktifIcon);
        }

        // Pasif durumda renk ve ikonları ayarladık.
        private void setPasifDurum() {
            aktifDurum = false;
            setForeground(pasifRenk);
            setIcon(pasifIcon);
        }


        private void executeGraphQLMutation() {
            String graphqlSchema = "https://örnek şema URL'si";//burada hayali graphql şemasının url'sini belirttik.
            String mutationQuery = "mutation YeniKullanici(bilgi: id) { YeniKullanici(bilgi: isim) { id, isim } }";
            //burada graphql mutation sorgusunu belirttik. burada her bir butona tıklandıgında yeni bir kullanıcı eklemek için id ve isim degerlerini döndürür
            String variables = "{ \"bilgi\": \"" + graphqlBilgi + "\" }";

            //burada ise mutation sorgusunu,graphql değişkenleri ve graphql semasının url'sini konsola yazar.
            System.out.println("GraphQL Mutation Gönderiliyor: " + mutationQuery);
            System.out.println("GraphQL Değişkenleri: " + variables);
            System.out.println("Şema Adresi: " + graphqlSchema);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButonKontrolPaneli();
            }
        });
    }
}
