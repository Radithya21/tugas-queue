package demoqueue;

class Customer {
    private String name;
    private int orderNumber;

    public Customer(String name, int orderNumber) {
        this.name = name;
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', orderNumber=" + orderNumber + '}';
    }
}
