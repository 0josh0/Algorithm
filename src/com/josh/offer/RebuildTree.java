package com.josh.offer;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
 * 根据前序遍历和中序遍历重构二叉树
 * 递归
 */
public class RebuildTree {

	@Test
	public void test() {
		int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		RebuildTree r = new RebuildTree();
		Tree root = new Tree(preOrder[0]);
		r.helper(root, 0, preOrder.length - 1, preOrder, 0, inOrder.length - 1, inOrder);
		// 输出按层节点
		Queue<Tree> q = new LinkedList<Tree>();
		q.add(root);
		while (!q.isEmpty()) {
			Tree node = q.poll();
			System.out.print(node.value + "  ");
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
	}

	public void helper(Tree root, int pLeft, int pRight, int[] preOrder, int iLeft, int iRight, int[] inOrder) {

		int pos = -1;//记录根节点位置
		for (int i = iLeft; i <= iRight; i++) {//在中序遍历中找到根节点位置
			if (inOrder[i] == root.value) {
				pos = i;
				break;
			}
		}
		//生成左子树
		if (iLeft < iRight && pos > iLeft) {
			Tree leftChild = new Tree(preOrder[pLeft + 1]);
			root.left = leftChild;
			int leftLen = pos - iLeft;
			helper(root.left, pLeft + 1, pLeft + leftLen, preOrder, iLeft, pos - 1, inOrder);
		}
		//生成右子树
		if (iLeft < iRight && pos < iRight) {
			Tree rightChid = new Tree(preOrder[pLeft + pos - iLeft + 1]);
			root.right = rightChid;
			int rightLen = iRight - pos;
			helper(root.right, pRight - rightLen + 1, pRight, preOrder, pos + 1, iRight, inOrder);
		}

	}
}
