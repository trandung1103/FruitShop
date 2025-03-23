/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fruitshop;

import java.util.ArrayList;

/**
 *
 * @author DungTD
 */
public class Order {
    private String CustomerName;
    private ArrayList<Fruit> listOrders = new ArrayList<>();
    public Order(){
        
    }
    public Order(String CustomerName, ArrayList<Fruit> listOrders){
        this.CustomerName = CustomerName;
        this.listOrders = listOrders;
    }

    public String getCustomerName() {
        return CustomerName;
    }
    public ArrayList<Fruit> getListOrders() {
        return listOrders;
    }
    public Fruit checkFruitInOrder(Fruit fruit){
        for(Fruit fruits:getListOrders()){
            if(fruit.getFruitId().equalsIgnoreCase(fruits.getFruitId())){
                return fruits;
            }
        }
        return null;
    }
    public void addInOrder(Fruit f, int Quantity){
        Fruit x = checkFruitInOrder(f);
        if(x!=null){
            x.setFruitQuantity(x.getFruitQuantity()+Quantity);
        }else{
         
            listOrders.add(new Fruit(f.getFruitId(),f.getFruitName(),f.getFruitPrice(),f.getFruitQuantity(),f.getFruitOrigin()));
        }
    }
    
    public void showInOrder() {
        System.out.println("Danh sách các mặt hàng trong đơn hàng của " + CustomerName + ":");
        for (Fruit fruit : listOrders) {
            System.out.println("Mã: " + fruit.getFruitId() +
                               ", Tên: " + fruit.getFruitName() +
                               ", Giá: " + fruit.getFruitPrice() +
                               ", Số lượng: " + fruit.getFruitQuantity() +
                               ", Xuất xứ: " + fruit.getFruitOrigin());
        }
    }
    
}
