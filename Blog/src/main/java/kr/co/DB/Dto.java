package kr.co.DB;

public class Dto {

	private int id;
	private String username;
	private int age;
	private String address;
	private String writeday;
	
	// Constructor
	public Dto() {
		
	}
	
	public Dto(int id, String username, int age, String address, String writeday) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.address = address;
		this.writeday = writeday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	
	
	
}
