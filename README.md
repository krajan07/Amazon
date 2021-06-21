# Amazon

Introduction

•	This is the project report for the Project 1: Automating the Amazon application using Selenium Web driver for “Implement software development and database fundamentals through agile” course of Simplilearn.
•	Project submitted by : Krishnaveni Rajan
•	Email Id: krishnaveni07.rajan@gmail.com
•	Submission Date: 21-June-2021
•	Language/Tools Used : Core Java with Selenium Web driver and JDBC of MySQL. Project written in Eclipse. 

Problem Statement
To automate the Amazon application using Selenium WebDriver with Java.    
Background of the problem statement:
Automating the Amazon application to get the list of types of a particular product.

The following requirements should be met:
•	Create a Java class for an Amazon application
•	Open the browser and locate web elements using Locators.
•	Write an automation script using page object design pattern class to store the web elements of a web page.
•	Manage Transactions using Selenium and JDBC.

Project Details

This is the project has been provides the automation code to do the following using Core Java in Eclipse tool.
•	Connect to MySQL database by reading the connection properties from config.properties files
•	Create a table named ecommerce.amazon with Id, categoryName, productName and Date added using the ‘execute’ command
•	Add a row with categoryName as Electronic and productName as Mobiles.
•	Get Category Name and Product name from table ecommerce.amazon table and store as variables.
•	Open Amazon India Home page.
•	Using XPath, select the category by using the Category Name taken from MySQL table and stored as variable.
•	Using XPath, provide ‘Mobiles’  by using the Product Name taken from MySQL table and stored as variable.
•	Search for the Mobiles.
•	Get the count of Mobiles listed using XPath
•	Compare the count of Mobile with the Search details present in the Amazon site
•	Do comparison of count with the search details and print message accordingly.
•	Print ‘Name’ of the mobiles from the searched page.
•	Close the browser and SQL connection made.
•	Push the code to GitHub @ https://github.com/krajan07/Amazon 


Libraries Used

Java default libraries were used. Along with the default, reference libraries were used.
 

Conclusion

I was able to get the steps executed without errors. But identified that the number of mobiles listed in the search page did not compare with the number displayed by Amazon. 

Note: Snapshot attached in Amazon Project Code Snapshot document
