class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while (true) {
            // Find the k-th node
            ListNode kth = prevGroup;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // If less than k nodes remain, stop
            if (kth == null) {
                break;
            }

            ListNode groupStart = prevGroup.next;
            ListNode nextGroup = kth.next;

            // Reverse the group
            ListNode prev = nextGroup;
            ListNode curr = groupStart;

            while (curr != nextGroup) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect reversed group
            prevGroup.next = kth;
            prevGroup = groupStart;
        }

        return dummy.next;
    }
}
