#! py -3

class UnionFind:
    """
    并查集的简单实现
    source: https://github.com/wolverinn/Iridescent/blob/master/Data%20Structure.md#union-find
    """
    def __init__(self, N) -> None:
        self.data = [i for i in range(N)]  # 元素的值
        self.parent = [i for i in range(N)]  # 元素父节点的下标
        self.size = [1 for i in range(N)]  # 以该元素为根的树的大小
        self.count = N  # 集合的个数
    
    def find(self, value):
        index = self.data.index(value)
        while self.parent[index] != index:
            index = self.parent[index]
        return index
    
    def union(self, val1, val2):
        root1, root2 = self.find(val1), self.find(val2)
        if root1 == root2:
            return
        if self.size[root1] > self.size[root2]:
            self.parent[root2] = root1
            self.size[root1] += self.size[root2]
        else:
            self.parent[root1] = root2
            self.size[root2] += self.size[root1]
        self.count -= 1

    def connected(self, val1, val2):
        return self.find(val1) == self.find(val2)
