Feature: Post yapabilme
  Scenario: TC-12


  Given kullanici herokuapp "https://restful-booker.herokuapp.com" anasayfasinda
  And endpointi "booking" uzantisini ekler heroukapp
  And Request body ekler firstname "Hakan" lastname "Dag",totalprice 11111, depositpaid "true"
  And bookingdates checkin "2021-09-09", checkout "2021-09-21" olmali herokuapp




