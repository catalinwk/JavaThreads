/**
 *  This class creates a timer that displays every second (using CPU time and sleep function) its name and remaining time
 *  Is is created not by implementing Runnable interface.
 *  We are extending Thread class
 *  @author Catalin Mazilu 
 */
public class MyTimerThread extends Thread {
	
	int seconds; //number of seconds to count (CPU seconds)
	
	MyTimerThread(String name, int seconds){
		super(name);
		
		this.seconds = seconds;
		
		this.start();
	}
	
	
	public void run(){
		
		//start counting
		while (seconds>0) {
			
			System.out.println(getName() + ": " + seconds);
			
			seconds--;//decreasing number of seconds passed
			
			try { 
				
				sleep(1000); //putting the timer to sleep 1 second before net iteration
			
			} 
			catch (InterruptedException e) {
			
				System.out.println(getName() + " has terminated");
			
			}
		}
	}
	
}
