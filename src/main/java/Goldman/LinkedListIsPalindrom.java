package Goldman;

import java.util.Stack;

public class LinkedListIsPalindrom {

    public static void main(String args[])
    {
        Nod one = new Nod(1);
    Nod two = new Nod(2);
    Nod three = new Nod(3);
    Nod four = new Nod(4);
    Nod five = new Nod(3);
    Nod six = new Nod(2);
    Nod seven = new Nod(1);
    one.ptr = two;
    two.ptr = three;
    three.ptr = four;
    four.ptr = five;
    five.ptr = six;
    six.ptr = seven;
    boolean condition = isPalindrome(one);
        System.out.println("isPalidrome :" + condition);
}
    static boolean isPalindrome(Nod head)
    {

        Nod slow = head;
        boolean ispalin = true;
        Stack<Integer> stack = new Stack<Integer>();

        while (slow != null) {
            stack.push(slow.data);
            slow = slow.ptr;
        }

        while (head != null) {

            int i = stack.pop();
            if (head.data == i) {
                ispalin = true;
            }
            else {
                ispalin = false;
                break;
            }
            head = head.ptr;
        }
        return ispalin;
    }
}

class Nod {
    int data;
    Nod ptr;
    Nod(int d)
    {
        ptr = null;
        data = d;
    }
}
