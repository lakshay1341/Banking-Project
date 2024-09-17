### README.md

```markdown
# Banking Project

This Banking Project is a Java-based application designed to simulate basic banking operations. It leverages object-oriented programming principles, collections, and the factory design pattern to manage users, accounts, transactions, and different banks (SBI and Axis).

## Features

- Create and manage user accounts
- Perform transactions (deposit, withdraw, transfer)
- Switch between different banks (SBI and Axis)
- Handle exceptions gracefully
- Log in to previously created accounts

## Technologies Used

- **Java**: The primary programming language used for the application.
- **Object-Oriented Programming (OOP)**: Utilized for creating classes and objects to represent users, accounts, transactions, and banks.
- **Collections Framework**: Used for managing collections of objects such as lists and maps.
- **Factory Design Pattern**: Implemented to create instances of different banks (SBI and Axis).
- **Java NIO**: Used for file operations and handling user data.

## Installation

1. **Clone the repository:**

   ```sh
   git clone https://github.com/lakshay1341/Banking-Project.git
   cd Banking-Project/src/New_Bank_Project
   ```

2. **Compile the Java files:**

   ```sh
   javac *.java
   ```

3. **Run the application:**

   ```sh
   java Main
   ```

## Usage

### Creating a User

To create a new user, follow the prompts in the application to enter user details such as name, address, and initial deposit.

### Managing Accounts

- **Deposit Money**: Select the deposit option and enter the amount to deposit into the account.
- **Withdraw Money**: Select the withdraw option and enter the amount to withdraw from the account.
- **Transfer Money**: Select the transfer option, enter the recipient's account details, and the amount to transfer.

### Switching Banks

The application allows you to switch between different banks (SBI and Axis). Follow the prompts to select the desired bank.

### Logging In

To log in to a previously created account, enter the user credentials when prompted.

## Exception Handling

The application includes robust exception handling to manage errors such as invalid inputs, insufficient funds, and account not found scenarios.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

- Java for providing a robust programming language
- The open-source community for continuous support and contributions

---
