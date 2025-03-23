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

    // 1️⃣ Test thêm trái cây vào danh sách
    @Test
    void testAddFruit() {
        listFruit.add(new Fruit("F1", "Táo", 10.0, 5, "USA"));
        assertEquals(1, listFruit.size(), "Danh sách trái cây phải có đúng 1 phần tử");
    }

    // 2️⃣ Test hiển thị danh sách trái cây
    @Test
    void testDisplayFruitList() {
        listFruit.add(new Fruit("F1", "Táo", 10.0, 5, "USA"));
        listFruit.add(new Fruit("F2", "Cam", 15.0, 3, "Vietnam"));
        
        assertEquals(2, listFruit.size(), "Danh sách trái cây phải có đúng 2 sản phẩm");
    }

    // 3️⃣ Test mua hàng với dữ liệu giả lập
    @Test
    void testBuyFruit() {
        listFruit.add(new Fruit("F1", "Táo", 10.0, 5, "USA"));

        // 🔹 Thêm dữ liệu giả lập: Chọn item 1, mua 2 quả, xác nhận Y, nhập tên "Hoang"
        validMock.addInput("1");   // Chọn Item số 1
        validMock.addInput("2");   // Mua số lượng 2
        validMock.addInput("Y");   // Xác nhận tiếp tục
        validMock.addInput("Hoang"); // Nhập tên khách hàng

        control.shopping(listFruit, listOrder);

        assertFalse(listOrder.isEmpty(), "Danh sách đơn hàng không được rỗng sau khi mua hàng");
        assertEquals(3, listFruit.get(0).getQuantity(), "Số lượng sản phẩm phải giảm sau khi mua");
    }

    // 4️⃣ Test xóa trái cây khỏi danh sách
    @Test
    void testDeleteFruit() {
        listFruit.add(new Fruit("F1", "Táo", 10.0, 5, "USA"));
        listFruit.removeIf(fruit -> fruit.getFruitId().equals("F1"));
        
        assertEquals(0, listFruit.size(), "Danh sách trái cây phải rỗng sau khi xóa");
    }

    // 5️⃣ Test kiểm tra đầu vào không hợp lệ
    @Test
    void testInvalidInput() {
        validMock.addInput("abc");  // Nhập giá trị sai

        assertThrows(NumberFormatException.class, () -> validMock.checkInputDouble(), "Nhập sai kiểu dữ liệu phải báo lỗi");
    }
}
