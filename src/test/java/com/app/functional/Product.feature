Feature: Sample Product API test

  Background: 
    Given Set base url "https://fakestoreapi.com"

  @Getmethod
  Scenario: Validate the products
    Given Set basepath "/products/1"
    When Set headers
      | Content-Type | application/json |
    And Make GET call
    Then Validate status code 200
    Then Validate the response "response"
    Then Validate the id "1" as "id"
    Then Validate the title "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops" as "title"
    And teardown

  @Postmethod
  Scenario: Validate the post product
    Given Set basepath "/products"
    When Set headers
      | Content-Type | application/json |
    And Set inputpayload "C:\Users\mkpan\eclipse-workspace\sand\APICucumberTest_Product\src\test\resources\Product.json"
    And make POST call
    Then Validate status code 201
    Then Validate the response "response"
    Then Validate the id "21" as "id"
    Then Validate the title "New Product" as "title"
    Then Validate the price "29.99" as "price"
    And teardown

  @Putmethod
  Scenario: Validate the put product
    Given Set basepath "/products/1"
    When Set headers
      | Content-Type | application/json |
    And Set inputpayload "C:\Users\mkpan\eclipse-workspace\sand\APICucumberTest_Product\src\test\resources\putproduct.json"
    And Make PUT call
    Then Validate status code 200
    Then Validate the response "response"
    Then Validate the id "1" as "id"
    Then Validate the title "Updated Product" as "title"
    Then Validate the price "39.99" as "price"
    And teardown
