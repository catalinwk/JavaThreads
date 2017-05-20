
/**
 * This application makes use of MyTimerThread class
 * @author Catalin Mazilu
 *
 */
public class MyTimerThreadApplications {

	
	public static void main(String args[]){
		MyTimerThread th1 = new MyTimerThread("counter 1",3);
		MyTimerThread th2 = new MyTimerThread("counter 2",1);
		
		try {
		
			th1.join();
		} 
		catch (InterruptedException e){
			System.out.println(th1.getName() + " has terminated");
		}
		
		System.out.println("main thread has terminated");
	}
}
