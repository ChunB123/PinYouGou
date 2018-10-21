package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author YaphetS
 * @date 2018/10/20 10:01 AM
 */
public class ThirdThread  {

	public static void main(String[] args){

		ThirdThread thirdThread=new ThirdThread();

		FutureTask<Integer> task=new FutureTask(new Callable() {
			@Override
			public Object call() throws Exception {

				int i=0;
				for(;i<100;i++){
					System.out.println(
							Thread.currentThread().getName()+" 循环变量的值"+i);
				}

				return i;
			}
		});

		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" 循环变量的值"+i);
			if(i==20){
				new Thread(task,"有返回值的线程").start();
			}
		}

		try{
			System.out.print("子线程的返回值"+task.get());
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
