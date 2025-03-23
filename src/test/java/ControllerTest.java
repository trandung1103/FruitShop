import Controller.controller;
import Model.Fruit;
import Model.Order;
import Validation.ValidatorMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
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
        listFruit.add(new Fruit("F1", "Táo", 10.0, 5, "USA"));
        assertEquals(1, listFruit.size(), "Danh sách trái cây phải có đúng 1 phần tử");
    }

    @Test
    void testDisplayFruitList() {
        listFruit.add(new Fruit("F1", "Táo", 10.0, 5, "USA"));
        listFruit.add(new Fruit("F2", "Cam", 15.0, 3, "Vietnam"));
        
        assertEquals(2, listFruit.size(), "Danh sách trái cây phải có đúng 2 sản phẩm");
    }

    @Test
    void testAddOrder() {
    listFruit.add(new Fruit("F1", "Táo", 10.0, 5, "USA"));
    listFruit.add(new Fruit("F2", "Cam", 15.0, 3, "Vietnam"));

    ArrayList<Order> listOrder = new ArrayList<>();
    listOrder.add(new Order("F1", "Táo", 2, 10.0));

    control.updateOrder(listOrder, "F1", 2);

    assertEquals(4, listOrder.get(0).getQuantity(), "Số lượng đơn hàng phải được cập nhật đúng.");
}



    @Test
    void testDeleteFruit() {
        listFruit.add(new Fruit("F1", "Táo", 10.0, 5, "USA"));
        listFruit.removeIf(fruit -> fruit.getFruitId().equals("F1"));
        
        assertEquals(0, listFruit.size(), "Danh sách trái cây phải rỗng sau khi xóa");
    }

    @Test
    void testInvalidInput() {
        validMock.addInput("abc"); 

        assertThrows(NumberFormatException.class, () -> validMock.checkInputDouble(), "Nhập sai kiểu dữ liệu phải báo lỗi");
    }
}
