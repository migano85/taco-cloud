package tacos.data;

public record TestRecord(Long id, String name) {

	//for more info check : https://www.baeldung.com/java-record-keyword
	private static String tt = "tito";
	
	public TestRecord {
		//you can write customize code that get executed when calling the argument constructor, like this
		System.out.println("inside argumented constructor  " + name);
		System.out.println("default const value : " + tt);
		if(name.equals("joe")) {
			name = "i am not joe";
		}
	}
	
	public TestRecord() {
		//you can add default constructor, like this; well you must call the argument constructor anyway
		this(1L,"def");
		System.out.println("inside default constructor  " + name);
		System.out.println("in default const " + tt);
	}
}
