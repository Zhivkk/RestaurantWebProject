Потребители:
public class User – описва различните видове ползватели
UUID id;
String userName; - задължително при регистрация и логване
String firstName; - не се изисква при регистрация, а само при редактиране на профила
String lastName; -  не се изисква при регистрация, а само при редактиране на профила
String email; - задължително при регистрация и логване
String phone; - задължително при покупка (въвежда се във формата за доставка/плащане)
Enum userStatus; - active, inactive, deleted (енумерация); - въвежда се автоматично от системата
String position; - admin, user, waiter, client, chef, bartender, caterer …. (енумерация) – client се въвежда автоматично от системата, останалите се променят ръчно от admin
String photo; - връзка към снимка
LocalDateTime creationDate; - дата на регистрация, въвежда се автоматично от системата
LocalDateTime dateOfChange; - дата на промяна, въвежда се автоматично от системата

Съставки:
Public class Ingredient – описва наличностите в склада
UUID Id;
String ingredientName;
Double ingredientQuantity; - наличното количество в склада
LocalDateTime creationDate;
LocalDateTime dateOfChange;

Продукти:
public class Product – описва менюто (храни и напитки)
UUID id;
String productName; 
Enum category; - soup, salad, appetizer, main course, dessert, soft drink, alcohol, others (енумерация)
String description; - Кратко описание на продукта
Map (Ingredient, quantity) recipe – съдържа рецептата за продукта (съставка/количество)
Text preparation; - начин на приготвяне;
Double grammage; - количество на една порция
BigDecimal price;
String picture;
String productStatus; - available, out of stock,    (енумерация)
LocalDateTime creationDate;
LocalDateTime dateOfChange;

Поръчки:
public class Order – описва поръчката
User user; - името на клиента (логнатия в системата)
Enum orderStatus; - for execution, for payment, paid, for delivery, delivered (енумерация)
List (Product) order – списък с продуктите в поръчката
BigDecimal price; - обща цена за поръчката
String addressForDelivery; - може да се раздели на отделни позиции – град, квартал, улица ....
note;
LocalDateTime creationDate;
LocalDateTime dateOfChange;

Съобщения:
public class Message – изпращане на съобщение от потребителя до системата
User user; - името на клиента (логнатия в системата)
String subject;
Text messageText;
String messageStatus; written, read, replied, deleted 
LocalDateTime creationDate;
LocalDateTime dateOfAnswer;


СТРАНИЦИ:
1.	Начална страница – яка реклама на кръчмата
2.	Страница за логване
3.	Страница за регистрация
4.	Страница за промяна на профила
5.	Меню – общи приказки с линкове към отделни страници soup, salad, appetizer, main course, dessert, soft drink, alcohol
6.	Soup – галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
7.	Salad – галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
8.	Appetizer – галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
9.	Мain course – галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
10.	Dessert – галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
11.	Soft drink – галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
12.	Alcohol - галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
13.	Others - галерия със снимки на продуктите с две връзки на всяка снимка – за подробности и за поръчка
14.	Поръчки – списък на направените поръчки, бутон за потвърждение
15.	Форма за плащане / доставка
16.	Налични съставки в склада
17.	Съставки в склада с намалено количество – за доставка
18.	Справка на поръчки за деня (или от дата до дата)
19.	Страница за готвача – показва списък на всички поръчки, които за в статус „за изпълнение“ – като кликнеш на тях показва рецептата (как се приготвя). Когато е готово – трябва да може ръчно да се променя статуса на “за плащане”
20.	Страница съобщение – потребителя пише съобщение
21.	Страница за четене и отговор на съобщение
22.	Модул за промяна на менюто – импортиране на продукти от json файл в базата данни. Страница, която да изтрива старата база данни за продукти (или само определени нейни елементи) и да добавя новите от json файл.
23.	Страница за контакти

ШАБЛОН: https://bootstrapmade.com/demo/Restaurantly/
 




