package com.josh.task2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class MaxPoints {

	@Test
	public void test(){
		Point p1 = new Point(-4,-4);
		Point p2 = new Point(-8,528);
		Point p3 = new Point(-3,3);
		Point p4 = new Point(-9,-651);
		Point p5 = new Point(9,591);
		Point[] points = {p1,p2,p3,p4,p5};
		
		maxPoints(points);
		
	}
	
	public int maxPoints(Point[] points) {
		int maxPointsNum = 2;
		if(points == null || points.length == 0){
			System.out.println("直线上的最多点数：0");
			return 0;
		}else if(points.length == 1){
			System.out.println("直线上的最多点数：1");
			return 1;
		}else{
			//存储所有直线的斜率
			double k = 0.0;
			float b = 0;
			List<Double> kList = new ArrayList<Double>();
			List<Float> bList = new ArrayList<Float>();
			Set<Integer> xSet = new HashSet<Integer>();
			List<Point> repeatPointList = new ArrayList<Point>();
			List<Integer> repeatPointFlag = new ArrayList<Integer>();
			List<Integer> repeatPointNum = new ArrayList<Integer>();
			//double rk = 0.0;
			//遍历所有点，求出所有直线的斜率
			for(int i=0;i<points.length;i++){
				int rpn = 0;
				for(int j=i+1;j<points.length;j++){
					if((points[i].x-points[j].x) == 0){//斜率不存在的情况。。。
						if(points[i].y == points[j].y){
							rpn++;
						}else{
							xSet.add(points[i].x);
						}
					}else{
						k = (double)(points[i].y-points[j].y)/(double)(points[i].x-points[j].x);
						b = (float) ((double)points[i].y - k*(double)points[i].x) ;
						if(k == -0.0){
							k = 0.0;
						}
						if(b == -0.0){
							b = 0;
						}
						kList.add(k);
						bList.add(b);
					}
				}
				if(rpn != 0){
					if(!repeatPointFlag.contains(points[i].x)){
						repeatPointList.add(points[i]);
						repeatPointFlag.add(points[i].x);
						repeatPointNum.add(rpn+1);
					}
				}
			}
			boolean[] flag = new boolean[kList.size()];
			for(int p=0;p<kList.size();p++){
				flag[p] = false;
			}
			int sameLineNum = 1;
			//while(a<kList.size() && flag[a] == false){
			for(int a=0;a<kList.size();a++){
				for(int c=a+1;c<kList.size();c++){
					if( kList.get(a).equals(kList.get(c)) && bList.get(a).equals(bList.get(c)) && !flag[c]){
						sameLineNum ++;
						flag[a] = true;
						flag[c] = true;
					}
				}
				//计算出kList.get(a)这条直线上的重复点个数Num(考虑一条直线上可能有多组重复点....)
				//sameLine = sameLine + Num*(Num-1)/2;
				for(int e=0;e<repeatPointList.size();e++){
					//判断重复点是否在斜率为kList.get(a)的直线上
					int y = (int) (kList.get(a)*repeatPointList.get(e).x + bList.get(a));
							//repeatPointList.get(e).y;
					if(y==repeatPointList.get(e).y){
						sameLineNum = sameLineNum + repeatPointNum.get(e)*(repeatPointNum.get(e)-1)/2;
					}
				}
				maxPointsNum = Math.max(maxPointsNum, (int) (1+Math.sqrt((1+8*sameLineNum)))/2);
				a++;
			}
  			//遍历所有点，计算斜率不存在的情况，在同一条直线上的点数
  			Iterator<Integer> xIt = xSet.iterator();
  			while(xIt.hasNext()){
  				int xPos = xIt.next();
  				int count = 0;
  				for(int q=0;q<points.length;q++){
  	  				if(points[q].x == xPos){
  	  					count++;
  	  				}
  	  			}
  				maxPointsNum = Math.max(maxPointsNum, count);
  			}
  			for(int e=0;e<repeatPointNum.size();e++){
				maxPointsNum = Math.max(maxPointsNum, repeatPointNum.get(e));
			}
			System.out.println("直线上的最多点数："+maxPointsNum);
			return maxPointsNum;
		}
    }
}
