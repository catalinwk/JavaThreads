/**
 * How to use syncronized methods with threading
 * @author Catalin Mazilu
 *
 */

public class SyncronizedMethods {
	
	public static void main(String args[]){
		
		System.out.println("Main thread started");
		
		//creating 2 label designers
		LabelDesigner labelDes1 = new LabelDesigner("Office 1");
		
		LabelDesigner labelDes2 = new LabelDesigner("Office 2");
		
		try {
			labelDes1.thrd.join();
			labelDes2.thrd.join();
		}
		catch (InterruptedException e){
			System.out.println("main thread has been terminated");
		}
		
	}
}

/**
 * Creates a Thermal Printer:
 * - has internal templates for labels (cand add new ones)
 * - has methods for printing
 * - when changing templates the object is locked by the working thread
 * @author Catalin Mazilu
 *
 */
class ThermalPrinter {
	String labelTemplate [] = new String[100]; //it can hold a maximum of 100 label templates
	int labelTemplateCounter = 0; //number of existing templates
	
	ThermalPrinter(){
	}
	
	//this method updates the label template library on the printer 
	synchronized public void addLabel(String name){
		System.out.println("Adding new label to printer");
		labelTemplate[labelTemplateCounter++]=name;
		
		try {
			//taking time to process operation 
			Thread.sleep(5000);
			
		}
		catch (InterruptedException e){
			System.out.println(Thread.currentThread().getName()+ " has terminated");
		}
	
	}
	
	
	public String toString(){
		String allLabels="";
		
		for (int i=0; i<labelTemplateCounter; i++){
			allLabels += labelTemplate[i];
			allLabels = (i>0 && (i+1) < labelTemplateCounter ) ?  allLabels+=", " : allLabels;  
		}
		return allLabels;
	}
	
}

/**
 * This class creates a Label Designer class with access to a Thermal Printer
 * @author Catalin Mazilu
 *
 */

class LabelDesigner implements Runnable {
	String name;
	Thread thrd;
	static ThermalPrinter myPrinter = new ThermalPrinter(); 
	
	LabelDesigner(String name){
		this.name=name;
		thrd=new Thread(this,name);
		thrd.start();
	}
	
	public void run(){
		//On initialization deploy labels to printer 
		
		myPrinter.addLabel(name+"_label");
		System.out.println(thrd.getName() + " label has been added");
	}
	
}
