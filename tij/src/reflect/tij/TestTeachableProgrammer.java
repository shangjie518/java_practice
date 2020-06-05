package reflect.tij;

interface Teachable {
	void work();
}

class Programmer {
	private String name;

	public Programmer() {
	}

	public Programmer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void work() {
		System.out.println(name + "Writing code");
	}
}

class TeachableProgrammer extends Programmer {
	public TeachableProgrammer() {
	}

	public TeachableProgrammer(String name) {
		super(name);
	}

	private void teach() {
		System.out.println(getName() + "Lecturing");
	}

	private class Closure implements Teachable {

		public void work() {
			teach();
		}
	}

	public Teachable getCallbackReference() {
		return new Closure();
	}
}

public class TestTeachableProgrammer {

	public static void main(String[] args) {
		TeachableProgrammer tp = new TeachableProgrammer("Lee Gang ");
		tp.work();
		tp.getCallbackReference().work();
	}

}
