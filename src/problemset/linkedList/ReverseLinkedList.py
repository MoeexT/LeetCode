"""
problem 206
https://leetcode-cn.com/problems/reverse-linked-list/
反转一个单链表
"""

from utils.link_list import ListNode, LinkList, show_list


class Solution:
    # def reverseList(self, head: ListNode) -> ListNode:
    #     if head is None:
    #         return None
    #
    #     stack = []
    #     while head:
    #         stack.insert(0, head)
    #         head = head.next
    #
    #     res = stack[0]
    #     cursor = res
    #     for node in stack[1:]:
    #         cursor.next = node
    #         cursor = cursor.next
    #     cursor.next = None
    #
    #     return res
    def reverseList(self, head: ListNode) -> ListNode:
        p, rev = head, None
        while p:
            print("rev:", rev)
            print("p:", p)
            rev, rev.next, p = p, rev, p.next
            print("rev:", rev)
            print("p:", p)
            print('-----------------------')
        return rev


if __name__ == '__main__':
    list_head = LinkList.single_list(5)
    sol = Solution()
    res = sol.reverseList(list_head)


