Feature: TC-15 pojo class kullanabilme
  Scenario: TC-15 pojo class kullanimi

    Given kullanici "https://jsonplaceholder.typicode.com" anasayfasinda jsonplaceholder
    And   endpointi "todos" a git jsonplaceholder
    And  I send post request  userId 55,title "Tidy your room",completed false  jsonplaceholder



