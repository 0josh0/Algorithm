package com.josh.task11;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
 * 题意：检查图中是否有环
 * 分析：
 * 
 */
public class CourseSchedule {
	@Test
	public void test(){
		int[][] pre = {{1,0},{2,0},{3,1},{3,2}};
		System.out.println(canFinish(4,pre));
	}
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] in=new int[numCourses];//标记每个节点的入度
		//int[] res = new int[numCourses];
		for(int i=0;i<prerequisites.length;i++){//初始化in
			in[prerequisites[i][1]]++;
		}
		//声明一个队列，把所有入度为0的节点全部入队
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<in.length;i++){
			if(in[i]==0) queue.add(i);
		}
		while(!queue.isEmpty()){
			int q = queue.poll();
			System.out.print(q+"  ");
			for(int i=0;i<prerequisites.length;i++){//遍历图
				if(prerequisites[i][0]==q){//在图中找到与队列中q(入度为0的节点)链接的节点，
					in[prerequisites[i][1]]--;//入度减一
					if(in[prerequisites[i][1]]==0) queue.add(prerequisites[i][1]);//如果减一之后入度为0，入队
				}
			}
		}
		//遍历入度数组，若有入度不为0的，表示有环
		for(int i=0;i<in.length;i++){
			if(in[i]!=0) return false;
		}
		return true;
    }
}
