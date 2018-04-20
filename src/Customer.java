public class Customer {
    private String Id;
    private String customerName;

    public Customer (String Id, String customerName){
        this.Id = Id;
        this.customerName = customerName;
    }

    public String getId() {
        return Id;
    }

    @Override
    public String toString()
    {
        return customerName;
    }

}
