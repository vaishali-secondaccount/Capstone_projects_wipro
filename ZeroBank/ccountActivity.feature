Feature: Account activity
@smoke
Scenario: Check account activity and pay bill
Given user logged in
When click on account activity link and click on sub module pay bill
And Choose payee , account and amount then select date from new window and add description
And click or enter on pay button
Then payment done