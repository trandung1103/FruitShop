/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import Controller.controller;
import Model.Fruit;
import Model.Order;
import View.Menu;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author hoang
 */
public class Main {

    public static void main(String[] args) {
        controller control = new controller();
        Menu newMenu = new Menu();
        ArrayList<Fruit> listFruit = new ArrayList<>();
        HashMap<String, ArrayList<Order>> listOrder = new HashMap<>();
        while (true) {
            int choice = newMenu.menu();
            switch (choice) {
                case 1:
                    control.createFruitList(listFruit);
                    break;
                case 2:
                    control.viewOrder(listOrder);
                    break;
                case 3:
                    control.shopping(listFruit, listOrder);
                    break;
                case 4:
                    return;
            }
        }
    }
}
