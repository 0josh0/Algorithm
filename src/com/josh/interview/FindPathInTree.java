/**
 * 
 */
package com.josh.interview;

import java.util.Iterator;
import java.util.Stack;

import org.junit.Test;

/**
 * @Title: FindPathInTree
 * @Description:TODO
 * @author Summer
 * @date 2016年9月17日 下午10:26:00
 * 
 */
public class FindPathInTree {

	@Test
	public void test() {
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(12);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(7);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;

		findPath(n1, 22);
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void findPath(TreeNode root, int except) {
		if (root == null)
			return;
		int curSum = 0;
		Stack<Integer> path = new Stack<Integer>();
		helper(root, except, curSum, path);
	}

	public void helper(TreeNode node, int except, int curSum, Stack<Integer> path) {
		curSum += node.val;
		path.push(node.val);
		boolean isLeaf = (node.left == null && node.right == null);
		if (curSum == except && isLeaf) {
			// 输出路径
			Iterator<Integer> it = path.iterator();
			while (it.hasNext()) {
				System.out.print(it.next() + "  ");
			}
		}
		// 如果不是叶子节点或者和不等于except，递归左右子树
		if (node.left != null) {
			helper(node.left, except, curSum, path);
		}
		if (node.right != null) {
			helper(node.right, except, curSum, path);
		}
		// 返回父亲节点前弹出路径
		path.pop();
	}
}
