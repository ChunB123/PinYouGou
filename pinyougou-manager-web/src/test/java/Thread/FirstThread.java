package Thread;

/**
 * @author YaphetS
 * @date 2018/10/20 9:11 AM
 */
public class FirstThread extends Thread{

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName());
		}

	}
}
