package testingThings;

import java.util.Comparator;
import java.util.Objects;

import tacos.data.TestRecord;

public class classWithMain {

	public static void main(String[] args) {

		TestRecord tr = new TestRecord();//we can add noArgs constructor indirectly
		System.out.println("id for default" + tr.id());
		System.out.println(new TestRecord(3L, "number 3").name());
		
		
		Comparator<String> compExample1 = (first, second)->Integer.compare(first.length(), second.length());
		
		System.out.println(compExample1.compare("1176", "228"));
		
		Comparator<Double> compExample2 = (s, q) -> Objects.equals(q, s)?1:2;//we should return int because this is the return type of compare() the single method in the interface
		
		Comparator<Double> compTheOldWay = new Comparator<Double>() {
			//before java 8 there was inline implementation for interfaces, not only functional interfaces ut even the one which have more than one interface like List
			
			@Override
			public int compare(Double s, Double q) {
				return Objects.equals(q, s)?1:2;
			}
		};
	}

}
