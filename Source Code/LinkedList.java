
public class LinkedList {

    public Customer head;
    private int size;

    public LinkedList() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public void set(int j, Customer c) {
        Customer current = head;
        for (int i = 0; i < j; i++) {
            current = current.getNext();
        }
        //important: change data not pointers
        current.setName(c.getName());
        current.setPIN(c.getPIN());
        current.setBirthDate(c.getBirthDate());
        current.setFilename(c.getFilename());
        current.setSaveAcc(c.getSaveAcc());
        current.setCheqAcc(c.getCheqAcc());
        current.setCreditCard(c.getCreditCard());
    }

    public Customer get(int j) {
        Customer current = head;
        for (int i = 0; i < j; i++) {
            current = current.getNext();
        }
        return current;
    }

    public void add(Customer c) {
        if (size == 0) {
            head = c;
            head.setNext(c);
            head.setPrevious(c);
            c.setNext(head);
            c.setPrevious(head);
            size += 1;
        } else {
            Customer current = head;
            for (int i = 0; i < size - 1; i++) {
                current = current.getNext(); // for changing pointers
                //goes to end of loop
            }
            current.setNext(c);
            c.setPrevious(current);
            c.setNext(head); //circular linkedlist
            head.setPrevious(c);
            size += 1;
        }
    }

    public void remove(int j) {
        //note: if a file's status isn't a green checkmark, it may not be deleteable
        //this occurs a lot in testing, when a gui crashes but can't be closed
        //solution: close netbeans to end the gui (task manager isn't enough) and delete the files
        if (j == 0) {
            set(0, get(1));
            size--;
        } else {
            Customer current = head;
            for (int i = 0; i < j - 1; i++) {
                current = current.getNext();
                //goes to customer at j-1
                //if 1, it just stays at head
            }
            //set j-1 to go to j+1 next
            current.setNext(current.getNext().getNext());
            //set j+1 to go to j-1 previous (note current's next has been changed)
            current.getNext().setPrevious(current);
            size -= 1;
        }
    }
}
