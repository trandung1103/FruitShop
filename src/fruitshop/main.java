/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fruitshop;

/**
 *
 * @author DungTD
 */
public class main {
    public static void main(String[] args) {
        Order o = new Order();
        validate vld = new validate();
        Fruitshop fs = new Fruitshop();
        while(true){
            int choice  = vld.inputIntMinMax("input choice: ", 1, 4);
            switch(choice){
                case 1:{
                    fs.CreateFruit();
                    break;
                }
                case 2:{
                    fs.ViewOrders();
                    break;
                }
                case 3: {
                    fs.Shopping();
                    break;
                }
                case 4:{
                    System.exit(0);
                    break;
                }
            }
        }
    }
}
