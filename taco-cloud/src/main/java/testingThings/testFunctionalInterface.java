package testingThings;

public class testFunctionalInterface {

	public static void main(String[] args) {

		Thread t1 = new Thread(new RunnableImpl());
		t1.start();
		
		new Runnable() {
			
			@Override
			public void run() {
				System.out.println("biko biko");
				
			}
		}.run();
	}

}
