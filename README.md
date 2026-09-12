# ATM Interface

## Project Description

ATM Interface is a console-based Java application that simulates basic ATM operations.

The project is developed using Object-Oriented Programming (OOP) concepts in Java.

## Features

- Account login using Account ID and PIN
- Maximum 3 login attempts
- Transaction history
- Cash withdrawal
- Cash deposit
- Money transfer between accounts
- Balance validation
- Insufficient funds validation
- Invalid amount validation
- Receiver account validation
- Same-account transfer validation

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- IntelliJ IDEA

## Project Structure


src
└── com.atm
    ├── Main.java
    ├── ATM.java
    ├── Account.java
    ├── Bank.java
    └── Transaction.java

## Classes

### Main

Handles user input, login process, ATM menu and operations.

### ATM

Handles account login and authentication.

### Account

Stores account information and handles withdrawal, deposit, transfer and transaction history.

### Bank

Stores accounts and finds an account using Account ID.

### Transaction

Stores transaction type, amount and description.

## How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure Java is configured.
3. Run `Main.java`.
4. Enter the Account ID and PIN.
5. Select an option from the ATM menu.

## Sample Accounts

| Account ID | Name | PIN | Initial Balance |
|------------|------|-----|-----------------|
| 1001 | Captain | 1234 | ₹10000 |
| 1002 | Rahul | 5678 | ₹8000 |
| 1003 | Roshan | 5578 | ₹4000 |

## ATM Menu

1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit

## Concepts Used

- Classes and Objects
- Encapsulation
- Constructors
- Methods
- ArrayList
- Conditional Statements
- Loops
- Switch Statement
- Object Interaction

## Author

Niyaz Ahmad