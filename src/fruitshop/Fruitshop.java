/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fruitshop;

/**
 *
 * @author DungTD
 */
public class Fruitshop {

    public validate vld = new validate();
    public BO bo = new BO();

    public void CreateFruit() {
        while (true) {
            try {
                String id = vld.inputString("enter id: ");
                if (bo.IdIsExist(id)) {
                    System.out.println("Fruit with the same ID already exist");
                    continue;
                }
                String name = vld.inputString("input name: ");
                double price = vld.inputDoubleMinMax("input double", 0, Double.MAX_VALUE);
                int quantity = vld.inputInt("Input quantity");
                String origin = vld.inputString("Enter origin: ");
                Fruit existingFruit = bo.findExistFruit(name, price, origin);
                if (existingFruit != null) {
                    System.out.println("Fruit existed");
                    String mergeOption = vld.inputString("Merge(Y/N): ");
                    if (mergeOption.equalsIgnoreCase("y")) {
                        existingFruit.setFruitQuantity(existingFruit.getFruitQuantity() + quantity);
                        System.out.println("Merge successfully");
                     
                        break;
                    }   
                    
                }
                Fruit newFruit = new Fruit(id, name, price, quantity, origin);
                bo.addFruit(newFruit);
                String option = vld.inputString("do you want to continue(Y/N): ");
                if (option.equalsIgnoreCase("n")) {
                    System.out.println("Add fruit successfully");
                    break;
                }
            } catch (Exception e) {
                System.out.println(" Fruit same id");
            }
        }
    }
    public int displayFruitList() {
        int countItem = 0;
        if(bo.getListFruit().isEmpty()){
            return -1;
        }
        for (Fruit f : bo.getListFruit()) {
            if (f.getFruitQuantity() != 0) {
                countItem++;

                if (countItem == 1) {
                    System.out.println("|++Item++|++FruitName++|++Origin++|++Price++|");
                }
                System.out.printf("%-5s%-10s%-14s%-10s%-5s", "", countItem, f.getFruitName(),
                        f.getFruitOrigin(), f.getFruitPrice());
                System.out.println("");
            }
        }
        if (countItem == 0) {
            return -1;
        }
        int input = vld.inputIntMinMax("Enter item : ", 0, countItem);
        return input;
    }

    public void ViewOrders(){
        if(bo.getListOrder().isEmpty()){
            System.out.println("No order: ");
            return;
        }
        for(Order o: bo.getListOrder()){
            System.out.println("Customer: "+ o.getCustomerName());
            bo.displayListOrder(o.getListOrders());
        }
    }
      public void Shopping() {
        Order o = new Order();
       while(true){
           int item = displayFruitList();
           if(item ==-1){
               System.out.println("Out of orders");
               break;
           }
           Fruit fruit =  bo.getItem(item);
           System.out.println("You selected"+fruit.getFruitName());
           int quantity = vld.inputInt("please input quantity: ");
           fruit.setFruitQuantity(fruit.getFruitQuantity()+quantity);
           System.out.println("The remaining fruitL "+fruit.getFruitQuantity()+"The taken"+quantity);
           o.addInOrder(fruit, quantity);
           String option = vld.inputString("continue(Y/N)");
           if(option.equalsIgnoreCase("y")){
               break;
           }continue;
       }
        if (o.getListOrders().isEmpty()) {
            System.out.println("No orders");
        } else {
            bo.displayListOrder(o.getListOrders());
            String name = vld.inputString("Input you name: ");
            Order order = new Order(name, o.getListOrders());
            bo.addOrder(order);
        }
    }

}
