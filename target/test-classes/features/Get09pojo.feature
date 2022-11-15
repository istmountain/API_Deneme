Feature: TC-18 pojo get
  Scenario: TC-18 pojo get

   Given kullanici "https://gorest.co.in/public/v1" anasayfasinda pojo
   And endpointi "users" ve 2500  olan uzantiyi ekler goRest pojo
    When HTTP Status Code should be 20 goRest pojo
   And Response data meta null id 2500,name "Hiranya Kaur", email "hiranya_kaur@klein.biz" gender "female", status "active"