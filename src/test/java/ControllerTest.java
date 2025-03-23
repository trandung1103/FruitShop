import Controller.controller;
import Model.Fruit;
import Model.Order;
import Validation.ValidatorMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private controller control;
    private ArrayList<Fruit> listFruit;
    private HashMap<String, ArrayList<Order>> listOrder;
    private ValidatorMock validMock;

    @BeforeEach
    void setUp() {
        control = new controller();
        listFruit = new ArrayList<>();
        listOrder = new HashMap<>();
        validMock = new ValidatorMock();
    }

    @Test
    void testAddFruit() {
        // Arrange
        Fruit fruit = new Fruit("F1", "Táo", 10.0, 5, "USA");

        // Act
        listFruit.add(fruit);

        // Assert
        assertEquals(1, listFruit.size(), "Danh sách trái cây phải có đúng 1 phần tử");
        assertEquals("F1", listFruit.get(0).getFruitId(), "ID trái cây không đúng");
    }

    @Test
    void testDisplayFruitList() {
        // Arrange
        listFruit.add(new Fruit("F1", "Táo", 10.0, 5, "USA"));
        listFruit.add(new Fruit("F2", "Cam", 15.0, 3, "Vietnam"));

        // Act & Assert
        assertEquals(2, listFruit.size(), "Danh sách trái cây phải có đúng 2 sản phẩm");
    }

    @Test
    void testAddOrder() {
        // Arrange
        listFruit.add(new Fruit("F1", "Táo", 10.0, 5, "USA"));
        ArrayList<Order> listOrder = new ArrayList<>();
        listOrder.add(new Order("F1", "Táo", 2, 10.0));

        // Act
        control.updateOrder(listOrder, "F1", 2);

        // Assert
        assertEquals(4, listOrder.get(0).getQuantity(), "Số lượng đơn hàng phải được cập nhật đúng.");
    }

    @Test
    void testDeleteFruit() {
        // Arrange
        listFruit.add(new Fruit("F1", "Táo", 10.0, 5, "USA"));

        // Act
        listFruit.removeIf(fruit -> fruit.getFruitId().equals("F1"));

        // Assert
        assertEquals(0, listFruit.size(), "Danh sách trái cây phải rỗng sau khi xóa");
    }

    @Test
    void testInvalidInput() {
        // Arrange
        validMock.addInput("abc");

        // Act & Assert
        assertThrows(NumberFormatException.class, () -> validMock.checkInputDouble(), "Nhập sai kiểu dữ liệu phải báo lỗi");
    }
}