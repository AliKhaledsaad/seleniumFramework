Feature: Automated End2End tests
Scenario Outline: automated End2End Tests
 Description : the purpose of this feature is to test End 2 End intergration
 
 Given user is on Home Page
 When  user search for "<productName>"
 And   choose to buy 2 item
 And   moves to checkout cart and enter personal details on checkout page and place the order
 Then  he can view ordr successfully purashed message and download the invoice
 
 Examples:
|productName|
|Apple MacBook Pro|