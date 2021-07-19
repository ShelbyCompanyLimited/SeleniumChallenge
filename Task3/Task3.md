
# Task 3

The purpose of this document is to explain the what kind of testing I did in the automation part and the share opinions about what I think that shold be automated

### UI Task Automation reflection 

* For UI Automation part I would say that the tests represents very low level of smoke test. Where the very basic checks are performed. 
* For UI Automation I would automate whole regression suite. Because in my opinion regression tests always should be automated. If the come to be very big and time consuming and if we want to execute them on each commit, I would say that we need to group our tests in smaller suites, where we will be able to run them as Sanity Checks after each commit, and full regression suite can run every night. 

* For the given type of the application where we have a lot of dinamyc data (New Items, new prices etc), I would go with data driven tests in order to be able to easily do changes for products, even better we can colect them from DB before test starts. 



## API Task Automatin reflection (This task is added in separate repo https://github.com/ShelbyCompanyLimited/APIChallenge ) 

* For this test again I would say that in the example I did very low level of smoke test. 
* For API Automation task again I would like to do Automate whole Regression test suite, where we can go deeper and do spme negative scenarios (Not only positive). As well if there are some caluclations we need to do them on our side in order to check if the API behaves as expected. 
* For API Automation I Always prefer data diven testing because as always in API it's all about data, so we need to have relaible, configurable and flexible tests. 
* In my opinion for API testing is very important to write a reusable functions where we can use them as Bots and create diferent scenarios. For example: We have scenario to find a hotel , add extra Breakfast and pay the hotel. Those 3 steps should be different "Bots" so with the same code we can test Finding a hotel and booking it without extra breakfast, and as well wih the same code we can do a full scenario.


