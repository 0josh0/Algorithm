package com.josh.offer;
//����ģʽ - �̰߳�ȫд��
public class Singleton {

	private static Singleton instance=null;
	//˽�й��캯��
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
