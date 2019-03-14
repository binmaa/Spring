package com.binmma.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration(locations="classpath:spring-mvc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ThreadPool {
	
	@Autowired
	@Qualifier("threadPoolExcuter")
	private ThreadPoolExcuter pool;
	
	@Test
	public void start() throws InterruptedException{
		CountDownLatch latch = new CountDownLatch(1);
		Map<String, Map<String, String>> params = new HashMap<String,Map<String,String>>();
		for (int i = 0; i < 7; i++) {
			Map<String,String> bean = new HashMap<>();
			bean.put("key"+i, i+"");
			params.put("name_"+i, bean);
		}
		Map<String, Future<BackBean>> check = pool.check(params);
		Set<String> keySet = check.keySet();
		Iterator<String> iterator = keySet.iterator();
		
		List result = new ArrayList<String>();
		while(iterator.hasNext()){
			String next = iterator.next();
			Future<BackBean> future = check.get(next);
			BackBean backBean;
			try {
				backBean = future.get();//Callable接口和Future模式, 调用future接口的get方法, 会同步等待该future执行结束, 然后获取到结果
				result.add(backBean);
			} catch (InterruptedException | ExecutionException e) {
				result.add("节点"+next+"执行错误");
				e.printStackTrace();
			}
		}
		System.out.println(result.toString());
		
		Thread.currentThread().sleep(20*1000);
		Map<String, Future<BackBean>> check2 = pool.check(params);
		latch.await();
	}
	

}
@Service
class ThreadPoolExcuter implements InitializingBean{
	private ExecutorService executorService;
	 public Map<String, Future<BackBean>> check(final Map<String,Map<String,String>> params){
		 Set<String> keySet = params.keySet();
		 Iterator<String> iterator = keySet.iterator();
		 Map<String, Future<BackBean>> resultFutures = new HashMap<String, Future<BackBean>>();
		 while(iterator.hasNext()){
			 final String next = iterator.next();
			 Future<BackBean> submit = executorService.submit(new Callable<BackBean>() {
				 @Override
				 public BackBean call() throws Exception {
					 Thread.currentThread().sleep(1000);
					 Map<String, String> res = new HashMap<String,String>();
					 res.putAll(params.get(next));
					 if(StringUtils.equals("name_10", next)){
						 int i = 12/0;
					 }
					 return new BackBean(next, res);
				 }
			 });
			 //通过线程池提供的参数进行监控
			 ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;
			 long taskCount = pool.getTaskCount();//线程池需要执行的任务数量。
			 int activeCount = pool.getActiveCount();//获取活动的线程数。
			 int largestPoolSize = pool.getLargestPoolSize();//线程池里曾经创建过的最大线程数量。
			 long completedTaskCount = pool.getCompletedTaskCount();//线程池在运行过程中已完成的任务数量，小于或等于taskCount
			 int poolSize = pool.getPoolSize();//线程池的线程数量。
			 int size = pool.getQueue().size();//线程队列数量
			 System.out.println("--------------------------------------------------");
			 System.out.println(size+" :线程队列数量");
			 System.out.println(taskCount+" ：线程池需要执行的任务数量。");
			 System.out.println(activeCount+" ：获取活动的线程数。");
			 System.out.println(largestPoolSize+" ：线程池里曾经创建过的最大线程数量。");
			 System.out.println(completedTaskCount+" ：线程池在运行过程中已完成的任务数量，小于或等于taskCount。");
			 System.out.println(poolSize+" ：线程池的线程数量。");
			 System.out.println("--------------------------------------------------//r");
			 
			 resultFutures.put(next, submit);
		 }
		return resultFutures;
	 }

	@Override
	public void afterPropertiesSet() throws Exception {
//		executorService = Executors.newFixedThreadPool(10);
		executorService = Executors.newSingleThreadExecutor();
//		executorService = new ThreadPoolExecutor(10,14,30,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
		
	}
}
/**结果封装**/
class BackBean {
	public BackBean(){}
	public BackBean(String name,Map<String,String> map){
		this.name = name;
		this.result = map;
	}
	private String name;
	private Map<String,String> result;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getResult() {
		return result;
	}
	public void setResult(Map<String, String> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "BackBean [name=" + name + ", result=" + result + "]";
	}
	
}
class MyCallable implements Callable<BackBean>{

	@Override
	public BackBean call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}