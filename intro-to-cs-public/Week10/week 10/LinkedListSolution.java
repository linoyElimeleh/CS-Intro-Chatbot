public class LinkedList {
    private Node head;

    // 1. Add a value to the end of the list
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // 2. Display all elements in the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 3. Find the length of the linked list
    public int length() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // 4. Search for a value in the list
    public boolean search(int target) {
        Node current = head;
        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 5. Delete the first occurrence of a value
    public void delete(int value) {
        if (head == null) return;

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // 6. Reverse the linked list
    public void reverse() {
        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    // 7. Find the middle element
    public int findMiddle() {
        if (head == null) throw new IllegalStateException("List is empty");

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    // 8. Merge two sorted linked lists
    public static LinkedList merge(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                mergedList.add(current1.data);
                current1 = current1.next;
            } else {
                mergedList.add(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            mergedList.add(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            mergedList.add(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }

    // Main method for testing (optional)
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Test add() and display()
        list.add(10);
        list.add(20);
        list.add(30);
        list.display(); // Output: 10 -> 20 -> 30 -> null

        // Test length()
        System.out.println("Length: " + list.length()); // Output: 3

        // Test search()
        System.out.println("Search 20: " + list.search(20)); // Output: true
        System.out.println("Search 40: " + list.search(40)); // Output: false

        // Test delete()
        list.delete(20);
        list.display(); // Output: 10 -> 30 -> null

        // Test reverse()
        list.reverse();
        list.display(); // Output: 30 -> 10 -> null

        // Test findMiddle()
        System.out.println("Middle Element: " + list.findMiddle()); // Output: 30

        // Test merge()
        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(3);
        list1.add(5);

        LinkedList list2 = new LinkedList();
        list2.add(2);
        list2.add(4);
        list2.add(6);

        LinkedList merged = LinkedList.merge(list1, list2);
        merged.display(); // Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
    }
}