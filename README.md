# SpitwiseApplication
This is a low level design of splitwise like application.

### Create an expense sharing application.
An expense sharing application is where you can add your expenses and split it among different people. The app keeps balances between people as in who owes how much to whom.

## Requirements :
  
    1. User: Each user should have a userId, name, email, mobile number.
    2. Expense: Could either be EQUAL, EXACT or PERCENT
    3. Users can add any amount, select any type of expense and split with any of the available users.
    4. The percent and amount provided could have decimals upto two decimal places.
    5. In case of percent, you need to verify if the total sum of percentage shares is 100 or not.
    6. In case of exact, you need to verify if the total sum of shares is equal to the total amount or not.
    7. The application should have a capability to show expenses for a single user as well as balances for everyone.
    8. When asked to show balances, the application should show balances of a user with all the users where there is a non-zero balance.
    9. The amount should be rounded off to two decimal places. Say if User1 paid 100 and amount is split equally among 3 people. Assign 33.34 to first person and         33.33 to others.

### Input

You can create a few users in your main method. No need to take it as input.
There will be 3 types of input:
    
    Expense in the format: EXPENSE <user-id-of-person-who-paid> <no-of-users> <space-separated-list-of-users> <EQUAL/EXACT/PERCENT> <space-separated-values-in-case-of-non-equal>
    Show balances for all: SHOW
    Show balances for a single user: SHOW <user-id>

### Output
    When asked to show balance for a single user. Show all the balances that user is part of:
      Format: <user-id-of-x> owes <user-id-of-y>: <amount>
    If there are no balances for the input, print No balances
    In cases where the user for which balance was asked for, owes money, they’ll be x. They’ll be y otherwise.
 

## Solution Approach

Use Case  Diagram 
User to add expense.
User to query for balances.

### Entities -
    1. User :
        userId,
        name,
        mobileno,
        emailId,
        BalanceInterface(Observer Pattern)
    2. Expense : 
        payeeID,
        amount,
        type,
        splittingBehavior
        List<UserId> paidTo
    3. ExpenseType
    4. Interface SplittingBehavior
    5. Classes for each splitting behavior.
    6. Repos : UserIDMap, expenseIDMap, 

