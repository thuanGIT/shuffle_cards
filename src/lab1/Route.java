package lab1;


public class Route {
    private Stop start,end;

    public Route(){
        start = end = null;
    }

    public String toString(){
        if (start == null)
            return "No stops on route";
        else {
            Stop current = start;
            String result = "";
            while (current!= null) {
                result+= current.toString() + "\n";
                current = current.getNext();
            }
            return result;
        }
    }

    public void addStart(String address, int orderNumber) {
        Stop temp = new Stop(address,orderNumber);
        if (start == null) {
            start = end = temp;
        } else {
            start.setPrevious(temp);
            temp.setNext(start);
            start = temp;
        }
    }

    public void addEnd(String address, int orderNumber) {
        Stop temp = new Stop(address,orderNumber);
        if (end == null) {
            start = end = temp;
        } else {
            end.setNext(temp);
            temp.setPrevious(end);
            end = temp;
        }
    }

    public void insert(String address, int orderNumber) {
        Stop temp = new Stop(address,orderNumber);

        Stop current = start;
        Stop prev = null;
        while (current != null && current.getAddress().compareToIgnoreCase(temp.getAddress()) < 0) {
            prev = current;
            current = current.getNext();
        }

        // Add at beginning
        if (prev == null) {
            addStart(address, orderNumber);
        } else if (current == null) { //end of linkedlist
            addEnd(address, orderNumber);
        } else {
            // Let the prev next refers to the new node
            prev.setNext(temp);
            // Let the current previous refers to new node
            current.setPrevious(temp);
            // Set previous of new node to prev and next of new node to current
            temp.setPrevious(prev);
            temp.setNext(current);
        }       
    }   
}
