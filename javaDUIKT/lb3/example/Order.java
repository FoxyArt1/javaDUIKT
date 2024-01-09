public class Order {
    private int orderId;
    private List<Product> products;
    private String status;
    public Order(int orderId, List<Product> products, String status) {
        this.orderId = orderId;
        this.products = products;
        this.status = status;
    }
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }
}
