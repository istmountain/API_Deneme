Feature: POM kullanarak TestdataMap kullanabilme
  Scenario: TC-09 Testdata Map kullanma

    Given  kullanici herokuapp "https://restful-booker.herokuapp.com" anasayfasinda
    And    endpointi "booking" ve 91 olan uzantiyi ekler heroukapp
    When   Response body firstname "Dane", lastname "Sevilla",totalprice 111,depositpaid "true" additionalneeds "Breakfast" bookingdates "Map"olmali



