Feature: put yapabilme

Scenario: TC-12 put yapma




   Given kullanici "https://jsonplaceholder.typicode.com" jsonplaceholder anasayfasinda
    And  endpointi "todos" ve 198  olan uzantiyi ekler jsonplaceholder put
    When userId 21, title "Wash the dishes". completed "false" olmali patch jsonplaceholder




