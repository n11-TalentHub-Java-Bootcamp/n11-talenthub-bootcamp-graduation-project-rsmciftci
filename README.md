#n11 Graduation Project
>! Please just register with your own phone number not to bother others.
## Features

* Saves a customer.
* Updates a customer.
* Deletes a customer.
* Applies a credit for a customer.
* Calculates credit limit automatically by the formulas given to us.
* When application is done sms sent to customer to inform about credit result and limit.
* Finds if credit application is already done.


## Predefined Features 
We were free to create a credit score service. Given conditions for credit
score and credit result is
> If credit score lower than 500, customer's credit application
> will be rejected
#
According to predefined credit limit calculation, maximum credit score we care about is 1000.
#
Credit score assumption,
> credit score = last 3 digits of identity number + 100
#
Result of the formula above gives all the values needed.

## Installations
Make sure Java 11 & PostgreSql 14 are installed on your computer.
######
Create a table named 'graduationProject' manually.
######
Go to application.properties update username & password for PostgreSQL.
######
Open a new terminal and go 
> cd graduation-project-frontend/frontend
######
To be able start react,
> npm start
######
Run the spring boot project.


