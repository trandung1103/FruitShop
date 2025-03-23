 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Fruit;
import Model.Order;
import Validation.validator;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author hoang
 */
public class controller {

    validator valid = new validator();

    public void createFruitList(ArrayList<Fruit> listFruit) {
        while (true) {
            System.out.print("Enter fruit ID: ");
            String fruitID = valid.checkInputString();
            if (!valid.checkIdExist(listFruit, fruitID)) {
                System.err.println("ID existed");
                return;
            }
            System.out.print("Enter fruit name: ");
            String fruitName = valid.checkInputString();
            System.out.print("Enter price: ");
            double price = valid.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = valid.checkInputInt();
            System.out.print("Enter origin: ");
            String origin = valid.checkInputString();
            listFruit.add(new Fruit(fruitID, fruitName, price, quantity, origin));
            if (!valid.checkInputYN()) {
                return;
            }
        }
    }

    public void displayListOrder(ArrayList<Order> listOrder) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : listOrder) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(), order.getQuantity(), order.getPrice(), order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    public void displayListFruit(ArrayList<Fruit> listFruit) {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fruit : listFruit) {
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%-15.0f$\n", countItem++, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }

    public Fruit getFruitByItem(ArrayList<Fruit> listFruit, int item) {
        int countItem = 1;
        for (Fruit fruit : listFruit) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    public void viewOrder(HashMap<String, ArrayList<Order>> orderList) {
        for (String name : orderList.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> listOrder = orderList.get(name);
            displayListOrder(listOrder);
        }
    }
    //if order exist then update order
    public void updateOrder(ArrayList<Order> listOrder, String id, int quantity) {
        for (Order order : listOrder) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }
    public void shopping(ArrayList<Fruit> listFruit, HashMap<String, ArrayList<Order>> orderList) {
        if (listFruit.isEmpty()) {
            System.err.println("No item in shop ");
            return;
        }
        ArrayList<Order> listOrder = new ArrayList<>();
        while (true) {
            displayListFruit(listFruit);
            System.out.print("Enter item: ");
            int item = valid.checkInputIntLimit(1, listFruit.size());
            System.out.println("User selected item: " + item);
            Fruit fruit = getFruitByItem(listFruit, item);
            if (fruit == null) {
                System.err.println("Invalid item selection. Please try again.");
                continue;
            }
            System.out.print("Enter quantity: ");
            int quantity = valid.checkInputIntLimit(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity()-quantity);
            if(!valid.checkItemExist(listOrder, fruit.getFruitId())){
                updateOrder(listOrder, fruit.getFruitId(), quantity);
            }
            else {
                listOrder.add(new Order(fruit.getFruitId(), fruit.getFruitName(), quantity, fruit.getPrice()));
            }
            if(!valid.checkInputYN()){
                break;
            }
        }
        displayListOrder(listOrder);
        System.out.println("Enter name: ");
        String name = valid.checkInputString();
        orderList.put(name, listOrder);
        System.err.println("Add succesfull");
    }
}