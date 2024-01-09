public class Order {

    private int id;
    private int userId;
    private Map<Product, Integer> orderDetails;
    private double totalPrice;

    public Order(int id, int userId, Map<Product, Integer> orderDetails) {
        this.id = id;
        this.userId = userId;
        this.orderDetails = orderDetails;
        this.totalPrice = 0;

        for (Product product : orderDetails.keySet()) {
            total
