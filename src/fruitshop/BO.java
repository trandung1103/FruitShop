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
public class BO {
    ArrayList<Fruit> listFruit = new ArrayList<>();
    ArrayList<Order> listOrder = new ArrayList<>();

    public ArrayList<Fruit> getListFruit() {
        return listFruit;
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }
    public void addFruit(Fruit fruit){
        listFruit.add(fruit);
    }
    public void addOrder(Order od){
        listOrder.add(od);
    }
    public Fruit getItem(int item){
        int count = 0;
        Fruit k;
        for(Fruit f: getListFruit()){
            if(f.getFruitQuantity()>0) {
                count++;
            }
            if(count==item){
                return null;
            }
        }
        return null;
    }
    public boolean IdIsExist(String id){
        for(Fruit fruit: listFruit){
            if(fruit.getFruitId().equals(id)){
                return true;
            }
        }
        return false;
    }
    public Fruit findExistFruit(String name,double price, String origin){
        for(Fruit fruit: listFruit){
            if(fruit.getFruitName().equals(name) && fruit.getFruitPrice()==price && fruit.getFruitOrigin().equals(origin)){
                return fruit;
            }
        }
        return null;
    }
     public void displayListOrder(ArrayList<Fruit> listOrder) {
        double total = 0;
        System.out.println("Product | Quantity | Price | Amount");
        for (Fruit f : listOrder) {
            System.out.printf("%-1s%-10s%-10s%-10s%-5s", "", f.getFruitName(), f.getFruitQuantity(), f.getFruitPrice(), f.getFruitPrice() * f.getFruitQuantity());
            System.out.println("");
            total += f.getFruitPrice() * f.getFruitQuantity();
        }
        System.out.println("Total : " + total);
    }
}
