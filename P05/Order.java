import java.util.ArrayList;

public class Order {
    public Order(Customer customer) {
        this.customer = customer;
        this.orderNumber = nextOrderNumber++;
    }
    public void addComputer(Computer computer) {
        computers.add(computer);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order " + orderNumber + " for " + customer);
        for(Computer c : computers) sb.append("\n\n" + c);
        return sb.toString();
    }

    // WARNING: The equals method relies on a stable toString method
    //   that includes ALL significant fields to be compared
    // This includes the order in which Computer objects were added
    // A better implementation would sort field computers,
    //   which would require that Option implement Comparable
    // We'll leave that as a challenge for the enthusiastic student
    @Override
    public boolean equals(Object o) {
        try {
            if(this == o) return true;
            if(this.getClass() != o.getClass()) return false;
            Order c = (Order) o;
            if(!this.customer.equals(c.customer)) return false;
            if(this.computers.size() != c.computers.size()) return false;
            for(int i=0; i<this.computers.size(); ++i)
                if(!this.computers.get(i).equals(c.computers.get(i))) return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Customer customer;
    private long orderNumber;
    private ArrayList<Computer> computers = new ArrayList<>();
    
    private static long nextOrderNumber = 0;
}
