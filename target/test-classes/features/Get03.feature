@tag
Feature:BaseUrl kullanabilme

  Background:
    Given kullanici "https://jsonplaceholder.typicode.com" jsonplaceholder anasayfasinda


  Scenario: TC-03 BaseUrl kullanma

    When  endpointi "todos" ve 23 olan uzantiyi ekler
    Then  User send GET Request to the URL
    And   HTTP Status Code should be 200 olmali jsonplaceholder
    And   Response format should be "application/json" olmali jsonplaceholder
    And   title ise "et itaque necessitatibus maxime molestiae qui quas velit" olmali
    And   "completed" ise false olmali
    And   userID 2 olmali


  Scenario: TC-04 sadece ID sorgulama

    When  endpointi "todos" a git jsonplaceholder
    Then User "tek uzantili" send GET Request to the URL
    And  Accept type is "application/json"
    Then HTTP Status Code should be 200 olmali jsonplaceholder
    And Response format should be "application/json" olmali jsonplaceholder
    And 200 tane todos olmali
    And  titlelerden biri "quis eius est sint explicabo" olmali
    And  userIds ler  2, 7, and 9 olabilir

  Scenario: TC-07  liste olusturma Groavy language kullanimi Lambda gibi


    And   endpointi "todos" a git jsonplaceholder
    Then User "tek uzantili" send GET Request to the URL
    Then  HTTP Status Code should be 200 olmali jsonplaceholder
    And   Print all ids greater than 190 on the console
    And   Assert that there are 10 ids greater than 190
    And   Print all userIds whose ids are less than 5 on the console
    And   Assert that the number of userIds whose ids are less than 5 is 4
    And   Print all titles whose ids are less than 5
    And   Assert that "delectus aut autem" is one of the titles whose id is less than 5


