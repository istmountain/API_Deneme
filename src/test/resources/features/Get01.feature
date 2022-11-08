Feature:  API de Get Request yapabilme
  Scenario:  TC-01 get request yapma

  manuel api  testi icin Postman kullaniriz
  otomasyon icin ise rest assured kutuphanesini indirmek gerekir ve bunu xml e ekleyecegiz

  otomsayon yapmak icin
  1- ne istendigini anlama
  2 - test adimlarini (TC ) yazma ( cucumber gherkin language kullanilir)
  Given: on kosul
  When: yapacagimiz aksiyonlar( get, put post..)
  Then:ciktilar dogrulama response
  And: coklu ardisik islemler icin

  3- Test kodlarinin yazimi
  a- Set the url ( URl ye git burada ise data gondermeye gerek yok)
  b- Set the Expected data ( biz data gondeririz bizim kosulumuz bu olur
  c- gonderecegimiz kodlari yazariz (request)
  d- dogrulama yapacagiz

    Given kullanici  "https://restful-booker.herokuapp.com/booking/1005" adresine gider
    When User sends a GET Request to the url
    Then HTTP Status Code should be 200 olmali
    And Content Type should be JSON
    And Status Line should be "HTTP/1.1 200 OK"  olmali
