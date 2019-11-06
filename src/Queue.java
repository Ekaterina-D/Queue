import java.util.Objects;
import java.util.PriorityQueue;

class Customer implements Comparable<Customer> {

    private String name;
    private boolean retiree;

    public Customer(String name, boolean retiree) {
        this.name = name;
        this.retiree = retiree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getRetiree() {
        return retiree;
    }

    public void setRetiree(boolean retiree) {
        this.retiree = retiree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return retiree == customer.retiree &&
                name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, retiree);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", retiree=" + retiree +
                '}';
    }

    @Override
    public int compareTo(Customer customer) {
        if (customer.getRetiree() == getRetiree()) {
            return 0;
        } else if (getRetiree()) {
            return -1;
        } else {
            return 1;
        }
    }
}

class CustomerQueue {

    public static void main(String[] args) {

        PriorityQueue<Customer> customerPriorityQueue = new PriorityQueue<>();

        customerPriorityQueue.add(new Customer("Petya", true));
        customerPriorityQueue.add(new Customer("Ivan", false));
        customerPriorityQueue.add(new Customer("Masha", true));
        customerPriorityQueue.add(new Customer("Vasya", false));

        while (!customerPriorityQueue.isEmpty()) {
            System.out.println(customerPriorityQueue.remove());
        }
    }

}