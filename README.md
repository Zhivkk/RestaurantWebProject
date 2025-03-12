Application for managing a restaurant and selling food online.

The main database information is stored here: https://github.com/Zhivkk/RestaurantWebProjectResources including all used product photos. When starting the application, the local database is synchronized with the information in github.

1. Registration and login modules - upon registration, the user role is automatically assigned. After logging in, according to the role, users are redirected to different pages to which they have access.
2. The administrator can change the roles of users
3. After logging in, the user is redirected to different functionalities, depending on the user's role
4. User - redirects to information about the restaurant and menu. Functionalities have been developed for a detailed product preview and adding to the cart the products they want to purchase. After completing the order - the cart is sent for preparation by the user-chef.
5. Chef - redirects to a page that visualizes the ordered food products for preparation. You can see the amount of ingredients for each product and the recipe for preparation. When the preparation is completed - the product is removed from the list and sent for delivery
6. Bartender - redirects to a page that visualizes the ordered drinks for preparation. You can see the amount of ingredients for each drink and the recipe for preparation. When the preparation is completed - the drink is removed from the list and sent for delivery
7. Supplier - redirects to a page that displays a list of all delivery orders, along with the user's phone number and delivery address. When clicking on the order, it displays delivery details. Upon completion of delivery, the order is removed from the list.
8. Admin - redirects to a page with the main administrative functionalities - access to read and change user profiles, prepare reports, read and respond to messages from customers, manage reservations made.
9. Two separate microservices have been developed, respectively for sending e-mails and for organizing restaurant table reservation activities.
10. The microservice for sending e-mails automatically sends a message to the user after registration, as well as when the products ordered by him are delivered for delivery. The user can also send a special message that is read by the administrator.
11. The microservice for organizing reservations accepts reservation orders, checks whether there are free tables depending on the specified number of guests and reserves a table for the guests. The information is submitted to the administrator of the main application, who monitors that the guests are properly seated. The microservice automatically deletes all reservations made older than one month. After a successful reservation, it sends an e-mail to the user via the first microservice.

STATIC TEMPLATE was used in the development of the application: https://bootstrapmade.com/demo/Restaurantly/; as well as a convertor to json: https://csvjson.com/csv2json
