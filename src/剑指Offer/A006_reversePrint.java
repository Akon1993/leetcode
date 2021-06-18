package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class A006_reversePrint {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        int[] ints = reversePrint(node1);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int[] ints = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ints[size - 1 - i] = list.get(i);
        }
        return ints;
    }

}
