package Thread;

/**
 * @author YaphetS
 * @date 2018/10/20 2:34 PM
 */
public class JoinThread extends Thread{

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName());
			if(i==20){
				FirstThread firstThread=new FirstThread();
				firstThread.start();
				try {
					firstThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName());
			if(i==20){
				JoinThread joinThread=new JoinThread();
				joinThread.start();
				joinThread.join();
			}

		}

	}
}
