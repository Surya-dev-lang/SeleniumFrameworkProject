Feature: Application Login

Scenario: Login with valid credentials
Given Open any Browser
And Navigate to Login page
When User enters username as "srknt.sahu90@yahoo.com" and password as "12345" into the fields
And User clicks on Login button
Then Verify user is able to successfully login