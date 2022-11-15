Feature: Get04
     @tag1
  Scenario: TC-05 sadece ID sorgulama asString methodunu kullanip assert etme

     #https://restful-booker.herokuapp.com/booking/?firstname=Sally&lastname=Jackson endpointimiz bu
      Given   kullanici herokuapp "https://restful-booker.herokuapp.com" anasayfasinda
      When    endpointi "booking" olan herokuapp sitesi firstname "Susan" lastname "Wilson"
      When    User sends a GET Request to the url
      And     HTTP Status Code should be 200 Herokuapp
      And     firstname "Susan" lastname "Wilson" var oldugunu dogrula

     Scenario: TC-06 Assertion icin JsonUnit Classini kullanma

       Given kullanici herokuapp "https://restful-booker.herokuapp.com" anasayfasinda
       When  endpointi "booking" ve 10 olan uzantiyi ekler heroukapp
       When  User sends a GET Request to the url
       And   HTTP Status Code should be 200 Herokuapp
       And   Response format should be "application/json" olmali herokuapp
       And   Response firstname "Sally",lastname "Ericsson", totalprice 335 , depositpaid  true
       And   bookingdates checkinDate "2021-10-09",bookingdates checkoutDate "2022-03-12"

         # nested disinda diger bir cozum ise JsonPath clasindan obje olusturmak restassured kutuphanesinden gelir










