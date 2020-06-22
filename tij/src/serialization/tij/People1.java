package serialization.tij;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class People1 implements Externalizable {
	
	private String name;
	private int age;
	transient private String gender;
	transient private String desc;

	
	
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub

		out.writeChars(this.name);
		out.writeInt(this.age);
		out.writeChars(this.gender);
		out.writeChars(this.desc);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
	
		
		System.out.println(in.readObject());

	}
	
	public String toString() {
		return String.format("Name:%s, age:%d, gender:%s, description:%s, hashCode: %s", this.name,this.age,this.gender,this.desc, this.hashCode());
	}

}
