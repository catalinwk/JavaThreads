/**
 * This application creates two thread classes 
 *  - one that counts even numbers
 *  - one that counts odd numbers
 *  The main thread waits for child threads to terminate by checking their state regularly 
 */



/**
 * 
 * @author Catalin Mazilu
 * this class creates a thread that counts even numbers
 */
class EvenCountThread implements Runnable {
	String thrdName;
	Thread thrd;
	
	EvenCountThread(String name){
		thrdName=name;
		 thrd = new Thread(this,thrdName);
		thrd.start();
	}
	
	public void run(){
		System.out.println("Even start counting");
		
	    for (int i=1; i<=10; i++){
	    	if (i%2==0)   //if is an even number
	    		System.out.println(thrdName + ": " + i);
	    	
		    try {
		    		Thread.sleep(1000); //sleep 1 second at each interation
		    } catch (InterruptedException e) {
		    		
		    		System.out.println(thrdName + " has terminated");
		    }
	    	
	    	
	    }//for
	    
	    //sleep 5 more seconds after output
	    try {
	    	Thread.sleep(5000); //sleep 1 second at each iteration
	    } catch (InterruptedException e) {
	    	System.out.println(thrdName + " has terminated");
	    }
	    
	    
	    System.out.println(thrdName + " has terminated");

	}//run method
	
	/**
	 * 
	 * @return reference to current thread
	 */
	public Thread getThread(){
		return thrd;
	}
}


/**
 * 
 * @author Catalin Mazilu
 * this class creates a thread that counts even numbers
 */
class OddCountThread implements Runnable {
	String thrdName;
	Thread thrd;
	
	OddCountThread(String name){
		thrdName=name;
		thrd = new Thread(this,thrdName);
		thrd.start();
	}
	
	public void run(){
		System.out.println("Odd start counting");
		
	    for (int i=1; i<=9; i++){
	    	if (i%2!=0) //if is an odd number
	    		System.out.println(thrdName + ": " + i);
	    	
		    try {
		    	Thread.sleep(1000); //sleep 1 second at each iteration
		    } catch (InterruptedException e) {
		    	System.out.println(thrdName + " has terminated");
		    }
	    	
	    	
	    }//for
	    
	    System.out.println(thrdName + " has terminated");

	}//run method
	
	/**
	 * 
	 * @return reference to current thread
	 */
	public Thread getThread(){
		return thrd;
	}
}


/**
 * 
 * @author Catalin Mazilu
 * This application has 2 child threads - one that counts odd numbers, and one that counts even numbers
 */
public class EvenOddCounting {

	public static void main(String args[]){
		System.out.println("Main thread has started");

		//creating Thread objects
		EvenCountThread th1 = new EvenCountThread("odd");
		OddCountThread th2 = new OddCountThread("even");
		
		//waiting for threads to terminate
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
