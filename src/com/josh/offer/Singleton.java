package com.josh.offer;
//单例模式 - 线程安全写法
public class Singleton {

	private static Singleton instance=null;
	//私有构造函数
	private Singleton(){};
	
	public static Singleton getInstance(){
		if(instance==null){
			synchronized(Singleton.class){
				if(instance==null){
					instance=new Singleton();
				}
			}
		}
		return instance;
	}
}
