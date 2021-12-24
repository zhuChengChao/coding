/**
 * 反转链表：
 *  reverseList：通过while遍历
 *  reverseRecursion：通过递归反转链表
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseLinkedList {

    /**
     * 正常流程反转链表
     * @param head
     * @return 反转后链表的头结点
     */
    public static ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode pre = null;
        ListNode temp = null;

        while (curr != null){
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    /**
     * 通过递归反转链表：反转指定的结点curr，并把反转后的结点返回
     * @param curr
     * @return
     */
    public static ListNode reverseRecursion(ListNode curr){
        if (curr.next == null){
            return curr;
        }

        // 递归的反转当前结点curr的下一个结点；
        ListNode pre = reverseRecursion(curr.next);
        // 把下一个节点的next指向当前节点，完成反转
        pre.next = curr;
        curr.next = null;
        return curr;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reverseList(node1);
        reverseRecursion(node1);
    }

}
