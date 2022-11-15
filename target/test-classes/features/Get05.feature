Feature: Serialization Deserialization
  Scenario: TC-08 Json formatini Java ya ( Map ) a cevirme
  // De- Serialization: Json formatından Java objesine çevirmektir
  //Serialization: Java objesini JSON formatına çevirmek
  //De-Serialization ve Serialization 2 türlü yapılır.
  //Gson:(Google tarafından üretilmiştir, pek kullanmaaycağız)
  //Object Mapper: Daha popülerdir bunu kullanacağız


    Given kullanici "https://jsonplaceholder.typicode.com" jsonplaceholder anasayfasinda
    When  endpointi "todos" ve 2 olan uzantiyi ekler
    Then  User send GET Request to the URL
    And   HTTP Status Code should be 200 olmali jsonplaceholder
    And   "completed" ise false olmali
    And   userId is 1 , id is 2 title is "quis ut nam facilis et officia qui" olmali completed is "false"
    And   header  Via  is "1.1 vegur"  header Server is "cloudflare"

