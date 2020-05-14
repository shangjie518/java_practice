package reflect.tij;
class Building{}
class House extends Building{}

public class BuildingTest {

	public static void main(String[] args) {
		Building b=new House();
		Class<House> houseType=House.class;
		House h= houseType.cast(b);
		if (h==null) {
			System.out.println("we are here");
		}
		House g=(House)b;
		if (g==h) {
			System.out.println("we are here2");
		}
	}
}
