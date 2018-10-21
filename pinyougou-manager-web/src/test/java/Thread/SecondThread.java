package Thread;

/**
 * @author YaphetS
 * @date 2018/10/20 9:33 AM
 */
public class SecondThread implements Runnable {


	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}


}
