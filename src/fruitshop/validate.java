/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitshop;

import java.util.Scanner;

/**
 *
 * @author DungTD
 */
public class validate {

    public final Scanner sc = new Scanner(System.in);

    public int inputInt(String msg) {
        System.out.println(msg);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (Exception e) {
                System.out.println("Please input number");
            }
        }
    }

    public String inputString(String msg) {
        System.out.println(msg);
        while (true) {
            try {
                String result = sc.nextLine().trim();
                return result;
            } catch (Exception e) {
                System.out.println("Please input string");
            }
        }
    }

    public int inputIntMinMax(String msg, int min, int max) {
        System.out.println(msg);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result > max || result < min) {
                    System.out.println("Please input in the range of " + min + " to " + max);
                    continue;
                }
                return result;
            } catch (Exception e) {
                System.out.println("Please input number");
            }
        }
    }

    public double inputDoubleMinMax(String msg, double min, double max) {
        System.out.println(msg);
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result > max || result < min) {
                    System.out.println("Please input in the range of " + min + " to " + max);
                    continue;
                }
                return result;
            } catch (Exception e) {
                System.out.println("Please input number");
            }
        }
    }
}
