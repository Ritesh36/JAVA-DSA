public class FastAndSlowpointer {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;
    static Node tail;

    public static void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static boolean detectcycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHappy(int n) {
        int slow = square(n);
        int fast = square(square(n));
        while (slow != fast) {
            slow = square(slow);
            fast = square(square(fast));
        }
        return slow == 1;
    }

    public static int square(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String args[]) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        // head.next.next.next.next.next = head.next;
        // printList();
        // System.out.println(detectcycle(head));
        int n = 2;
        System.out.println(isHappy(n));
    }
}
