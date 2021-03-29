"""
Yang Rong Individual Service
All Rights Reserved @2021

二叉树、二叉搜索树相关操作实现。

@author: Yang Rong
@version 1.0
@email: samyang3125c@gmail.com
@create: 2021-03-29
"""


class TreeNode:
    """
    树节点。
    """

    def __init__(self, val, left, right):
        """
        实例化树节点。
        :param val: 节点的值。
        :param left: 左子节点。
        :param right: 右子节点。
        """
        self.val = val
        self.left = left
        self.right = right


class BinaryTree:
    """
    二叉树数据结构。
    """

    def __init__(self, root):
        """
        实例化二叉树。
        :param root: 根节点。
        """
        self.root = root

    def preorder_traversal(self, node, func):
        """
        前序遍历。
        :param node: 当前节点。
        :param func: 处理函数。
        :return: None
        """
        if not node:
            return
        func(node.val)
        self.preorder_traversal(node.left, func)
        self.preorder_traversal(node.right, func)

    def inorder_traversal(self, node, func):
        """
        中序遍历。
        :param node: 当前节点。
        :param func: 处理函数。
        :return: None
        """
        if not node:
            return
        self.inorder_traversal(node.left, func)
        func(node.val)
        self.inorder_traversal(node.right, func)

    def postorder_traversal(self, node, func):
        """
        后序遍历。
        :param node: 当前节点。
        :param func: 处理函数。
        :return: None
        """
        if not node:
            return
        self.postorder_traversal(node.left, func)
        self.postorder_traversal(node.right, func)
        func(node.val)

    def depth_fist_search(self, node, func):
        """
        左视的深度优先遍历。
        :param node: 当前节点。
        :param func: 处理函数。
        :return: None
        """
        if not node:
            return
        stack = []
        stack.insert(0, node)
        while stack:
            curr = stack.pop(0)
            func(curr.val)
            if curr.right:
                stack.insert(0, curr.right)
            if curr.left:
                stack.insert(0, curr.left)
        return

    def width_fist_search(self, node, func):
        """
        左视的广度优先遍历。
        :param node: 当前节点。
        :param func: 处理函数。
        :return: None
        """
        if not node:
            return
        queue = []
        queue.insert(0, node)
        while queue:
            curr = queue.pop(-1)
            func(curr.val)
            if curr.left:
                queue.insert(0, curr.left)
            if curr.right:
                queue.insert(0, curr.right)
        return


class BinarySearchTree(BinaryTree):
    """
    二叉搜索树数据结构。
    """

    def find(self, data):
        """
        查找值为 data 的节点。
        :param data: 要查找的目标值。
        :return: TreeNode
        """
        p = self.root
        while p:
            if data < p.val:
                p = p.left
            elif data > p.val:
                p = p.right
            else:
                return p
        return None

    def insert(self, data):
        """
        插入值为 data 的节点。
        :param data: 要插入的节点的值。
        :return: None
        """
        if not self.root:
            self.root = TreeNode(data, None, None)
            return
        p = self.root
        while p:
            if data < p.val:
                if not p.left:
                    p.left = TreeNode(data, None, None)
                    return
                p = p.left
            else:
                if not p.right:
                    p.right = TreeNode(data, None, None)
                    return
                p = p.right
        return

    def delete(self, data):
        """
        删除值为 data 的节点。
        :param data: 要删除的节点的值。
        :return: None
        """
        # 先定位要删除的节点位置。
        p = self.root
        pp = None
        while p and p.val != data:
            pp = p
            if data < p.val:
                p = p.left
            else:
                p = p.right
        if not p:
            # 没有找到要删除的节点，直接返回。
            return
        # 要删除的节点有两个子节点。
        if p.left and p.right:
            # 查找右子树中最小节点。
            min_p = p.right
            min_pp = p
            while min_p.left:
                min_pp = min_p
                min_p = min_p.left
            # 做一些处理，复用后续逻辑，删除替换后的多余节点。
            p.val = min_p.val
            p = min_p
            pp = min_pp
        # 删除节点，它是一个叶子节点或者仅有一个子节点。
        # 获取 child 指针。
        if p.left:
            child = p.left
        elif p.right:
            child = p.right
        else:
            child = None
        # 做节点的删除操作。
        if not pp:
            # 判断是否为根节点。
            self.root = child
        elif pp.left == p:
            pp.left = child
        else:
            pp.right = child


if __name__ == '__main__':
    # 初始化一个测试树。
    node4 = TreeNode(4, None, None)
    node5 = TreeNode(5, None, None)
    node6 = TreeNode(6, None, None)
    node7 = TreeNode(7, None, None)
    node2 = TreeNode(2, node4, node5)
    node3 = TreeNode(3, node6, node7)
    node1 = TreeNode(1, node2, node3)
    # 测试前、中、后序遍历。
    tree = BinaryTree(node1)
    preorder = []
    tree.preorder_traversal(tree.root, preorder.append)
    print(preorder == [1, 2, 4, 5, 3, 6, 7])
    inorder = []
    tree.inorder_traversal(tree.root, inorder.append)
    print(inorder == [4, 2, 5, 1, 6, 3, 7])
    postorder = []
    tree.postorder_traversal(tree.root, postorder.append)
    print(postorder == [4, 5, 2, 6, 7, 3, 1])
    # 测试深度、广度遍历。
    depth = []
    tree.depth_fist_search(tree.root, depth.append)
    print(depth == [1, 2, 4, 5, 3, 6, 7])
    width = []
    tree.width_fist_search(tree.root, width.append)
    print(width == [1, 2, 3, 4, 5, 6, 7])
    # 初始化一个二叉搜索树。
    node11 = TreeNode(1, None, None)
    node33 = TreeNode(3, None, None)
    node55 = TreeNode(5, None, None)
    node77 = TreeNode(7, None, None)
    node22 = TreeNode(2, node11, node33)
    node66 = TreeNode(6, node55, node77)
    node44 = TreeNode(4, node22, node66)
    # 测试二叉搜索树查、增、删。
    bst = BinarySearchTree(node44)
    find_66 = bst.find(6)
    print(find_66.val == 6 and find_66.left == node55 and find_66.right == node77)
    bst.insert(8)
    print(node77.right.val == 8)
    bst.delete(8)
    print(node77.left is None and node77.right is None)
