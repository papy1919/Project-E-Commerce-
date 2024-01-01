# E-commerce Application Documentation

### Introduction:
This Java application is a console-based e-commerce system built on object-oriented principles. It offers a range of functionalities covering user management, product handling, order tracking, dynamic product search, and more.

### Key Features
##### -User Authentication
##### -Login/Logout: The system manages user login/logout, distinguishing roles (admin, customer,supplier). 
##### -Access Levels: Different access levels are defined to limit privileges based on user roles. 
##### -Product Management:
##### *Abstract Product Class: An abstract base class Product encapsulates general product attributes.
##### *Product Categories: Specific categories extend the Product class to represent different product types (Cars, Smartphone, Accessory).
##### -Shopping Cart:
##### *Cart Management: Users can add, update, and remove products in their shopping cart.
##### -Order Processing:
##### *Order and History: The purchasing process manages the transition from cart to order completion and records transactions in an Order class.
##### -Inventory Management:
##### *Stock Tracking: The application automates inventory tracking and updates quantities post-purchase.
##### -Dynamic Product Search and Filtering:
##### *Search Functionality: Users can search for products with filtering options to refine search results.
##### Payment Processing:
##### *Payment System: A basic payment system is implemented to simulate transactions.


### Implemented Optional Features
##### -User Reviews and Ratings:Users can add and view reviews for purchased products.
##### -Aggregate ratings are displayed for each product.
##### -Product Recommendations:Analysis of user purchase habits to suggest relevant products.

### Code Structure
##### The code structure comprises several core classes:

##### -User: Represents system users with functionalities like cart addition, order history, etc.

##### -Product: An abstract class encapsulating general product attributes.

##### -Supplier: Manages product suppliers.

##### -Order: Handles order details and transactions.

### Usage of Interfaces
The application utilizes the following interfaces:


##### ISearch Interface:
##### -Purpose: This interface defines a contract for classes that need to implement search functionalities within the system.\n
##### -Usage:
Classes that implement ISearch are required to define the search() method, which typically handles various search criteria and displays search results.
In the provided code, the Searchable class implements ISearch to enable searching for products based on type, name, category, supplier, price, and rating.
The search() method in Searchable prompts users to choose a filter (type, name, category, etc.) and performs product searches accordingly.\n


##### ISignUp Interface:
##### -Purpose: This interface outlines the necessary functionalities for user sign-up processes.\n
##### -Usage:
Classes implementing ISignUp are required to have a method, named signUp(), responsible for handling user registration procedures.
In the code, the Signing class implements ISignUp to ensure user sign-up functionality adheres to the defined contract.
The signUp() method within Signing class guides users through the registration process, ensuring valid email entry and collecting necessary user details.\n


##### ILogIn Interface:
##### Purpose: This interface outlines the necessary functionalities for user Log-in processes.\n
##### Usage:
Classes implementing ILogIn are required to have a method, named logIn(), responsible for handling user registration procedures.
In the code, the Loging class implements ILogIn to ensure user sign-up functionality adheres to the defined contract.
The logIn() method within Signing class guides users through the registration process, ensuring valid email entry and collecting necessary user details.
