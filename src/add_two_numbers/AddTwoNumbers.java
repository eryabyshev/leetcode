package add_two_numbers;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int inNext = 0;
        ListNode next = new ListNode();
        ListNode answer = next;

        while (true) {
            if(l1 == null && l2 == null) {
                if (inNext > 0) {
                    next.next = new ListNode();
                    next = next.next;
                    next.val = inNext;
                }
                return answer;
            }
            int temp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + inNext;
            inNext = temp > 9 ? 1 : 0;
            temp = temp > 9 ? temp % 10 : temp;
            next.val = temp;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            if (l1 != null || l2 != null) {
                next.next = new ListNode();
                next = next.next;
            }
        }
    }


    private static ListNode nodeFromArray(int... ar) {
        ListNode next = new ListNode();
        ListNode answer = next;
        for (int i = 0; i < ar.length; i++) {
            next.val = ar[i];
            if(i != ar.length - 1) {
                next.next = new ListNode();
                next = next.next;
            }
        }
        return answer;

    }

    private static List<Integer> intFromListNode(ListNode node) {
        List<Integer> result = new ArrayList<>();
        do {
            result.add(node.val);
            node = node.next;
        } while (node != null);
        return result;
    }



    public static void main(String[] args) {


        ListNode a = nodeFromArray(9,9,9,9,9,9,9);
        ListNode b = nodeFromArray(9,9,9,9);

        ListNode listNode = addTwoNumbers(a, b);

        List<Integer> integers = intFromListNode(listNode);

        int c = 0;


    }


}
