# n11

<b>n11</b> sitesinde çalıştıgımız bu senaryo da;
<p>login olup bir ürün aratıp gelen sayfalar arasında ikinci sayfaya gecip buradan bir ürünü favorilere ekleyip
sonrasında favorlerden silme adımları çalışıldı.</p>

<b>
* Framework olarak Cucumber ve Gherkin kullanıldı.</br>
* Page safyasında selenium4 den sonra kullanılmaya başlanılan metod yapısı kullanıldı.</br>
* Her sayfa geçişlerinde ekran görüntüsünü alıp raporlama yapmak için hooks class yapısı kullanıldı</br>
* Cucumber framework'ünde çalışıldıgından Raporlama için surefile ve failsafe pluginleri kullanıldı </b>

APİ
Api testleri için baseurl olarak petstore.swagger.io/v2 kullanıldı.
Petshore sitesinde pet tablolarında CRUD işlemleri yapıldı.
Petshore sitesinden yapılan responce ile gelen datayı java objesi olarak kullanmak için POJO class yapısı kullanıldı
POJO class icinde syntex yapısı için lombok kütüphanesi kullanıldı.
Api kısmında bir baseApi class'ı oluşturulup base url burada bir metod içersindetanımlandıkdan sonra stepdef kısmındaki tanımlanan tüm spesifkasyonlar bu metod üzerinden tanımlandı.


