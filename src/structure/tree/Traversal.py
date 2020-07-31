#! py -3

class Node:
    val = 0
    left, right = None, None
    def __init__(self, x) -> None:
        self.val = x


def preorder(root: Node):
    if root is None:
        return []
    return [root.val] + preorder(root.left) + preorder(root.right)


def postorder_non_recursive(root: Node):
    """
    后续遍历 非递归
    把逆前序遍历（根-右-左）结果倒序，
    即为后序遍历结果
    """
    if not root:
        return []
    res, stack = [], []

    while res or stack:
        if root:
            res.append(root.val)
            stack.append(root)
            root = root.right
        else:
            root = stack.pop()
            root = root.left
    return res[::-1]

def postorder_non_recursive_stack(root: Node):
    """
    后续遍历 非递归
    """
    if not root:
        return []
    res, stack = [], [root]
    while stack:
        root = stack.pop()
        res.append(root)
        if root.left:
            stack.append(root.left)
        if root.right:
            stack.append(root.right)
    return res[::-1]

if __name__ == "__main__":
    preorder()
