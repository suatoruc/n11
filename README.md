# n11

<b>n11</b> sitesinde çalıştıgımız bu senaryo da;
 - <h2><b>UI kısmında </b></h2>
<p>login olup bir ürün aratıp gelen sayfalar arasında ikinci sayfaya gecip</br>
buradan bir ürünü favorilere ekleyipsonrasında favorlerden silme adımları çalışıldı.</p>
<strong> UI daki testler için;</strong></br>
<b><i> 
* Framework olarak Cucumber ve Gherkin kullanıldı.</br>
* Page safyasında selenium 4'den sonra kullanılmaya başlanılan metod yapısı kullanıldı.</br>
* Her sayfa geçişlerinde ekran görüntüsünü alıp raporlama yapmak için hooks class yapısı kullanıldı</br>
* Cucumber framework'ünde çalışıldıgından Raporlama için surefile ve failsafe pluginleri kullanıldı </i> </b>


  <h2><b>Backend kısmında </b></h2>
pet tablolarında CRUD işleleri yapıldı.</br>
<strong>Backend'de çalıştığımız APİ testlerinde; </strong></br>
<b><i>
* Baseurl olarak petstore.swagger.io/v2 kullanıldı.</br>
* Petshore sitesinde pet tablolarında CRUD işlemleri yapıldı.</br>
* Petshore sitesinden yapılan responce ile gelen datayı java objesi olarak kullanmak için </br> POJO class yapısı kullanıldı
* POJO class icinde syntex yapısı için lombok kütüphanesi kullanıldı.</br>
* Api kısmında bir baseApi class'ı oluşturulup base url burada bir metod içersindetanımlandıkdan </br> sonra stepdef kısmındaki tanımlanan tüm spesifkasyonlar bu metod üzerinden tanımlandı.</br> </i></b>


