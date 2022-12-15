# hotelManagementConsole

Entities in this Application are:
	1)Customer
	2)Waiter
	3)Manager
	4)Cashier
	5)KitchenOrderTaker

		In this Application I have 5 entities(persons) as mentioned above. The following are their works and use cases.Here every entity has unique id for traversing , along with a name.
1)Customer:
	The Customer is just the person who comes to restaurant to Eat.His works are,
		->Calls a waiter
		->Ask for Available food
		->Places Order
		->Pays Bill
		->Raise Issue

2)Waiter:
	Waiter is the person who works for this restaurant as a food server , order taker etc….His works are,
		->DisplayMenu
		->takesOrder
		->CollectBillFromCashier

3)Manager:
	Manager is a person who manages all the activities in the restaurant.His works are,
		->he will be assigned with some waiter_id’s
		->He will handle with any issues with his waiter’s customer

4)Cashier:
	The Cashier is the person who sits in the billCounter for paying the bill. His works are ;
		->Generate Bill
		->CollectMoney

5)KitchenOrderTaker:
	Kitchen order taker also the chef is one who gets the order and prepares the food.His works are;
		->Orders from waiter(Prepares food).


—>Extra classes:
	->Order(Which has the ordered food details)
	->Items(which has the food name, price and specifications)
	->Menu(it has the total menus of what are the available foods)
