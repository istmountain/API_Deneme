Feature: Get Request yapabilme

  Scenario: TC-02 Herokuapp sitesinde bookinglere goz atma

     Given kullanici herokuapp "https://restful-booker.herokuapp.com/booking/1" adresine gider
     When  User sends a GET Request to the url herokuapp
     Then HTTP Status Code should be 404 olmali herokuapp
     And   Status Line should be "HTTP/1.1 404 Not Found"  olmali herokuapp
     And   Response body "Not Found"  icermeli herokuapp
     And   Response body "TechProEd" icermemeli heroukapp
     And   Server "Cowboy" olmali herokuapp


