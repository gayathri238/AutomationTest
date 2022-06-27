Feature: Portal Login


@FunctionalTest
Scenario Outline: Order Tshirt and verify history
Given User login into application with "<Username>" and password "<password>"
When Order Tshirt
Then History is populated with order details

Examples:
|Username                    |password|
|gaya238@gmail.com |Password-1234|

@FunctionalTest
Scenario Outline: Update Personal Information
Given User login into application with "<Username>" and password "<password>"
When Update First Name with "<Firstname>" in Account Page with password "<password>"
Then Personal Information should be saved
Examples:
|Username                    |password|Firstname|
|gaya238@gmail.com |Password-1234|Gayathri|






