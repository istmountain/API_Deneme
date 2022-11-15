Feature: Get 10
  Scenario: TC-10

Given kullanici "https://gorest.co.in/public/v1" anasayfasinda
And  endpoint  users "users" ve 2965 girmeli
When User send GET Request to the URL gorest iki parametreli
Then HTTP Status Code should be 200 gorest
And  Response body should be like meta "null" gorest
And R body gorest data,id 2965 name "Amarnath Dhawan Sr.", email "dhawan_amarnath_sr@johnson-beer.info", gender "female", status"inactive"

 Scenario: TC-11
   Given kullanici "https://gorest.co.in/public/v1" anasayfasinda
   And  endpoint  users "users"  girmeli
   When User send GET Request to the URL gorest tek parametreli
   Then The value of pagination limit is 10
   And  The current link should be "https://gorest.co.in/public/v1/users?page=1"
   And  The number of users should  be 10
   And  We have at least one "active" status
   And   "Miss Charuchandra Arora", "Krishna Chopra", "Gouranga Namboothiri" are among the users
   And  The female users are less than male users
  # eleman sayisini id sayisindan buluruz cunku diger turlu eslesme ihtimali var

