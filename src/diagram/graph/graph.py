#! py -3
import csv
import sys

# 图的顶点
from functools import total_ordering


class Node:
    def __init__(self, tag, name, x, y):
        # 节点信息
        self.tag = tag  # 类型
        self.name = name  # 名称
        self.x = int(x)  # 坐标
        self.y = int(y)
        # 生成树相关信息
        self.next = []  # 相连的节点
        self.next_d = sys.maxsize  # 与相邻节点的距离

    def __str__(self):
        # "{type}:{x},{y} -{:.2f}-> {type}{x1}{y1}"
        if self.next is not None:
            """ return "{}:{},{} -[{:.2f}]-> {}:{},{}".format(
                self.name, self.x, self.y, self.next_d,
                self.next.name, self.next.x, self.next.y
            ) """
            return "{} -> {}".format(self.name, self.next)
        else:
            return "{}:{},{}".format(self.name, self.x, self.y)

    def __repr__(self):
        return "{}:({},{})".format(self.name, self.x, self.y)


@total_ordering
class Edge:
    def __init__(self, name, length):
        self.name = name
        self.length = length

    def __eq__(self, value):
        return self.length == value.length

    def __lt__(self, value):
        return self.length < value.length


def graph_edges():
    """
    图的各边，假设各个顶点均相连，有 n*(n-1)/2 条
    Edges的结构：
        {
            A-V1: xxx,
            A-V2: xxx,
            A-V10: 11.66,
            ...
            V12-P78: xxx
        }
    """
    edges = {}
    nodes = graph_nodes()
    # 添加I型管道
    for node in nodes:
        if node.tag == 'V':
            edges['A' + node.name] = distance(nodes[0], node)
    # 添加II型管道
    for i in range(1, len(nodes)):
        for j in range(i + 1, len(nodes)):
            n1, n2 = nodes[i].name, nodes[j].name
            edges[n1 + n2] = distance(nodes[i], nodes[j])
    # with open(Path + 'edges.txt', 'w') as f:
    #     for k, v in Edges.items():
    #         f.write(k + ': ' + str(round(v, 2)) + '\n')
    return edges


def graph_nodes():
    """
    返回全部节点
    """
    nodes = []
    with open(Path + "pipe.csv", 'rt') as csv_file:
        reader = csv.reader(csv_file, delimiter=',')
        for row in reader:
            nodes.append(Node(row[1][0], row[1], row[2], row[3]))
    return nodes


def distance(node1: Node, node2: Node):
    """
    计算两点间距离
    √[(x2-x1)^2+(y2-y1)^2]
    """
    return ((node1.x - node2.x) ** 2 + (node1.y - node2.y) ** 2) ** 0.5


def get_dis(node1, node2):
    """
    查表返回两点间距离
    """
    try:
        e = node1.name + node2.name
        d = Edges[e]
    except KeyError:
        e = node2.name + node1.name
        d = Edges[e]
    return (e, d)


# 全局变量
Path = "src/diagram/graph/"
Edges = graph_edges()
