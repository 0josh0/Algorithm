package com.josh.task11;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
 * ���⣺���ͼ���Ƿ��л�
 * ������
 * 
 */
public class CourseSchedule {
	@Test
	public void test(){
		int[][] pre = {{1,0},{2,0},{3,1},{3,2}};
		System.out.println(canFinish(4,pre));
	}
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] in=new int[numCourses];//���ÿ���ڵ�����
		//int[] res = new int[numCourses];
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
			System.out.print(q+"  ");
			for(int i=0;i<prerequisites.length;i++){//����ͼ
				if(prerequisites[i][0]==q){//��ͼ���ҵ��������q(���Ϊ0�Ľڵ�)���ӵĽڵ㣬
					in[prerequisites[i][1]]--;//��ȼ�һ
					if(in[prerequisites[i][1]]==0) queue.add(prerequisites[i][1]);//�����һ֮�����Ϊ0�����
				}
			}
		}
		//����������飬������Ȳ�Ϊ0�ģ���ʾ�л�
		for(int i=0;i<in.length;i++){
			if(in[i]!=0) return false;
		}
		return true;
    }
}
