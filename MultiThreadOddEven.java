import java.util.Random;
class NumberManager{
	private int generatedNumber;
	private boolean numberGenerated=false;
	public synchronized void generateNumber() {
	generatedNumber=new Random().nextInt(99)+2;
	System.out.println("Generated Random Number:"+generatedNumber);
	numberGenerated=true;
	notifyAll();
	}
	
	public synchronized void printEvenNumbers() throws InterruptedException {
		while(!numberGenerated  || generatedNumber %2!=0) {
			wait();
		}
		for(int i=2;i<=generatedNumber;i+=2) {
			System.out.println(i+" ");
			
		}
		numberGenerated=false;
	}
	public synchronized void printOddNumbers() throws InterruptedException {
		while(!numberGenerated  || generatedNumber %2==0) {
			wait();
		}
		for(int i=1;i<=generatedNumber;i+=2) {
			System.out.println(i+" ");
			
		}
		
		numberGenerated=false;
}
}


class NumberGenerator extends Thread{
	NumberManager numberManager;
	public NumberGenerator(NumberManager numberManager) {
		this.numberManager=numberManager;
	}
	public void run() {
		while(true) {
		numberManager.generateNumber();
		try {
			Thread.sleep(1000);	
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
}
class EvenPrinterThread extends Thread{
	NumberManager numberManager;
	public EvenPrinterThread(NumberManager numberManager) {
		this.numberManager=numberManager;
	}
	public void run() {
		while(true) {
			try {
				numberManager.printEvenNumbers();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
class OddPrinterThread extends Thread{
	NumberManager numberManager;
	public OddPrinterThread(NumberManager numberManager) {
		this.numberManager=numberManager;
	}
	public void run() {
		while(true) {
			try {
				numberManager.printOddNumbers();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
public class MultiThreadOddEven {

	public static void main(String[] args) {
		NumberManager numberManager=new NumberManager();
		NumberGenerator numberGenerator=new NumberGenerator(numberManager);
		EvenPrinterThread evenPrinterThread=new EvenPrinterThread(numberManager);
		OddPrinterThread oddPrinterThread=new OddPrinterThread(numberManager);
		numberGenerator.start();
		evenPrinterThread.start();
		oddPrinterThread.start();

	}

}
