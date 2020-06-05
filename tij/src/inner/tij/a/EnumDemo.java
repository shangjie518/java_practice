package inner.tij.a;

public class EnumDemo {

	enum ProfileType{masteruser, anyuser, subuser, guest};
	
	public static void main(String[] args) {
		for(ProfileType p:ProfileType.values()) {
			System.out.println(p.name()+" ordinal:"+p.ordinal());
			System.out.println("Class: "+p.getClass());
			System.out.println(p.compareTo(p.masteruser));
			System.out.println(p.equals(ProfileType.masteruser));
			System.out.println("p.toString()="+p.toString());
		}
		
		for(String s:"masteruser anyuser".split(" ")) {
			ProfileType p=Enum.valueOf(ProfileType.class, s);
			System.out.println(p);
		}
		
	}
}
