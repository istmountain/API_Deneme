@tag
   Feature:BaseUrl kullanabilme

   Background:

   Given kullanici "https://jsonplaceholder.typicode.com" anasayfasinda

    Scenario: TC-03 BaseUrl kullanma

    When  endpointi "todos" ve 23 olan uzantiyi ekler
    Then  User send GET Request to the URL
    And   HTTP Status Code should be 200
    And   Response format should be "application/json" olmali
    And   title ise "et itaque necessitatibus maxime molestiae qui quas velit" olmali
    And   "completed" ise false olmali
    And   userID 2 olmali


     Scenario: TC-04 sadece ID sorgulama

        When  endpointi "todos" a git
        Then User tek uzantili send GET Request to the URL
        And  Accept type is "application/json"
        Then  HTTP Status Code should be 200
        And Response format should be "application/json" olmali
        And 200 tane todos olmali
        And  titlelerden biri "quis eius est sint explicabo" olmali
        And  userIds ler  2, 7, and 9 olabilir





       #Given https://jsonplaceholder.typicode.com/todos
       #When I send a GET request to the Url
       #And  Accept type is "application/json" (gonderilecek olan data turunu json seklinde gonder diyor)
       #Then  HTTP Status Code should be 200
       #And Response format should be "application/json"
       #And There should be 200 todos
       #And "quis eius est sint explicabo" should be one of the todos title
       #And  2, 7, and 9 should be among the userIds




