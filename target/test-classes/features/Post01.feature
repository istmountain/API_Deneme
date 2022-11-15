Feature:  Post request yapma


  Scenario: TC-12 post request

  /*
  Given
  1) https://jsonplaceholder.typicode.com/todos
  2)
  When
  I send POST Request to the Url
  Then
  Status code is 201 {
  "userId": 55,
  "title": "Tidy your room",
  "completed": false
  }
  And
  response body is like {
  "userId": 55,
  "title": "Tidy your room",
  "completed": false,
  "id": 201
  }
  */


    Given kullanici "https://jsonplaceholder.typicode.com" jsonplaceholder anasayfasinda
    And   endpointi "todos" a git jsonplaceholder
    When I send POST Request to the Url user Id 55,title"Tidy your room",completed "false" jsonplaceholder
    And   Response body is like UserId 55 ,title "Tidy your room" completed "false"

