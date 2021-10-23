# Algorithm
## Goals
The goal of this "Bank On It" program is to create a basic ATM system with specific requirements. According to the instructions given, each user will have an account number and a PIN, a checking account and a savings account. The checking account has a balance, and the user can deposit money into the account, withdraw money from the account, and check the balance. The checking account does not have interest. The savings account is almost exactly like the checking account except that there is an interest rate associated with the account and it can be calculated by the standard basic interest formula: A=P(1+rt), where P = principle (balance before calculating interest), r is the interest rate, and t is the period (months)

The ATM will expect a user to log in using account number and PIN. If the user is an administrator, she will be taken to an admin menu. If the user is a known user, she will be taken to a user menu. If the user is unknown, the system will exit. The admin user will have an account number of 00000 and a pin 12345. The admin menu will have the following the options to add a user, delete a user (account must be empty), list all users, apply interest to all savings accounts, and exit. The user menu will have the options to get checking balance, deposit into checking, withdraw from checking, get savings balance, deposit into savings, withdraw from savings, and exit. Finally, the system will need to store the user and account information into some sort of file system.

For this bank program that I have created, I made 5 classes in seperate files, which include the *Bank class*, *Checking class*, *Saving class*, *User class*, and *Admin class*. The Bank class acts as the main class of the program, it functions to run the program and manage all the seperate classes created and make the whole bank program work. The Checking class is to manage the checking account and balance of the user. The Saving class is to manage the saving balance of the user. The User class is to manage the user UI and act as a platform for the user to interact with this program by accessing and updating their personal bank account information. Finally, the Admin class is to manage the admin UI and provide a platform for the Admin to modify and view the users' bank information.

## Input
For this bank program that I have created, I made 5 classes in seperate files, which include the *Bank class*, *Checking class*, *Saving class*, *User class*, and *Admin class*. The Bank class has no input, while the Checking class has an input of the current balance that the user currently has and this balance is passed into the Checking account. For the Saving class, it also has an input of the current balance possessed by the user at that time being saved in the Saving account. In regards to the User class, the user can input user details and the program will save all the information entered in order to keep users' information up-to-date. Finally, the Admin class allows the admin to choose and execute a few changes in the whole bank program, which involves adding a user, deleting a user, and view a list of users with their bank information.

## Output
In the 5 classes that I have created for this program, the Bank class outputs the main menu and both the user menu and the admin menu to the console depending on the user who logged in to his/her account. The account number and PIN number is checked before determining whether the user is a regular user, an admin, or unknown to the bank database. The Checking class outputs any changes to the checking account done by user him/herself after withdrawing or depositing money out of or into the checking account. The Saving class does exactly the same as the Checking class, which outputs any changes in the saving account of the user after some transactions have happened. Next, the User class outputs some added information that is done either by an admin or the user through this bank program. Also, the Admin class outputs new users added by the admin along with their details to the console. This output shows the admin all information of the users together with their accounts information.

## Steps 
In the Bank class (the main class that handles the starting of the program), I asked the user for their account number and the PIN:
* If it matches with the details of the admin, the program will show him/her the admin menu and give them the admin choices
* If it matches with the details of the user, the program will show him/her the user menu and provide them with the User choices
* Users can access various different options in savings and checkings account
* Admins can perform changes in the users' bank information, like adding interest, deleting a user, or adding a user.

In the Checking class (the class that handles the checking account of users), I allow the program to perform the following operations:
* Return the balance of the checking accout that the user currently has.
* If the user chooses to withdraw from the checking account check if it the account is empty or whether the balance in the account is sufficient to be withdrawn.
* If the account is empty then give the user an error otherwise deduct from the users checking account.
* If the user chooses to deposit then add the given ammount of money to the users checking account.
* Check if the amount entered by the user is negative and give them errors with respect to their wrong input of values.

In the Saving class (the class that handles the saving account of users), I made the program perform the following operations:
* Return the balance of savings account that the user currently has.
* If the user chooses to withdraw from the savings account check if it is empty or whether the balance in the account is sufficient to be withdrawn.
* If the account is empty then give the user an error otherwise deduct from the user savings account
* If the user chooses to deposit then add the given ammount of money to the users savings account
* Check if the ammount entered by the user is negative and give the errors with respect to their wrong input of values.

In the User class (the class that handles all the user UI),
I made the program perform the following operations:
* Set the name of the user.
* Set the account number.
* Set the account pin.
* return the user info. 
* return the pin and account number to the user.

These information are crucial in making this program work since they can be helpful for both the user and the admin to conduct different operations in this bank program.

Finally, in the Admin class (the class that handles all the admin UI),
I made the program perform the following operations:
* main to create the vector 
* Add the user information
* Delete the user information by asking the admin for the account number
* List all the users by running a loop through the vector
* Add the interest to the savings account

These are choices that an admin can pick to make changes in this bank program. The changes made here will be saved in the program by serialization and everything will be up-to-date when we run the program in the future since the information is saved.










