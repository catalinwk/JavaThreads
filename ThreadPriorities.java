/**
 * This class demonstrates the use of thread priorities
 * - one thread displays * character
 * - one thread displays . character
 * 
 * They display it for 1000 times each let's see how they behave when we change priorities
 * @author Catalin Maziu
 *
 */
public class ThreadPriorities {

	public static void main(String args[]){
		CharacterThread th1 = new CharacterThread("thread 1",'*',1000);
		CharacterThread th2 = new CharacterThread("thread 2",'.',1000);
	
		th1.th.setPriority(Thread.NORM_PRIORITY+1);
		th1.th.start();
		th2.th.start();
	}
	
	
}

/**
 * This class creates a thread for displaying a character
 * @author Catalin Mazilu
 *
 */
class CharacterThread implements Runnable {
	String name; //thread name
			
	Thread th; //thread variable
	
	char ch; //character used for output
	
	int counter; //how many times to display
	
	
	CharacterThread(String name, char ch, int counter){
		this.name = name;
		this.ch = ch;
		this.counter = counter;
		
		th = new Thread(this); //creating a new thread
		
	}
	
	public void run() {
		
		while (counter >0 ){
			
			System.out.print(ch);
			
			counter--;
		}
	}
}