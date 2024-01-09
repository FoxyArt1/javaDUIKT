import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class OrderTest {

    private Order order;
    @Before
    public void setUp() {
        Map<Product, Integer> orderDetails = new HashMap<>();
        Product product1 = new Product("productUno", 10.0);
        Product product2 = new Product("productDos", 20.0);

        orderDetails.put(product1, 2);
        orderDetails.put(product2, 3);

        order = new Order(1, 123, orderDetails);
    }
    @Test
    public void testOrderConstructor() {
        assertEquals(1, order.getId());
        assertEquals(123, order.getUserId());
        assertEquals(5, order.getOrderDetails().size());
        assertEquals(0.0, order.getTotalPrice(), 0.001);
    }
    @Test
    public void testCalculateTotalPrice() {
        assertEquals(70.0, order.getTotalPrice(), 0.001);
    }
}
