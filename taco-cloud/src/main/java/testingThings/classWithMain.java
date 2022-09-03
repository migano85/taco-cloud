package testingThings;

import tacos.data.TestRecord;

public class classWithMain {

	public static void main(String[] args) {
		TestRecord tr = new TestRecord();
		System.out.println("id for default" + tr.id());
		System.out.println(new TestRecord(3L, "number 3").name());
		
	}

}
