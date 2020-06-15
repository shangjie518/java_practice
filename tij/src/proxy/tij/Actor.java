package proxy.tij;

public class Actor implements Person {

	@Override
	public String sing(String name) {
		System.out.println("Actor sing:"+name);
		return "return: Actor sing:"+name;
	}

	@Override
	public String dance(String name) {
		System.out.println("Actor dance:"+name);
		return "return: Actor dance:"+name;
	}

}
