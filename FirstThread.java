/**
 * This is my first thread class 
 * @author Catalin Mazilu
 * This application creates a thread that executes for about ten seconds
 * The main, parent thread executes for twenty seconds
 */
class MyFirstThread implements Runnable{

	String thrdName;
	
	/**
	 * This initialises the thread name
	 * @param name name of the thread
	 */
	MyFirstThread(String name){
		thrdName = name;
	}
	
	/**
	 * The entry point for the thread
	 */
	public void run(){
		//Showing a message when the thread starts
		System.out.println("The thread has started!");
		
		try {
			for (int count=0; count <10; count++){
				Thread.sleep(1000);
				System.out.println("Thread count is: " + count);
			}
		} 
		catch (InterruptedException e){
			System.out.println(thrdName + " Interrupted ");
		}
		
		System.out.println(thrdName + " terminating");
	}
}

public class FirstThread {

	public static void main(String args[]){
		System.out.println("Main thread executing");
		
		//construct a custom thread object
		MyFirstThread myThreadObject = new MyFirstThread("Child #1");
		
		//create a thread from custom thread object
		Thread myThrd = new Thread(myThreadObject); 
		
		//start execution of the thread
		myThrd.start();
		
		for (int i=0; i<10; i++){
			System.out.print(".");
			try {
				Thread.sleep(2000);
			} 
			catch(InterruptedException e){
				System.out.println("Main thread interrupted");
			}
		}
		
		System.out.println("Main thread ending.");
	}//main 
}

