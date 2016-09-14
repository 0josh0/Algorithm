package com.josh.holiday;
/*
 * 题意：n个加油站构成一个环，gas[i]表示该加油站的储油量，cost[i]表示从当前加油站到i+1加油站需要消耗的油量
 *     返回能走一圈的第一个加油站
 * 分析：1、常规做法，超时
 *      2、总结一条规律，若A到不了D，则D之前的所有点都不能作为start，所以直接跳过
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int rest = 0,head=0,len=gas.length;
        while(head<len){
        	rest=gas[head]-cost[head];
        	if(rest>=0){//判断能否到达下一个加油站
        		boolean canReach = true;
            	for(int i=1,index=head+1;i<len;i++,index++){
            		rest=rest+gas[index%len]-cost[index%len];//计算到下一个加油站剩余的油量
            		if(rest<0){
            			canReach = false;
            			head=index;//跳过前面不能作为起始节点的加油站
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
