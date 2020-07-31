class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def __str__(self):
        return "[{}, {}]".format(self.val, self.next)


class LinkList:

    @staticmethod
    def single_list(length: int) -> ListNode:
        head = ListNode(1)
        cursor = head
        for i in range(2, length + 1):
            node = ListNode(i)
            cursor.next = node
            cursor = cursor.next
        return head


def show_list(head):
    string = ""
    cursor = head
    while cursor:
        string += str(cursor.val) + " -> "
        cursor = cursor.next
    print(string + "None")
