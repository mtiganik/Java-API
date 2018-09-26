package hw2.model;

public class Order {
    private static long idCounter = 1000;

    private long id;
    private String orderNumber;

    public Order(){
        this.id = idCounter++;
    }

    public long getId(){ return this.id;}

    public String getOrderNumber(){ return this.orderNumber;}

    public void setId(long id){this.id = id;}

    public void setOrderNumber(String orderNumber){this.orderNumber = orderNumber;}
}
