/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Validation.validator;

/**
 *
 * @author hoang
 */
public class Menu {

    validator valid = new validator();

    public int menu() {
        //loop until user want to exit
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = valid.checkInputIntLimit(1, 4);
        return choice;
    }
}
