package lab1;

public class Stop {
    // address (String), orderNumber (int), next (Stop), and previous (Stop).
    private String address;
    private int orderNumber;
    private Stop next;
    private Stop previous;

    public Stop(String address, int orderNumber) {
        this.address = address;
        this.orderNumber = orderNumber;
    }

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}
    public int getOrderNumber(){return orderNumber;}
    public void setOrderNumber(int orderNumber){this.orderNumber = orderNumber;}
    public Stop getPrevious(){return previous;}
    public void setPrevious(Stop previous){this.previous = previous;}
    public Stop getNext(){return next;}
    public void setNext(Stop next){this.next = next;}
    public String toString(){return String.format("[%s (#%d)]", getAddress(),getOrderNumber());}
}
