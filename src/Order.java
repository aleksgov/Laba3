public class Order {
    private int orderId;
    private String customer;
    private double amount;
    private String status;

    public Order(int orderId, String customer, double amount, String status) {
        this.orderId = orderId;
        this.customer = customer;
        this.amount = amount;
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    @Override

    public String toString() {
        return "\nOrder{ "  +
                "orderId = " + orderId +
                ", customer = '" + customer + '\'' +
                ", amount = " + amount +
                ", status = '" + status + '\'' +
                " }";
    }
}
