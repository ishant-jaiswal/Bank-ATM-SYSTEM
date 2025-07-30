# Bank ATM System

This is a Java-based Bank ATM System project with a graphical user interface built using Swing. The system allows users to sign up, log in, and perform various banking operations such as deposits, withdrawals, balance inquiries, and more.

## Features

- User registration with multiple signup steps
- User login authentication
- Deposit and withdrawal functionalities
- Balance enquiry
- Mini statement generation
- PIN change
- Fast cash withdrawal options
- Transaction history

## Technologies Used

- Java Swing for GUI
- MySQL for database management
- JDBC for database connectivity

## Setup Instructions

1. Ensure you have Java Development Kit (JDK) installed.
2. Set up a MySQL database named `bankmanagementsystem`.
3. Update the database credentials in `Conn.java` if necessary.
4. Compile and run the Java source files.
5. Use the GUI to interact with the system.

## Notes

- The project currently uses simple SQL queries; consider enhancing security by using prepared statements to prevent SQL injection.
- Passwords and sensitive data should be handled securely (e.g., hashing PINs).
- Input validation and error handling can be improved.

## License

This project is open source and free to use.
