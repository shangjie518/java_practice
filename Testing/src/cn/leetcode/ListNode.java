package cn.leetcode;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	ListNode() {
		this.val = 0;
	}

	ListNode reverseList(ListNode head) {
		ListNode newHead = new ListNode(-1);
		while (head != null) {
			ListNode tmp = head;
			tmp.next = newHead.next;
			newHead.next = tmp;
			head = head.next;
		}
		return newHead.next;
	}

	ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode rHead = new ListNode();
		ListNode newHead = new ListNode();
		ListNode cur = newHead;
		int count = 0;
		while (head != null) {
			count++;
			if (count == 1)
				newHead = head;
			if (count < m) {
				cur.next = head;
				head = head.next;
				cur = cur.next;

			} else if (count >= m && count <= n) {
				ListNode tmp = head;
				head = head.next;
				tmp.next = rHead.next;
				rHead.next = tmp;
				if (count == m)
					cur = rHead.next;
			} else if (count > n) {
				cur.next = head;
				head = head.next;
				cur = cur.next;
			}
		}
		newHead.next = rHead.next;
		return newHead;

	}

}
