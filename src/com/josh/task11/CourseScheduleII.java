package com.josh.task11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class CourseScheduleII {
	@Test
	public void test(){
		int[][] pre = {{1,0},{2,0},{3,1},{3,2}};
		int[] res = findOrder(4,pre);
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
		
	}
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] in=new int[numCourses];//���ÿ���ڵ�����
		int[] res = new int[numCourses];
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<prerequisites.length;i++){//��ʼ��in
			in[prerequisites[i][1]]++;
		}
		//����һ�����У����������Ϊ0�Ľڵ�ȫ�����
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<in.length;i++){
			if(in[i]==0) queue.add(i);
		}
		
		while(!queue.isEmpty()){
			int q = queue.poll();
			stack.push(q);
			//System.out.print(q+"  ");
			for(int i=0;i<prerequisites.length;i++){//����ͼ
				if(prerequisites[i][0]==q){//��ͼ���ҵ��������q(���Ϊ0�Ľڵ�)���ӵĽڵ㣬
					in[prerequisites[i][1]]--;//��ȼ�һ
					if(in[prerequisites[i][1]]==0) queue.add(prerequisites[i][1]);//�����һ֮�����Ϊ0�����
				}
			}
		}
		//����������飬������Ȳ�Ϊ0�ģ���ʾ�л�
//		for(int i=0;i<in.length;i++){
		if(stack.size()!=numCourses) return new int[0];
//		}
		int c=0;
		while(!stack.isEmpty()){
			res[c++]=stack.pop();
		}
		return res;
    }
}
