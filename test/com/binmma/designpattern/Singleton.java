package com.binmma.designpattern;

/**
 * 单例设计模式
 * @author mabin
 *单例模式特点：
 *1、单例类只能有一个实例。
 *2、单例类必须自己创建自己的唯一实例。
 *3、单例类必须给所有其他对象提供这一实例。
 * 单例模式保证了全局对象的唯一性，比如系统启动读取配置文件就需要单例保证配置的一致性。
 * 
 * 单例即只有一个队像，那么不能随意创建对象-》构造器私有
 * 构造器私有外部想获取对象-》提供获取对象的方法instance -》外部调用没有对象必须为类属性static
 * 对象实例化不能直接写在instance中-》需要类属性Singleton 创建对象
 * 
 * 当类较大时jvm加载类较慢，此时若调用类中方法需要再实例化 单例模式就破坏了
 * 解决方式：
 * 懒汉式加载，需要获取对象时通过instance方法实例化对象
 * 		    懒汉式线程不安全（当两个线程同时获取对象时会实例化两个对象）
 * 			解决方式：加锁，直接加锁，每次获取对象都要等待锁释放高并发时阻塞严重
 * 					  解决方式： DCL 双检查锁机制 只有第一次并发实例化时需要获取锁
 *
 */
public class Singleton {
	private Singleton(){
		init();//初始化对象信息
		System.out.println("Singleton...被加载了");
	};
	private static Singleton singleton ;
	
	public static Singleton instance(){
		if(singleton ==null){//DCL双检查锁机制（DCL：double checked locking）
			synchronized(Singleton.class){
				if(singleton ==null){
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
	private void init(){
		System.out.println("Singleton...cz");
	}
}
