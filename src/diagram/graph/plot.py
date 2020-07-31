#! py -3

import networkx as nx
from random import random
from matplotlib import pyplot as plt

from graph import get_dis, graph_nodes, Path


def plot_nodes(nodes):
    """
    绘图
    不同颜色绘出181个点（和边，现在还没完成）
    """
    fig = plt.figure(figsize=(10, 10))
    for i in range(len(nodes)):
        color, x, y = nodes[i].tag, nodes[i].x, nodes[i].y
        if color == 'A':
            plt.scatter(x, y, s=30, c='black')
        elif color == 'V':
            plt.scatter(x, y, s=20, c='red')
            plt.text(x, y, nodes[i].name, fontsize=7)
        else:
            assert color == 'P'
            plt.scatter(x, y, s=5, c='blue')
    # plt.savefig(Path + "nodes.png")
    plt.show()


def plot_line(G, root):
    if root is None:
        print('None')
        return
    for node in root.next:
        G.add_edge(root.name, node.name,
                   weight=round(get_dis(root, node)[1], 2))
        plot_line(G, node)


def plot_graph(root, dgraph=False):
    G = None
    if dgraph:
        G = nx.DiGraph()
    else:
        G = nx.Graph()
    fig = plt.figure(figsize=(50, 50))
    plot_line(G, root)
    position = {nd.name: [nd.x, nd.y] for nd in graph_nodes()}
    edge_labels = dict([((u, v,), d['weight'])
                        for u, v, d in G.edges(data=True)])
    # pos = nx.spring_layout(G, pos=position)
    nx.draw_networkx_edge_labels(G,
                                 width=3,
                                 font_size=8,
                                 font_color='#515A5A',
                                 pos=position,
                                 edge_labels=edge_labels,
                                 )
    colors = []
    for c in position:
        if c[0] == 'A':
            colors.append('#EF5350')
        elif c[0] == 'V':
            colors.append('#82E0AA')
        else:
            assert c[0] == 'P'
            colors.append('#5DADE2')

    nx.draw_networkx(G,
                     width=3,
                     font_size=10,
                     node_size=400,
                     font_color='#515A5A',
                     pos=position,
                     node_color=colors,
                     cmap=plt.cm.Blues,
                     edge_cmap=plt.cm.BuGn,
                     edge_color=[random.random() for i in range(len(G.edges))],
                     )
    plt.savefig(Path + 'dgraph.svg')
    # plt.show()
