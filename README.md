# cheese-mvc-persistent
Web app built with Java and Spring Boot framework. Allows users to update a database about cheeses. 

## Requirements

The app must meet several requirements:

* List all cheeses
* List all menus
* List all categories 
* Edit all cheeses 
* Edit all menus 
* Display the homepage after addition of new cheese
* Include a menu bar with available commands

## User Scenarios
* User enters a username that is stored in the database with the correct password and is redirected to the /newpost page with their username being stored in a session
* User enters a username that is stored in the database with an incorrect password and is redirected to the /login page with a message that their password is incorrect
* User tries to login with a username that is not stored in the database and is redirected to the /login page with a message that this username does not exist 

## Routes
* **"/cheese"** - GET: Display list of all cheeses.
* **"/cheese/add"** - GET & POST: Display form for users to add a new cheese with a name, description, and category.
* **"/cheese/remove"** - GET: Display list of all cheeses in checkbox list form. Users can select which cheeses to remove.
* **"/category"** - GET: Display list of all current categories and a link to add a new category.
* **"/category/add"** - GET & POST: Display form for user to add new category.
* **"/menu"** - GET: Displaylist of all current menus and a link to add a new menu.
* **"/menu/add"** - GET & POST: Display form for user to add new menu.
* **"/menu/view/n"** - GET: Display list of all cheeses for specified menu.
* **"/menu/add-item/n"** - GET: Display dropdown menu of all cheeses and allows user to add a specific cheese to the menu.
