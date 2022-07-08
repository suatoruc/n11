Feature: n11 otomationCase for Micro

  @n11
  Scenario: N11 Favori Ürün Senaryosu
    Given	"https://www.n11.com" sitesi açılır.
    Then 	Ana sayfanın açıldığı kontrol edilir.
    When    Siteye login olunur.
    And  	Login işlemi kontrol edilir.
    Given  	"Iphone" kelimesi aranır.
    And  	"Iphone" kelimesi aratıldığı kontrol edilir.
    Then  	Arama sonuçları sayfasından 2. sayfa açılır.
    When 	2. sayfanın açıldığı kontrol edilir.
    Given   Sayfadaki 3. ürün favorilere eklenir.
    Then  	Hesabım - İstek Listem - Favorilerim sayfasına gidilir.
    When 	Favorilerim sayfası açıldığı kontrol edilir.
    Then 	Eklenen ürün favorilerden silinir ve silme işlemi kontrol edilir.
    And   	Üye çıkış işlemi yapılır.
