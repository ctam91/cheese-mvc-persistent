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
* User goes to the homepage and views a list of cheeses stored in database.
![Alt text](src/main/resources/img/add_cheese.jpg?raw=true "Optional Title")
* User enters a new cheese into the database and is redirected to the homepage
* User creates a new category and can add cheeses to the category.
* User creates a new menu and can add cheeses to the menu. 

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
