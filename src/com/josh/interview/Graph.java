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
 * @date 2016��9��6�� ����10:31:04
 * 
 */
public class Graph {

	@Test
	public void test() {
		// ������Ҫ�����
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

		// �������ǵĹ�ϵ
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

		System.out.print("������ȱ����� ");
		Set<Node> visited = new HashSet<Node>();
		graph.depathSearch(a, visited);
		System.out.println();

		System.out.print("������ȱ����� ");
		graph.boardSearch(a);
		System.out.println();
	}

	// ������ȱ���-�ݹ�ⷨ
	public void depathSearch(Node cur, Set<Node> visited) {
		if (visited.contains(cur))
			return;
		visited.add(cur);
		System.out.print(cur.value + "  ");
		for (Edge edge : cur.outGoing) {
			depathSearch(edge.end, visited);
		}
	}

	// ������ȱ���-�ǵݹ�ⷨ
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

	// ������ȱ���-���нⷨ
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

// ���ڽ�����洢ͼ������ڵ�
class Node {
	String value;// �ڵ�����
	List<Edge> outGoing;// �洢��ǰ�ڵ�����г���

	public Node(String value) {
		this.value = value;
		outGoing = new ArrayList<Edge>();
	}
}

// �����
class Edge {
	Node start, end;// �ߵ���ֹ�ڵ�
	int weight;// �ߵ�Ȩ��

	public Edge(Node start, Node end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
