/**
 * 
 */
package com.josh.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

/**
 * @Title: Graph
 * @Description:TODO
 * @author Summer
 * @date 2016年9月6日 下午10:31:04
 * 
 */
public class Graph {

	@Test
	public void test() {
		// 构造需要点对象
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		Node h = new Node("h");
		Edge ab = new Edge(a, b, 1);
		Edge ac = new Edge(a, c, 2);
		Edge ad = new Edge(a, d, 3);
		Edge ah = new Edge(a, h, 6);
		Edge bc = new Edge(b, c, 7);
		Edge de = new Edge(d, e, 3);
		Edge ef = new Edge(e, f, 4);
		Edge eg = new Edge(e, g, 8);
		Edge hg = new Edge(h, g, 2);

		// 建立它们的关系
		a.outGoing.add(ab);
		a.outGoing.add(ac);
		a.outGoing.add(ad);
		a.outGoing.add(ah);
		b.outGoing.add(bc);
		d.outGoing.add(de);
		e.outGoing.add(ef);
		e.outGoing.add(eg);
		h.outGoing.add(hg);

		Graph graph = new Graph();

		System.out.print("深度优先遍历： ");
		Set<Node> visited = new HashSet<Node>();
		graph.depathSearch(a, visited);
		System.out.println();

		System.out.print("广度优先遍历： ");
		graph.boardSearch(a);
		System.out.println();
	}

	// 深度优先遍历-递归解法
	public void depathSearch(Node cur, Set<Node> visited) {
		if (visited.contains(cur))
			return;
		visited.add(cur);
		System.out.print(cur.value + "  ");
		for (Edge edge : cur.outGoing) {
			depathSearch(edge.end, visited);
		}
	}

	// 深度优先遍历-非递归解法
	public void depathSearch2(Node cur, Set<Node> visited) {
		// Stack<Node> stack = new Stack<Node>();
		//
		// if (visited.contains(cur))
		// return;
		// visited.add(cur);
		// System.out.print(cur.value + " ");
		// for (Edge edge : cur.outGoing) {
		// depathSearch(edge.end, visited);
		// }
	}

	// 广度优先遍历-队列解法
	public void boardSearch(Node cur) {
		Set<Node> visited = new HashSet<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(cur);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (!visited.contains(node)) {
				visited.add(node);
				System.out.print(node.value + "  ");
				for (Edge edge : node.outGoing) {
					if (!visited.contains(edge.end))
						queue.add(edge.end);
				}
			}

		}
	}
}

// 用邻接链表存储图，定义节点
class Node {
	String value;// 节点名称
	List<Edge> outGoing;// 存储当前节点的所有出边

	public Node(String value) {
		this.value = value;
		outGoing = new ArrayList<Edge>();
	}
}

// 定义边
class Edge {
	Node start, end;// 边的起止节点
	int weight;// 边的权重

	public Edge(Node start, Node end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
