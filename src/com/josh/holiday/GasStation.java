package com.josh.holiday;
/*
 * ���⣺n������վ����һ������gas[i]��ʾ�ü���վ�Ĵ�������cost[i]��ʾ�ӵ�ǰ����վ��i+1����վ��Ҫ���ĵ�����
 *     ��������һȦ�ĵ�һ������վ
 * ������1��������������ʱ
 *      2���ܽ�һ�����ɣ���A������D����D֮ǰ�����е㶼������Ϊstart������ֱ������
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int rest = 0,head=0,len=gas.length;
        while(head<len){
        	rest=gas[head]-cost[head];
        	if(rest>=0){//�ж��ܷ񵽴���һ������վ
        		boolean canReach = true;
            	for(int i=1,index=head+1;i<len;i++,index++){
            		rest=rest+gas[index%len]-cost[index%len];//���㵽��һ������վʣ�������
            		if(rest<0){
            			canReach = false;
            			head=index;//����ǰ�治����Ϊ��ʼ�ڵ�ļ���վ
            			break;
            		}
            	}
            	if(canReach) return head;
        	}
        	head++;
        }
		return -1;
    }
}
