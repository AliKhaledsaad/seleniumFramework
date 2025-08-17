Feature:
 User Registration
 I want to check that user can register in our e-commerce website
 
 Scenario Outline::
 user registration
 
 Given the user in the home page
 When I click on register link
 And i entered "<gender>", "<firstname>" , "<lastname>" , "<email>" , "<password>"
 Then the registration successfully page should be displayed
 
 Examples:
 	| gender | firstname | lastname | email | password |
	| m | samirs | gorges | samir11zz11zges@Test.com | 1230031zzz1122 |
 	| m | kahled | Mate | khal2dMr111zz11zs@Test.com | 122452112zzz22322 |
 	| f | nada | mestse | nadam222111zz11z212sms@Test.com | 14121745zzz223 |
 
