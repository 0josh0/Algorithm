package com.josh.holiday;

import org.junit.Test;

/*
 * ����: ������������ƽ���ϸ��ǵ����
 * ����: ����ص����������Ȼ�����������Ӽ�ȥ�ص�����
 */
public class RectangleArea {
	@Test
	public void test(){
		System.out.print(computeArea(-2,-2,2,2,-3,1,-1,3));
	}
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
       int overArea = over(A,B,C,D,E,F,G,H);
       int area1 = (C-A)*(D-B);
       int area2 = (G-E)*(H-F);
       return area1+area2-overArea;
    }
	//�������ص��ľ��ε����
    public int over(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(B>=H || F>=D || E>=C || A>=G) return 0;
        int bottomX=E,bottomY=0,topX=C,topY=0;
        if(B>F && A>=E){//�Ҳ����ƫ��
        	bottomX = A;
        	bottomY = B;
        }else if(B>F && A<E){
        	bottomX = E;
        	bottomY = B;
        }else if(B<=F && A>=E){
        	bottomX = A;
        	bottomY = F;
        }else if(B<=F && A<E){
        	bottomX = E;
        	bottomY = F;
        }
        if(D>H && G>=C){
        	topX=C;
        	topY=H;
        }else if(D>H && G<C){
        	topX=G;
        	topY=H;
        }else if(D<=H && G>C){
        	topX=C;
        	topY=D;
        }else if(D<=D && G<=C){
        	topX=G;
        	topY=D;
        }
        int area = (topX-bottomX)*(topY-bottomY);
        return area;
    }
}
