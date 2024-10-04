package com.callcenter.dicodingpemula

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var articleAdapter: ArticleAdapter
    private val articles = mutableListOf<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.recyclerView)

        // Initialize default articles with shorter overview text
        articles.addAll(listOf(
            Article("Bayam", "Bayam (Amaranthus) adalah tumbuhan yang biasa ditanam untuk dikonsumsi daunnya sebagai sayuran hijau. Tumbuhan ini berasal dari Amerika tropik namun sekarang tersebar ke seluruh dunia. Tumbuhan ini dikenal sebagai sayuran sumber zat besi yang penting bagi tubuh.\n" +
                    "\n" +
                    "Pemerian botani\n" +
                    "Terna semusim yang menyukai iklim hangat dan cahaya kuat. Bayam relatif tahan terhadap pencahayaan langsung karena merupakan tumbuhan C4. Batang berair dan kurang berkayu. Daun bertangkai, berbentuk bulat telur, lemas, berwarna hijau, merah, atau hijau keputihan. Bunga tersusun majemuk tipe tukal yang rapat, bagian bawah duduk di ketiak, bagian atas berkumpul menjadi karangan bunga di ujung tangkai dan ketiak percabangan. Bijinya berwarna hitam, kecil, dan keras.\n" +
                    "\n" +
                    "Penggunaan\n" +
                    "\n" +
                    "Tanaman Bayam\n" +
                    "Bayam sebagai sayur hanya umum dikenal di Asia Timur dan Asia Tenggara, sehingga disebut dalam bahasa Inggris sebagai Chinese amaranth. Di Indonesia dan Malaysia, bayam sering disalahartikan menjadi \"spinach\" dalam bahasa Inggris (mungkin sebagai akibat penerjemahan yang dalam film kartun Popeye), padahal nama itu mengacu ke jenis sayuran daun lain - lihat Bayam (Spinacia).\n" +
                    "\n" +
                    "Di tingkat konsumen, dikenal dua macam bayam sayur: bayam petik dan bayam cabut. Bayam petik berdaun lebar dan tumbuh tegak besar (hingga dua meter) dan daun mudanya dimakan terutama sebagai lalapan (misalnya pada pecel, gado-gado), urap, serta digoreng setelah dibalur tepung. Daun bayam cabut berukuran lebih kecil dan ditanam untuk waktu singkat (paling lama 25 hari), lebih cocok untuk dibuat sup encer seperti sayur bayam dan sayur bobor. Bayam petik biasanya berasal dari jenis A. hybridus (bayam kakap) dan bayam cabut terutama diambil dari A. tricolor. Jenis-jenis lainnya yang juga dimanfaatkan adalah A. spinosus (bayam duri) dan A. blitum (bayam kotok).\n" +
                    "\n" +
                    "Kandungan besi pada bayam relatif lebih tinggi daripada sayuran daun lain (besi merupakan penyusun sitokrom, protein yang terlibat dalam fotosintesis) sehingga berguna bagi penderita anemia.\n" +
                    "\n" +
                    "Beberapa kultivar A. tricolor memiliki daun berwarna merah atau putih dan dipakai sebagai tanaman hias, meskipun dapat pula disayur. Jenis tanaman hias lainnya adalah A. caudatus karena tandan bunganya berwarna merah panjang menggantung seperti ekor. Di tempat asalnya, bayam dimanfaatkan bijinya (bayam biji) sebagai sumber karbohidrat. Biji ini sekarang juga populer sebagai makanan diet karena tidak menyebabkan kegemukan.\n" +
                    "\n" +
                    "Akar tunggang bayam juga dimanfaatkan sebagai obat. Kebanyakan digunakan oleh masyarakat sebagai salah satu alternatif memenuhi kebutuhan hidup.\n" +
                    "\n" +
                    "Jenis Bayam di Indonesia\n" +
                    "Terdapat tiga jenis bayam di Indonesia yaitu:[1]\n" +
                    "\n" +
                    "Amaranthus Dubius ; biasa disebut juga dengan bayam petik. Ciri-ciri tanaman bayam jenis ini adalah pertumbuhannya lebih tegak, berdaun agak lebar dengan warna hijau tua dan ada juga yang berwarna kemerahan. Biasanya tanaman ini banyak dipelihara di halaman rumah.\n" +
                    "Amaranthus Tricolor ; atau lebih dikenal dengan bayam cabut. Batangnya berwarna merah dan ada pula yang berwarna hijau keputih-putihan.\n" +
                    "Amaranthus Cruentus ; Jenis tumbuhan bayam satu ini dapat ditanam sebagai bayam cabut maupun bayam petik.  Ciri dari tanaman bayam satu ini adalah tumbuh tegak, berdaun besar, berwarna hijau keabu-abuan. Tanaman ini bisa mulai dipanen secara cabutan pada usia 3 minggu.\n" +
                    "Manfaat Bayam untuk Kesehatan[1]\n" +
                    "Baik Untuk Penglihatan\n" +
                    "Bayam mengandung vitamin A beta karoten, lutein dan zeaxanthin. Kandungan lutein dan zeaxhantin mampu membantu mata untuk menyaring cahaya gelombang pendek yang berbahaya serta mencegah kerusakan pada makula atau pusat retina mata.\n" +
                    "\n" +
                    "Memperkuat Otot\n" +
                    "Manfaat dari sayur bayam hijau adalah dapat memperkuat otot karena faktor koenzim Q-10 (C0-Q10) yang bertugas sebagai antioksidan sekaligus membantu memompa darah ke seluruh tubuh. Darah yang dipompa ke seluruh bagian tubuh ini dibantu juga oleh otot jantung yang sudah lebih kuat. Kandungan koenzim dalam bayam juga mampu menurunkan risiko gagal jantung dan jantung koroner.\n" +
                    "\n" +
                    "Menjaga tekanan darah\n" +
                    "Kandungan kalium pada bayam mampu melemaskan dinding pembuluh darah sehingga menurunkan tekanan darah dan melindungi dari kram otot. Selain itu risiko terkena hipertensi pun bisa berkurang karena kandungan folat yang berfungsi menenangkan pembuluh darah. Disamping folat, ada juga kandungan nitrat alami yaitu senyawa yang berfungsi untuk membuka pembuluh darah dalam meningkatkan aliran darah dan meringankan beban kerja pada jantung.\n" +
                    "\n" +
                    "Membantu Mencegah Kanker\n" +
                    "Manfaat lainnya dari bayam yang belum banyak diketahui ialah ternyata bayam mampu membantu mencegah kanker dan membantu memperlambat pertumbuhan sel tumor. Bayam mengandung beta karoten dan vitamin C yang aktif berperan dalam perlindungan terhadap perkembangan sel kanker. Selain beta karoten dan vitamin C, zat yang mampu mencegah kanker adalah klorofil. Klorofil ini efektif sebagai penahan efek karsinogenik dari amina heterosilik.", "android.resource://com.callcenter.dicodingpemula/drawable/bayam"),
            Article("Arugula", "Arugula (Bahasa Inggris Amerika) atau daun roket (Bahasa Inggris Persemakmuran) (Eruca vesicaria; syns. Eruca sativa Mill., E. vesicaria subsp. sativa (Miller) Thell., Brassica eruca L.) adalah tanaman tahunan yang dapat dimakan dalam keluarga Brassicaceae yang digunakan sebagai sayuran daun karena rasanya yang segar, asam, pahit, dan pedas. Nama umum lainnya termasuk roket taman atau daun rudal taman (di Inggris, Australia, Afrika Selatan, Irlandia, dan Selandia Baru), dan eruca. Ini juga disebut \"ruchetta\", \"rucola\", \"rucoli\", \"rugula\", \"colewort\", dan \"roquette\". E. vesicaria, yang populer sebagai sayuran salad, adalah spesies Eruca yang berasal dari wilayah Mediterania.\n" +
                    "\n" +
                    "Kadang-kadang dikelirukan dengan Diplotaxis tenuifolia, yang dikenal sebagai \"roket dinding abadi\", tanaman lain dari keluarga Brassicaceae yang digunakan dengan cara yang sama.\n" +
                    "\n" +
                    "\n" +
                    "Daun arugula\n" +
                    "Eruca vesicaria adalah tanaman tahunan yang tumbuh setinggi 20 hingga 100 cm (8 hingga 40 inci). Daun menyirip berlengkung dengan empat sampai sepuluh, kecil,daun lateral dan daun terminal besar. Bunganya berdiameter 2 hingga 4 cm (3⁄4 hingga 1+1⁄2 inci), tersusun dalam bunga majemuk, dengan struktur bunga khas Brassicaceae. Kelopaknya berwarna putih krem dengan urat ungu, dan benang sari berwarna kuning. Buahnya adalah siliqua (polong) dengan panjang 12 hingga 25 mm (1/2 hingga 1 inci) dengan paruh apikal, berisi beberapa biji (yang dapat dimakan). Spesies tersebut memiliki jumlah kromosom 2n = 22.\n" +
                    "\n" +
                    "Etimologi\n" +
                    "Sativa, dari salah satu nama lain dari penyebutan tumbuhan, berasal dari satum, artinya \"menyemai\", menandakan bahwa benih tumbuhan itu disemai di kebun. Eruca sativa berbeda dari E. vesicaria dalam memiliki masa kelopak bunga tumbuhan peluruh yang lebih awal. Beberapa ahli botani menganggapnya sebagai subspesies E. vesicaria sebagai E. v. subsp. sativa. Yang lain lagi tidak membedakan antara keduanya.\n" +
                    "\n" +
                    "Nama umum bahasa Inggris \"roket\" berasal dari kata Italia ruchetta atau rucola, kata kecil dari kata Latin eruca, yang pernah menunjuk tanaman tertentu dalam keluarga Brassicaceae (mungkin sejenis kubis). \"Arugula\" , nama umum yang sekarang tersebar luas di Amerika Serikat dan Kanada, memasuki bahasa Inggris Amerika dari dialek Italia yang tidak baku. Kata standar Italia adalah rucola. The Oxford English Dictionary memberi tanggal kemunculan pertama \"arugula\" dalam bahasa Inggris Amerika pada artikel tahun 1960 di The New York Times oleh editor makanan dan penulis buku masak yang produktif, Craig Claiborne.\n Nutrisi\n Arugula mentah terdiri dari 92% air, 4% karbohidrat, dan 2,5% protein, dan mengandung sedikit lemak. Meskipun penyajian referensi 100 g (3+1⁄2 oz) hanya menyediakan 105 kJ (25 kkal) energi makanan, arugula memiliki nilai gizi yang tinggi, terutama saat segar, beku, dikukus, atau direbus dengan cepat. Ini adalah sumber yang kaya (20% atau lebih dari Nilai Harian, DV) folat dan vitamin K. Arugula juga merupakan sumber yang baik (10–19% DV) vitamin A, vitamin C, dan mineral makanan kalsium, magnesium, dan mangan.", "android.resource://com.callcenter.dicodingpemula/drawable/arugula"),
            Article("Bit merah", "Bit merah (bahasa Inggris: beetroot) dimasukkan ke dalam kelas Beta vulgaris dan subspecies group vulgaris Conditiva. Karena warnanya yang merah keunguan yang kuat, selain untuk makanan, juga digunakan sebagai pewarna makanan dan pengobatan.\n Penggunaan\n Umbi yang berwarna merah keunguan dapat dimakan secara langsung sebagai bagian dari salad yang dicampur dengan sayuran lain, atau juga direbus dan dipanggang.\n" +
                    "\n" +
                    "Dalam skala industri umbinya direbus dan disterilisasi seperti dengan cuka. Di Eropa Timur bit merah disajikan sebagai sup dan merupakan sajian yang populer. Bit merah dapat juga digunakan untuk membuat anggur atau wine. Penggunaan lain\n" +
                    "Betanin, yang didapat dari akar, digunakan dalam industri sebagai pewarna merah, untuk meningkatkan warna dan rasa di dalam pasta tomat, saus, pencuci mulut, selai, es krim, pemanis, sereal, dan lain sebagainya.\n" +
                    "\n" +
                    "Sejarah penggunaan\n" +
                    "Pada abad pertengahan, bit merah digunakan untuk menyembuhkan beberapa penyakit, terutama penyakit yang berhubungan dengan pencernaan dan darah. Bartolomeo Platina menyarankan untuk mencampur bit merah dengan bawang putih untuk menghilangkan efek napas bau bawang putih.[1] Nutrisi\n Per 100 gram penyajian tersedia 43 kalori, bit merah adalah sumber yang istimewa dari (20% of the Daily Value, DV) of folate dan sumber yang bagus (14% DV) dari mangan, dengan nutrisi lain dalam jumlah kecil (lihat tabel di samping).[2]", "android.resource://com.callcenter.dicodingpemula/drawable/bit_merah"),
            Article("Kubis tiongkok", "Kubis tiongkok (Brassica rapa, subspesies pekinensis dan chinensis) dapat merujuk kepada dua kelompok sayuran dedaunan Tiongkok yang sering digunakan dalam masakan Tionghoa: Kelompok Pekinensis (kubis napa) dan Kelompok Chinensis (pakcoy).\n" +
                    "\n" +
                    "Sayur-sayuran tersebut merupakan kultivar varian atau subspesies dari lobak dan masuk pada genus yang sama dengan Brassica oleracea yang mencakup kultivar kubis, brokoli, dan kubis bunga. Keduanya memiliki beberapa variasi dalam nama, penyebutan, dan klasifikasi saintifik, khususnya varietas pakcoy (B. rapa chinensis).\n" +
                    "\n" +
                    "Sejarah\n" +
                    "Kubis tiongkok biasanya ditanam di wilayah Delta Sungai Yangtze. Ahli naturalis dari Dinasti Ming, Li Shizhen, mempopulerkan sayuran tersebut dengan mengirimkan perhatian pada kualitas pengobatannya.", "android.resource://com.callcenter.dicodingpemula/drawable/kubis_tiongkok"),
            Article("Brokoli", "Brokoli (Brassica oleracea L. Kelompok Italica) adalah tanaman yang sering dibudidayakan sebagai sayur. Brokoli adalah kultivar dari spesies yang sama dengan kubis dan kembang kol, yaitu Brassica oleracea.[3] Brokoli berasal dari daerah Laut Tengah dan sudah sejak masa Yunani Kuno dibudidayakan. Sayuran ini masuk ke Indonesia belum lama (sekitar 1970-an) dan kini cukup populer sebagai bahan pangan.\n" +
                    "\n" +
                    "Bagian brokoli yang dimakan adalah kepala bunga berwarna hijau yang tersusun rapat seperti cabang pohon dengan batang tebal. Sebagian besar kepala bunga tersebut dikelilingi dedaunan. Brokoli paling mirip dengan kembang kol, namun brokoli berwarna hijau, sedangkan kembang kol putih.\n" +
                    "\n" +
                    "Cara menanam brokoli adalah disemai setelah tumbuh 3-4 daun sejati kemudian ditanam (dijadikan bibit terlebih dahulu). Masa panen adalah 55- 100 hari (tergantung varietas). Brokoli merupakan tanaman yang hidup pada cuaca dingin.\n" +
                    "\n" +
                    "\n" +
                    "Tanaman Brokoli\n" +
                    "Sebagai makanan, brokoli biasanya direbus atau dikukus, atau dapat pula dimakan mentah. Cara terbaik dalam mengolah brokoli adalah dengan cara dikukus. Hal ini bertujuan agar segala vitamin dan nutrisi penting di dalamnya tidak hilang selama proses pemasakan. Merebus brokoli akan menghilangkan sekitar 50 % asam folat yang terkandung di dalamnya. Oleh karena itu, jika ingin mengolah brokoli dengan cara direbus, sebaiknya brokoli tidak direbus terlalu lama, kira-kira tidak lebih dari 5 menit. Brokoli mengandung vitamin C dan serat makanan dalam jumlah banyak. Brokoli juga mengandung senyawa glukorafanin, yang merupakan bentuk alami senyawa antikanker sulforafana (sulforaphane). Selain itu, brokoli mengandung senyawaan isotiosianat yang, sebagaimana sulforafana, ditengarai memiliki aktivitas antikanker.", "android.resource://com.callcenter.dicodingpemula/drawable/brokoli"),
            Article("Kubis brussel", "Kubis brussel adalah sebuah anggota dari Grup Gemmifera dari kubis (Brassica oleracea), yang dibesarkan untuk diambil kuncupnya yang bisa dimakan.\n" +
                    "\n" +
                    "Sayuran hijau berdaun tersebut biasanya berukuran 2,5–4 cm (0,98–1,6 in) dalam diameter dan terlihat seperti miniatur kubis. Kubis brussel telah lama populer di Brussel, Belgia, dan bermula dan mendapatkan namanya di sana.", "android.resource://com.callcenter.dicodingpemula/drawable/kubis_brussel"),
            Article("Paprika", "Paprika (Capsicum annuum L.) adalah tumbuhan penghasil buah yang berasa manis dan sedikit pedas dari suku terong-terongan atau Solanaceae). Buahnya yang berwarna hijau, kuning, merah, atau ungu sering digunakan sebagai campuran salad. Dalam pengertian internasional, paprika dipakai untuk menyatakan hampir semua varietas Capsicum annuum. Nama-nama tertentu, seperti pepperoni, diberikan untuk paprika dengan ciri penampilan, penggunaan, atau rasa yang khas.\n" +
                    "\n" +
                    "Asal\n" +
                    "Tanaman ini berasal dari Amerika Selatan tepatnya di Meksiko, Tanaman ini dibawa ke Eropa pada abad ke 16 oleh Christoper Columbus.\n" +
                    "\n" +
                    "Tanaman\n" +
                    "\n" +
                    "Paprika\n" +
                    "Tanaman paprika umumnya tumbuh setinggi 50 cm - 150 cm. Tanaman ini dapat cocok di berbagai iklim dan dapat tumbuh di berbagai belahan dunia. Untuk budidaya dengan hidroponik tinggi paprikabisa mencapai 3- 4m. Ditanam Didaerah pegunungan dengan suhu minstra.", "android.resource://com.callcenter.dicodingpemula/drawable/paprika"),
            Article("Waluh", "Waluh (Cucurbita) mencakup sekelompok tumbuhan merambat anggota suku labu-labuan (Cucurbitaceae) penghasil buah konsumsi berukuran besar bernama sama. Tumbuhan ini berasal dari benua Amerika, tetapi sekarang menyebar di banyak tempat yang memiliki iklim hangat.\n" +
                    "\n" +
                    "Waluh mencakup beberapa spesies anggota genus Cucurbita, yaitu C. argyrosperma, C. maxima, C. moschata, dan C. pepo. Dalam beberapa pengertian setempat di Indonesia, waluh disebut sebagai \"labu\" saja, meskipun sebenarnya labu mencakup kelompok tanaman yang lebih luas, seperti labu air, labu ular, labu siam, dan beligo. Waluh dibedakan dari labu lainnya karena buahnya dimakan yang telah masak (biasanya berwarna jingga), berukuran relatif besar, berbentuk bulat sampai bulat telur dengan lekukan daun buah yang tampak jelas, dan berkulit keras. Pengertian waluh agak bermiripan dengan gabungan pumpkin dan beberapa squash dalam bahasa Inggris.\n" +
                    "\n" +
                    "Buah waluh berwarna oranye karena mengandung beta-karotena (salah satu provitamin A dan juga sebagai antioksidan). Jika dipotong, buah ini mempunyai penampang yang mirip bintang, berbiji besar dan berwarna cokelat atau putih. Daging buahnya renyah, rasanya manis, dan sedikit asam. Daun muda waluh juga dapat dibuat sebagai sayur.\n" +
                    "\n" +
                    "Peristilahan dan Ciri Khas\n" +
                    "\n" +
                    "Bunga waluh yang sedang mekar\n" +
                    "Waluh didatangkan ke Indonesia dari benua Amerika diperkirakan pada abad ke-19 oleh pemerintah kolonial, meskipun ada kemungkinan sebelumnya juga sudah diperkenalkan secara perorangan. Jenis yang tumbuh di Indonesia kebanyakan adalah C. moschata dan C. pepo. Jenis-jenis ini biasanya dibedakan dari buahnya.\n" +
                    "\n" +
                    "Cucurbita pepo\n" +
                    "Buah C. pepo biasanya relatif kecil dibandingkan dengan lainnya, dengan tangkai buah agak membesar di bagian perbatasan dengan buah, agak bersudut (berjumlah lima), dan tidak \"tenggelam\" ke dalam buah. Warna buahnya dapat hijau atau kuning, tidak selalu jingga. Zucchini termasuk dalam C. pepo dan baru diperkenalkan belakangan ke Indonesia, pada tahun 1980-an sebagai sayuran eksotik. Di Amerika Serikat, C. pepo dianggap sebagai pumpkin sejati dan mencakup:\n" +
                    "\n" +
                    "Cucurbita moschata\n" +
                    "Buah C. moschata berukuran besar, keras kulitnya, cenderung berbentuk lonjong. Daging buahnya lunak dengan rasa mulai dari tawar sampai manis. Tangkai buah keras, bersudut, membesar di bagian dekat buah, dan \"tenggelam\" ke dalam buah. C. moschata mencakup kebanyakan waluh yang dikenal orang.\n" +
                    "\n" +
                    "Cucurbita maxima\n" +
                    "C. maxima mencakup banyak waluh berukuran besar sampai raksasa. Meskipun demikian, tumbuhan ini relatif kurang tahan kering dan panas dibandingkan jenis waluh lainnya. Batangnya lunak dan tangkai buahnya tidak membentuk sudut, tidak membesar di bagian dekat buah, dan sangat tenggelam.", "android.resource://com.callcenter.dicodingpemula/drawable/waluh"),
            Article("Tomat", "Tomat atau rangam (Solanum lycopersicum) adalah tumbuhan dari keluarga Terong-terongan, tumbuhan asli Amerika Tengah dan Selatan, dari Meksiko sampai Peru. Tomat merupakan tumbuhan siklus hidup singkat, dapat tumbuh setinggi 1 sampai 3 meter. Tumbuhan ini memiliki buah berwarna hijau, kuning, dan merah yang biasa dipakai sebagai sayur dalam masakan atau dimakan secara langsung tanpa diproses. Tomat memiliki batang dan daun yang tidak dapat dikonsumsi karena masih sekeluarga dengan kentang dan terung yang mengadung alkaloid.\n" +
                    "\n" +
                    "Cara menanam tanaman tomat adalah disemai lebih dahulu, setelah tumbuh 4 daun sejati kemudian ditanam (dijadikan bibit terlebih dahulu). Panen dimulai usia 9 minggu setelah tanam selanjutnya setiap 5 hari.\n" +
                    "\n" +
                    "\n" +
                    "Tomat\n" +
                    "Kata \"tomat\" berasal dari kata dalam bahasa Nahuatl, tomatl (diucapkan: /tɔ.matɬ/). Salah satu produk buatan hasil olahan tomat yang digemari, yaitu saus tomat. Hampir di berbagai negara memproduksi saus tomat. Saus tomat sendiri banyak dimanfaatkan untuk bumbu tambahan dalam mengolah berbagai masakan. Saus tomat juga dapat disajikan langsung bersama burger, sandwich, dan banyak lagi yang lainnya. Selain untuk tambahan dalam mengolah makanan, tomat juga dapat diolah menjadi jus tomat.\n" +
                    "\n" +
                    "Sejarah\n" +
                    "Menurut tulisan karangan Andrew F. Smith \"The Tomato in America\", tomat kemungkinan berasal dari daratan tinggi pantai barat Amerika Selatan. Setelah Spanyol menguasai Amerika Selatan, mereka menyebarkan tanaman tomat ke koloni-koloni mereka di Karibia. Spanyol juga kemudian membawa tomat ke Filipina, yang menjadi titik awal penyebaran ke daerah lainnya di seluruh benua Asia. Spanyol juga membawa tomat ke Eropa. Tanaman tomat tumbuh dengan mudah di wilayah beriklim tropis Mediterania.\n" +
                    "\n" +
                    "Kandungan\n" +
                    "Tomat mengandung antioksidan berupa likopen yang dapat membantu memerangi efek radikal bebas penyebab kanker. Tomat juga memiliki kandungan antioksidan lain yakni polifenol, naringenin, dan asam klorogenat. Di samping itu, ternyata buah tomat rendah kalori dan lemak, tetapi kaya akan karotenoid, lutein, gula, vitamin A, vitamin C, asam folat, dan kalium[1]\n" +
                    "\n" +
                    "Macam-Macam Tomat\n" +
                    "Terdapat ratusan kultivar tomat yang dibudidayakan dan diperdagangkan. Pengelompokan hampir selalu didasarkan pada penampilan atau kegunaan buahnya.\n" +
                    "\n" +
                    "Berdasarkan penampilan\n" +
                    "\n" +
                    "Tomat muda yang masih hijau\n" +
                    "Terdapat buah tomat dengan kisaran warna dari hijau ketika masak, kuning, jingga, merah, ungu (hitam), serta belang-belang.\n" +
                    "\n" +
                    "Dari ukuran dan bentuk,[2] tomat dikelompokkan sebagai berikut:\n" +
                    "\n" +
                    "granola yang bentuknya bulat dengan pangkal buah mendatar dan mencakup yang biasanya dikenal sebagai tomat buah (karena dapat dimakan langsung),\n" +
                    "gondol yang biasa dibuat saus dengan bentuk lonjong oval (biasanya yang ditanam di Indonesia adalah kultivar 'Gondol Hijau' dan 'Gondol Putih', dan keturunan dari kultivar impor 'Roma') dan termasuk pula tomat buah,\n" +
                    "sayur adalah tomat dengan buah biasanya padat dan dipakai untuk diolah dalam masakan\n" +
                    "ceri (tomat ranti) yang berukuran kecil dan tersusun berangkai pada tangkai buah yang panjang.\n" +
                    "Berdasarkan kegunaan\n" +
                    "Orang mengenal tomat buah, tomat sayur, serta tomat lalapan. Berdasarkan hal ini, fungsi tomat merupakan klasifikasi dari buah maupun sayuran, walaupun struktur tomat adalah struktur buah.\n" +
                    "\n" +
                    "Perkembangan pengetahuan, sekarang tomat tidak hanya sebagai pelengkap untuk makanan melainkan juga sudah dikenal luas untuk kecantikan. Manfaat tomat untuk kecantikan antara lain adalah untuk mengecilkan pori-pori dan mencerahkan kulit karena tomat kaya dengan kandungan vitamin C.", "android.resource://com.callcenter.dicodingpemula/drawable/tomat"),
            Article("Vanila", "Vanilla adalah pemberi rasa yang dihasilkan dari tanaman genus Vanilla, terutama Vanilla planifolia. Kata \"vanilla\"diturunkan dari bahasa Spanyol, vaina yang memiliki arti \"polong\", karena bentuk buah vanila adalah polong.[1] Tumbuhan ini pertama kali dibudidayakan oleh masyarakat Aztec Mesoamerika yang menyebut tanaman ini dengan nama tlilxochitl. Hernán Cortés membawa vanilla bersama dengan cokelat ke Eropa pasca penjelajahannya di benua Amerika. Vanilla oleh masyarakat Mesoamerika digunakan sebagai salah satu bumbu utama bagi minuman cokelat.[2]\n" +
                    "\n" +
                    "Usaha awal untuk membudidayakan vanilla tergolong sulit karena vanilla membutuhkan lebah Melipona yang hanya berada di Amerika Tengah. Seorang pakar botani asal Belgia yang pertama kali menemukan hal ini dan berusaha mencari cara untuk melakukan penyerbukan vanilla secara buatan, namun usahanya tidak memuaskan.[3] Metode penyerbukan buatan yang sederhana justru ditemukan oleh seorang budak di pulau Réunion, Edmond Albius, pada tahun 1841 dan menyebabkan vanilla mulai dibudidayakan secara luas.[4] Tanaman vanilla sendiri masuk ke Indonesia mulai pada tahun 1819 dibawa oleh ahli botani berkebangsaan Belanda bernama Marchal dan pertama kali ditanam di Kebun Raya Bogor.[5]\n" +
                    "\n" +
                    "Ada tiga spesies utama vanilla yang saat ini dikembangkan, dan semuanya merupakan tumbuhan yang dibawa dari Amerika Tengah.[6] Vanilla planifolia dibudidayakan di Madagaskar, Réunion, dan kawasan tropis lainnya di sekitar Samudera Hindia; Vanilla tahitensis, dibudidayakan di Pasifik Selatan, dan Vanilla pompona dibudidayakan di Samudra Hindia barat, Amerika Tengah, dan Amerika Latin.[7] V. planifolia adalah yang paling banyak dibudidayakan di dunia.[8][9] Vanilla planifolia menghasilkan ekstrak vanilla terbanyak dibandingkan kedua spesies tersebut.[10]\n" +
                    "\n" +
                    "Vanilla merupakan salah satu jenis rempah yang paling penting dan mahal di dunia setelah saffron dan cardamom karena vanilla membutuhkan banyak tenaga kerja untuk mendapatkannya.[11][12][13] Di Amerika Selatan, tumbuhan Leptotes bicolor digunakan sebagai pengganti vanilla. Vanila banyak dimanfaatkan polongnya untuk rempah dan juga untuk aromanya. Tanaman ini banyak dimanfaatkan pada industri makanan (60%), kosmetik (33%), dan sebagai bahan aromaterapi (7%). Secara tradisional tanaman vanila digunakan untuk pengobatan beberapa penyakit seperti dysmenorrhea, demam, hysteria, dyspepsia, pencegahan karies gigi, pengobatan sakit gigi, batuk, dan juga sakit perut. Tanaman ini dikenal memiliki efek antispasmodic, antiinflamasi, dan analgesik.[14][15]\n" +
                    "\n" +
                    "Biologi\n" +
                    "Seperti kebanyakan anggrek lainnya, vanila tumbuh dengan memerlukan tanaman lain sebagai sarana penjalaran tanaman atau pelindung dari sinar matahari langsung. Vanila tumbuh optimum pada rasio bayangan sekitar 50-60%. Tanaman pelindung ini harus cepat rimbun, mudah dipangkas, daunnya tidak mudah gugur, tahan hama, dan sistem perakarannya dalam seperti tanaman lamtoro atau dadap.[5][13] Di Reunion, tumbuhan ini dipelihara bersama dengan pemeliharaan hutan (wanatani). Sebetulnya vanilla mampu melakukan penyerbukan sendiri atau dibantu oleh lebah dan burung kolibri. Namun penyerbukan ini sulit untuk dilakukan karena ukuran serbuk sari vanila yang besar sehingga biasanya penyerbukannya dilakukan oleh manusia dan sangat memakan tenaga.[14] Tumbuhan ini hanya berbunga selama sehari, sehingga buruh perkebunan harus memeriksa setiap hari untuk melakukan penyerbukan buatan. Selain itu proses panen dan pengemasan juga masih dilakukan oleh tenaga manusia sehingga sangat tidak efisien.[13] Inilah yang menjadikan perkebunan vanilla padat karya.\n" +
                    "\n" +
                    "Vanila dapat tumbuh pada ketinggian 0-1500 mdpl. Di daerah asalnya, vanila tumbuh di hutan hujan tropis dengan curah hujan sekitar 1500–3000 mm/tahun dengan suhu sekitar 15-30oC dan kelembaban yang tinggi. Faktor curah hujan dan suhu menjadi faktor penentu bagi pertumbuhan vanila. Vanila harus ditanami pada tempat yang memiliki bulan basah selama 7-8 bulan setahun dengan bulan kering sekitar 2-3 bulan setiap tahunnya. Vanila akan mengalami kematian jika terjadi bulan kering 4 bulan berturut-turut dalam setahun tanpa ada penyiraman[16] Tanah sebagai medium tumbuh vanila harus cukup subur dengan unsur hara yang tinggi dan air yang tidak boleh menggenang. Pada kondisi tanah berlempung perlu ditambahkan pasir agar kelembaban yang berlebih dapat dikurangi. Penambahan pupuk organik dan anorganik dapat dilakukan agar vanila tumbuh dengan subur, membuat tanah menjadi gembur, dan mempertahankan kelembaban tanah.[5][13]\n" +
                    "\n" +
                    "Buahnya merupakan kapsul yang memanjang yang ketika telah masak, akan membuka bagian ujungnya, mengering, dan mengeluarkan aroma yang khas.\n" +
                    "\n" +
                    "Biji tumbuhan ini tidak akan berkecambah tanpa bantuan fungi mikoriza anggrek. Sehingga pembudidaya tidak memperbanyak melalui biji melainkan dari secara stek.\n" +
                    "\n" +
                    "Budidaya\n" +
                    "Perbanyakan\n" +
                    "Vanilla diperbanyak dengan cara stek dan kultur jaringan. Lahan yang dibutuhkan untuk stek umumnya bervariasi, namun yang dibutuhkan setidaknya adalah dengan mengurangi penerimaan cahaya matahari hingga 50% pada tanaman stek dan dibutuhkan jarak yang cukup antar tanaman. Mulsa dan pengairan secukupnya juga diperlukan.[17] Pohon maupun tiang untuk tempat vanilla merambat harus dipersiapkan sebelumnya.\n" +
                    "\n" +
                    "Perbanyakan dengan kultur jaringan dilakukan pertama kali di Universitas Tamil Nadu, India. Perbanyakan ini dilakukan dengan mengambil sel dari auxillary bud tumbuhan vanilla.[18][19] Perbanyakan secara in vitro juga telah dilakukan melalui kultur kalus, protocorn, node batang, dan ujung akar.[20] Individu yang didapatkan dari kultur jaringan ditumbuhkan di dalam lab hingga setinggi 30 cm sebelum menjadi bibit untuk ditanam di lahan maupun rumah tanaman.[21]\n" +
                    "\n" +
                    "Panen\n" +
                    "Buah vanilla matang sekitar enam bulan setelah penyerbukan. Pemanenan harus dilakukan dengan cermat. Tanda buah sudah mulai matang adalah ujung buah vanilla yang mulai berwarna pucat kekuningan, dan setiap buah memiliki waktu kematangan yang tidak sama. Buah yang terlalu matang dapat menyebabkan buah terbelah dan bijinya keluar, sehingga hanya sedikit yang bisa dipanen. Satu pohon vanilla berusia lima tahun dapat menghasilkan antara 1.5 hingga 3 kilogram buah per tahun, dan terus meningkat hingga maksimum 6 kilogram. Jika buah yang masih hijau terlanjur dipanen, buah tersebut masih dapat dijual atau diperam terlebih dahulu untuk mendapatkan harga yang lebih baik.[17][21][22]\n" +
                    "\n" +
                    "Pascapanen\n" +
                    "\n" +
                    "Buah vanilla yang telah kering\n" +
                    "Pascapanen buah vanila meliputi pelayuan, fermentasi, pengeringan, dan pemeraman.[23][24]\n" +
                    "\n" +
                    "Pelayuan\n" +
                    "Pelayuan dilakukan untuk mematikan jaringan vegetatif buah sehingga mencegah pertumbuhan biji vanilla dari dalam buah selama pengolahan berikutnya dan penyimpanan. Metode yang digunakan bervariasi, mulai dari pendinginan hingga pemanasan (dengan air panas, perebusan, oven, atau sinar matahari). Metode yang digunakan menentukan hasil akhir dari buah vanilla.[25][26] Penjemuran untuk membunuh sel vegetatif buah dilakukan di bawah sinar matahari hingga buahnya berwarna kecoklatan. Metode ini umum dilakukan oleh masyarakat Aztec pada zaman dahulu.[25]\n" +
                    "\n" +
                    "Fermentasi\n" +
                    "Pemeraman dilakukan dengan menempatkan tumpukan buah vanilla dalam kondisi lembap dan terinsulasi, biasanya terbungkus kain. Temperatur di dalam tumpukan akan menjadi cukup tinggi antara 45 hingga 75 derajat Celcius dengan kelembaban buah yang masih tinggi, hingga 70 persen. Pada tahap ini, buah vanila sudah mengeluarkan aroma yang khas karena proses enzimatis di dalamnya.[25]\n" +
                    "\n" +
                    "Pengeringan\n" +
                    "Pengeringan mengurangi kadar air dari buah vanilla menjadi antara 25 hingga 30 persen. Kelembaban perlu dikurangi untuk mencegah tumbuhnya jamur dan bakteri serta meningkatkan rendemen senyawa aromatik di dalam buah. Pengeringan dapat dilakukan dengan penjemuran.[25]\n" +
                    "\n" +
                    "Pemeraman\n" +
                    "Pemeraman dilakukan dengan menyimpan buah di dalam wadah tertutup selama lima hingga enam bulan. Selama proses ini, aroma dan rasa dari buah vanila terus meningkat.\n" +
                    "\n" +
                    "Vanilla di Indonesia\n" +
                    "Produsen utama vanila di dunia antara lain Indonesia, Madagaskar, Meksiko, China, Kosta Rika, dan Komoro. Indonesia dan Madagaskar menguasai sekitar 90% dari pasar vanila di seluruh dunia. Pada pasar internasional, kebutuhan vanila sekitar 32.000 ton pada tahun 2005 dan kebutuhan akan senyawa vanillin meningkat sekitar 7% setiap tahun.[14] Menurut data Kementerian Pertanian tahun 2014,[27] luas area perkebunan vanila di Indonesia adalah 19.728 hektar dengan produksi sekitar 3.314 ton dan untuk Jawa Barat sendiri luas lahan perkebunan vanila mencapai 1.202 hektar dengan produksi sekitar 159 ton. Pada tahun 2012, rata-rata harga polong kering vanila pada pasar domestik adalah Rp45.108,00. Indonesia pada 2012 melakukan ekspor vanila sekitar 278 ton dengan nilai impor sebesar 5.367.000 dollar AS dan impor vanila sekitar 52 ton dengan nilai impor sebesar 408.000 dollar AS.\n" +
                    "\n" +
                    "Vanila Indonesia terkenal akan kandungan vanillin nya yang tinggi yaitu sekitar 2,75% dan diakui oleh United Nations Development Programe (UNDP) memiliki kualitas yang setara dengan Bourbon vanilla yang sudah terkenal di pasar internasional akan kualitasnya. Ini merupakan keunggulan yang harus dimanfaatkan dalam pengembangan kualitas vanila Indonesia terutama bagi komoditas khusus ekspor.[28] Pertanian vanila umumnya diusahai oleh rakyat dengan area perkebunan yang relatif kecil. Padahal pertanian rakyat merupakan roda penggerak perekonomian nasional, tidak hanya sebagai sumber penghasilan petani, namun juga sebagai bahan baku produk lanjutannya.[29] Menilik kondisi geografis Jawa Barat yang didominasi oleh dataran tinggi yang sejuk dengan curah hujan yang tinggi serta tanah yang subur, sudah seharusnya Jawa Barat menjadi produsen vanila utama di Indonesia dan potensi ini seharusnya dimanfaatkan sebaik mungkin.\n" +
                    "\n" +
                    "Senyawa Aktif pada Vanilla\n" +
                    "\n" +
                    "Struktur kimia dari vanillin\n" +
                    "Artikel utama: Vanillin\n" +
                    "Ekstrak vanilla didapatkan dari setiap bagian dari buah, dari kulit sampai bijinya. Ekstrak vanilla mengandung ratusan jenis senyawa, termasuk asam vanilat, anisaldehid, asam hidroksibenzoat, asam anisat, anisil alkohol, asetaldehida, asam asetat, furfural, asam heksanoat, 4-hidroksibenzaldehida, eugenol, metil cinnamat, asam isobutirat, asam kaproat, vitispiran, fenol, fenol eter, senyawa karbonil, ester, benzil eter, lakton, karbohidrat, lemak, dan garam mineral.[15] Namun yang memberikan aroma khas vanilla yang harum adalah senyawa vanillin (4-hidroksi-3-metoksibenzaldehid). Senyawa minor lainnya yang ikut mempengaruhi rasa yaitu piperonal. Senyawa utama yaitu vanillin dapat dibuat secara sintetis dari fenol dan larut dalam etanol.[30][31]\n" +
                    "\n" +
                    "Vanillin (4-hidroksi-3-metoksibenzaldehid) sendiri adalah senyawa aktif utama pada polong vanila dan menyusun sekitar 85% dari seluruh senyawa volatil pada polong vanila. Senyawa ini merupakan senyawa paling umum yang digunakan sebagai aroma pada es krim, soft drinks, kosmetik, dan parfum. Walaupun vanillin dapat disintesis, tetapi vanillin alami masih lebih disukai konsumen karena alasan keamanan, kepercayaan, dan dianggap lebih bebas pengawet. Senyawa vanillin dilaporkan memiliki aktivitas anticlastogenic, antimutagenik, dan antikarsinogenik dan mampu mereduksi risiko kerusakan kromosom lewat analisis sinar X dan UV. Vanillin secara efektif mampu menghambat kerusakan sel darah merah pada pasien sickle cell anemia. Selain itu vanillin juga bersifat afrodisiak, antioksidan, dan antimikroba.[15]\n" +
                    "\n" +
                    "Vanillin dapat diekstrak dari polong lewat proses percolation atau oleoresin. Metode percolation dilakukan dengan sirkulasi pelarut etanol/air dengan konsentrasi 35-50:65-50 (v/v) pada kondisi vakum selama 48-72 jam. Proses oleoresin dilakukan dengan penghancuran polong dan disirkulasikan dengan etanol pada suhu 45oC pada keadaan vakum selama 8-9 hari. Alkoholnya kemudian diuapkan.[14]\n" +
                    "\n" +
                    "Sifat antioksidan vanillin telah diuji dalam berbagai metode seperti oxygen radical absorption capacity (ORAC) assay dan oxidative hemolysis inhibition assay (OxH-LIA) dan ditemukan bahwa sifat antioksidannya lebih kuat dibandingkan dengan asam askorbat (vitamin C) dan Trolox. Vanillin dilaporkan menghambat pertumbuhan bakteri Gram positif dan negative, ragi, dan juga kapang. Pertumbuhan Saccharomyces cerevisiae, Zygosaccharomyces bailii, Zygosaccharomyces rouxii, dan Debaryomyces bansenii teramati terhambat pada medium sari apel yang mengandung 2000 ppm vanillin setelah diinkubasi selama 40 hari pada suhu 27oC[14]", "android.resource://com.callcenter.dicodingpemula/drawable/vanilla"),

            // Add more articles as needed
        ))

        articleAdapter = ArticleAdapter(articles) { article ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("title", article.title)
                putExtra("overview", article.overview)
                putExtra("imageUri", article.imageUri) // Sending image URI
            }
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = articleAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
