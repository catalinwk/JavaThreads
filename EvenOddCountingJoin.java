/**
 *  Two threads are counting odd and even numbers.
 *  We are using join to when thread termination 
 *  The main thread waits for child threads to terminate by checking their state regularly 
 */




/**
 * 
 * @author Catalin Mazilu
 * This application has 2 child threads - one that counts odd numbers, and one that counts even numbers
 */
public class EvenOddCountingJoin {

	public static void main(String args[]){
		System.out.println("Main thread has started");

		//creating Thread objects
		OddCountThread th1 = new OddCountThread("odd");
		EvenCountThread th2 = new EvenCountThread("even");
		
		//waiting for odd counting thread to terminate
		try {
			th1.getThread().join();
		} catch (InterruptedException e){
			System.out.println("Main thread interrupted");
		}
		
		System.out.println("main thread has passed join for " + th1.thrdName);
		
		//waiting 3 seconds for even counting thread to terminate
		try {
			th1.getThread().join(3000);
		} catch (InterruptedException e){
			System.out.println("Main thread interrupted");
		}
		System.out.println("main thread has passed join for " + th2.thrdName);
		
		
		//waiting for all threads to terminate
		do {
			try {
				Thread.sleep(100);
			} catch(InterruptedException e){
				System.out.println("Main thread has terminated");
			}
		} while (th1.getThread().isAlive() | th2.getThread().isAlive());
		
		System.out.println("Main has terminated");
	}
}
