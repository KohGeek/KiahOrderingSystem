package Testing;

class Student {
	String name;
	String regno;

	public Student(String name, String regno) {
		super();
		this.name = name;
		this.regno = regno;
	}

	public Student() {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRegno() {
		return this.regno;
	}
	
	public Student setStudent() {
		return new Student("rickie", "11111");
	}
}
