Feature: Customer

Background: Steps common for all scenarios

	Given User Launch Chrome browser	
	When User opens URl "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashboard

@Sanity	
Scenario: Add New Customer

 
	When User click on customers Menu
	And click on customers Menu Item
	And click on Add new button
	Then User can view Add new customer page
	When User enter customer info
	And click on Save button
	Then User can view confirmation message "The new customer has been added successfully."
	And close browser

@regression
Scenario: Search Customer by Email
 
	When User click on customers Menu
	And click on customers Menu Item
	And Enter Customer Email
	When Click on Search button
	Then User should found Email in the Search table
	And close browser

Scenario: Search Customer by Name

 	When User click on customers Menu
	And click on customers Menu Item
	And Enter customer FirstName
	And Enter customer LastName
	When Click on Search button
	Then User Should found Name in the Search table
	And close browser

