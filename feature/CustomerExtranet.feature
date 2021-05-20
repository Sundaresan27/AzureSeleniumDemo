Feature: Customer Extranet 

@Smoke
Scenario Outline: User should only be able to login with valid credentials
Given I navigate to the Intertek website
When I enter Username as "<username>" and Password as "<password>" into the fields
And I click on Login button 
And I select the company with country "<company>" name
And I click on the equivalent submenu and click on the contract then click create contract
Examples:
|username		|password	|company								 |
|sundareswaran  |Sundar27@	|USA - Intertek Technical Services, Inc.|



 
