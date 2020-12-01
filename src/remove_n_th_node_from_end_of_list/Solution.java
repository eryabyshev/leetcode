package remove_n_th_node_from_end_of_list;

import java.util.ArrayList;
import java.util.List;

public class Solution {

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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int lenght = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            lenght++;
        }
        if(lenght == 1 || lenght == 0) {
            return null;
        }
        if(n == lenght) {
            return head.next;
        }
        int posForRemove = lenght - n - 1;
        node = head;
        while (node.next != null && posForRemove > 0) {
            node = node.next;
            posForRemove--;
        }
        node.next = node.next.next;
        return head;
    }

    public static void main(String[] args) {

        System.out.println(intFromListNode(removeNthFromEnd(nodeFromArray(1), 1)));

    }
}
