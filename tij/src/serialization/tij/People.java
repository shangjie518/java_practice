package serialization.tij;

import java.io.Serializable;

public class People implements Serializable {
	
	private String name;
	private int age;
	transient private String gender;
	

	public People(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String toString() {
		return String.format("Name:%s, age:%d, gender:%s, hashCode: %s", this.name,this.age,this.gender,this.hashCode());
	}

}
