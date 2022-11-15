Feature: TC-17 pojo
  Scenario: TC-17

    Given kullanici herokuapp "https://restful-booker.herokuapp.com" anasayfasinda
    And   endpointi "booking" ve 3  uzantisini ekler heroukapp pojo
    When I send Get Request to the Url herokuapp pojo
    Then  HTTP Status Code should be 200 Herokuapp pojo
    And Response body firstname "Susan", lastname "Ericsson", totalprice 994, depositpaid true,additionalneeds "Breakfast" bookingdates checkin "2021-03-08", checkout: "2021-03-26"