Feature: TC-19 ObjectMapper  get
  Scenario: TC-19 ObjectMapper get

    Given kullanici "https://jsonplaceholder.typicode.com" jsonplaceholder anasayfasinda
    And  endpointi "todos" ve 198 olan uzantiyi ekler
    When I send Get Request to the Url jsonplaceholder objectMapper
    #Then HTTP Status Code should be 200 olmali jsonplaceholder
    And Response body is like UserId 10 , id 198 ,title "quis eius est sint explicabo" completed true olmali