Feature: Petshore Api Testleri For Micro


    Scenario: Negatif Post senaryosu
      Given Kullanici post islemi icin endpointe gonderecegi requesti gonderir
      Then  Kullanici "post" islemi ile gelen responce ekrana yazdirir
      And   Kullanici post islemi sonucu status code 200 oldugunu test eder

      Scenario: Pozitif post senaryosu
        Given  Kullanici post islemi icin requestbody sini hazirlar ve endpointe gonderir
        Then  Kullanici "post" islemi ile gelen responce ekrana yazdirir
        And   Kullanici post isleminden sonra status code 200 oldugunu teyit eder

  Scenario: Petshore da CRUD islemleri Get
    Given Kullanici "pet" endpoint ine response yollar
    And Kullanici status code nun 200 oldugunu dogrular
    Then kullanici 1 nolu ped in adinin "poncikk" oldgunu dogrular

    Scenario: Pozitif Put islemi
      Given Kullanici put islemi icin requestini hazırlar ve entpointe gonderir
      Then  Kullanici "put" islemi ile gelen responce ekrana yazdirir
      And Kullanici status code nun 200 oldugunu dogrular
      And Kullanici put islemi sonrasi pet in adinin "bacaksiz" olarak guncellendigini dogrular

      Scenario: pozitif delete islemi
        Given Kullanici delete islemi icin requestini hazırlar ve endpointe gonderir
        And   Kullanici "delete" isleminin basarili oldugunu statuscodun 200 gelmesi ile dogrular
        Then  Kullanici delete islemini dogrulamak icin silinen id ye get yapar ve donen response codun 404 oldugunu dogrular

