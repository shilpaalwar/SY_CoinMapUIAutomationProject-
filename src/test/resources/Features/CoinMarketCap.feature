#Author: shilpagpt.com
#Feature: This file contains Filter and extract information scenarios on Coin Market Cap Application

Feature: Filter 
  Background: User naviagtes to Coin Market Cap application
		Given User Open Coin Market Cap Application
		And User is on homepage 

  @Filter
  Scenario: Filter Coin Market Cap Table
    Given User filter Rows by 20
    Then Filter by Algoritham "PoW"
    When Click on Add Filter
    And Toggle "Mineable"
    Then Select Cryptocurrency "Coins"
    And select price and set minimum value to "100" and maximum to "10000"
    And Click on Apply Filter
    And Click on Show results
    And Verify results displayed
    
    
