public class User {

    private int id;
    private String username;
    private Map<Product, Integer> cart;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public void addProductToCart(Product product, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be non-negative");
        }

        if (product.getStock() < quantity) {
            throw new IllegalStateException("Not enough stock");
        }

        cart.put(product, quantity);
    }

    public void removeProductFromCart(Product product) {
        cart.remove(product);
    }

    public void updateProductQuantityInCart(Product product, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be non-negative");
        }

        cart.put(product, quantity);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", cart=" + cart +
                '}';
    }
}
