package Validation;

import java.util.LinkedList;
import java.util.Queue;

public class ValidatorMock extends validator {
    private final Queue<String> inputQueue = new LinkedList<>();

    // Thêm giá trị giả lập vào danh sách
    public void addInput(String input) {
        inputQueue.add(input);
    }
    public void addInt(int input) {
        inputQueue.add(String.valueOf(input));
    }

    // Ghi đè checkInputString() để lấy dữ liệu từ danh sách thay vì Scanner
    @Override
    public String checkInputString() {
        return inputQueue.poll();  // Lấy dữ liệu giả lập từ danh sách
    }

    // Ghi đè checkInputInt() để lấy dữ liệu số nguyên từ danh sách
    @Override
    public int checkInputInt() {
        return Integer.parseInt(inputQueue.poll());
    }

    // Ghi đè checkInputDouble() để lấy dữ liệu số thực từ danh sách
    @Override
    public double checkInputDouble() {
        return Double.parseDouble(inputQueue.poll());
    }

    // Ghi đè checkInputYN() để lấy dữ liệu Y/N
    @Override
    public boolean checkInputYN() {
        return inputQueue.poll().equalsIgnoreCase("Y");
    }
}
