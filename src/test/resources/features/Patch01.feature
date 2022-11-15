Feature:  patch yapabilme
    @a
  Scenario: TC-13 patch yapmabilme
    Given kullanici "https://jsonplaceholder.typicode.com" jsonplaceholder anasayfasinda put
    And  endpointi "todos" ve 198  olan uzantiyi ekler jsonplaceholder put
    When userId 21, title "mutfaga git". completed "false" olmali patch jsonplaceholder
