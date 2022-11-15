Feature: TC-16 post pojo
  Scenario: TC-16  pojo

    Given kullanici herokuapp "https://restful-booker.herokuapp.com" anasayfasinda
    And   endpointi "booking" uzantisini ekler heroukapp pojo
    And   Request body firstname "Hakan",lastname "Dag", totalprice 99, depositpaid true , bookingdates checkin checkout additionalneeds "Breakfast with white tea, Dragon juice"
  #  And HTTP Status Code should be 200 Herokuapp pojo
  #  And Request body bookingid 16,booking, firstname "Ali",lastname "Can", totalprice 99, depositpaid true , bookingdates checkin checkout additionalneeds "Breakfast with white tea, Dragon juice"