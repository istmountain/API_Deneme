Feature: Get04
     @tag1
  Scenario: TC-05 sadece ID sorgulama

     #https://restful-booker.herokuapp.com/booking/?firstname=Sally&lastname=Jackson endpointimiz bu
    Given   kullanici "https://restful-booker.herokuapp.com" anasayfasinda
    When    endpointi "booking" olan herokuapp sitesi firstname "Sally" lastname "Jackson"
    When    User sends a GET Request to the url
    And     HTTP Status Code should be 200
    And     firstname "Sally" lastname "Jackson" var oldugunu dogrula


