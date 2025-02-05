INQUIRY / Задание


Потребители:
public class User () { // – описва различните видове ползватели

private UUID id;

private String username; // задължително при регистрация и логване

private String firstName; // не се изисква при регистрация, а само при редактиране на профила

private String lastName; //  не се изисква при регистрация, а само при редактиране на профила

private String profilePicture  //  не се изисква при регистрация, а само при редактиране на профила

private String email; // задължително при регистрация

private String password; // задължително при регистрация и логване

private String phone; // задължително при регистрация

private UserRole role; // admin, waiter, client, chef, bartender, caterer …. (енумерация) – client се въвежда автоматично от системата, останалите се променят ръчно от admin

private Country country; // това трябва да се премахне

private boolean isActive;

private LocalDateTime createdOn; // дата на регистрация, въвежда се автоматично от системата

private LocalDateTime updatedOn; // дата на промяна, въвежда се автоматично от системата

@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
@OrderBy("createdOn DESC")
private List<Order> orders = new ArrayList<>();

@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
@OrderBy("createdOn DESC")
private List<Massage> massages = new ArrayList<>();
}


Съставки:
public class Ingredient (){ //  описва наличностите в склада

private UUID Id;

private String ingredientName;

Double ingredientQuantity; - наличното количество в склада

LocalDateTime createdOn;

LocalDateTime updatedOn;
} 


Рецепта:
public class ProductIngredient (){

private UUID id;

@ManyToOne
private Product product;

private int quantity;

private LocalDateTime createdOn;

private LocalDateTime updatedOn;
}


Продукти:
public class Product { //– описва менюто (храни и напитки)

private UUID id;

private String productName; 

private Enum category; // soup, salad, appetizer, main course, dessert, soft drink, alcohol, others (енумерация)

private String description; // Кратко описание на продукта

@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
@OrderBy("createdOn DESC")
private List <ProductIngredient> productIngredient = new ArrayList<>(); // съдържа рецептата за продукта (съставка/количество)

private Text preparation; // начин на приготвяне;

private int grammage; // количество на една порция

private BigDecimal price;

private String picture;

private String productStatus; // available, out of stock,    (енумерация)

private LocalDateTime createdOn;

private LocalDateTime updatedOn;
}


Поръчки:
public class Order () { // описва поръчката

private UUID id;

@ManyToOne
private User user; // името на клиента (логнатия в системата)

private Enum orderStatus; // for execution, for payment, paid, for delivery, delivered (енумерация)

@OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
@OrderBy("createdOn DESC")
private List<Cart> carts = new ArrayList<>();

private BigDecimal price; // обща цена за поръчката

private String addressForDelivery; // може да се раздели на отделни позиции – град, квартал, улица ....

private int tableNumber; // номер ана масата (когато се обслужва от сервитьор)

private String note; //Коментар

private LocalDateTime createdOn;

private LocalDateTime updatedOn;
}


Количка:
public class Cart (){ // количка - временно съхранява продуктите от поръчката

private UUID id;

@ManyToOne
private Order order;

private Product product;

private int quantity;

private LocalDateTime createdOn;

private LocalDateTime updatedOn;
}


Съобщения:
public class Message () { // изпращане на съобщение от потребителя до системата

@ManyToOne
private User user; // името на клиента (логнатия в системата)

private String subject;

private Text messageText;

private Enum messageStatus; //written, read, replied, deleted 

private LocalDateTime createdOn;

private LocalDateTime updatedOn;
}


СТРАНИЦИ:
1.	Начална страница – яка реклама на кръчмата, с бутони за регистрация и логване
2.	Страница за логване - потребителско име и парола
3.	Страница за регистрация - userName, email, phone, password
4.	Страница за промяна на профила - съдържа цялата информация за профила
5.	Меню – общи приказки с линкове към отделни страници soup, salad, appetizer, main course, dessert, soft drink, alcohol, others
6.	  Soup – галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
7.	  Salad – галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
8.	  Appetizer – галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
9.	  Мain course – галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
10.	  Dessert – галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
11.	  Soft drink – галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
12.	  Alcohol - галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
13.	  Others - галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка / може и една връзка, а поръчката да става от страницата с подробностите. Тук се уточнява и количеството
14.	Поръчки (кошница) – списък на направените поръчки, бутон за потвърждение
15.	Форма за плащане / доставка
16.	Налични съставки в склада - само с достъп за admin
17.	Съставки в склада с намалено количество – за доставка - - само с достъп за admin
18.	Справка на поръчки за деня (или от дата до дата) - - само с достъп за admin
19.	Страница за готвача – показва списък на всички поръчки, които за в статус „за изпълнение“ – като кликнеш на тях показва рецептата (как се приготвя). Когато е готово – трябва да може ръчно да се променя статуса на “за плащане”
20.	Страница съобщение – потребителя пише съобщение
21.	Страница за четене и отговор на съобщение
22.	Модул за промяна на менюто – импортиране на продукти от json файл в базата данни. Страница, която да изтрива старата база данни за продукти (или само определени нейни елементи) и да добавя новите от json файл. Само с достъп за admin
23.	Страница за контакти
24.	Страница на администратора - съдържа всички данни на потребителя и връзки към страниците, достъпни само за admin.

ШАБЛОН: https://bootstrapmade.com/demo/Restaurantly/
Aко сменяме снимки - традиционна българска кръчма - тук: https://www.podlipitebg.com/galeriya
