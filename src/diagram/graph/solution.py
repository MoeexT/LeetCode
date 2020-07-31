#! py -3

import sys
import heapq
from graph import graph_nodes, get_dis
from graph import Edge, Edges
from plot import plot_graph


Path = "src/diagram/graph/"
GraphEdges = {}
NodeInfo = {}
LengthI, LengthII = 0, 0


def generate_tree():
    nodes = graph_nodes()
    graph, root = [], nodes[0]

    # 中心供水站与一级供水站
    nodes.remove(root)
    graph.append(root)
    cur_node = root
    # 无奈的硬编码，找不到好办法-。-
    for i in range(12):
        next_node, next_dis = None, sys.maxsize
        for cur in graph:
            for nxt in nodes:
                if nxt.tag == 'V' and get_dis(cur, nxt)[1] < next_dis:
                    cur_node, next_node, next_dis = cur, nxt, get_dis(cur, nxt)[1]
        cur_node.next.append(next_node)
        graph.append(next_node)
        nodes.remove(next_node)
    graph.remove(root)
    # 一级供水站与二级供水站
    # curNode 是最小生成树中需要
    cur_node = root.next
    while len(graph) < 180:
        next_node, next_dis = None, sys.maxsize
        for cur in graph:
            for nxt in nodes:
                if get_dis(cur, nxt)[1] < next_dis:
                    cur_node, next_node, next_dis = cur, nxt, get_dis(cur, nxt)[1]
        cur_node.next.append(next_node)
        graph.append(next_node)
        nodes.remove(next_node)
    # print('graph size:', len(graph))
    return root


def dfs(root):
    """
    求两种管道的长度
    """
    global LengthI, LengthII
    if root is None:
        return
    for node in root.next:
        # print(node.name, end=', ')
        if root.tag == 'A' or (root.tag == 'V' and node.tag == 'V'):
            LengthI += get_dis(root, node)[1]
        else:
            LengthII += get_dis(root, node)[1]
        dfs(node)
    # print()


def dfs_edge(root):
    """
    将所有的边添加到一个字典里
    """
    global GraphEdges
    if root is None:
        print('None')
        return
    for node in root.next:
        t = get_dis(root, node)
        GraphEdges.update({t[0]: t[1]})
        dfs_edge(node)


def len_between_nodes():
    """
    计算每个P节点连接的II管道长度
    I级的应该忽略 A112V123
    """
    global NodeInfo

    def sblit(string):
        """
        将形如 "P13P127" 的字符串分割为 "P13", "P127"
        """
        assert len(string) > 1
        idx = 1
        while string[idx].isdigit():
            idx += 1
        return (string[:idx], string[idx:])

    for k, v in GraphEdges.items():
        for name in sblit(k):
            if name[0] == 'P':
                NodeInfo[name] = NodeInfo.get(name, 0) + v
    print(sorted(NodeInfo.items(), key=lambda item: item[1])[-10:])



def find_two_nodes():
    """
    错误！
    找到使II级水管长度最小化的两个节点
    ----------------------------
    入堆的时候加-号是当作大顶堆用，出来的时候再加负号就行了
    :return: 
    """
    heap = []
    heapq.heapify(heap)
    for k, v in Edges.items():
        if k[0] != 'A' and k.count('V') <= 1:
            heapq.heappush(heap, Edge(k, -v))
    
    top = heapq.heappop(heap)
    print(top.name + ':', -top.length)
    top = heapq.heappop(heap)
    print(top.name + ':', -top.length)



if __name__ == "__main__":
    tree = generate_tree()
    # dfs(tree)
    # print("I:", LengthI, "II:", LengthII)
    # plot_graph(tree, dgraph = True)
    # find_two_nodes()
    dfs_edge(tree)
    len_between_nodes()
